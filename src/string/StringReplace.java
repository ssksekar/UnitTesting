//$Id$
package string;

public class StringReplace {
	
	public static void main(String arg [])
	{
		String str = "<img srd=\"http://indi/.com.jsp\"/> font-family: arial, helvetica, sans-serif;";
		System.out.println(str);
		str = str.replaceAll( "arial, helvetica, sans-serif", "'Open Sans', sans-serif" );//No I18N
		System.out.println(str);
	}

}
