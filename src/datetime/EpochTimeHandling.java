//$Id$
package datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.adventnet.crm.common.util.DateTimeUtils;


public class EpochTimeHandling {

	public static void main( String arg [] ) throws Exception
	{
		/*
		System.out.println( DateTimeUtils.getDayDiffBtwTwoLongs( 1433960999000l, 1433997610000l ) );
		System.out.println( new SimpleDateFormat("y-d-MM").format( new Date() )  );
		System.out.println( new SimpleDateFormat("y-d-MM").parse( "2015-11-06" ).getTime()   );
		System.out.println( new Date().getTime() );
		*/
		
		long long1 = 1456770600000l;
		long long2 = 1456770600000l;
		
		System.out.println( DateTimeUtils.intervalInDaysBtwTwoEpochTime( long1, long2 ) );
	}
	
}
