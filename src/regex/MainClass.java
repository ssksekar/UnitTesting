//$Id$
package regex;

public class MainClass {

	public static void main(String arg[])
	{
		String pattern = "(contact|potential_[0-9]+)";
		System.out.println( "potential_1389647236723648276347236846283642".matches( pattern ) );
		System.out.println( ((Long) null) instanceof Long );
	}
	
}
