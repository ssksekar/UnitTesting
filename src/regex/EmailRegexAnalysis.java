//$Id$
package regex;

public class EmailRegexAnalysis {

	public static void main (String [] arg)
	{
		String pattern = "[1-9][0-9]?[0-9]?";
		
		System.out.println( "9".matches( pattern ) );
	}
}
