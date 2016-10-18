//$Id$
package crm;

import com.adventnet.iam.CryptoUtil;

public class CryptoUtilAnalysis {

	public static void main(String arg[]) throws Exception
	{
		System.out.print(CryptoUtil.decrypt("CRM_CUSTOM_HEADER", "405aa55992e3c58c6b686f1a4d37c76f820b3be4b3aacf8858b175ca0e892b10") );
	}
	
}
