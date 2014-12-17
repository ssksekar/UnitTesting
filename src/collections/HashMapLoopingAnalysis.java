//$Id$
package collections;

import java.util.HashMap;
import java.util.Iterator;

import com.adventnet.crm.integration.emails.util.ZMailMetaDetails;

public class HashMapLoopingAnalysis {

	public static void main( String arg [] )
	{
		HashMap<Long, ZMailMetaDetails> hm = new HashMap<Long, ZMailMetaDetails>();
		hm.put(1111l, new ZMailMetaDetails());
		hm.put(2222l, new ZMailMetaDetails());
		hm.put(3333l, new ZMailMetaDetails());
		hm.put(4444l, new ZMailMetaDetails());
		
		
		Iterator<Long> iter = hm.keySet().iterator();
		
		while ( iter.hasNext() )
		{
			Long l = iter.next();
			ZMailMetaDetails  zmailDet = hm.get( l );
			
		}
		
		
	}
}
