//$Id$
package logs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONArray;
import org.json.JSONObject;


public class LogsTest {
	
	public static void main(String arg[]) throws IOException
	{
		method();
	}
public static void method() throws IOException
{

	int start = 1;
	int end = 10;
	BufferedWriter bufferedWriter1 = null;

	try{
	bufferedWriter1 = new BufferedWriter(new FileWriter("/Users/sathish-1343/test12112.txt"));
		System.out.println("start=======>"+start+"=======end====="+end);
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
		
		URL logServer = new URL("https://prelogs.zoho.com/search?service=crm&type=application&date=2013-03-30&fromTime=00:01&toTime=23:59&range="+1+"-"+10+"&authtoken=bec059e5650c715018b491c3d3f65a85&logs_message="+URLEncoder.encode("Going to Activate the Bcc dropbox feature.", "utf-8"));
		//URL logServer = new URL("https://prelogs.zoho.com/search?service=crm&type=application&date=2013-03-31&fromTime=00:01&toTime=23:59&range="+1+"-"+5+"&authtoken=bec059e5650c715018b491c3d3f65a85&"+"&logs_message="+URLEncoder.encode("Going to Activate the Bcc dropbox feature.", "utf-8"));
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
		String result =sbuff.toString();
		JSONObject jobj = new JSONObject(result);
		String js = (String)jobj.getString("docs");
		JSONArray jarr = new JSONArray(js);
		
		int len = jarr.length();
		if(len == 0 || start == 85001)
		{
			//break;
		}
        System.out.println(js);
		for(int i = 0; i < len; i++)
		{
			JSONObject jobj2 = (JSONObject)jarr.get(i);
			
			try
			{
				bufferedWriter1.write(jobj2+"");
				bufferedWriter1.newLine();
				
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		
        
        
        
		in.close();
		
	}

	//Thread.sleep(10000);
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally
	{
		bufferedWriter1.flush();
		bufferedWriter1.close();
	}
}


}
