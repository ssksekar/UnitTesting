//$Id$
package string;


public class InefficientEmptyStringCheck {

	public static void main(String arg [])
	{
		String str = " a";
		
		System.out.println( isEmptyString(null) );
		
	}
	
	public static boolean isEmptyString( String str )
    {
    	if ( str != null )
    	{
    		int strLen = str.length();
    		
    		for ( int i = 0; i < strLen; i++ )
    		{
    			if ( !Character.isWhitespace( str.charAt( i ) ) )
    			{
    				return false;
    			}
    		}
    		
    	}
    	
    	return true;
    }
}
