//$Id$
package threadlocal;

public class ThreadLocalMainClass {

	public static void main(String arg[])
	{
		Thread t = null;
		
		for (int i = 1; i < 5; i++ )
		{
			t = new Thread( new NewThreadImpl() );
			t.setName( String.valueOf( (i*1000) ) );
			t.start();
		}
	}
}
