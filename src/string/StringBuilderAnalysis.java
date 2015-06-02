//$Id$
package string;

public class StringBuilderAnalysis {

	public static void main(String [] arg)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("sathish");
		sb.append(",");
		sb.append("kumar");
		sb.append(",");
		sb.append("sekar");
		sb.append(",");
		
		String s = sb.substring( 0, sb.length() - 1 );
		
		System.out.println( s );
	}
	
}
