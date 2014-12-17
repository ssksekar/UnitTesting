//$Id$
package math;

public class RoundOffAnalysis {

	public static void main(String str []) throws Exception
	{
		String str1 = "91826";
		String str2 = "125984";
		String str3 = "239807";
		String str4 = "104854600";
		//String str4 = "104857600";
		
		int a = Integer.valueOf( str4 ) / 1024;
		
		System.out.println( Integer.valueOf( str1 ) / 1024 );
		System.out.println( Float.valueOf( str1 ) / 1024 );
		System.out.println( Math.round( Float.valueOf( str1 ) / 1024 )  );
	}
	
}
