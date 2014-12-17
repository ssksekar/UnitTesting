//$Id$
package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class IteratorAnalysis {

	public static void main(String are[])
	{
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		//HashMap<Integer, String> hm = null;
		
		Iterator<Integer> iter = hm.keySet().iterator();
		
		System.out.println( iter.hasNext() );
	}
}
