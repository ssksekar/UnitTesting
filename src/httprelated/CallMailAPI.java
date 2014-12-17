//$Id$
package httprelated;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.adventnet.crm.common.util.CrmConstants;
import com.adventnet.crm.common.util.PMDConstants;
import com.adventnet.crm.integration.emails.util.FetchZMailAPI;
import com.adventnet.crm.integration.emails.util.ZMailConstants;
import com.adventnet.crm.integration.util.IntegrationUtil;

public class CallMailAPI {

	public static final HashMap<String, String> authentication = new HashMap<String, String>(){{ put( PMDConstants.TICKET, "d98cc10f576c99d21fec4071574845aa" ); }};
	public static final HashMap<String, String> authenticationISC = new HashMap<String, String>(){{ put( PMDConstants.ISC_TICKET, "7b39e79275afff340e07b9257b2497fa" );put( PMDConstants.ISC_ZUID, "533299" );put( PMDConstants.ISC_SCOPE, "crmmailapi" ); }};
	public static final String localUrl = "https://zmail.localzoho.com/mail/MailAPI";
	public static final String myLapUrl = "http://mail-fedora13-1.csez.zohocorpin.com:8080/mail/MailAPI";
	public static final String idcUrl = "https://zmail.zoho.com/mail/MailAPI";
	//public static final String idcUrl = "https://mail.skydesk.jp/mail/MailAPI";
	
	public static void main(String [] a) throws Exception
	{
		//getFileData();
		getNewMails();
		//getConversations();
		//getResults();
		//getMailsList();
		//getAllFromAddress();
		//getAccountDetails();
		//getMessageHeaders();
		//getAllFromAddress();
		//isMailBoxExists();
		
		getSupportReq();
	}
	
	public static void getFileData() throws Exception
	{
		HashMap<String, String> postParam = new HashMap<String, String>();
//		postParam.put("accId", "2349029000000008001");
		postParam.put("email", "sathishkumar.sekar@zohocorp.com");
		postParam.put("action", "getFileData");
		postParam.put("messageid", "1329498000012914025");		
		postParam.putAll(authentication);

		System.out.println( postParam );
		 /* http://mail-fedora13-1.csez.zohocorpin.com:8080/mail/MailAPI?ticket=79649cae31376b704d2c8b90d8b99f48&action=getFileData&messageid=35000000002012&accId=35000000000221 */
		String resp = IntegrationUtil.connectToZohoServiceAPI(postParam, idcUrl);
		System.out.println(resp);
	}
	
	public static void getNewMails() throws Exception
	{
		HashMap<String, String> postParam = new HashMap<String, String>();
		
		postParam.put("emailid", "ssksekar@zoho.com");
		postParam.put("action", "getNewMails");
		postParam.put("remoteAddr","192.168.29.242");
		postParam.put("limit", "200");
		postParam.put("rTime", "1415810678000");
		postParam.put("includeTo", "true");
		postParam.put("deliveredTo", "true");
		postParam.putAll(authentication);
		
		//postParam.put("folderid", "1329498000003817001");
		
		String resp = IntegrationUtil.connectToZohoServiceAPI(postParam, idcUrl);
		System.out.println(resp);
	}
	
