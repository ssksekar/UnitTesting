//$Id$
package common;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class MainClass {

	public static void main(String arg [])
	{
		LocalDate date = LocalDate.now().plusDays( 30l );
		Timestamp t = null;
		if ( date.getDayOfWeek() != DayOfWeek.SUNDAY )
		{
			date = date.with( TemporalAdjusters.next( DayOfWeek.SUNDAY ) );
			t = Timestamp.valueOf( date.atTime(1, 0) );
		}
		 
		System.out.println( date );
		System.out.println( t );
	}	
}
