//$Id$
package oops;

import java.util.HashMap;

import com.adventnet.crm.integration.emails.util.ZMailMetaDetails;

public class MainClass {

	public HashMap<Long, String> idVsName = null;
	private HashMap<Long, ZMailMetaDetails> zmsgIdVsZMailMetaDet = null;
	
	public static void main(String [] str)
	{
		MainClass mc = new MainClass();
		mc.call();
	}
	
	private void call()
	{
		Cricket cricket = new Cricket();
		Tennis tennis = new Tennis();
		
		zmsgIdVsZMailMetaDet = new HashMap<Long, ZMailMetaDetails>();
		idVsName = new HashMap<Long, String>();
		zmsgIdVsZMailMetaDet.put(111l, new ZMailMetaDetails());
		zmsgIdVsZMailMetaDet.get(111l).setFirstName("sathish");
		System.out.println(zmsgIdVsZMailMetaDet.get(111l).getFirstName());
		System.out.println(idVsName);
		cricket.idVsName = idVsName;
		cricket.zmsgIdVsZMailMetaDet = zmsgIdVsZMailMetaDet;
		cricket.play();
		System.out.println(zmsgIdVsZMailMetaDet.get(111l).getFirstName());
		System.out.println(idVsName);

		//tennis.play();
		//cricket.play();
		//tennis.play();
	}
}
