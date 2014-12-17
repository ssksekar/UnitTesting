//$Id$
package math;

public class ArithematicOperations {

	public static void main(String [] arg) throws Exception
	{
		String a = "893276573645874368486574";
		String b = "4358734203975938452354854576486392";
		
		int aLen = a.length();
		int bLen = b.length();
		
		/* making sure both string contains the same length */
		if ( aLen > bLen )
		{
			b = appendZero( aLen, bLen, b );
		}
		else if ( bLen > aLen )
		{
			a = appendZero( bLen, aLen, a );
			aLen = a.length();
		}
			
		System.out.println( a );
		System.out.println( b );
		String result = "";
		String aChar = null;
		String bChar = null;
		String [] operationResult;
		
		int carryOver = 0;
		int aInt = 0;
		int bInt = 0;
		
		for (int index = aLen - 1; index > -1; index--) 
		{
			aChar = a.substring( index, index + 1 );
			bChar = b.substring( index, index + 1 );
			
			aInt = Integer.parseInt(aChar);
			bInt = Integer.parseInt(bChar);
			
			operationResult = add( aInt, bInt, carryOver );
			
			if ( operationResult.length == 2 )
			{
				result = operationResult[1] + result;
				carryOver = Integer.parseInt( operationResult[0] );
				
				/* if loop runs for last time, have to include entire digits */
				if ( index == 0 && !operationResult[0].equals("0") )
				{
					result = operationResult[0] + result;
				}
			}
			else if ( operationResult.length == 1 )
			{
				result = operationResult[0] + result;
				carryOver = 0;				
			}
		}
		
		System.out.println( result );
		
		for (int index = aLen - 1; index > -1; index--) 
		{
			aChar = a.substring( index, index + 1 );
			bChar = b.substring( index, index + 1 );
			
			aInt = Integer.parseInt(aChar);
			bInt = Integer.parseInt(bChar);
			
			operationResult = add( aInt, bInt, carryOver );
			
			if ( operationResult.length == 2 )
			{
				result = operationResult[1] + result;
				carryOver = Integer.parseInt( operationResult[0] );
				
				/* if loop runs for last time, have to include entire digits */
				if ( index == 0 && !operationResult[0].equals("0") )
				{
					result = operationResult[0] + result;
				}
			}
			else if ( operationResult.length == 1 )
			{
				result = operationResult[0] + result;
				carryOver = 0;				
			}
		}
		
	}
	
	/* maximum value will be only 2 digits */
	static String[] add( int a, int b, int carryover ) throws Exception
	{
		int result = a + b + carryover;
		
		String resultStr = String.valueOf( result );
		String resultArr [] = new String[resultStr.length()];
		
		for ( int i = resultStr.length() - 1; i > -1; i-- )
		{
			resultArr[i] = resultStr.substring( i, i+1 );
		}
		
		return resultArr;
	}
	
	static String appendZero(int len1, int len2, String str)
	{
		int appendZero = len1 - len2;
		
		for( int i = 0; i < appendZero; i++ )
		{
			str = "0" + str;  
		}
		
		return str;
	}
	
}
