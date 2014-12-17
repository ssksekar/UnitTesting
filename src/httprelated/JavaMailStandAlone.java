//$Id$
package httprelated;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

import com.adventnet.crm.workflow.util.CrmWorkFlowConstants;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public class JavaMailStandAlone {
	public static void main(String[] args) throws Exception
	{
		String smtpport = "25";

		// Recipient's email ID needs to be mentioned.
		String to = "<sathishkumar.sekar@zohocorp.com>";

		// Sender's email ID needs to be mentioned
		String from = "<ssksekar@gmail.com>";

		// Assuming you are sending email from localhost
		String host = "127.0.0.1";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", "smtp");
		//properties.setProperty("mail.smtp.port", smtpport);

		// Get the default Session object.
		Session session = Session.getInstance(properties, null);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			SendViaPowerMTA(message);
			
			// Send message
			//Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	public static void SendViaPowerMTA(MimeMessage msg) throws Exception
	{
		String url = "https://campaigns.localzoho.com/api/sendtransmail";  //No I18N
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("servicename", "ZohoCRM");  // No i18N    
        params.put("servicekey", "964cf1a344870c6775d6ca3f9e1ba59f");   // No i18N
        params.put("ticket","5256b12322c5811ae4bcd77387f9bf5d"); // No I18N
        params.put("orgid","123456789");  // No i18N
        params.put("jobid","0987654321" ); 
        System.out.println("CONTENT ::: " + msg.getContent());
        System.out.println("FROM ::: " + msg.getFrom()[0]);
        System.out.println("------------------");
        msg.writeTo(System.out);
        System.out.println("------------------");
        ByteOutputStream boss = new ByteOutputStream();
        System.out.println(boss);
        System.out.println("------------------");
        msg.writeTo(boss);
        System.out.println("::::  " + boss);
        System.out.println("------------------");
        byte[] bytesArr = boss.getBytes();
        System.out.println(bytesArr);
        System.out.println("------------------");
        System.out.println(new String(bytesArr));
        System.out.println("------------------");
        params.put("mimemessage", new String(bytesArr) );   // No i18N
        params.put("typeofmail", "appln");   // No i18N
        //String postResp = connectToZohoServiceAPI(params, url, CrmWorkFlowConstants.WF_WH_METHOD_POST);
        //System.out.println("postResp ::: " + postResp);
    }    

	

	public static String connectToZohoServiceAPI(HashMap<String, Object> postParam, String targetURL, String methodType) throws Exception{
		InputStream in=null;
		try {
			in=connectToZohoServiceAPIAndGetResponseAsStream(postParam, targetURL, methodType);
			String postResp=convertStreamToString(in);
			return postResp;
	
		} catch (Exception e) {
			System.out.println("222222" + e);
		}
		finally {
			if(in!=null) {
				in.close();
			}
		}
		return null;
	}
	
	public static String convertStreamToString(InputStream is) throws Exception
	{
		if (is != null)
		{
			StringBuilder sb = new StringBuilder();
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));//No I18N
			while ((line = reader.readLine()) != null)
			{
				sb.append(line).append("\n");//No I18N
			}
			is.close();
			reader.close();
			return sb.toString();
		}
		return "";//No I18N
	}
	
	public static InputStream  connectToZohoServiceAPIAndGetResponseAsStream(HashMap<String, Object> postParam, String targetURL, String methodType) throws Exception {
		PostMethod post = null;
		GetMethod get = null;
		PutMethod put = null;
		HttpClient httpclient = null;
		List<NameValuePair> nvPairList = new ArrayList<NameValuePair>();
	//	int res = 0;
		try {
			if (CrmWorkFlowConstants.WF_WH_METHOD_GET.equals(methodType)) {
				get = new GetMethod(targetURL);			
			} else if (CrmWorkFlowConstants.WF_WH_METHOD_PUT.equals(methodType)) {
				put = new PutMethod(targetURL);
			} else {
				post = new PostMethod(targetURL);
			}
			
			Set setParam = postParam.entrySet();
			Iterator itParam = setParam.iterator();
	
			while (itParam.hasNext()) {
				Map.Entry me = (Map.Entry) itParam.next();
				String mapKey = (String) me.getKey();
				Object mapVal = (Object) me.getValue();
				
				NameValuePair nvPair = new NameValuePair(mapKey+"", mapVal+"");
				nvPairList.add(nvPair);					
				////post.setParameter(mapKey+"", mapVal+"");
			}
	
			httpclient = new HttpClient();
			MultiThreadedHttpConnectionManager cm = new MultiThreadedHttpConnectionManager();
			HttpConnectionManagerParams params = cm.getParams();
			params.setConnectionTimeout(10000);
			params.setSoTimeout(300000); //set socket timeout (how long it takes to retrieve data from remote host)
			httpclient.setHttpConnectionManager(cm);
	
			InputStream postResp = null;
			httpclient.getParams().setParameter("http.protocol.content-charset", "UTF-8"); //No I18N
			if (CrmWorkFlowConstants.WF_WH_METHOD_GET.equals(methodType)) {
				if (!nvPairList.isEmpty()) {
					get.setQueryString(nvPairList.toArray(new NameValuePair[nvPairList.size()]));
				}
				httpclient.executeMethod(get);
				postResp = new ByteArrayInputStream(get.getResponseBody());
			} else if (CrmWorkFlowConstants.WF_WH_METHOD_PUT.equals(methodType)) {
				if (!nvPairList.isEmpty()) {
					//for (NameValuePair nvPair : nvPairList) {
						put.setQueryString(nvPairList.toArray(new NameValuePair[nvPairList.size()]));
						//put.setParams();
						//put.setParameter(nvPair.getName(), nvPair.getValue());
					//}					
				}
				httpclient.executeMethod(put);
				postResp = new ByteArrayInputStream(put.getResponseBody());
			} else {
				if (!nvPairList.isEmpty()) {
					for (NameValuePair nvPair : nvPairList) {
						post.setParameter(nvPair.getName(), nvPair.getValue());
					}					
				}
				httpclient.executeMethod(post);
				postResp = new ByteArrayInputStream(post.getResponseBody());
			}
			
			return postResp;
	
		} catch (Exception e) {
			System.out.println("11111111" + e);
		} finally {
			if (post != null) {
				post.releaseConnection();
			}
			if (get != null) {
				get.releaseConnection();
			}
			if (put != null) {
				put.releaseConnection();
			}
		}
		return null;
	
	}
	
	
	public static void sendHTTPrequest (HashMap<String, Object> parmas) throws Exception
	{
		Random random = new Random();
		//System.out.println(len);
		String action = "sendMail";
		String url = "http://zmail.localzoho.com/mail/CrmMailAPI";

		PostMethod postParam = new PostMethod(url)
		{
			      @Override
			      public boolean getFollowRedirects()
			      {
			          return true;
			      }
		};
		
		
		for ( Map.Entry<String, Object> entry : parmas.entrySet())
		{
			//postParam.setParameter( entry.getKey(), entry.getValue() );
		}
			  
		/*	  
		postParam.setParameter("action",action);		  
		postParam.setParameter("encoding","utf-8");	// No I18N
		postParam.setParameter("emailid", "admin@crmmail.localzoho.com"); // No I18N
		postParam.setParameter("toAddress", toAddr[random.nextInt(11)]); // No I18N
		postParam.setParameter("fromAddress",  fromAddr[random.nextInt(8)] ); // No I18N
		postParam.setParameter("subject",content[0]);// No I18N
		postParam.setParameter("text",content[1]);// No I18N
		postParam.setParameter("mode","compose");
		postParam.setParameter("mailFormat","2");
		*/	
		
		HttpClient httpZMailClient=new HttpClient();
		MultiThreadedHttpConnectionManager cm = new MultiThreadedHttpConnectionManager();
		cm.getParams().setConnectionTimeout(6000);
		httpZMailClient.setHttpConnectionManager(cm);			
		httpZMailClient.executeMethod(postParam);

		String response = postParam.getResponseBodyAsString();
		System.out.println( response );   
	  
	}
}
