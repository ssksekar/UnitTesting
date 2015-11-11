//$Id$
package threadlocal;

public class ThreadLocalUtil {

	private static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();
	private static Long l = null;
	
	public static void setValue(Long userId)
	{
		threadLocal.set(userId);
		l = userId;
	}
	
	public void getThreadLocal()
	{
		System.out.println( "ThreadLocalUtil ::: " + Thread.currentThread().getName() + " ::: " + threadLocal.get() + " ::: " + l );		
	}
}
