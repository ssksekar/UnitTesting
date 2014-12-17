//$Id$
package string;

public class Split {

	public static void main(String arg[])
	{
		String [] emailArr = new String[]{ "sathishkumar.sekar@zohocorp.com", 
				"sathish@", "", "aisjoew", "@@@@@@", "sathis:kumar,@zoho.com",
				"mail-deamon@zoh.com.crm.india.chenni.amrica", "@indiada", 
				"saravana'kumar.j.k.k.k.kl.ll+132-1231_india-com@dunab.com" 
				}; 
		String emailPattern = "([A-Za-z0-9._%\\-\\'\\+]+@[A-Za-z0-9.\\-]+\\.[a-zA-Z]{2,6})$";

		for ( String emailid : emailArr )
		{
			System.out.print( emailid + " ::: " );
			if ( emailid.matches(emailPattern) )
			{
				System.out.println(true);
			}
			else
			{
				System.out.println(false);
			}
		}
	}	
}
