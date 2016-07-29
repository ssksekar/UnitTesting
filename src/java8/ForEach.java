//$Id$
package java8;

import java.util.Arrays;
import java.util.List;

public class ForEach {

	public static void main(String arg[])
	{
		List<Integer> al = Arrays.asList(10, 20, 30, 40);
		al.forEach( (Integer i) -> System.out.println("sathish") );
	}
	
}
