//$Id$
package httprelated;

import java.util.HashMap;
import java.util.Random;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONObject;

import com.adventnet.crm.integration.util.IntegrationUtil;

public class SendMail {

	public static void main (String [] arg) throws Exception
	{
		//String toAddr0 = "catchall@labbcc.localzoho.com";
		String [] msgIdArr = new String[]{"1329498000004375047", "1329498000004373045", "1329498000004371047", "1329498000004373043", "1329498000004372051", "1329498000004375045", "1329498000004373041", "1329498000004372049", "1329498000004373039", "1329498000004369007", "1329498000004371045", "1329498000004375043", "1329498000004375041", "1329498000004372045", "1329498000004375039", "1329498000004372043", "1329498000004371043", "1329498000004375037", "1329498000004371041", "1329498000004373037", "1329498000004375035", "1329498000004371039", "1329498000004373035", "1329498000004374045", "1329498000004371037", "1329498000004364009", "1329498000004375033", "1329498000004374043", "1329498000004374041", "1329498000004365011", "1329498000004374039", "1329498000004375031", "1329498000004364007", "1329498000004374037", "1329498000004372041", "1329498000004370005", "1329498000004371035", "1329498000004371033", "1329498000004371031", "1329498000004375029", "1329498000004364005", "1329498000004371029", "1329498000004365009", "1329498000004374035", "1329498000004372039", "1329498000004375027", "1329498000004375025", "1329498000004375023", "1329498000004374033", "1329498000004374031", "1329498000004371027", "1329498000004372037", "1329498000004372035", "1329498000004373033", "1329498000004373031", "1329498000004375021", "1329498000004372033", "1329498000004373029", "1329498000004375019", "1329498000004371025", "1329498000004375017", "1329498000004374029", "1329498000004375015", "1329498000004372031", "1329498000004372029", "1329498000004373027", "1329498000004371023", "1329498000004371021", "1329498000004372027", "1329498000004375013", "1329498000004374027", "1329498000004373025", "1329498000004375011", "1329498000004373023", "1329498000004372025", "1329498000004371019", "1329498000004375009", "1329498000004373021", "1329498000004372023", "1329498000004373019", "1329498000004371017", "1329498000004375007", "1329498000004374025", "1329498000004372021", "1329498000004372019", "1329498000004374023", "1329498000004374021", "1329498000004372017", "1329498000004371015", "1329498000004371013", "1329498000004371011", "1329498000004372015", "1329498000004371009", "1329498000004371007", "1329498000004372013", "1329498000004375005", "1329498000004373017", "1329498000004373015", "1329498000004374017"};
		String [] fromAddr = new String []{"sathish@crmmail.localzoho.com", 
				"rajamuthu@crmmail.localzoho.com", 
				"mani@crmmail.localzoho.com",
				"mahesh@crmmail.localzoho.com", 
				"saravanan@crmmail.localzoho.com", 
				"ponns@crmmail.localzoho.com", 
				"vembu@crmmail.localzoho.com", 
				"admin@crmmail.localzoho.com" };

		String [] toAddr = new String []{ "catchall@labbcc.localzoho.com", 
				"india-all@labbcc.localzoho.com", 
				"payments@labbcc.localzoho.com", 
				"support@labbcc.localzoho.com", 
				"mani@labbcc.localzoho.com",
				"catchall@labbcc.localzoho.com", 
				"arun@labbcc.localzoho.com", 
				"zohocrm@labbcc.localzoho.com", 
				"santhil@labbcc.localzoho.com", 
				"muniz@labbcc.localzoho.com", 
		"sales@labbcc.localzoho.com" };

		//	String [] fromAddr = new String []{ "admin@crmmail.localzoho.com" };
		
		int len = msgIdArr.length;
		Random random = new Random();
		//System.out.println(len);
		String action = "sendMail";
		String url = "https://zmail.localzoho.com/mail/MailAPI";
		
		//HashMap<String,String> postParam = new HashMap<String, String>();
		  
		  for ( int i = 0; i < len; i++ )
		  {
			  String [] content = getFileData(msgIdArr[i]);
				PostMethod postParam = new PostMethod(url)
				  {
				      @Override
				      public boolean getFollowRedirects()
				      {
				          return true;
				      }
				  };
			
			  	postParam.setParameter("action",action);		  
				postParam.setParameter("encoding","utf-8");	// No I18N
				postParam.setParameter("emailid", "admin@crmmail.localzoho.com"); // No I18N
				postParam.setParameter("toAddress", toAddr[random.nextInt(11)]); // No I18N
				postParam.setParameter("fromAddress",  fromAddr[random.nextInt(8)] ); // No I18N
				postParam.setParameter("subject",content[0]);// No I18N
				postParam.setParameter("text",content[1]);// No I18N
				postParam.setParameter("mode","compose");
				postParam.setParameter("mailFormat","2");
					
				postParam.setParameter("ticket","0a8a0c5aa03ba8f6ea698956a11f03d7");
								
				HttpClient httpZMailClient=new HttpClient();
				MultiThreadedHttpConnectionManager cm = new MultiThreadedHttpConnectionManager();
				cm.getParams().setConnectionTimeout(6000);
				httpZMailClient.setHttpConnectionManager(cm);			
				httpZMailClient.executeMethod(postParam);
	
				String response = postParam.getResponseBodyAsString();
				System.out.println( response );   
		  }
	}
	
	public static String[] getFileData( String messageId ) throws Exception
	{
		String [] content = new String []{"subject", "body"}; 
		System.out.println(messageId);
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("ticket", "cbd5e3cbc071aad4592598ba020d16e4");
		hm.put("emailid", "sathishkumar.sekar@zohocorp.com");
		hm.put("action", "getFileData");
		hm.put("getEnabled","true");
		hm.put("remoteAddr","192.168.29.242");
		hm.put("messageid",messageId);
		hm.put("from", "1");
		//hm.put("emailid", "sathishkumar.sekar@zohosmtpin.india.adventnet.com" );
		
		String resp = IntegrationUtil.connectToZohoServiceAPI(hm, "https://zmail.zoho.com/mail/MailAPI");
		//System.out.println(resp);
		
		JSONObject js = new JSONObject(resp);
		
		if ( js.has("SUBJECT") )
		{
			content = new String[]{ js.getString("SUBJECT"), js.getString("CONTENT") }; 
		}
		return content;
	}
}
