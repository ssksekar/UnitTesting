//$Id$
package classanalysis;

public class ImplementingInterfaceMainClass {

	public static void main( String arg [] ) throws Exception
	{
		CRMInterface crm = new CassandraClass();
		CRMInterface crm2 = new SathishClass();
		
		System.out.println( crm2.listKeys );
	}
	
}
