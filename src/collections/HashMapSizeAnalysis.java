//$Id$
package collections;

import java.util.HashMap;

public class HashMapSizeAnalysis {

	public static void main(String [] arg)
	{
		HashMap<String, String> hm = new HashMap<String, String>();
		
		if ( hm == null || hm.isEmpty() )
		{
			System.out.println( "hashmap is null or empty" );
		}
	}
	
}
