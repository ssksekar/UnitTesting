//$Id$
package string;

public class StringToObjectTypeCasting {

	public static void main (String [] arg)
	{
		String str = "12345";
		Object o = str;
		Long l = (Long) o;
		
		System.out.println( l );
	}
}
