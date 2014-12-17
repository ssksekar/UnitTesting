package threads.basic;





public class ThreadMainClass {

	public static void main( String arg [] ) throws Exception
	{
		Thread t = new Thread( new CreateThreadByImplementingRunnable() );
		  t.start();
	      try {
	         Thread.sleep(2000);
	      }
	      catch (InterruptedException x) {
	      }
	      System.out.println("in main() - 	      interrupting other thread");
	      t.interrupt();
	      System.out.println("in main() - leaving");
	}
}
