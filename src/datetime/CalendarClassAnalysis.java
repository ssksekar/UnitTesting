//$Id$
package datetime;

import java.util.Calendar;

public class CalendarClassAnalysis {

	public static void main(String arg[])
	{
		Calendar c = Calendar.getInstance();
		System.out.println( c.getTime() );
		c.roll(Calendar.HOUR, true);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		System.out.println( c.getTime() );
	}
	
}
