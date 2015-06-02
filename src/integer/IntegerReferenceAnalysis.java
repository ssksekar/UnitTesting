//$Id$
package integer;

import java.util.HashMap;

public class IntegerReferenceAnalysis {

	public static void main(String arg[])
	{
		Integer i = new Integer(10);
		HashMap<String, String> hm = new HashMap<String, String>();
		
		System.out.println( i );
		System.out.println( hm );
		d(i, hm);
		System.out.println( i );
		System.out.println( hm );
		
	}
	
	private static void d( Integer i, HashMap<String, String> hm )
	{
		i = 20;
		hm.put( "name", "sathish" );
	}
}
