//$Id$
package string;

import java.util.ArrayList;

public class ReplaceAllUtil {

	public static void main ( String [] arg ) throws Exception
	{
		String str = "\"zoho-sales\" \\<zoho-sales@zohocorp.com>, \r\n\t\"zoho-techsupport\" zoho-techsupport@zohocorp.com, \r\n\t\"zohocrm-jp\" <zohocrm-jp@zohocorp.com>";
		
		ArrayList<String> al = new ArrayList<String>();
		//String str = "Not Provided, sathishkumar.sekar@zohp.com";
		String str1 = "<sathishkimar>\r\t\n, \"vithya\" <vithya@zohocrp>, sekar@zoho.com";
		String str3 = "Not Provided, nothing given to me \r";
		
		addPlainEmailIdsInList(str,al);
		System.out.println(al);

		//al.clear();
		addPlainEmailIdsInList(str1,al);
		System.out.println(al);
		
		al.clear();
		addPlainEmailIdsInList(str3,al);
		System.out.println(al);
		
		System.out.println("----------------");
		replaceSqBracket("sdsds");
		
	}
	
	private static void addPlainEmailIdsInList ( String emailAddress, ArrayList<String> emailsList ) throws Exception
	{
		if ( emailAddress != null && emailAddress.indexOf( '@' ) > -1 )
		{
			emailAddress = emailAddress.replaceAll( "\r", "" );
			emailAddress = emailAddress.replaceAll( "\n", "" );
			emailAddress = emailAddress.replaceAll( "\t", "" );
			emailAddress = emailAddress.replaceAll( "\"", "" );
			emailAddress = emailAddress.replaceAll( "\'", "" );
			emailAddress = emailAddress.replaceAll( "\\\\", "" );
			emailAddress = emailAddress.replaceAll( "\\s", "" );
			
			String [] emailsArr = emailAddress.split( "," );
			
			for ( String emailId : emailsArr )
			{
				if ( emailId.indexOf( '@' ) > -1 && emailId.indexOf( '<' ) > -1 )
				{
					emailId = emailId.split( "<" )[1];
				}
				
				if ( emailId.indexOf( '@' ) > -1 && emailId.indexOf( '>' ) > -1 )
				{
					emailId = emailId.split( ">" )[0];
				}
				
				if ( emailId.indexOf( '@' ) > -1 )
				{
					emailsList.add( emailId );
				}
			}
		}
	}
	
	private static void replaceSqBracket(String str)
	{
		System.out.println(str);
		str = str.replaceAll( "\\[", "" );
		str = str.replaceAll( "\\]", "" );
		System.out.println(str);
	}
}
