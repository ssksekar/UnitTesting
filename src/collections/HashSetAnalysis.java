//$Id$
package collections;

import java.util.ArrayList;
import java.util.HashSet;

import com.adventnet.crm.common.util.CommonUtil;

import enumanalysis.*;

public class HashSetAnalysis {

	public static void main (String arg [])
	{
		HashSet<String> hs = new HashSet<String>();
		hs.add("sathish");
		hs.add("sathish");
		hs.add("sathish");
		hs.add("kumar");
		hs.add("sekar");
		hs.add("sekar");
		hs.add("sekar");
		hs.add("sekar");
		hs.add("praba");
		
		System.out.println(hs);
		//System.out.println( CommonUtil.convertArrayListToCommaSepratedString( new ArrayList<String>(hs) ) );
		
		HashSet<String> hs2 = new HashSet<String>(hs);
		HashSet<String> hs3 = hs;
		
		hs3.add( "vithys" );
		hs.add( "Mok" );
		hs2.add( "har" );
		
		System.out.println(hs);
		System.out.println(hs2);		
		for(String s : hs)
		{
			//System.out.println(s);
		}
	}
}
