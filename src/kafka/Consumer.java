//$Id$
package kafka;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import kafka.api.FetchRequest;
import kafka.api.FetchRequestBuilder;
import kafka.api.PartitionOffsetRequestInfo;
import kafka.cluster.Broker;
import kafka.common.ErrorMapping;
import kafka.common.TopicAndPartition;
import kafka.javaapi.FetchResponse;
import kafka.javaapi.OffsetResponse;
import kafka.javaapi.PartitionMetadata;
import kafka.javaapi.TopicMetadata;
import kafka.javaapi.TopicMetadataRequest;
import kafka.javaapi.consumer.SimpleConsumer;
import kafka.javaapi.message.ByteBufferMessageSet;
import kafka.message.Message;
import kafka.message.MessageAndOffset;

public class Consumer 
{
	private static String[] brokerList;
	private static String[] portList;
	
	private static int timeOut = 30000;
	private static int bufferSize = 65536;
	private static int fetchSize = 2097152;
	private static String broker_List = "mqueue.localzoho.com:9092";

	private Long readOffset;
	private String topic;
	private int partitionId;
	private String leader;
	private int port;
	private int messageCount;
	private String clientName;
	
	private SimpleConsumer consumer = null;
	private Broker leaderBroker;
	
	private static AtomicBoolean exit = new AtomicBoolean(false);
	
	
	static
	{
		String[] brokers = broker_List.split(","); 
		brokerList = new String[brokers.length];
		portList = new String[brokers.length];
	
		for(int i=0;i<brokers.length;i++)
		{
			brokerList[i] = brokers[i].split(":")[0];
			portList[i] = brokers[i].split(":")[1];
		}
	}

	/**
	 * Get {@link TopicMetadata} from Kafka Broker for given <b>Topic</b>s using
	 * {@link TopicMetadataRequest}. </br><i>Tries next Brokers in case of a
	 * Broker unavailability.</i>
	 */
	private static List<TopicMetadata> getTopiMetaData(List<String> topicList)
	{
		List<TopicMetadata> topicMetadata = null;
		for (int i=0;i<brokerList.length;i++)
		{
			SimpleConsumer consumer = null;

			try
			{
				consumer = new SimpleConsumer(brokerList[i], Integer.parseInt(portList[i]), 100000, 64 * 1024, "leaderLookup");//No I18N
				TopicMetadataRequest req = new TopicMetadataRequest(topicList);
				kafka.javaapi.TopicMetadataResponse resp = consumer.send(req);
				topicMetadata = resp.topicsMetadata();
				break;
			}
			catch (Exception e)
			{
				System.out.println("Error communicating with Broker " + brokerList[i] + " to find Leader for " +  topicList);
			}
			finally
			{
				if (consumer != null)
				{
					consumer.close();
				}
			}
		}
		//tried communication with atmost all brokers.

		if (topicMetadata == null)
		{//communication failed with all brokers.
			String msg = "Communication failed with all brokers -" + brokerList + '.';//No I18N
			System.out.println(msg);
		}
		return topicMetadata;
	}

	/**
	 * Gets {@link PartitionMetadata} for given <b>Topic</b> and
	 * <b>PartitionId</b> from Kafka Broker using {@link TopicMetadataRequest}.
	 */
	private static PartitionMetadata getTopicPartitionMeta(String topic, int partitionId) throws Exception
	{
		ArrayList<String> topicList = new ArrayList<String>(1);
		topicList.add(topic);

		//requested only one topic, so getting 1st element.
		List<TopicMetadata> metaData = getTopiMetaData(topicList);
		TopicMetadata topicMetadata = metaData.get(0);

		List<PartitionMetadata> partitionMetadatas = topicMetadata.partitionsMetadata();
		for (PartitionMetadata partitionMetadata : partitionMetadatas)
		{
			if (partitionMetadata.partitionId() == partitionId)
			{
				return partitionMetadata;
			}
		}
		return null;
	}

	/**
	 * Find <b>Leader</b> for given <b>Topic</b> and <b>PartitionId</b>.
	 */
	private static Broker findLeader(String topic, int partitionId, int maxRetry) throws Exception
	{
		return findNewLeader(topic, partitionId, maxRetry);
	}

