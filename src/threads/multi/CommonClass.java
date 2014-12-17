//$Id$
package threads.multi;

public class CommonClass {

	private static CommonClass commonClassObject = null;
	private int counter = 0; 
	
	private CommonClass()
	{
		
	}
	
	public static CommonClass getInstance()
	{
		if ( commonClassObject == null )
		{
			System.out.println( "Going to initiate the Object " );
			System.out.println( Thread.currentThread().getName() );
			commonClassObject = new CommonClass();
		}
		
		return commonClassObject;
	}
	
	
	public synchronized void incrementCounter()
	{
		this.counter++;
	}
	
	public int getCounter()
	{
		return this.counter;
	}
}
