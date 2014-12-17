//$Id$
package exception;

public class ExceptionClassAnalysis {

	public static void main(String [] arg)
	{
		try
		{
			throw new Exception();
		}
		catch (Exception ne)
		{
			System.out.println( ne );
			System.out.println( ne.getMessage() );
			System.out.println( ne.getMessage().equals("sathish") );
		}
	}
}
