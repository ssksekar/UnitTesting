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

public class SchedulerAvgTimeTaken  implements Runnable{

	public static void main(String arg [])
	{
		for ( int i = 13; i < 14; i++ )
		{
			Thread t = new Thread( new SchedulerAvgTimeTaken() );
			t.setName( String.valueOf(i) );
			t.start();
		}
	}
	
	public void run() 
	{
		try
		{
			int threadName = Integer.valueOf( Thread.currentThread().getName() );

			int fromDate = threadName;
			int toDate = threadName;
			int month = 10;
			//String searchQuery = "logtype=\"application\" and group_name CONTAINS \"IMAPConsumer\" and class_name CONTAINS \"MailClientNotificationHandler\" and method CONTAINS \"logTime\" and message CONTAINS \"Incoming Mail LogTime ::: UserId :::\"";
			String searchQuery = "logtype=\"application\"  and app_ip CONTAINS \"172.31.252.70\" and class_name CONTAINS \"com.zoho.scheduler.JobWrapper\" and message CONTAINS \"executed for :\"";
			
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

				String fromDateTime = sdf2.format(from) + "%20" + "02:00";
				String toDateTime = sdf2.format(to) + "%20" + "23:59";

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
					
					JSONObject jobj = LogsUtil.getLogs("application", fromDateTime, toDateTime, start, end, "query="+ encode(searchQuery), true);
					JSONArray docs = jobj.getJSONArray("docs");

					docsSize = docs.length();
					System.out.println( threadName + " ::: Received Size ::: " + docsSize);
					//System.out.println(jobj);
					
					for (int i = 0; i < docsSize; i++) 
					{
						JSONObject docObj =  docs.getJSONObject(i);
						String message = docObj.getString("message");
						//System.out.println( docObj );
						String rangeId = message.substring( message.indexOf( "Job : " ) + 6, message.indexOf( " ClassName" ) );
						String className = message.substring( message.indexOf( "com." ), message.indexOf( " QueueID : " ) );
						String time = message.substring( message.indexOf( "for : " ) + 6, message.indexOf( " milliseconds" ) );
						
						hm = new HashMap<String, String>();
						hm.put( "rangeId", rangeId );
						hm.put( "className", className );
						hm.put( "time_taken", time );
						hm.put( "time_long", docObj.getString( "time_stamp" ) );
				//		hm.put( "time", docObj.getString("_time") );
							
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

	public static int getCount(String type, String date, String searchString) throws Exception
	{
		JSONObject logsResult = LogsUtil.getLogs(type, date + "00:00", date + " 23:59", 1, 1, searchString, false);
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
			
			String insertSql = "insert into schedulerAvgTime2 (rangeid, classname, time_taken, time_long ) values ( ?, ?, ?, ? )";

			/* Local mysql */
			con = DriverManager.getConnection( "jdbc:mysql://localhost/sathish", "root", "" );
			
			/* IDC mysql */
			//con = DriverManager.getConnection( "jdbc:mysql://localhost/CrmMailTesting", "root", "qazwsx" );
			
			PreparedStatement preparedStatement = con.prepareStatement(insertSql);

			for ( HashMap<String, String> hm : insertionData )
			{
				preparedStatement.setLong( 1, Long.valueOf( hm.get( "rangeId" ) ) );
				preparedStatement.setString( 2, hm.get( "className" ) );
				preparedStatement.setLong( 3, Long.valueOf( hm.get( "time_taken" ) ) );
				preparedStatement.setLong( 4, Long.valueOf( hm.get( "time_long" ) ) );
				//preparedStatement.setString( 5,  hm.get( "time" ));

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
