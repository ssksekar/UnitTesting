//$Id$
package json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonArrRefAnalysis {

	public static void main (String arg []) throws Exception
	{
//		String str = "[{\"name\":\"sathish\", \"age\":26}]";
		String str = null;
		JSONArray ja = str != null ? new JSONArray( str ) : new JSONArray();
		System.out.println( ja );
		ja = appenInjsonArr(ja);
		System.out.println( ja );
	}
	
	public static JSONArray appenInjsonArr( JSONArray jsonArr ) throws Exception
	{
		if ( jsonArr == null )
		{
			jsonArr = new JSONArray();
		}
		
		jsonArr.put( new JSONObject( "{\"name\":\"sekar\", \"age\":53}" ) );
		
		return jsonArr;
	}
	
}
