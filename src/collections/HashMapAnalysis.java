//$Id$
package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapAnalysis {

	public static void main (String [] arg) throws Exception
	{
		HashMap<String, Long> hm = new HashMap<String, Long>(){
			
			public Long put( String key, Long value )
			{
				if ( this.containsKey(key) && this.get( key ) < value )
				{
					return super.put(key.toLowerCase(), value);
				}
				else if ( !this.containsKey(key) )
				{
					return super.put(key.toLowerCase(), value);
				}
				else
				{
					return null;
				}
			}
		};
		
		hm.put("sathish", 35l);
		hm.put("sathish", 10l);
		hm.put("sathish", 20l);
		hm.put("ssksekar", 20l);
		hm.put("ssksekar", 20l);
		hm.put("ssksekar", 40l);
		hm.put("sathish", 36l);
		
		System.out.println( hm );
		
	}
	
	
}
