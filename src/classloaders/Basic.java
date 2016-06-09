//$Id$
package classloaders;

import sun.net.spi.nameservice.dns.DNSNameService;

public class Basic {

	public static void main(String str [])
	{
		System.out.println( String.class.getClassLoader() );
		System.out.println( DNSNameService.class.getClassLoader() );
		System.out.println( ClassLoader.getSystemClassLoader() );
		System.out.println( ClassLoader.getSystemClassLoader() );
		System.out.println( Thread.currentThread().getContextClassLoader() );
	}
}	
