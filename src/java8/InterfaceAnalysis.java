//$Id$
package java8;

interface Interface {
	void call();
	default void display()
	{
		System.out.println( "Display" );
	}
}

class InterfaceImplementer implements Interface
{
	public void call()
	{
		System.out.println( "Calling" );
	}
}

public class InterfaceAnalysis
{
	public static void main( String arg [] )
	{
		Interface i = new InterfaceImplementer();
		 i.call();
		 i.display();
	}
}


