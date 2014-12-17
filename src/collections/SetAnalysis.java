//$Id$
package collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SetAnalysis {

	public static void main(String arg [])
	{
		String [] strArr = new String[]{"sathish", "kumar", "sekar", "praba", "kumar", "sekar",};
		List<String> l = Arrays.asList(strArr);
		System.out.println( l );
		HashSet<String> set = new HashSet<String>( l );
		System.out.println( set );
		
		for ( String setStr : set )
		{
			System.out.println( setStr );
		}
	}
}
