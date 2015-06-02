//$Id$
package collections;

import java.util.ArrayList;

public class ArrayListRemoval {

	public static void main(String arg [])
	{
		ArrayList<String> al = new ArrayList<String>();
		
		al.add( "sathish" );
		al.add( "sathish" );
		al.add( "sathish" );
		al.add( "sathish" );
		
		System.out.println( al );
		
		al.remove( "sathish" );
		
		System.out.println( al );
	}
	
}
