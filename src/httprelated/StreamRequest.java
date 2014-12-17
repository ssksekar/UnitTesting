//$Id$
package httprelated;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import sun.net.www.http.HttpClient;

public class StreamRequest {

	
	public static void main ( String [] arg ) throws Exception
	{
		String url = "https://crmlab.localzoho.com/crm/internal/json/Users/notifyCRMService?featureName=showRecentMails";
		int readTimeout = 10000;
		HashMap<Long, List<String>> object = new HashMap<Long, List<String>>();
		List<String> zuid = new ArrayList<String>();
		zuid.add("sathishkumar.sekar@zohosmtpin.india.adventnet.com,10404123");
		object.put(11111111l, zuid);
		System.out.println( performWrite(url, object, readTimeout) );
	}
	
	public static Properties performWrite (String url, Object inputOb, int readTimeout) throws Exception
    {
        URL u = new URL(url);
        Properties prop = new Properties();

        HttpClient hm = new HttpClient("");
        
        HttpURLConnection conn=(HttpURLConnection)u.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        if(readTimeout >=0 ) { 
        	conn.setReadTimeout(readTimeout);
        	conn.setConnectTimeout(readTimeout);
        }
        
        conn.setRequestMethod("POST"); //No I18N
        conn.setRequestProperty ("Content-Type", "text/xml"); //No I18N

        ObjectOutputStream oos = new ObjectOutputStream (conn.getOutputStream ());
        try
        {
            oos.writeObject (inputOb);
            oos.flush();
        }
        finally
        {
            oos.close();
        }
        InputStream stream = conn.getInputStream();
        try
        {
            prop.load (stream);
        }
        finally
        {
        	stream.close();
        }
        conn.disconnect();
        return prop;
    }

}
