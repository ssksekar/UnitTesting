//$Id$
package collections;

import java.util.HashMap;

public class GetKeysArrFromMap {

	public static void main( String arg [] )
	{
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("name", "sathish");
		hm.put("office", "zoho");
		hm.put("home", "keel kattalai");
		
		String strArr [] = hm.keySet().toArray( new String[ hm.size() ] );
		
		for ( String str : strArr )
		{
			System.out.println( str );
		}
	}
}
