//$Id$
package string;

public class IndexOfAnalysis {

	public static void main(String [] arg)
	{
		String exceptionMsg = "java.lang.Exception: Error while processing the request! You need to verify the ReplyTo address to send emails using this account. Please verify the ReplyTo address.";
		String toCheck = "You need to verify the ReplyTo address to send emails using this account. Please verify the ReplyTo address";
		
//		if( toCheck.indexOf( exceptionMsg ) > -1)
		if( exceptionMsg.indexOf( toCheck ) > -1)
		{
			System.out.println("IF");
		}
		else
		{
			System.out.println("ELSE");
		}
	}
}
