//$Id$
package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListToArray {

	public static void main(String [] arg)
	{
		List<Long> al = new ArrayList<Long>();
		al.add( 111111l );
		al.add( 2222222l );
		al.add( 3333333l );
		al.add( 3333333l );
		al.add( 3333333l );
		al.add( 4444444l );
		
//		Long [] l = al.toArray( new Long [al.size()] );
		
		System.out.println(al);
		Iterator<Long> iter = al.iterator();
		
		while ( iter.hasNext() )
		{
			Long aaa =  iter.next();
			
			if ( aaa.equals( 111111l ) )
			{
				iter.remove();
			}
		}
		
		System.out.println(al);
		System.out.println(al.toArray( new String[ al.size() ] ) [0] );
		
	}
	
}
