//$Id$
package json;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectAnalysis {

	public static void main ( String arg [] ) throws JSONException
	{
		JSONObject jsonArr = new JSONObject("{\"3\":{\"name\":\"Email.txt\",\"type\":\"text/plain\"},\"2\":{\"name\":\"01 - Hey Salaa - Blazee, Naresh Iyyar, Mohd Aslam.mp3\",\"type\":\"application/octet-stream\"},\"7\":{\"name\":\"migration.sh\",\"type\":\"application/octet-stream\"},\"6\":{\"name\":\"dd-changes.sql\",\"type\":\"application/octet-stream\"},\"5\":{\"name\":\"a.html\",\"type\":\"text/html\"},\"4\":{\"name\":\"zip1.zip\",\"type\":\"application/octet-stream\"}}");
		
		Iterator<String> keys = jsonArr.keys();
		
		while ( keys.hasNext() )
		{
			System.out.println( jsonArr.getJSONObject( keys.next() ).getString( "name" ) );
		}
				
		
		JSONObject jsonO = new JSONObject();
		jsonO.put( "1", 11l );
		jsonO.put( "2", 8934567890123456789l );
		
		System.out.println( jsonO );
	}
}
