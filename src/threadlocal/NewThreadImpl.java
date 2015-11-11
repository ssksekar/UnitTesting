//$Id$
package threadlocal;

public class NewThreadImpl implements Runnable{

	@Override
	public void run() {
		System.out.println( "NewThreadImpl ::: " + Thread.currentThread().getName() );		
		
		ThreadLocalUtil.setValue( Long.valueOf( Thread.currentThread().getName() ) );
		
		new ThreadLocalUtil().getThreadLocal();
	}

}
