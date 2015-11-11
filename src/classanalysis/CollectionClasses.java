//$Id$
package classanalysis;

import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;

public class CollectionClasses {

	public static void main(String arg[])
	{
		ArrayList<Long> al = new ArrayList<Long>();
		
		System.out.println( DigestUtils.md5Hex("") ) ;
	}
	
}
