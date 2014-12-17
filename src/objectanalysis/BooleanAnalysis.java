//$Id$
package objectanalysis;

public class BooleanAnalysis {

	public static void main(String are [])
	{
		if ( get(0) )
		{
			System.out.println("1");
		}
		else if ( get(0) )
		{
			System.out.println("0");
		}
		else if ( get(-1) )
		{
			System.out.println("-1");
		}
	}
	
	private static Boolean get(int q)
	{
		if ( q==0 )
		{
			return null;
		}
		else if ( q==-1 )
		{
			return false;
		}
		else if ( q==1 )
		{
			return true;
		}
		
		return null;
	}
	
}
