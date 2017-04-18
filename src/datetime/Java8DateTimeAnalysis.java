//$Id$
package datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Java8DateTimeAnalysis {

	public static void main(String arg[])
	{
		LocalDate local = LocalDate.now();
		System.out.println( local );
		System.out.println( LocalTime.now() );

		System.out.println( System.currentTimeMillis() );
		System.out.println( new Date( System.currentTimeMillis() ) );
		System.out.println( new Date( 1390022111070l ) );
		System.out.println( new Date( 1390022111070l ).getDate() );
	}
}