	/**
	 * Find new <b>Leader</b> for given <b>Topic</b> and <b>PartitionId</b>.
	 */
	private static Broker findNewLeader(String topic, int partitionId, int maxRetry) throws Exception
	{
		int i = 0;
		long sleep = 0l;
		boolean goToSleep;

		while (maxRetry < 0 || i < maxRetry)
		{
			goToSleep = false;
			PartitionMetadata metadata = getTopicPartitionMeta(topic, partitionId);
			if (metadata == null || metadata.leader() == null)
			{
				goToSleep = true;
			}
			else
			{
				return metadata.leader();
			}
			if (goToSleep)
			{
				sleep = 1000l;

				System.out.println("Cannot find leader for topic {0} partitionId "+topic+" in retry "+partitionId+", retrying after "+sleep+" millis.");

				try
				{
					Thread.sleep(sleep);
					i++;
				}
				catch (InterruptedException ie)
				{
					ie.printStackTrace();
				}
			}
		}

		return null;
	}

	/**
	 * Get <b>Offset</b> from given <b>Topic</b> and <b>PartitionId</b> using
	 * {@link kafka.javaapi.OffsetRequest}.
	 * 
	 * @param earliestTime
	 *            <b>True</b> to get Earliest Offset, <b>False</b> to get Latest
	 *            Offset.
	 */
	private static long getOffset(SimpleConsumer consumer, String topic, int partition, boolean earliestTime, String clientName)
	{
		long whichTime;
		if (earliestTime)
		{
			whichTime = kafka.api.OffsetRequest.EarliestTime();
		}
		else
		{
			whichTime = kafka.api.OffsetRequest.LatestTime();
		}
		TopicAndPartition topicAndPartition = new TopicAndPartition(topic, partition);
		Map<TopicAndPartition, PartitionOffsetRequestInfo> requestInfo = new HashMap<TopicAndPartition, PartitionOffsetRequestInfo>();
		requestInfo.put(topicAndPartition, new PartitionOffsetRequestInfo(whichTime, 1));
		kafka.javaapi.OffsetRequest request = new kafka.javaapi.OffsetRequest(requestInfo, kafka.api.OffsetRequest.CurrentVersion(), clientName);
		OffsetResponse response = consumer.getOffsetsBefore(request);

		if (response.hasError())
		{
			System.out.println("Error fetching Offset Data from Broker with Error Code "+ response.errorCode(topic, partition));
			return 0l;
		}
		long[] offsets = response.offsets(topic, partition);
		return offsets[0];
	}

	/**
	 * Convert {@link Byte}[] from {@link ByteBuffer}.
	 */
	private static byte[] byteBufferToByteArray(ByteBuffer bb)
	{
		byte[] returnBytes = new byte[bb.limit()];
		bb.get(returnBytes);
		return returnBytes;
	}

	/**
	 * Form Client Name used for communication with Kafka Brokers.
	 */
	private static String formClientName(String topic, int partitionId)
	{
		return "Consumer" + "_" + topic + "_" + partitionId; //No I18N
	}



	/**
	 * Used to run a consumer thread for Kafka
	 * @param partition
	 * @param offset
	 * @param leader
	 * @param port
	 * @param consumer
	 * @param errorCount
	 * @param sleep
	 */
	private void consumerFunction( Integer partition, Long offset, String topic, Boolean isBatched, Integer messageCount )
	{
		
		this.topic = topic;
		this.messageCount = messageCount;
		partitionId = partition;
		readOffset = offset;
		clientName = formClientName(topic, partitionId);

		if (handleExit(exit))
		{
			return;
		}

		try
		{
			//if leader cannot be found, try at next execution.
			if (handleLeader() == null)
			{
				return;
			}

			handleConsumerConnection();

			//fetch message
			ByteBufferMessageSet fetchedMessages = handleFetch(this.consumer, topic, partitionId, readOffset);

			//read fetched messages and write
			if (fetchedMessages.iterator().hasNext())
			{
		        processFetchedMsg(fetchedMessages,isBatched);
			}
			
		} catch(Exception e){
			System.out.println("Encountered error, (broker down?) finding leader again for {0}." + clientName);
			this.consumer.close();
			this.consumer = null;
		}
	}  

	/**
	 * Fetch data from <b>Topic</b> leader for given <b>Partition</b> from given
	 * <b>Offset</b>.
	 * @throws Exception 
	 */
	private ByteBufferMessageSet handleFetch(SimpleConsumer consumer, String topic, int partitionId, long readOffset) throws Exception
	{
		System.out.println("Reading from offset "+readOffset+" for " + clientName );
		FetchRequest req = new FetchRequestBuilder().clientId(clientName).addFetch(topic, partitionId, readOffset, fetchSize).build();
		FetchResponse fetchResponse = consumer.fetch(req);
		if (fetchResponse.hasError())
		{
			handleFetchError(fetchResponse.errorCode(topic, partitionId));
			return null;
		}
		else
		{
			return fetchResponse.messageSet(topic, partitionId);
		}
	}

