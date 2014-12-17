//$Id$
package common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.adventnet.crm.common.util.DateTimeUtils;

public class DateTimeAnalysis {

	public static void main(String [] arg) throws Exception
	{
		long DAY_IN_MS = 1000 * 60 * 60 * 24;
		Date date = new Date(System.currentTimeMillis() - (10 * DAY_IN_MS));
		
		String dateStr = DateTimeUtils.dateToString(date, DateTimeUtils.DB_DATE_PATTERN);
		long dateLong = DateTimeUtils.dateInLong(dateStr, DateTimeUtils.DB_DATE_PATTERN);
		
		System.out.println(date);
		System.out.println(dateStr);
		System.out.println(dateLong);
		
		
	}
}
