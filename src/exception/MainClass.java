//$Id$
package exception;

public class MainClass {

	public static void main(String arg []) throws CustomException
	{
		call();
	}
	
	private static void call() throws CustomException
	{
		try
		{
			String str = null;
			
			System.out.println( str.contains( " Sathish " ) );
		}
		catch( Exception e )
		{
			throw new CustomException(e);
		}
	}
}
