//$Id$
package logs;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONException;
import org.json.JSONObject;

public class LogsUtil {

	public static JSONObject getLogs( String logserverURL, HashMap<String, String> parametersMap ) throws NoSuchAlgorithmException, KeyManagementException, IOException, JSONException
	{
		String parametersStr = convertMapToQueryString( parametersMap );
		
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[]{
				new X509TrustManager() {
					public java.security.cert.X509Certificate[] getAcceptedIssuers() {
						return null;
					}
					public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
					}
					public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
					}
				}
			};


		// Install the all-trusting trust manager
		SSLContext sc = SSLContext.getInstance("SSL");

		sc.init(null, trustAllCerts, new java.security.SecureRandom());

		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());


		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) 
				{
					return true;
				}
			};

		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

		URL logServer = new URL( logserverURL + "?" + parametersStr );
		URLConnection urlConn = logServer.openConnection();
		urlConn.setDoInput(true);
		urlConn.setDoOutput(true);
		
		BufferedReader in = new BufferedReader(new InputStreamReader( urlConn.getInputStream()) );
		String inputLine;
		StringBuilder strBuff = new StringBuilder();
		while ((inputLine = in.readLine()) != null) 
		{
			strBuff.append(inputLine);
		}
		in.close();

		JSONObject jobj = new JSONObject(strBuff.toString());
		
		return jobj;
	}
	
	private static String convertMapToQueryString( HashMap<String, String> parametersMap ) throws UnsupportedEncodingException
	{
		StringBuffer strBuff = new StringBuffer();
		
		for ( Entry<String, String> entry : parametersMap.entrySet() )
		{
			strBuff.append( entry.getKey() );
			strBuff.append( "=" );
			strBuff.append( entry.getValue() );
			strBuff.append( "&" );
		}
		
		return strBuff.toString();
	}
}
