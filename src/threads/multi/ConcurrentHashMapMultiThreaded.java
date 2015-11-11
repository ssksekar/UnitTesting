//$Id$
package threads.multi;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapMultiThreaded implements Runnable {

	static ConcurrentHashMap<Long, ArrayList<ArrayList<String>>> chm = new ConcurrentHashMap<Long, ArrayList<ArrayList<String>>>();
	
	@Override
	public void run() {
		try
		{
			if ( Thread.currentThread().getName().equals( "thread1" ) )
			{
				System.out.println( chm );
				ArrayList<ArrayList<String>> asd = chm.get( 11111l );
				boolean stop = true;
				while( stop )
				{
					//asd = chm.get( 11111l );
					if ( asd != null && !asd.isEmpty() )
					{
						System.out.println( "Pakka ::: "  + chm );
						stop = false;
					}
					else
					{
						Thread.sleep( 2000 );
						System.out.println( "Mokka ::: "  + chm );
					}
				}				
			}
			else if ( Thread.currentThread().getName().equals( "thread2" ) )
			{
				Thread.sleep( 5000l );
				/* chm.put( 11111l, new ArrayList<ArrayList<String>>(){{
					add( new ArrayList<String>(){{
						add("Sathish");
						add("PSP");
						add("Tamil");
					}} );
				}} );
				*/
				ArrayList<ArrayList<String>> asd = chm.get( 11111l );
				asd.add(new ArrayList<String>(){{
					add("Sathish");
					add("PSP");
					add("Tamil");
				}} ); 
			}
		}
		catch(Exception ex)
		{
			
		}
	}
	
	public static void main(String arg [])
	{
		chm.put( 11111l, new ArrayList<ArrayList<String>>() );
		
		Thread thread1 = new Thread( new ConcurrentHashMapMultiThreaded() );
		Thread thread2 = new Thread( new ConcurrentHashMapMultiThreaded() );
		
		thread1.setName("thread1");
		thread2.setName("thread2");
		
		thread1.start();
		thread2.start();
	}

}
