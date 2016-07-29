//$Id$
package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConncurrentListModification implements Runnable{

	private static List<Long> al = new ArrayList<Long>();
	private static Long counter = 0l;
	public void run()
	{
		/*
		for ( int i = 1; i <= 1000; i++ )
		{
			synchronized (al) {
				al.add( new Random().nextLong() );
			}			
			
			iterate();
		}
		*/
		try
		{
			System.out.println( "Start ::: " + Thread.currentThread().getName() );
			incr();
			System.out.println( "End ::: " + Thread.currentThread().getName() );
		}
		catch(Exception ex)
		{
			
		}
	}
	
	private synchronized static void incr() throws Exception
	{
		System.out.println( "Inside ::: " + Thread.currentThread().getName() );
		if ( counter == 0 )
		{
			System.out.println( "Inside 3333 ::: " + Thread.currentThread().getName() );
			counter = 10l + 1;
			Thread.sleep(1000l);
			System.out.println( counter );
		}
	}
	
	private synchronized static void iterate()
	{
		if ( al.size() >= 50 )
		{
			List<Long> al2 = new ArrayList<Long>(al);
			al = new ArrayList<Long>();
			
			for ( Long l : al2 )
			{
				counter++;
				System.out.println( counter + " ::: " + l );
			}
		}
	}
	
	public static void main(String arg[]) throws Exception
	{
		
		for ( int i = 1; i <= 10; i++ )
		{
			Thread t = new Thread( new ConncurrentListModification() );
			t.start();
		}
		
	}
}
