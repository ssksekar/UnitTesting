//$Id$
package performance;

public class OOM {
	static final int SIZE=600*1024*1024;
	  
	public static void main(String[] a) 
	{
		System.out.println( "Started" );
		int[] i = new int[SIZE];
	    System.out.println( "Done" );
	}
}
