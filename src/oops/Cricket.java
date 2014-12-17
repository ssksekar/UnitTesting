//$Id$
package oops;

import java.util.HashMap;

import com.adventnet.crm.integration.emails.util.ZMailMetaDetails;

public class Cricket {

	public HashMap<Long, String> idVsName = null;
	public HashMap<Long, ZMailMetaDetails> zmsgIdVsZMailMetaDet = null;
	
	public void play()
	{
		idVsName.put(2222l, "kumar");
		zmsgIdVsZMailMetaDet.get(111l).setFirstName("kumar");
	}
	
}
