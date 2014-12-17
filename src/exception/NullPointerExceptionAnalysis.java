//$Id$
package exception;

public class NullPointerExceptionAnalysis {

	public static void main(String [] str)
	{
		String name = null;
		String matchWord = "Kumar";
		
		try{
			throw new Exception();
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println( "=====================" );
			System.out.println(e.getMessage());
			if ( e.getMessage() != null )
			{
				if ( "love".indexOf(e.getMessage()) > -1 )
				{
					System.out.println("u r correct");
				}
			}
			else
			{
				System.out.println("Double correct");
			}
			
		}
	}
	
}
