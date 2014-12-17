//$Id$
package common;

import java.util.Calendar;

public class CalendarAnalysis {
	public static void main(String arg[])
	{
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		
		System.out.println( cal.get( Calendar.DAY_OF_MONTH ) );
		System.out.println( cal.get( Calendar.MONTH ) );
		System.out.println( cal.get( Calendar.YEAR ) );
	}

	
}
