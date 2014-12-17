//$Id$
package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesAnalysis {

	public static void main(String [] arg)
	{
		Properties prop = new Properties() {
			public Object put(Object key, Object value)
			{
				if ( key != null && value != null )
				{
					return super.put(key, value);
				}
				else
				{
					return null;
				}
			}
		};
		Properties prop2 = new Properties();
		prop.put("name", "sathish");
		prop.put("age", "25");
		prop.put("sex", null);
		
		prop2 = prop;
		
		System.out.println(prop);
		System.out.println(prop2);
		
		prop.remove("name");
		
		System.out.println(prop);
		System.out.println(prop2);
		
	}
	
}
