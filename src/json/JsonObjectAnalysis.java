//$Id$
package json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectAnalysis {

	public static void main ( String arg [] ) throws JSONException
	{
		
		JSONArray jsonArr = new JSONArray("[{\"alias\":\"sathishkumar.sekar@zohocorp.com\",\"sequence\":\"10\"},{\"alias\":\"ssksekar@zohocorp.com\",\"sequence\":\"83\"}]");
		
		for ( int i = 0; i < jsonArr.length(); i++ )
		{
			JSONObject jsonObj = jsonArr.getJSONObject( i );
			//System.out.println( jsonObj );
			System.out.println( jsonObj.getString( "alias" ) );
			System.out.println( jsonObj.getInt( "sequence" ) );
		}
		

		JSONObject jsonObj = new JSONObject();
		jsonObj.put( "A", "aaaaaaa" );
		jsonObj.put( "B", "bbbbbbb" );
		jsonObj.put( "C", null );
		
		System.out.println( jsonObj );
	}
}
