//$Id$
package looping;

public class BreakContinueAnalysis {

	public static  void main(String [] arg)
	{
		for ( int i = 1; i <= 10; i++ )
		{
			if ( i/2 == 2 )
			{
				continue;
			}
			System.out.println( i );
		}
	}
}
