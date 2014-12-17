//$Id$
package collections;

import java.util.HashMap;

public class HashMapOveridesFn {

	public static void main ( String [] arg )
	{
		HashMap<String, Object> userDetails = new HashMap<String, Object>(){
			
			public Object put(String key, Object value)
			{
				return super.put( key.toLowerCase(), value );
			}
		};
		
		userDetails.put("SAthiSDK", 234234234235l);
		userDetails.put("KuMAr", 23);
		userDetails.put("SekAr", true);
		
		System.out.println( userDetails );
	}
}
