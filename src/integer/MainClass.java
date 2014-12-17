//$Id$
package integer;

import com.adventnet.crm.integration.emails.util.EmailCassandraUtil.EmailCassandraUtilBean;

public class MainClass {

	public static void main(String arg [])
	{
		int a = 1;
		Integer b = 1;
		System.out.println( Integer.valueOf(a) instanceof Integer );
		call( Integer.valueOf(a) );
		
		System.out.println( EmailCassandraUtilBean.class.getCanonicalName() );
		System.out.println( EmailCassandraUtilBean.class );
		System.out.println( EmailCassandraUtilBean.class.getSimpleName() );
		System.out.println( EmailCassandraUtilBean.class.getName() );
		
		System.out.println( ((Integer) null).intValue() );
		
	}	
	
	private static void call ( Integer a )
	{
		System.out.println( a );
		final int ca = 1;
		
		switch(a)
		{
		case ca:
			System.out.println( "Done" );
		}
	}
}
