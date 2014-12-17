//$Id$
package common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import com.adventnet.crm.activities.util.ActivityUtil;
import com.adventnet.crm.common.util.DateTimeUtils;
import com.adventnet.crm.security.util.UserUtil;

public class DateAnaylsis {
	
	public static void main(String arg[]) throws Exception {
		String d1 = "2013-07-02";
		Long d1L = DateTimeUtils.dateInLong(d1, "yyyy-MM-dd");

		// System.out.println(DateTimeUtils.getDayDiffBtwTwoLongs(System.currentTimeMillis(),
		// d1L));
		// compare2Dates();
		// DateTimeUtils.getTodayDate("yyyy-MM-dd", null);

		System.out.println(getDaysBtwTwoEpochTime(1375959995993l,
				1472929774998l));
	

	}

	public static Integer getDaysBtwTwoEpochTime(Long longTime1, Long longTime2)
			throws Exception {
		Integer daysInDwtween = null;

		if (longTime1 == longTime2) {
			System.out.println("Equal");
			daysInDwtween = new Long((longTime2 - longTime1)
					/ DateTimeUtils.MILLISEC_PER_DAY).intValue();
		} else if (longTime1 < longTime2) {
			System.out.println("Long2 is greater than Long1");
			daysInDwtween = new Long((longTime2 - longTime1)
					/ DateTimeUtils.MILLISEC_PER_DAY).intValue();
		} else if (longTime1 > longTime2) {
			System.out.println("Long1 is greater than Long2");
			System.out.println(longTime2 - longTime1);
			System.out.println(-3022099500l / DateTimeUtils.MILLISEC_PER_DAY);
			daysInDwtween = new Long((longTime2 - longTime1)
					/ DateTimeUtils.MILLISEC_PER_DAY).intValue();
		}

		return daysInDwtween;
	}

	public static String getTodayDate(String userDatePattern) throws Exception {
		Timestamp curTimeInGMT = DateTimeUtils.getCurrentTimeInGMT();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(curTimeInGMT.getTime());
		String todayDate = new SimpleDateFormat(userDatePattern).format(cal
				.getTime());
		return todayDate;
	}

	public static void compare2Dates() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse("2012-12-31");
		Date date2 = sdf.parse("2010-01-31");

		System.out.println(sdf.format(date1));
		System.out.println(sdf.format(date2));
		System.out.println(date1.toString());
		System.out.println(String.valueOf(date1));

		if (date1.compareTo(date2) > 0) {
			System.out.println("Date1 is after Date2");
		} else if (date1.compareTo(date2) < 0) {
			System.out.println("Date1 is before Date2");
		} else if (date1.compareTo(date2) == 0) {
			System.out.println("Date1 is equal to Date2");
		} else {
			System.out.println("How to get here?");
		}

	}
}
