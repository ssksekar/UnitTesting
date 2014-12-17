//$Id$
package string;

import com.adventnet.crm.common.util.PMDConstants;

public class test {
	public static void main(String[] arg) throws Exception 
	{
		String pattern = "[0-9]{1,19}(,[0-9]{1,19})*";
		
		System.out.println("111111 ::: " + "1234567890123456789,12345678901234567891111111".matches(pattern));
	}
}
