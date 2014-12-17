//$Id$
package string;

public class StringArrayAnalysis {

	public static void main(String [] arg)
	{
		
		String s = "  ";
		
		if ( !s.isEmpty() )
		{
			System.out.println( "Empty" );
		}
				
		if ( s.trim().length() > 0 )
		{
			System.out.println( "trim" );
		}
		
		if ( !s.matches("\\s*") )
		{
			System.out.println( "regex" );
		}
		
	}
	
}
