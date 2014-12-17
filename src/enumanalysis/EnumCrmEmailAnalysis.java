//$Id$
package enumanalysis;

import org.json.JSONArray;

import com.adventnet.crm.entity.util.CrmModuleConstants;
import com.adventnet.crm.integration.emails.util.ZMailConstants;
import com.adventnet.crm.integration.emails.util.ZMailConstants.CRM_EMAIL_MODULES;
import com.adventnet.crm.integration.search.util.CrmLuceneSearchUtil;

public class EnumCrmEmailAnalysis {

	public static void main(String arg[])
	{
		String str = null;
		for ( String module : ZMailConstants.INCOMING_MAILS_PROCESSING_MODULES_ORDER )
		{
			switch ( CRM_EMAIL_MODULES.valueOf( module ) )
			{
			case Users:
			case Potentials:
			case UnMatched:
				System.out.println(module);
				break;	
			
			case Contacts:
				System.out.println(module);
			case Leads:
				System.out.println(module);
				break;
				
			
			}				
		}
	}
}