	public static void getConversations() throws Exception
	{
		HashMap<String, String> postParam = new HashMap<String, String>();
		
		/*
		postParam.put("iscticket", "751921849d00e31b90d82d4d35f439f6");
		postParam.put("isczuid", "10403323");
		postParam.put("iscscope", "crmmailapi");
		*/
		postParam.put("emailid", "ssk.zoho@gmail.com");
		postParam.put("action", "getConversation");
		postParam.put("includeTo", "true");
		postParam.put("includeFolder", "true");
		postParam.put("messageid", "1329498000006372007");
		postParam.putAll(authentication);
		//postParam.put("folderid", "1329498000003817001");
		
		String resp = IntegrationUtil.connectToZohoServiceAPI(postParam, idcUrl);
		System.out.println(resp);
		
		// response ::: [{"F":"admin@crmmail.localzoho.com","A":false,"TH":1,"TO":"<ssksekar@crmmail.localzoho.com>","S2":"","DT":"Jun 25","children":"1010557000000212001","S1":"read","NT":0,"M":"1010557000000211001","T":"1010557000000211001","ST":"1372135755000","FN":"Sent","SZ":"0","P":"Normal","S":1,"R":"1372155555328","TC":0,"NFG":"0","AT":0,"AR":0,"FD":"1010557000000005019","HC":0,"SN":"admin","SM":"pass123The MX Records of your domain are not pointed to Zoho. You may not receiv","NS2":0,"PR":0,"SB":"The MX Records of your domain are not pointed to Zoho. You may not receive emails in Zoho.   Hide | Learn More"},{"F":"ssksekar@crmmail.localzoho.com","A":false,"TH":1,"S2":"","DT":"Jun 25","S1":"read","NT":0,"M":"1010557000000212001","T":"1010557000000211001","ST":"1372135771000","FN":"Inbox","SZ":"0","P":"Normal","S":1,"R":"1372155574122","TC":0,"NFG":"0","AT":0,"AR":0,"FD":"1010557000000005013","HC":0,"SN":"ssksekar","SM":"ok On Tue, 25 Jun 2013 15:49:15 +0530 admin &lt;admin@crmmail.localzoho.co","NS2":0,"PR":0,"SB":"Re: The MX Records of your domain are not pointed to Zoho. You may not receive emails in Zoho.   Hide | Learn More"}] 
	}
	
	
	public static void getResults() throws Exception
	{
		HashMap<String, String> postParam = new HashMap<String, String>();
		/*
		postParam.put("iscticket", "3068f2b0bc5e827e2850f2ae54b93fec");
		postParam.put("isczuid", "10533823");
		postParam.put("iscscope", "crmmailapi");
		*/
		//postParam.put("emailid", "catchall@labbcc.localzoho.com");
		postParam.put("fromemailid", "angelad@scat.com.au");
		postParam.put("searchid", "scott@bravium.com.au");
		
		//postParam.put(ZMailConstants.ZMAIL_ACCOUNTID, "1143012000000008003");
		postParam.put( ZMailConstants.INCLUDEARCHIVE, PMDConstants.TRUE ); // No I18N
		postParam.put( ZMailConstants.AFN, PMDConstants.TRUE ); // No I18N
		postParam.put( ZMailConstants.STRICTCHECK, PMDConstants.FALSE ); // No I18N
		postParam.put( ZMailConstants.FROM_CONST, "0" ); // No I18N
		postParam.put( ZMailConstants.RANGE, "200" ); // No I18N
		postParam.put( PMDConstants.ACTION, "getResults" ); // No I18N
		postParam.putAll(authentication);
		 
		String resp = IntegrationUtil.connectToZohoServiceAPI(postParam, idcUrl);
		System.out.println(" Response :::  " + resp);
		
		
		//response ::: [{"F":"catchall@labbcc.localzoho.com","A":false,"TH":1,"S2":"","DT":"05:16 PM","S1":"read","NT":0,"M":"1014957000000052005","T":"1014957000000055003","ST":"1373782616000","FN":"Inbox","SZ":"5302","P":"Normal","S":1,"R":"1373802418291","TC":0,"NFG":"0","AT":0,"AR":0,"FD":"1014957000000005013","HC":0,"SN":"catchall","SM":"request.getAttribute( ZMailConstants.MESSAGEID_LOWER_CASE ) On Sun, 14 Jul 2013 17:16","NS2":0,"AFN":"Inbox","PR":3,"SB":"Re: Re: [##2279868##] Re: Search API Key for Baihui & SkyDesk CRM"},{"F":"catchall@labbcc.localzoho.com","A":false,"TH":1,"S2":"replied","DT":"05:16 PM","S1":"read","NT":0,"M":"1014957000000055003","T":"1014957000000055003","ST":"1373782594000","FN":"Inbox","SZ":"4507","P":"Normal","S":1,"R":"1373802396664","TC":0,"NFG":"0","AT":0,"AR":0,"FD":"1014957000000005013","HC":0,"SN":"catchall","SM":"request.getAttribute( ZMailConstants.MESSAGEID_LOWER_CASE ) Jun 20 rajamuthu@crmmail.","NS2":1,"AFN":"Inbox","PR":3,"SB":"Re: Re: [##2279868##] Re: Search API Key for Baihui & SkyDesk CRM"},{"F":"catchall@labbcc.localzoho.com","A":false,"TH":1,"S2":"","DT":"05:12 PM","S1":"read","NT":0,"M":"1014957000000052003","T":"1014957000000055001","ST":"1373782324000","FN":"Inbox","SZ":"4900","P":"Normal","S":1,"R":"1373802126426","TC":0,"NFG":"0","AT":0,"AR":0,"FD":"1014957000000005013","HC":0,"SN":"catchall","SM":"ecefdze On Sun, 14 Jul 2013 17:08:40 +0530 catchall &lt;catchall@labbcc.lo","NS2":0,"AFN":"Inbox","PR":3,"SB":"Re: [ Hg Admin ] : security-crud.xml checked in the branch ZOHOCRM_USER_TERRITORY_MANAGEMENT_BRANCH by muniasankar.d"},{"F":"catchall@labbcc.localzoho.com","A":false,"TH":1,"S2":"replied","DT":"05:08 PM","S1":"read","NT":0,"M":"1014957000000055001","T":"1014957000000055001","ST":"1373782120000","FN":"Inbox","SZ":"4541","P":"Normal","S":1,"R":"1373801922849","TC":0,"NFG":"0","AT":0,"AR":0,"FD":"1014957000000005013","HC":0,"SN":"catchall","SM":"request.getAttribute( ZMailConstants.MESSAGEID_LOWER_CASE ) Jun 20 mahesh@crmmail.loc","NS2":1,"AFN":"Inbox","PR":3,"SB":"Re: [ Hg Admin ] : security-crud.xml checked in the branch ZOHOCRM_USER_TERRITORY_MANAGEMENT_BRANCH by muniasankar.d"},{"F":"mailer-daemon@mail.zoho.com","A":false,"TH":0,"S2":"","DT":"Jul 10","M":"1014957000000050001","NT":0,"S1":"read","ST":"1373459874000","SZ":"1205","P":"Normal","FN":"Inbox","S":1,"R":"1373479675842","NFG":"0","AT":0,"AR":0,"FD":"1014957000000005013","HC":0,"SN":"mailer-daemon@mail.zoho.com","SM":"This message was created automatically by mail delivery system.  THIS IS A WAR","NS2":0,"AFN":"Inbox","PR":3,"SB":"Mail Delivery Status Notification (Delay)"},{"F":"catchall@labbcc.localzoho.com","A":false,"TH":0,"S2":"","DT":"Jul 8","M":"1014957000000047001","NT":0,"S1":"read","ST":"1373252314000","SZ":"6384","P":"Normal","FN":"Inbox","S":1,"R":"1373272118218","NFG":"0","AT":0,"AR":0,"FD":"1014957000000005013","HC":0,"SN":"catchall","SM":"suer Jun 21 vembu@crmmail.localzoho.com wrote Zoho ForumsHi sathis","NS2":0,"AFN":"Inbox","PR":3,"SB":"Re: Re: [Zoho CRM] How do I stop someone from spamming my web to lead form?[TopicId]=2266000004095749"},{"F":"catchall@labbcc.localzoho.com","A":true,"TH":0,"S2":"","DT":"Jun 28","M":"1014957000000045005","NT":0,"S1":"read","ST":"1372392438000","SZ":"79876","P":"Normal","FN":"Inbox","S":1,"R":"1372412240864","NFG":"0","AT":1,"AR":0,"FD":"1014957000000005013","HC":0,"SN":"catchall","SM":"/Applications/eclipse/Eclipse.app/Contents/MacOS/ZIDE/crmEmail/webapps/zohocrm/j","NS2":0,"AFN":"Inbox","PR":3,"SB":"javascript22222"},{"F":"catchall@labbcc.localzoho.com","A":true,"TH":0,"S2":"","DT":"Jun 28","M":"1014957000000043027","NT":0,"S1":"read","ST":"1372392438000","SZ":"79857","P":"Normal","FN":"Sent","S":1,"R":"1372412238847","NFG":"0","AT":1,"AR":0,"FD":"1014957000000005019","HC":0,"SN":"catchall","SM":"/Applications/eclipse/Eclipse.app/Contents/MacOS/ZIDE/crmEmail/webapps/zohocrm/j","NS2":0,"AFN":"Sent","PR":3,"SB":"javascript22222"},{"F":"catchall@labbcc.localzoho.com","A":true,"TH":0,"S2":"","DT":"Jun 28","M":"1014957000000045003","NT":0,"S1":"read","ST":"1372391639000","SZ":"79774","P":"Normal","FN":"Inbox","S":1,"R":"1372411442004","NFG":"0","AT":1,"AR":0,"FD":"1014957000000005013","HC":0,"SN":"catchall","SM":"/Applications/eclipse/Eclipse.app/Contents/MacOS/ZIDE/crmEmail/webapps/zohocrm/j","NS2":0,"AFN":"Inbox","PR":3,"SB":"javascript22222"},{"F":"catchall@labbcc.localzoho.com","A":true,"TH":0,"S2":"","DT":"Jun 28","M":"1014957000000043025","NT":0,"S1":"read","ST":"1372391639000","SZ":"79757","P":"Normal","FN":"Sent","S":1,"R":"1372411439941","NFG":"0","AT":1,"AR":0,"FD":"1014957000000005019","HC":0,"SN":"catchall","SM":"/Applications/eclipse/Eclipse.app/Contents/MacOS/ZIDE/crmEmail/webapps/zohocrm/j","NS2":0,"AFN":"Sent","PR":3,"SB":"javascript22222"},{"AccountID":"1014957000000005001"}]
	}
	
	

