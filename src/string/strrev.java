//$Id$
package string;

import java.util.ArrayList;
import java.util.LinkedList;

public class strrev {

	public static void main(String [] arg )
	{
		String input = "​Wherever you're, Chat connects: quick and easy !";
		//String inputList
		System.out.println( input );
		System.out.println("​easyandq uic'kc, onne ctsChaty: oureW her ever !");
		
		LinkedList<String> delimiters = new LinkedList<String>();
		delimiters.add(" ");
		delimiters.add("'");
		delimiters.add(":");
		delimiters.add("!");
		delimiters.add(",");
		
		for ( String delimiter : delimiters )
		{
			
		}
		
	}
}
