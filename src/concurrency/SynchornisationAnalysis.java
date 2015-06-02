//$Id$
package concurrency;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SynchornisationAnalysis implements Runnable{
	
	private static Map<Long, List<Boolean>> userIdVsList = new HashMap<Long, List<Boolean>>();
	//private static List<Long> userIdList = new ArrayList<Long>();

	public static void main( String arg [] ) throws Exception
	{
		Thread t1 = new Thread( new SynchornisationAnalysis() );
		t1.setName("Thread-1");
		t1.start();		
		
		Thread t2 = new Thread( new SynchornisationAnalysis() );
		t2.setName("Thread-2");
		t2.start();		
	}
	
	public void run()
	{
		try{
			
			Random random = new Random();
			
			for ( int i = 0; i < 5; i++ )
			{
				syncBlock( (long) random.nextInt(5) );
			}
			
			syncBlock( 111111l );
		}
		catch(Exception ex)
		{
			System.out.println( ex );
		}
		
	}
	
	private static synchronized void populate( Long userId ) throws Exception
	{
		List<Boolean> listBool = userIdVsList.get( userId );
		System.out.println( Thread.currentThread().getName() + " ::: 111111 ::: " + userId + " ::: " + userIdVsList );
		if ( listBool == null )
		{
			userIdVsList.put(userId, new ArrayList<Boolean>());
		}
	}
	
	private static void syncBlock( Long userId ) throws Exception
	{
		populate(userId);
		
		System.out.println( Thread.currentThread().getName() + " ::: 222222 ::: " + userId + " ::: " + userIdVsList );
		
		synchronized ( userIdVsList.get(userId) ) 
		{
			Thread.sleep( 2000l );
			System.out.println( Thread.currentThread().getName() + " ::: 3333333 ::: " + userId + " ::: " + new Timestamp( System.currentTimeMillis() ) );
			
		}	
	}
	
}
