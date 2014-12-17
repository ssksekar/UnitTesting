//$Id$
package collections;

import java.util.Arrays;

public class ArraysAnalysis {

	public static void main(String arg [])
	{
		String [] arr = new String [10];
		
		for ( String a : arr )
		{
			System.out.println( a );
		}

		Arrays.fill( arr, "sathish" );
		
		for ( String a : arr )
		{
			System.out.println( a );
		}
		
	}
	
}
