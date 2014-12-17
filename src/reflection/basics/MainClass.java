//$Id$
package reflection.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.prettyprint.cassandra.serializers.SerializerTypeInferer;


public class MainClass {

	public static void main(String arg []) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InstantiationException
	{
		Map<String, String> str = (Map<String, String>) Util.class.getField("str2").get( Util.class.newInstance() );
		System.out.println( str.get("age" ) );
		
		List<?> list = getList();
		System.out.println( list );
		
	}
	
	private static List<?> getList()
	{
		return new ArrayList<String>(){{add("sathish");}};
	}
	
}
