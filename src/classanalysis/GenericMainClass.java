//$Id$
package classanalysis;

public class GenericMainClass {

	public static void main(String arg []) throws Exception
	{
		System.out.println( "Sathish" );
		
		GenericClass<Long, String, Long> generic  = new GenericClass<Long, String, Long>(1111l);
		System.out.println( generic.getInfo() );
	}

}
