//$Id$
package threads.multi;

public class MainClass {

	public static void main(String arg[]) throws Exception
	{
		ExtendsThread extendsThread = new ExtendsThread();
		extendsThread.start();
		Thread.sleep( 2 );
		Thread implementsThread = new Thread( new ImplementsRunnable() );
		implementsThread.start();
	}
	
}
