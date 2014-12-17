//$Id$
package string;

public class VariableArugments {

	public static void main( String arg[] )
	{
		display("sathish", "praba", "vithya", "mokishta", "sekar");
	}
	
	static void display(String ... key)
	{
		System.out.println( key[3] );
	}
}
