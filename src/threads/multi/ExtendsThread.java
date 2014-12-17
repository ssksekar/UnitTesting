//$Id$
package threads.multi;

public class ExtendsThread extends Thread {

	public void run()
	{
		try{
			CommonClass commonClass = CommonClass.getInstance();
			
			for (int i = 0; i < 10; i++ )
			{
				commonClass.incrementCounter();
				
				if ( i == 5 )
				{
					synchronized( commonClass )
					{
						commonClass.wait();
					}
				}
				
				Thread.sleep( 1 );
			}
			
			System.out.println( Thread.currentThread().getName()  + " ::: " + commonClass.getCounter() );
		}
		catch(Exception ex)
		{
			
		}
	}
	
}