	public static void getMailsList() throws Exception
	{
		HashMap<String, String> postParam = new HashMap<String, String>();
		postParam.put( PMDConstants.ACTION, "getMailList" );
		postParam.put( ZMailConstants.FROM_CONST, "1" );
		postParam.put( ZMailConstants.LIMIT, "100" );
		postParam.put( ZMailConstants.MESSAGEID_CONST, "3088813000000014001" );
		//postParam.put( ZMailConstants.EMAILID, "yogesh.m@zohocorp.com" );
		postParam.put( "accId", "3088813000000008001" );
		postParam.put( ZMailConstants.REMOTE_ADDR, "192.168.29.55" );
		postParam.put( ZMailConstants.SORT_ORDER, PMDConstants.TRUE );
		postParam.put( ZMailConstants.INCLUDE_TO_ADDR, PMDConstants.TRUE );
		postParam.put( "sent", PMDConstants.TRUE );
		postParam.putAll(authentication);
		
		String resp = IntegrationUtil.connectToZohoServiceAPI(postParam, idcUrl);
		System.out.println(" Response :::  " + resp);
		
	}
	
	
	public static void getAllFromAddress() throws Exception
	{
		HashMap<String, String> postParam = new HashMap<String, String>();
		postParam.put( PMDConstants.ACTION , "getAllFromAddress" );
		postParam.put( ZMailConstants.GET_ENABLED_EMAILS, String.valueOf( false ) );
		postParam.put( ZMailConstants.REMOTE_ADDR, "192.168.29.55" );
		postParam.putAll(authentication);
		
		String resp = IntegrationUtil.connectToZohoServiceAPI(postParam, idcUrl);
		System.out.println(" Response :::  " + resp);
	}

	
	public static void getAccountDetails() throws Exception
	{
		HashMap<String, String> postParam = new HashMap<String, String>();
		postParam.put( PMDConstants.ACTION , "getAccountDetails" );
		postParam.put( "includeSignature", "true" );
		postParam.put( ZMailConstants.REMOTE_ADDR, "192.168.29.55" );
		postParam.putAll(authentication);
		
		String resp = IntegrationUtil.connectToZohoServiceAPI(postParam, idcUrl);
		System.out.println(" Response :::  " + resp);		
	}

