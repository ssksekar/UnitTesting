//$Id$
package logs;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Driver;

public class ConsumerSleep  implements Runnable{

	public static void main(String arg [])
	{
		for ( int i = 0; i < 24; i++ )
		{
			Thread t = new Thread( new ConsumerSleep() );
			
			if ( i < 10 )
			{
				t.setName( "0" + i );
			}
			else
			{
				t.setName( String.valueOf(i) );
			}
			
			t.start();
		}
	}
	
	public void run() 
	{
		try
		{
			int fromDate = 7;
			int toDate = 7;
			int month = 11;
			//String searchQuery = "logtype=\"application\" and group_name CONTAINS \"IMAPConsumer\" and class_name CONTAINS \"MailClientNotificationHandler\" and method CONTAINS \"logTime\" and message CONTAINS \"Incoming Mail LogTime ::: UserId :::\"";
			String searchQuery = "logtype=\"application\" and class_name=\"com.adventnet.crm.queue.util.KafkaConsumerThread\" and method=\"consumerFunction\" and message CONTAINS \"imap0\"";
			
			for (int dateIdx = fromDate; dateIdx <= toDate; dateIdx++)
			{
				int page = 0;

				int range = 1000;

				int docsSize = -1;
				
				ArrayList<HashMap<String, String>> al = null;
				HashMap<String, String> hm = null;
				
//				String fromDateTime = dateIdx+"/"+month+"/2016" + encode(" 00:00");
//				String toDateTime = dateIdx+"/"+month+"/2016" + encode(" 23:00");

				SimpleDateFormat sdf = new SimpleDateFormat( "d-MM-yyyy" );
				SimpleDateFormat sdf2 = new SimpleDateFormat( "dd/MM/yyyy" );
				
				Date from = sdf.parse( dateIdx+"-"+month+"-2016");
				Date to = sdf.parse( dateIdx+"-"+month+"-2016");

				int threadName = Integer.valueOf( Thread.currentThread().getName() );
				
				String fromDateTime = sdf2.format(from) + "%20" + Thread.currentThread().getName() + ":00";
				String toDateTime = sdf2.format(to) + "%20" + Thread.currentThread().getName() + ":59";

				System.out.println( fromDateTime );
				System.out.println( toDateTime );
				
				/*
				String fromDateTime = "01/09/2016%2000:00";
				String toDateTime = "01/09/2016%2023:59";
				*/
				
				while(docsSize != 0)
				{	
					int start = ( page * range ) + 1;
					int end = ( page + 1) * range;
					
					al = new ArrayList<HashMap<String,String>>();
					
					JSONObject jobj = LogsUtil.getLogs( fromDateTime, toDateTime, start, end, "query="+ encode(searchQuery), true );
					JSONArray docs = jobj.getJSONArray( "docs" );

					docsSize = docs.length();
					System.out.println( threadName + " ::: Received Size ::: " + docsSize);
					//System.out.println(jobj);
					
					for (int i = 0; i < docsSize; i++) 
					{
						JSONObject docObj =  docs.getJSONObject(i);
						String message = docObj.getString("message");
						System.out.println( message );
						
						String [] messageArr = message.split( "," );
						String [] partitionArr = messageArr[1].split( ":::" );
						String [] sleepArr = messageArr[2].split( ":::" );
						
						hm = new HashMap<String, String>();
						hm.put( "partitions" , partitionArr[1].trim());
						hm.put( "sleep" , sleepArr[1].trim());
						al.add(hm);
					}
					
					insert(al, threadName);
					page++;
				}
				
				System.out.println( threadName + " ::: Completed" );
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{

		}
		//}
	}

	public static int getCount(String date, String searchString) throws Exception
	{
		JSONObject logsResult = LogsUtil.getLogs(date + "00:00", date + " 23:59", 1, 1, searchString, false);
		int count = logsResult.getInt("numFound");
		return count;
	}

	
	private static String encode(String data) throws UnsupportedEncodingException
	{
		return URLEncoder.encode(data, "UTF-8");
	}
	
	private static void insert( ArrayList<HashMap<String, String>> insertionData, int threadName ) throws Exception
	{
		System.out.println( threadName + " ::: Insertion Size ::: " + insertionData.size() );
		//System.out.println( "Insertion Size ::: " + insertionData );
		Connection con = null;
		try
		{
			Class.forName( Driver.class.getName() );		
			
			String insertSql = "insert into consumerSleep ( partitions, sleep ) values ( ?, ? )";

			/* Local mysql */
			con = DriverManager.getConnection( "jdbc:mysql://localhost/sathish", "root", "" );
			
			/* IDC mysql */
			//con = DriverManager.getConnection( "jdbc:mysql://localhost/CrmMailTesting", "root", "qazwsx" );
			
			PreparedStatement preparedStatement = con.prepareStatement(insertSql);

			for ( HashMap<String, String> hm : insertionData )
			{
				preparedStatement.setInt( 1, Integer.valueOf( hm.get( "partitions" ) ) );
				preparedStatement.setInt( 2, Integer.valueOf( hm.get( "sleep" ) ) );

				preparedStatement.addBatch();
			}

			//System.out.println( preparedStatement );
			preparedStatement.executeBatch();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if ( con != null )
			{
				try {
					con.close();
				} catch (SQLException e) {
					//e.printStackTrace();
				}
			}
		}
	}
}