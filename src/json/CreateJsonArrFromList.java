//$Id$
package json;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;

public class CreateJsonArrFromList {
	
	public static void main (String [] arg)
	{
		LinkedList<String> list1 = new LinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		
		list1.add( "sekar" );
		list1.add( "praba" );
		list2.add( "sathish" );
		list2.add( "vithya" );
		
		System.out.println( list1 );
		System.out.println( list2 );
		
		List<String> list = list1;
		list.addAll(list2);
		
		System.out.println( list );
		
		JSONArray jsonArr = new JSONArray( list );
		
		System.out.println( jsonArr );
	}

}
