//$Id$
package string;

import java.util.Iterator;
import java.util.StringTokenizer;

import com.adventnet.crm.common.util.PMDConstants;

public class StringTokenizerAnalysis {
	
	public static void main(String arg[])
	{
		String emailAddress =  null;
		StringTokenizer strToken = new StringTokenizer(emailAddress, PMDConstants.COMMA_DELIMTER);
		System.out.println( strToken );
		
		
		while ( strToken.hasMoreTokens() )
		{
			System.out.println( strToken.nextToken() );
		}
	}

}