	/**
	 * Take action based on Error Code.
	 * @throws Exception 
	 */
	private void handleFetchError(short errorCode) throws Exception
	{
		System.out.println("Error fetching data from the Broker: " + leader + " for topic: " + topic + " partitionId: " + partitionId + " with error " + ErrorMapping.exceptionFor(errorCode));

		if (errorCode == ErrorMapping.OffsetOutOfRangeCode())
		{
			readOffset = getOffset(this.consumer, topic, partitionId, true, clientName);
		}
		else
		{
			System.out.println("Encountered error , (broker down?) finding leader again for {0}." + clientName);
			this.consumer.close();
			this.consumer = null;
			leader = null;
		}
	}

	/**
	 * Closes underlying Writer, commits Offset and {@link SimpleConsumer}
	 * instance.
	 */
	private void close() throws Exception
	{
		if (this.consumer != null)
		{
			this.consumer.close();
		}
	}

	/**
	 * Makes ready for exit if necessary, by closing all the resources used.
	 */
	private boolean handleExit(AtomicBoolean exit)
	{
		if (exit.get())
		{
			try
			{
				System.out.println("Existing consumer {0}." + clientName);
				close();
			}
			catch (Exception e)
			{
				System.out.println("Exception while closing for " + clientName );
				e.printStackTrace();
			}
		}
		return exit.get();
	}

	   /**
	    * Process fetched messages and also gets next next offset to Read.	
        */
        private boolean processFetchedMsg(ByteBufferMessageSet fetchedMessages, Boolean isBatched)
	    {
		System.out.println("Fetched messages of size {0} bytes." + fetchedMessages.sizeInBytes());
		
		List<byte[]> bufArr = null;
		List<Long> offsetArr = new LinkedList<Long>();
        int count=1;
		try
		{
			for (MessageAndOffset messageAndOffset : fetchedMessages)
			{
				if(isBatched)
				{
					if(bufArr==null){
						bufArr = new LinkedList<byte[]>();
					}
					if(count<=messageCount)
					{
						byte[] buf = byteBufferToByteArray(messageAndOffset.message().payload());
						bufArr.add(buf);
						count++;
						offsetArr.add(readOffset);
					}
					else
					{
						try
						{
							handleBulkMessages(bufArr,offsetArr);
						}
						catch(Exception e)
						{
			    			System.out.println("Exception in handling bulk message," + e);
			    			e.printStackTrace();
			    			return false;
						}
						bufArr.clear();
						offsetArr.clear();
						bufArr.add(byteBufferToByteArray(messageAndOffset.message().payload()));
						offsetArr.add(readOffset);
						count=1;
					}
				}
				else
				{
					handleMessage(messageAndOffset.message());
				}
				readOffset = messageAndOffset.nextOffset();
			}
			if(isBatched)
			{
				handleBulkMessages(bufArr,offsetArr);
			}
		}
		catch (Exception e)
		{	
			System.out.println("Exception while handling message," + e);
			e.printStackTrace();
			return false;

		}
		
     return true;
	}

	

	/**
	 * Fetches Leader from Broker for assigned Topic and PartitionId, if current
	 * Leader is null.
	 */
	private String handleLeader()
	{
		//check leader status, if null get leader from kafka broker
		try
		{
			if (this.leader == null)
			{
				this.leaderBroker = findLeader(topic, partitionId, 5);
				this.leader = leaderBroker.host();
				this.port = leaderBroker.port();
			}
		}
		catch (Exception e)
		{
			System.out.println("Cannot find leader for topic " + topic + " of partition " + partitionId + ", will retry at next schedule," + e);
			e.printStackTrace();
		}
		return leader;
	}

	/**
	 * Establishes connection to Broker is necessary.
	 */
	private void handleConsumerConnection()
	{
		//check simple consumer status, if null create new simple consumer instance
		if (this.consumer == null)
		{
			System.out.println("Leader for "+clientName+" is {1}."+ leader );
			this.consumer = new SimpleConsumer(this.leader, this.port, timeOut, bufferSize, clientName);
		}
	}

	/**
	 * Obtain message key and payload from given {@link Message} object and
	 * process it.
         * @throws Exception 
	 */
	private void handleMessage(Message message)throws Exception
	{
		byte[] buf = byteBufferToByteArray(message.payload());

		System.out.println( new String(buf) );
	}
	
	/**
	 * Obtain byte array as a list from given {@link Message} object and
	 * process it.
	 */
	private void handleBulkMessages(List<byte[]> bufArr, List<Long> offsetArr)throws Exception 
	{
		for ( byte[] b : bufArr )
		{
			System.out.println( new String(b) );
		}
	}
	
	public static void main(String []arg)throws Exception
	{
		Consumer consumer = new Consumer();
		consumer.consumerFunction( 1, 10l, "ZCrmMailClient", false, 10 );
	}
}
