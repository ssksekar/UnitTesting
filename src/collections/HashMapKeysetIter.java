//$Id$
package collections;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapKeysetIter {

	public static void main(String [] arg)
	{
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put( "111" ,  "sekar" );
		hm.put( "222" ,  "praba" );
		hm.put( "333" ,  "sathish" );
		hm.put( "444" ,  "vithya" );
	
		System.out.println( hm );
		
		Iterator<String> iter = hm.keySet().iterator();
		
		while ( iter.hasNext() )
		{
			String str = iter.next();
			System.out.println( str );
			
			if ( str.equals( "222" ) )
			{
				iter.remove();
			}
		}		
		System.out.println( hm );
	}
}
