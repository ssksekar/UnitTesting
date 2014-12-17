//$Id$
package string;

public class ReplaceAllAnalysis {

	public static void main(String arg [])
	{
		String tobeReplaced = "Sathish {1} name should be replaced";
		
		tobeReplaced = tobeReplaced.replaceAll("\\{1\\}", "kumar");
		//tobeReplaced = tobeReplaced.replaceAll("\\{1\\}", null);
		
		System.out.println(tobeReplaced);
	}
	
	
}
