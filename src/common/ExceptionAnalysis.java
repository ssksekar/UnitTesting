//$Id$
package common;

public class ExceptionAnalysis {

	public static void main(String [] ar)
	{
		try{
			System.out.println(11111);
			throw new NumberFormatException();
		}
		catch( NumberFormatException ne )
		{
			System.out.println(22222);
			throw new ArrayIndexOutOfBoundsException();
		}
		catch( ArrayIndexOutOfBoundsException ne )
		{
			System.out.println(333333);
			
		}
		catch( Exception ne )
		{
			System.out.println(444444);
		}
	}
}
