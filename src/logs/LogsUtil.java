//$Id$
package logs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONObject;

public class LogsUtil {

	public static JSONObject getLogs(String type, String fromDateTime, String toDateTime, int fromIndex, int toIndex, String searchQuery, boolean isAscending) throws Exception
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
		String url = "https://logs.zoho.com/search?service=crm&fromDateTime="+fromDateTime+"&toDateTime="+toDateTime+"&range="+fromIndex+"-"+toIndex+"&appid=36064526&authtoken=d834d4ad3d4a5bfcdf2cab8f31cd5482";
		url = isAscending ? url + "&order=asc" : url;
		url += "&" + searchQuery;
		
		//System.out.println( url );
		
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

}
