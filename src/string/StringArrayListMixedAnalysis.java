//$Id$
package string;

import java.util.ArrayList;
import java.util.List;

import com.adventnet.crm.common.util.PMDConstants;

public class StringArrayListMixedAnalysis {

	public static void main(String arg []) throws Exception
	{
		String labelIds = "    sathish,      kumar    , asdaas   ";
		
		List<String> labelList = convertCommaSepratedStringToList(labelIds);
		
		System.out.println( labelList );
		labelList.remove( "kumar" );
		System.out.println( labelList );
		labelIds = labelList.toString();
		System.out.println( labelIds );
		
		System.out.println( String.valueOf( null ) );
	}
	
	public static List<String> convertCommaSepratedStringToList( String commaSepratedStr ) throws Exception
	{
		if ( commaSepratedStr != null )
		{
			List<String> list = new ArrayList<String>();
			
			commaSepratedStr = commaSepratedStr.trim();
			String str [] = commaSepratedStr.split( PMDConstants.COMMA_DELIMTER );
			
			for ( String s : str )
			{
				list.add( s.trim() );
			}
			
			return list;
		}
		
		return null;
	}
}
