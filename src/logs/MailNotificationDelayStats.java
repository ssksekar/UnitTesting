//$Id$
package logs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Driver;

public class MailNotificationDelayStats {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try
		{
			int fromDate = 28;
			int toDate = 28;
			int month = 7;
			String searchQuery = "logtype=\"application\" and group_name CONTAINS \"IMAPConsumer\" and class_name CONTAINS \"MailClientNotificationHandler\" and method CONTAINS \"logTime\" and message CONTAINS \"Incoming Mail LogTime ::: UserId :::\"";

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
					
					JSONObject jobj = getLogs("application", "2016-"+month+"-"+dateIdx, start, end, "&query="+ encode(searchQuery),true);
					JSONArray docs = jobj.getJSONArray("docs");

					docsSize = docs.length();
					System.out.println("Received Size ::: " + docsSize);
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
					
					insert(al);
					page++;
				}
				
				System.out.println("Completed");
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
		JSONObject logsResult = getLogs(type, date, 1, 1, searchString, false);
		int count = logsResult.getInt("numFound");
		return count;
	}

	public static JSONObject getLogs(String type, String date, int fromIndex, int toIndex, String searchQuery, boolean isAscending) throws Exception
	{
		/** SSL Start **/

		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[]{
				new X509TrustManager() {
					public java.security.cert.X509Certificate[] getAcceptedIssuers() {
						return null;
					}
					public void checkClientTrusted(
							java.security.cert.X509Certificate[] certs, String authType) {
					}
					public void checkServerTrusted(
							java.security.cert.X509Certificate[] certs, String authType) {
					}
				}
		};


		// Install the all-trusting trust manager
		SSLContext sc = SSLContext.getInstance("SSL");

		sc.init(null, trustAllCerts, new java.security.SecureRandom());

		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());


		// Create all-trusting host name verifier

		HostnameVerifier allHostsValid = new HostnameVerifier() {

			public boolean verify(String hostname, SSLSession session) {

				return true;

			}

		};

		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

		/** SSL End **/

		//URL logServer = new URL("https://logs.zoho.com/search?appid=36064526&service=crm&type="+type+"&date="+date+"&fromTime=00:01&toTime=23:59&range="+fromIndex+"-"+toIndex+"&authtoken=d834d4ad3d4a5bfcdf2cab8f31cd5482&"+searchQuery);
		String url = "https://logs.zoho.com/search?appid=36064526&service=crm&type="+type+"&date="+date+"&range="+fromIndex+"-"+toIndex+"&authtoken=d834d4ad3d4a5bfcdf2cab8f31cd5482&";
		url = isAscending ? url + "order=asc&" : url;
		url += searchQuery;
		
		URL logServer = new URL(url);
		
		URLConnection yc = logServer.openConnection();
		yc.setDoInput(true); 
		yc.setDoOutput(true);

		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;
		StringBuilder sbuff = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
		{
			sbuff.append(inputLine); 
		}
		JSONObject jobj = new JSONObject(sbuff.toString());

		return jobj;
	}

	private static String encode(String data) throws UnsupportedEncodingException
	{
		return URLEncoder.encode(data, "UTF-8");
	}
	
	private static void insert(ArrayList<HashMap<String, String>> insertionData) throws Exception
	{
		System.out.println( "Insertion Size ::: " + insertionData.size() );
		//System.out.println( "Insertion Size ::: " + insertionData );
		Connection con = null;
		try
		{
			Class.forName( Driver.class.getName() );		
			
			String insertSql = "insert into MailNotificationDelay (UserId, CrmMailUid, FolderType, CurrentTime, MailReceivedTime, Difference) values ( ?, ?, ?, ?, ?, ? )";

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

