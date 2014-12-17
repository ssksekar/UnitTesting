//$Id$
package generics;

import java.util.Arrays;
import java.util.List;

public class MainClass {

	public static void main(String arg []) throws Exception
	{
		
		//Car car = new BMW();
		
		//printCarEngineCC(car);
		
		List<Integer> ints = Arrays.asList(1,2,3);
		int s = 0;
		for (int n : ints) { s += n; }
		assert s == 7;
	}
	
	public static void printCarMake( Car car )
	{
		System.out.println( car.getCarMake() );
	}

	public static void printCarEngineCC( Car car )
	{
		System.out.println( car.getEngineCC() );
	}
}
