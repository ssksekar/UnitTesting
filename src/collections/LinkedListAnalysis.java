//$Id$
package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LinkedListAnalysis {

	public static void main(String arg[])
	{
		List<String> mailsList =  new LinkedList<String>(){
			public boolean addAll( Collection<? extends String> c ) {
		        System.out.println( "111" );
				
		        if ( c != null )
		        {
					return super.addAll( c );
		        }
				
				System.out.println( "2222" );
		        return false;
		    }
			
			public boolean add(String e) {
				System.out.println( "eurieyiriu" );
				return super.add(e);
			}
		};
		

		LinkedList<String> a = new LinkedList<String>();
		a.add("sathish");
		mailsList.add( "sss" );
		mailsList.addAll( a );
		mailsList.addAll( null );
		
		System.out.println( mailsList );
		
	}
	
}
