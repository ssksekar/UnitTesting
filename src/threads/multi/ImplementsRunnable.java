//$Id$
package threads.multi;

public class ImplementsRunnable implements Runnable {

	public void run() 
	{
		try{
			CommonClass commonClass = CommonClass.getInstance();
			
			for (int i = 0; i < 10; i++ )
			{
				commonClass.incrementCounter();
				Thread.sleep( 1 );
			}
			synchronized( commonClass )
			{
				commonClass.notify();
			}
			System.out.println( Thread.currentThread().getName()  + " ::: " + commonClass.getCounter() );
		}
		catch(Exception ex)
		{
			
		}
		
	}
	
}
