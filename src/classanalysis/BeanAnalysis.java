//$Id$
package classanalysis;

import java.util.ArrayList;
import java.util.HashMap;

import com.adventnet.crm.integration.emails.util.MailDetailsBean;
import com.aspose.cells.a.d.ac;

public class BeanAnalysis {

	Long user;
	
	HashMap<Long, HashMap<Long, HashMap<Long, ArrayList<MailDetailsBean>>>> hm = null;
	
	HashMap<Long, HashMap<Long, ArrayList<MailDetailsBean>>> hm1 = hm.get("1");
	HashMap<Long, ArrayList<MailDetailsBean>> hm2 = hm1.get("1");
	
	
	enum action
	{
		create( new Ma )
		{
			MailDetailsBean a()
			{
				return null;
			}
		},
		
		update
		{
			MailDetailsBean a()
			{
				return null;
			}
		};
		
		abstract MailDetailsBean a();
	}
	
	
	public static void main(String [] arg) throws Exception
	{
		BeanAnalysis b = new BeanAnalysis();
		
		b.user = 10l;
		
		HashMap<action, ac>
		
		action.create.a();
	}
	
}
