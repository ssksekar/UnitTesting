//$Id$
package string;

public class StartsAndEndsWith {

	public static void main(String arg [])throws Exception
	{
		String str = "\"Sathish kumar\"";
		
		if ( str.startsWith( "\"" ) && str.endsWith( "\"" ) )
		{
			str = str.substring( 1, 5 );
		}
		
		System.out.println( str );
	}
	
}
