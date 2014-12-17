//$Id$
package collections;

import java.util.ArrayList;

public class ArrayListIteration {

	public static void main (String [] arg)
	{
		ArrayList<String> al = new ArrayList<String>();
		al.add("sathish");
		al.add("kumar");
		al.add("sekar");
		al.add("vithya");
		
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("jagadeesh");
		al2.add("mokshitha");
		
		al.addAll(al2);
		
		for ( String str : al )
		{
			System.out.println( str );
		}
		
	}
}
