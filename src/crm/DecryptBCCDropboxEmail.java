//$Id$
package crm;

import com.adventnet.crm.security.util.Base36EncryptDecrypt;

public class DecryptBCCDropboxEmail {
	
	public static void main( String [] arg ) throws Exception
	{
		System.out.println( Base36EncryptDecrypt.decrypt("wk7043") );
		System.out.println( Base36EncryptDecrypt.decrypt("k7fepb") );
	}
}
