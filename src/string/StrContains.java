//$Id$
package string;

public class StrContains {

	public static void main( String arg [])
	{
		String str = " [CrmUserRecentMails] Duplicate entry '2000000017080-1010583000000229011' for key 1";
		String strs = "Duplicate entry";
		
		System.out.println(str.contains(strs));
	}
}
