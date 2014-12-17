//$Id$
package objectanalysis;

import java.util.ArrayList;

public class InstanceOfAnalysis {

	public static void main(String arg [])
	{
		checkInstanceOf( new ArrayList<Long>() );
	}	
	
	public static void checkInstanceOf( Object o )
	{
		System.out.println( o instanceof ArrayList );
	}
}
