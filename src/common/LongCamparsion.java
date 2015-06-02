//$Id$
package common;

public class LongCamparsion {
	
	public static void main(String [] arg)
	{
		Long l = 2000001852018520l;
		Long l1 = null;
		
		if ( l == l1 )
		{
			System.out.println( "====" );
		}

		if ( l.equals(l1 ) )
		{
			System.out.println( "EQUALS" );
		}
	}

}
