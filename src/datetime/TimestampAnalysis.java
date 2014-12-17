//$Id$
package datetime;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.adventnet.crm.common.util.DateTimeUtils;

public class TimestampAnalysis {

	public static void main(String [] arg) throws Exception
	{
		String str = "2014-06-24 12:47:26";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parsedDate = dateFormat.parse(str);
		Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		System.out.println( dateFormat );
		System.out.println( parsedDate );
		System.out.println( parsedDate.getTime() );
		System.out.println( timestamp );
		
		System.out.println( DateTimeUtils.dateInLong(str, "yyyy-MM-dd hh:mm:ss"));
		System.out.println( Timestamp.valueOf( str ) );
	}
	
	
}
