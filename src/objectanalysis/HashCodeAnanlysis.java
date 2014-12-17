//$Id$
package objectanalysis;

import java.util.HashMap;

public class HashCodeAnanlysis {

	public static void main(String arg[])
	{
		String str = "sathish";
		String str2 = "sathish";
		System.out.println( str.hashCode() );
		System.out.println( str2.hashCode() );
		System.out.println( str.equals(str2) );
		System.out.println( str == str2 );
		
		HashMap<String, String> hm = new HashMap<String, String>();
		ClassObjRefAnalysis c = new ClassObjRefAnalysis();
		
		System.out.println( hm );
		c.hm = hm;
		c.modifyMap();
		System.out.println( hm );
		System.out.println( hm.get( "Father" ) );
	}
}
