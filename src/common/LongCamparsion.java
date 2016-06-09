//$Id$
package common;

public class LongCamparsion {
	
	public static void main(String [] arg)
	{
		Long l = 2000001852018520l;
		Long l1 = 2000001852018511l;
		

		if ( l > l1 )
		{
			System.out.println( "l greater than l1 " );
		}

		if ( l < l1 )
		{
			System.out.println( "l lesser than l1 " );
		}
	}

}
