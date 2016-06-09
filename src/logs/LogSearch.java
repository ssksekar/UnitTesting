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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author tamil-1221
 *
 */
public class LogSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try
		{
			
			int fromDate = 8;
			int toDate = 9;
			int month = 3;
			String searchQuery = "logtype=\"application\" AND message CONTAINS \"mail.recentflag\" AND group_name=\"IMAPConsumer\"";

			//Parse pattern
			//TODO
			Pattern countPattern = Pattern.compile("IMAP ::: QUEUE CHECK ::: USERID ::: (.*) ::: OPR ::: mail.recentflag ::: OFFSET ::: (.*)");

			for (int dateIdx = fromDate; dateIdx <= toDate; dateIdx++)
			{
				
				BufferedWriter bufferedWriter = null;

				FileWriter fileWriter = null;

				int page = 0;

				int range = 1000;

				int docsSize = -1;
				
				fileWriter = new FileWriter("SEARCH_"+month+"_"+dateIdx+".txt");

				bufferedWriter = new BufferedWriter(fileWriter);

				while(docsSize != 0)
				{	
					int start = ( page * range ) + 1;
					int end = ( page + 1) * range;

					JSONObject jobj = getLogs("application", "2016-"+month+"-"+dateIdx, start, end, "&query="+ encode(searchQuery));

					JSONArray docs = jobj.getJSONArray("docs");

					docsSize = docs.length();

					for (int i = 0; i < docsSize; i++) {

						JSONObject docObj =  docs.getJSONObject(i);
						String message = docObj.getString("message");

						Matcher cc = countPattern.matcher(message);

						if(cc.find())
						{
							//to process message data
							//TODO : change required pattern group id
							String userId = cc.group(1);

							//TODO : output pattern
							bufferedWriter.write("IMAP ::: "+userId+"\n");
							bufferedWriter.flush();
						}

					}

					page++;
				}

				try
				{
					System.out.println("before close");
					bufferedWriter.close();
					fileWriter.close();
				}
				catch(Exception se)
				{
					se.printStackTrace();
				}

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
		JSONObject logsResult = getLogs(type, date, 1, 1, searchString);
		int count = logsResult.getInt("numFound");
		return count;
	}

	public static JSONObject getLogs(String type, String date, int fromIndex, int toIndex, String searchQuery) throws Exception
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
		URL logServer = new URL("https://logs.zoho.com/search?appid=36064526&service=crm&type="+type+"&date="+date+"&range="+fromIndex+"-"+toIndex+"&authtoken=d834d4ad3d4a5bfcdf2cab8f31cd5482&"+searchQuery);	
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
}
