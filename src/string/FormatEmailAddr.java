//$Id$
package string;

import java.util.ArrayList;

import com.adventnet.crm.common.util.CommonUtil;
import com.adventnet.crm.common.util.PMDConstants;
import com.adventnet.crm.integration.emails.util.MailUtil;

public class FormatEmailAddr {

	public static void main(String [] arg) throws Exception
	{
		String str = "sathish kumar.ske<renuka@sathish.com>, asjkdha <asdasda asdasda>asdasd";
		
		String emailAddr = null;
		String [] emailAddrArr = str.split( PMDConstants.COMMA_DELIMTER );
		int emailAddrArrLen = emailAddrArr.length;
		
		for ( int i = 0; i < emailAddrArrLen; i++ )
		{
			emailAddr = emailAddrArr[i];
			
			if ( emailAddr.contains( "<" ) )
			{
				emailAddr = emailAddr.substring( emailAddr.indexOf( "<" ) + 1 );
				emailAddr = emailAddr.substring( 0, emailAddr.indexOf( ">" ) );
			}
			
			emailAddrArr[ i ] = emailAddr.trim(); 
		}
		
		//System.out.println( CommonUtil.convertStringArrayToCommaSepratedString(emailAddrArr) );
		
		
		//System.out.println( MailUtil.removeUsernamesNGetAddr(str) );
		
		ArrayList<String> emailList = new ArrayList<String>();
		emailList.add( "sathish@zohocorp.com" );
		emailList.add( "mahesh@zohocorp.com" );
		emailList.add( "ponns@zohocorp.com" );
		emailList.add( "cassandra@zohocorp.com,prakash@zohocorp.com" );
		
		System.out.println(emailList);
		System.out.println(CommonUtil.convertArrayListToCommaSepratedString(emailList));
		
		emailList.remove( "1222121231231" );
		System.out.println(emailList);
	}	
}
