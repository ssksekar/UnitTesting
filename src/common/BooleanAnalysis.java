//$Id$
package common;

public class BooleanAnalysis {
	public static void main(String [] arg)
	{
		Boolean b = null;
		
		if ( b != null && b )
		{
			System.out.println( "India is great" );
		}
		else
		{
			System.out.println( "USA is great" );
		}
	}
}
