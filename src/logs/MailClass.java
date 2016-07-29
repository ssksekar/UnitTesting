//$Id$
package logs;

public class MailClass {

	public static void main(String arg [])
	{
		String message = "Incoming Mail LogTime ::: UserId ::: 224814000000034003 ::: CrmMailUid ::: 1532237397308025543 ::: FolderType ::: 101 ::: CurrentTime ::: 1469714973605 ::: MailReceivedTime ::: 1461255452000 ::: Difference ::: 8459521 Sec";
		message = message.substring( message.indexOf("UserId"), message.indexOf( " Sec" ) );
		String arr [] = message.split( ":::" );
		
		for ( String s : arr )
		{
			System.out.println( s.trim() );
		}
	}
	
}
