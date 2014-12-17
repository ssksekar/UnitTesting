//$Id$
package looping;

public class ForWhileLoop {
	
	public static void main(String arg [])
	{
		for ( int i = 1; i <= 5; i++ )
		{
			int j = i;
			while( j > 0 )
			{
				System.out.println( "j ::: " + j );
				if ( j == 4 )
				{
					//break;
					j--;
					//continue;
					break;
					//System.out.println( i );
				}
				else
				{
					System.out.println( i );
				}
				
				j--;				
			}
			
			System.out.println();
		}
	}
}
