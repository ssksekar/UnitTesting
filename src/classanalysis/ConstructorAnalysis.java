//$Id$
package classanalysis;

public class ConstructorAnalysis {

	public ConstructorAnalysis(String m) throws Exception
	{
		System.out.println( "Message Printed" );
		throw new Exception( "Sucks" );
	}
	
	
	public static void main(String arg []) throws Exception
	{
		ConstructorAnalysis c = new ConstructorAnalysis("");
	}
}