	public static void getMessageHeaders() throws Exception
	{
		HashMap<String, String> postParam = new HashMap<String, String>();
		postParam.put( PMDConstants.ACTION, "getMessageHeaders" );
		postParam.put( ZMailConstants.EMAILID, "sathishkumar.sekar@zohocorp.com" );
		postParam.put( ZMailConstants.MESSAGEIDS_CONST, "1329498000008168133,1329498000008174101" );
		
		postParam.putAll(authentication);
		//System.out.println( postParam );
		String resp = IntegrationUtil.connectToZohoServiceAPI(postParam, idcUrl);
		System.out.println(" Response :::  " + resp);
		
		// Response :::  {"1329498000005025227":[{"Received-SPF":"Pass (zoho.com: domain of sergimora74@gmail.com designates 209.85.212.65 as permitted sender )  client-ip: 209.85.212.65"},{"Delivered-To":"sales@zohocorp.com"},{"Return-Path":"zmgrbounces+1082700000000483045@zoho.com"},{"Return-Path":"<sergimora74@gmail.com>"},{"Received":"from mail-vb0-f65.google.com (mail-vb0-f65.google.com [209.85.212.65]) by mx.zohomail.com\r\n\twith SMTP id 1377450695156590.7137241583163; Sun, 25 Aug 2013 10:11:35 -0700 (PDT)"},{"Received":"by mail-vb0-f65.google.com with SMTP id f12so629813vbg.0\r\n        for <sales@zohocorp.com>; Sun, 25 Aug 2013 10:11:34 -0700 (PDT)"},{"Received":"by 10.221.50.8 with HTTP; Sun, 25 Aug 2013 10:11:34 -0700 (PDT)"},{"DKIM-Signature":"v=1; a=rsa-sha256; c=relaxed/relaxed;\r\n        d=gmail.com; s=20120113;\r\n        h=mime-version:in-reply-to:references:date:message-id:subject:from:to\r\n         :content-type;\r\n        bh=7bR3yVZ3ME6hQGQFEAfG4ftGBqbOSZvo/KfhfAJUsOU=;\r\n        b=VAenbsubLgq81/ayUN1h+H3gg0xHUU1BUEJsbqH/KCs6E9D1fVHv9089a/5NvkGIu9\r\n         ww96Nya3/aDk3Cpd+N+ct3qEFkcKJnQYlpvC0sgeoYyPqYs9mjvpDnGRlWXUBQe3ic6a\r\n         IILKpB9TErRsCUotpVjI9oGMhDAoLey3T8mGDxFDuQWrMetQRIbTc5UNzYlcMtBPTl3o\r\n         HHLYYLOowNXMgGWpesZrDn5mRyfCzpsGMkJpo/HVCVl3XxvSpEMW7M3Wv2PS6xqUc7dL\r\n         4XMPE7BXmJOrXpEIoRYn1SxxqPG/PzZqKt28V2/ynEZQ6wPK2AE8I9ZGpBuxBeaMVDEa\r\n         uT3w=="},{"MIME-Version":"1.0"},{"X-Received":"by 10.58.211.227 with SMTP id nf3mr327394vec.20.1377450694443;\r\n Sun, 25 Aug 2013 10:11:34 -0700 (PDT)"},{"In-Reply-To":"<CACJyz7GXhOpG-q2OF6BVE2OoaS7rpspX4nKogdWZc78Cxw6rfw@mail.gmail.com>"},{"References":"<CACJyz7GXhOpG-q2OF6BVE2OoaS7rpspX4nKogdWZc78Cxw6rfw@mail.gmail.com>"},{"Date":"Sun, 25 Aug 2013 19:11:34 +0200"},{"Message-ID":"<CACJyz7EOBL1KyvEdQPASM33RLYNBPeLWkJJfUbagrVM=uey-Sw@mail.gmail.com>"},{"Subject":"Fwd: Question"},{"From":"Sergi Mora <sergimora74@gmail.com>"},{"To":"sales@zohocorp.com"},{"Content-Type":"multipart/alternative; boundary=047d7bd6b65a5688a104e4c8bb81"},{"X-ZohoMail":"ZL SS_6 SFPD SFPP UW2468 UB6248 FMWL SFP_WHTLST COSF   SGR3_1_13083_42"},{"X-ZohoMail-Owner":"<CACJyz7EOBL1KyvEdQPASM33RLYNBPeLWkJJfUbagrVM=uey-Sw@mail.gmail.com>+zmo_0_<sergimora74@gmail.com>"},{"X-ZohoMail-Sender":"209.85.212.65"},{"X-Zoho-List-Id":"sales.zohocorp.com"},{"X-Zoho-Virus-Status":"2"}],"1329498000005022261":[{"Delivered-To":"sales@zohocorp.com"},{"Return-Path":"zmgrbounces+1082700000000483045@zoho.com"},{"Return-Path":"<george@mogeneration.com>"},{"Received":"from mail-ie0-f173.google.com (mail-ie0-f173.google.com [209.85.223.173]) by mx.zohomail.com\r\n\twith SMTP id 1377494302034142.9131736091207; Sun, 25 Aug 2013 22:18:22 -0700 (PDT)"},{"Received":"by mail-ie0-f173.google.com with SMTP id qa5so906670ieb.18\r\n        for <sales@zohocorp.com>; Sun, 25 Aug 2013 22:18:20 -0700 (PDT)"},{"Received":"by 10.50.159.135 with HTTP; Sun, 25 Aug 2013 22:18:18 -0700 (PDT)"},{"X-Google-DKIM-Signature":"v=1; a=rsa-sha256; c=relaxed/relaxed;\r\n        d=google.com; s=20120113;\r\n        h=x-gm-message-state:mime-version:in-reply-to:references:date\r\n         :message-id:subject:from:to:cc:content-type;\r\n        bh=D/S1ozJRfS0q/hgXqG2M85BR+ct5o/3Ego7o4US3Teg=;\r\n        b=DeqjrWG7W2zTHrD3ZQWOoOa3MRE2kR1rrN5VPPlTgcmyOQrvIpj8+Ht6lvXZ2Esfwb\r\n         kygChSwPgI2SNlSJggubUThLUxn2QF1R1YOZ32cUqdHNHP4CkE/9SsJZzashrWCPvn4w\r\n         lgBv9CCZzq/jL2LyXF1WBK9OumV1zZQmcHtV0JJPyIBrsv8AA/bmAKIUSD2xDmbX8ztQ\r\n         ADXrlUxTrmshBp3NeajEogDU3b9A9K+d8S9MeShUUpC09c+J47LfUVC2AwHCEeELKpje\r\n         wDT98PUMTyc3JhJhU7qGyTwTwM0JznMdZzNM4pDryBNZ6ZilujetWzxwBLfqXuXRqLHW\r\n         waxA=="},{"X-Gm-Message-State":"ALoCoQmqh1RSJL7HfnwyhjnDrXVIJ81KBU4IAdHVCYIFksQiNXw2U+bhTNldOhMb3R2cVExOR0DQ"},{"MIME-Version":"1.0"},{"X-Received":"by 10.42.208.211 with SMTP id gd19mr6159109icb.15.1377494300485;\r\n Sun, 25 Aug 2013 22:18:20 -0700 (PDT)"},{"In-Reply-To":"<140a9a6d460.7200677303150911813.6344719213703381094@zohocorp.com>"},{"References":"<140a4f39715.8070014858763064843.-1224104169683543098@zohocrm.com>\r\n\t<6C1C4704-C506-4BB1-9147-3CF6ED6AF1CD@mogeneration.com>\r\n\t<140a9a6d460.7200677303150911813.6344719213703381094@zohocorp.com>"},{"Date":"Mon, 26 Aug 2013 15:18:18 +1000"},{"Message-ID":"<CAHLt8Rrxj8fuTZD5XzSfJTxYpCdP_vti0x0FOi=kS_KG8QBAeA@mail.gmail.com>"},{"Subject":"Re: [##267572##] Re: Re: Zoho CRM Account Manager's Contact Details"},{"From":"George Hernandez <george@mogeneration.com>"},{"To":"Zoho Sales <sales@zohocorp.com>"},{"Cc":"support@zohocrm.com, \"migration@zohocrm.com\" <migration@zohocrm.com>"},{"Content-Type":"multipart/mixed; boundary=20cf303ea90a75f9f904e4d2e2d8"},{"X-Zoho-Virus-Status":"1"},{"X-ZohoMail":"ZL THD_FND SS_36 UW2468 UB2468 CHF_KWN_DBL_EXT  SGR4_1_13083_9"},{"X-ZohoMail-Owner":"<CAHLt8Rrxj8fuTZD5XzSfJTxYpCdP_vti0x0FOi=kS_KG8QBAeA@mail.gmail.com>+zmo_0_<george@mogeneration.com>"},{"X-ZohoMail-Sender":"209.85.223.173"},{"X-Zoho-List-Id":"sales.zohocorp.com"}],"1329498000005022271":[{"Received-SPF":"Pass (zoho.com: domain of cablequest-1834-902-19894-apac-sales=zohocorp.com@mailmx1.mailpost.in designates 202.162.243.86 as permitted sender )  client-ip: 202.162.243.86"},{"Delivered-To":"apac-sales@zohocorp.com"},{"Received":"from mmail13.iaires.com (mm13.iaires.com [202.162.243.86]) by mx.zohomail.com\r\n\twith SMTP id 13774972153531017.2313720516695; Sun, 25 Aug 2013 23:06:55 -0700 (PDT)"},{"Return-Path":"zmgrbounces+1082700000000483045@zoho.com"},{"Return-Path":"zmgrbounces+1082700000000484527@zoho.com"},{"Return-Path":"<cablequest-1834-902-19894-apac-sales=zohocorp.com@mailmx1.mailpost.in>"},{"Date":"Mon, 26 Aug 2013 11:34:24 +0530"},{"To":"apac-sales@zohocorp.com"},{"From":"\"CableQuest\" <cqnews@cable-quest.in>"},{"Reply-To":"CableQuest <cqnews@cable-quest.in>"},{"Subject":"\"CASBAA Convention 2013 - Special Rate US $799\""},{"Message-ID":"<128985603919894@mailpost.in>"},{"X-Priority":"3"},{"Precedence":"bulk"},{"X-Abuse-Reports-To":"abuse@utilityinbox.com"},{"List-Unsubscribe":"<mailto:cablequest-1834-902-19894-17769b73bf4f3236d3ec723fae79ee54@usub.mailpost.in?subject=Unsubscribe>, <http://cablequest.empressmail.com/cablequest/?p=unsubscribe&mid=902&uid=17769b73bf4f3236d3ec723fae79ee54>"},{"MIME-Version":"1.0"},{"Content-Type":"multipart/alternative;\r\n\tboundary=\"b1_8579ecd521c0bb5c65b9bfd5de4b6575\""},{"X-Zoho-Virus-Status":"1"},{"X-ZohoMail":"ZL SS_1 SFPD SFPP UW2468 UB2468 ZFF-PB_1  ZXHF-XP-MRH_2 COSF  ZMHF-701-ILN_4  SGR3_1_13083_358"},{"X-ZohoMail-Owner":"<128985603919894@mailpost.in>+zmo_0_<cablequest-1834-902-19894-apac-sales=zohocorp.com@mailmx1.mailpost.in>"},{"X-ZohoMail-Sender":"202.162.243.86"},{"X-Zoho-List-Id":"apac-sales.zohocorp.com"}]}
	}

