//$Id$
package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import com.adventnet.crm.integration.emails.util.MailDetailsBean;

public class HashMapLoopingAnalysis {
	
	static int sum = 0;

	public static void main( String arg [] )
	{
		ConcurrentHashMap<Long, MailDetailsBean> hm = new ConcurrentHashMap<Long, MailDetailsBean>();
		HashMap<Long, MailDetailsBean> hm2 = new HashMap<Long, MailDetailsBean>();
		
		for ( int i = 1; i <= 40; i++ )
		{
			hm2.put( Long.valueOf(i), new MailDetailsBean(){{ setFromAddr( new Random().nextInt(20) + "@gmail.com" ); }} );
		}
		
		hm = new ConcurrentHashMap<Long, MailDetailsBean>(hm2);
		
		System.out.println( "SIZE ::: " + hm.size() );
		
		Iterator<Long> iter = hm.keySet().iterator();
		
		long startTime = System.currentTimeMillis();
		System.out.println( "0000 ::: " + hm );
		while ( iter.hasNext() )
		{
			Long l = iter.next();
			MailDetailsBean  zmailDet = hm.get( l );
			iter.remove();
			System.out.println( "11111 ::: " + l + " ::: " + zmailDet );
			iterAgain(hm);
			System.out.println( "33333 ::: " + hm );
			if ( zmailDet != null )
			{
				if ( zmailDet.getFromAddr().equals( new Random().nextInt(10) + "@gmail.com" ) )
				{
					//System.out.println( hm );
					
					//System.out.println( hm );
					//iterAgain(hm);
				}
			}
		}

		//System.out.println( System.currentTimeMillis() - startTime );
		//System.out.println( sum );
	}
	
	private static void iterAgain( ConcurrentHashMap<Long, MailDetailsBean> hm )
	{
		Iterator<Long> iter = hm.keySet().iterator();
		System.out.println( "22222 ::: " + hm );
		sum += hm.size();
		while ( iter.hasNext() )
		{
			iter.next();
			iter.remove();
			/*
			Long l = iter.next();
			MailDetailsBean  zmailDet = hm.get( l );
			if ( zmailDet != null )
			{
				if ( zmailDet.getFromAddr().equals( new Random().nextInt(10) + "@gmail.com" ) )
				{
					iter.remove();
				}
			}
			*/
		}
	}
}
