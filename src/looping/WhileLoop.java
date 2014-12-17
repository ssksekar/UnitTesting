//$Id$
package looping;

public class WhileLoop {

	static int counter = 10;
	
	public static void main(String [] arg)
	{
		boolean wantToRun = true;
		int counterLocal = 5;
		System.out.println( counterLocal );
		while ( wantToRun )
		{
			if( counterLocal == counter )
			{
				System.out.println( "GONNA STOP" );
				wantToRun = false;
			}
			else
			{
				System.out.println( counterLocal );
				counterLocal++;
			}
		}
	}
}