	private static void getAllFromAddress( HashMap<String, String> authentication ) throws Exception
	{
		HashMap<String, String> postParam = new HashMap<String, String>();
		postParam.put( PMDConstants.ACTION , "getAllFromAddress" );
		postParam.put( ZMailConstants.GET_ENABLED_EMAILS, "true" );
		//postParam.put( ZMailConstants.REMOTE_ADDR, remoteAddr );
		postParam.putAll( authentication );
		
		String response = IntegrationUtil.connectToZohoServiceAPI(postParam, idcUrl);
	}

	
	private static void isMailBoxExists() throws Exception
	{
		HashMap<String, String> postParam = new HashMap<String, String>();
		postParam.put( PMDConstants.TICKET, "e35ee18080f6cd5d5481acd2f32ff89e" );
		postParam.put( CrmConstants.ZUID, "496488" );
		postParam.put("mode", "ismbexist");
		
		String response = IntegrationUtil.connectToZohoServiceAPI(postParam, "https://zmail.localzoho.com/mailadmin/MailAdminAPI.do");
		
		System.out.println(response);
	}
	
	
	private static void getSupportReq() throws Exception
	{
		HashMap<String, String> postParam = new HashMap<String, String>();
		postParam.put( PMDConstants.TICKET, "87afdbfbc0c1fd99867321d14f5446ea" );
		postParam.put("toindex", "5");
		postParam.put("crmsupportzgid", "10951874");
		postParam.put("contactemail", "ssk.support@zohocorpin.com,ssk.social@zohocorpin.com");
		postParam.put("service", "ZohoCRM");
		postParam.put("multivalues", "true");
		postParam.put("fromindex", "1");
		postParam.put("zgid", "10951869");
		postParam.put("remoteAddr", "172.20.5.104");
		
		
		String response = IntegrationUtil.connectToZohoServiceAPI(postParam, "https://support.localzoho.com/internalapi/json/cases/getrequestlist");
		
		System.out.println(response);
	}
	
	
}
