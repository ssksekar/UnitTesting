//$Id$
package logs;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Driver;

public class MailNotificationDelayStats implements Runnable{

	public static void main(String arg [])
	{
		for ( int i = 0; i < 24; i++ )
		{
			Thread t = new Thread( new MailNotificationDelayStats() );
			t.setName( String.valueOf(i) );
			t.start();
		}
	}
	
	public void run() 
	{
		try
		{
			int fromDate = 29;
			int toDate = 29;
			int month = 7;
			String searchQuery = "logtype=\"application\" and group_name CONTAINS \"IMAPConsumer\" and class_name CONTAINS \"MailClientNotificationHandler\" and method CONTAINS \"logTime\" and message CONTAINS \"Incoming Mail LogTime ::: UserId :::\"";
			int threadName = Integer.valueOf( Thread.currentThread().getName() );

			for (int dateIdx = fromDate; dateIdx <= toDate; dateIdx++)
			{
				int page = 0;

				int range = 1000;

				int docsSize = -1;
				
				ArrayList<HashMap<String, String>> al = null;
				HashMap<String, String> hm = null;
				
				while(docsSize != 0)
				{	
					int start = ( page * range ) + 1;
					int end = ( page + 1) * range;
					
					al = new ArrayList<HashMap<String,String>>();
					
					String startTime = threadName + ":00";
					String endTime = threadName + ":59";
					
					JSONObject jobj = LogsUtil.getLogs("application", dateIdx+"/"+month+"/2016 " + startTime, dateIdx+"/"+month+"/2016 " + endTime, start, end, "&query="+ encode(searchQuery),true);
					JSONArray docs = jobj.getJSONArray("docs");

					docsSize = docs.length();
					System.out.println( threadName + " ::: Received Size ::: " + docsSize);
					//System.out.println(jobj);
					
					for (int i = 0; i < docsSize; i++) 
					{
						JSONObject docObj =  docs.getJSONObject(i);
						String message = docObj.getString("message");

						message = message.substring( message.indexOf("UserId"), message.indexOf( " Sec" ) );
						String arr [] = message.split( ":::" );
						
						hm = new HashMap<String, String>();
						
						for ( int k = 0; k < arr.length; k = k + 2 )
						{
							hm.put( arr[k].trim(), arr[k+1].trim() );
						}						
						
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
		JSONObject logsResult = LogsUtil.getLogs(type, date+ " 00:00", date + " 23:59", 1, 1, searchString, false);
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
			
			String insertSql = "insert into MailDelay29_1 (UserId, CrmMailUid, FolderType, CurrentTime, MailReceivedTime, Difference) values ( ?, ?, ?, ?, ?, ? )";

			/* Local mysql */
			con = DriverManager.getConnection( "jdbc:mysql://localhost/sathish", "root", "" );
			
			/* IDC mysql */
			//con = DriverManager.getConnection( "jdbc:mysql://localhost/CrmMailTesting", "root", "qazwsx" );
			
			PreparedStatement preparedStatement = con.prepareStatement(insertSql);

			for ( HashMap<String, String> hm : insertionData )
			{
				preparedStatement.setLong( 1, Long.valueOf( hm.get( "UserId" ) ) );
				preparedStatement.setString( 2, hm.get( "CrmMailUid" ) );
				preparedStatement.setString( 3, hm.get( "FolderType" ) );
				preparedStatement.setString( 4, hm.get( "CurrentTime" ) );
				preparedStatement.setLong( 5, Long.valueOf( hm.get( "MailReceivedTime" ) ) );
				preparedStatement.setString( 6, hm.get( "Difference" ) );

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