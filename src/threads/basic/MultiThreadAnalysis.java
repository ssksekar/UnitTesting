//$Id$
package threads.basic;

public class MultiThreadAnalysis  implements Runnable {

	String userName; 
	
	public void run()
	{
		try{
			userName = Thread.currentThread().getName();
			System.out.println( "ThreadName Before sleep ::: " + Thread.currentThread().getName() );
			System.out.println( "UserName Before ::: " + userName );
			System.out.println();
			Thread.sleep(1000);
			
			System.out.println( "ThreadName After sleep ::: " + Thread.currentThread().getName() );
			System.out.println( "UserName Before ::: " + userName );
			System.out.println();
		}
		catch(Exception ex)
		{
			System.out.println( "Exception Caught" );
		}
	}
	
}


class mainClass
{
	public static void main( String arg [] ) throws Exception
	{
		Thread t1 = new Thread( new MultiThreadAnalysis() );
		Thread t2 = new Thread( new MultiThreadAnalysis() );
	//	t1.setName( "Sathish" );
		//t2.setName( "Vithya" );
		
		t2.start();
		t1.start();
	}
}