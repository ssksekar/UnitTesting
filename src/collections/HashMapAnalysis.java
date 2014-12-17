//$Id$
package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapAnalysis {

	public static void main (String [] arg)
	{
		LinkedHashMap<String, String> msgIds = new LinkedHashMap<String, String>();
		msgIds.put("name", "sathish");
		msgIds.put("office", "zoho");

		//String m = msgIds.toString();
		System.out.println( msgIds );
		System.out.println( msgIds.get("name") );
		System.out.println( msgIds.get("name2") );
		
		
		HashMap<String, Long> a1 = new HashMap<String, Long>();
		HashMap<String, Long> a2 = null;
		
		System.out.println(a1);
		a1.putAll(a2);
		System.out.println(a1);
		
		HashMap<? extends Object,? extends Object> hms = new HashMap<Long, Long>();
		hms.put(1111l, 2222l);
	}
	
	
}
