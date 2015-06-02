//$Id$
package string;

public class PostfixIncrementorAnalysis {

	public static void main(String arg [])
	{
		String arr [] = new String[5];
		int i = 0;
		
		while ( i < 5 )
		{
			System.out.println( i );
			arr[i++] = String.valueOf( i * 100 + 100 );
			System.out.println( i );
		}
		
		for ( String s : arr )
		{
			System.out.println( s );
		}
	}	
}
