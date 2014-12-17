//$Id$
package math;

public class MatchingLongEquals {

	public static void main(String [] str)
	{
		Long l1 = 11111l;
		Long l2 = 11111l;
		
		if ( l1.equals(l2) )
		{
			System.out.println( "TRUE" );
		}
		else
		{
			System.out.println( "FALSE" );
		}
	}
}
