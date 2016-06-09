//$Id$
package runtime;

import java.util.HashMap;
import java.util.Random;

import org.github.jamm.MemoryMeter;

public class MemoryAnalyser {

	public static void main(String arg[]) throws Exception
	{
		HashMap<Long, Integer> hmLong = new HashMap<Long, Integer>();
		HashMap<String, Integer> hmStr = new HashMap<String, Integer>();
		
		Random r = new Random(); 
		
		for ( int i = 0; i < 1000000; i++ )
		{
			hmLong.put( r.nextLong(), r.nextInt() );
			hmStr.put( String.valueOf(r.nextLong()), r.nextInt() );
		}
		
		 MemoryMeter meter = new MemoryMeter();
		   System.out.println( meter.measureDeep( hmLong ) );
		   System.out.println( meter.measureDeep( hmStr ) );
		   //meter.measure(object);
		   //meter.measureDeep(object);
		    //meter.countChildren(object);
	}
	
}
