//$Id$
package common;

public class AnalysisingClass {

	public static void main(String [] arg)
	{
		System.out.println( AnalysisingClass.class.getCanonicalName() );
		System.out.println( AnalysisingClass.class.getName() );

	}
	
	public static void disp()
	{
		System.out.println( "Display inside AnalysisingClass" );
	}
	
}
