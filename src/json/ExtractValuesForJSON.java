//$Id$
package json;

import org.json.JSONArray;
import org.json.JSONObject;

public class ExtractValuesForJSON {

	public static void main(String arg []) throws Exception
	{
		String str = "[{\"F\":\"bala111@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"06:26 PM\",\"M\":\"212000000002025\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1409469989000\",\"SZ\":\"22256\",\"P\":\"Normal\",\"FN\":\"Inbox\",\"S\":0,\"R\":\"1409489793998\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"212000000000293\",\"HC\":0,\"SN\":\"sathishkumar.sekar+28\",\"SM\":\"Locks in Java By Jakob Jenkov Connect with me: Rate article:Share article\",\"NS2\":0,\"AFN\":\"Inbox\",\"PR\":3,\"SB\":\"Internal 22222\"},{\"F\":\"bala111@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"06:25 PM\",\"M\":\"212000000002023\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1409469958000\",\"SZ\":\"12898\",\"P\":\"Normal\",\"FN\":\"Inbox\",\"S\":0,\"R\":\"1409489762977\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"212000000000293\",\"HC\":0,\"SN\":\"sathishkumar.sekar+28\",\"SM\":\"Java Callable Future ExamplePankaj January 2, 2013 JavaIn last few posts, we \",\"NS2\":0,\"AFN\":\"Inbox\",\"PR\":3,\"SB\":\"Internal 1111\"},{\"F\":\"sara111@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"06:23 PM\",\"M\":\"212000000002019\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1409469785000\",\"SZ\":\"16238\",\"P\":\"Normal\",\"FN\":\"Sent\",\"S\":1,\"R\":\"1409489585963\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"212000000000299\",\"HC\":0,\"SN\":\"sathish\",\"SM\":\"The most disappointing rumor about the iPhone 6 may have just been confirmedMOB\",\"NS2\":0,\"AFN\":\"Sent\",\"PR\":3,\"SB\":\"Internal User 111111\"},{\"F\":\"sara111@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"06:23 PM\",\"M\":\"212000000002021\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1409469785000\",\"SZ\":\"16238\",\"P\":\"Normal\",\"FN\":\"Inbox\",\"S\":0,\"R\":\"1409489590219\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"212000000000293\",\"HC\":0,\"SN\":\"sathish\",\"SM\":\"The most disappointing rumor about the iPhone 6 may have just been confirmedMOB\",\"NS2\":0,\"AFN\":\"Inbox\",\"PR\":3,\"SB\":\"Internal User 111111\"},{\"F\":\"bala111@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"06:22 PM\",\"M\":\"212000000002017\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1409469724000\",\"SZ\":\"4385\",\"P\":\"Normal\",\"FN\":\"Inbox\",\"S\":0,\"R\":\"1409489529142\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"212000000000293\",\"HC\":0,\"SN\":\"sathishkumar.sekar+28\",\"SM\":\"html {    background-color: #e6e9e9;    background-image: -webkit-linear-gradi\",\"NS2\":0,\"AFN\":\"Inbox\",\"PR\":3,\"SB\":\"Unknown 222222\"},{\"F\":\"bala111@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"06:21 PM\",\"M\":\"212000000002015\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1409469695000\",\"SZ\":\"450\",\"P\":\"Normal\",\"FN\":\"Inbox\",\"S\":0,\"R\":\"1409489499937\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"212000000000293\",\"HC\":0,\"SN\":\"sathishkumar.sekar+28\",\"SM\":\"\",\"NS2\":0,\"AFN\":\"Inbox\",\"PR\":3,\"SB\":\"Unknown 111111\"},{\"F\":\"bala111@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"06:21 PM\",\"M\":\"212000000002013\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1409469673000\",\"SZ\":\"32075\",\"P\":\"Normal\",\"FN\":\"Inbox\",\"S\":0,\"R\":\"1409489477850\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"212000000000293\",\"HC\":0,\"SN\":\"sathishkumar.sekar+28\",\"SM\":\"&lt;!DOCTYPE html&gt;&lt;html&gt;        &lt;head&gt;        &lt;meta charse\",\"NS2\":0,\"AFN\":\"Inbox\",\"PR\":3,\"SB\":\"Leads 222222\"},{\"F\":\"bala111@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"06:20 PM\",\"M\":\"212000000002011\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1409469622000\",\"SZ\":\"33680\",\"P\":\"Normal\",\"FN\":\"Inbox\",\"S\":0,\"R\":\"1409489426997\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"212000000000293\",\"HC\":0,\"SN\":\"sathishkumar.sekar+28\",\"SM\":\"Watch a fully assembled iPhone 6 boot up for the very first timeMOBILEBy Jac\",\"NS2\":0,\"AFN\":\"Inbox\",\"PR\":3,\"SB\":\"Leads 1111\"},{\"F\":\"bala111@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"06:18 PM\",\"M\":\"212000000002009\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1409469516000\",\"SZ\":\"16101\",\"P\":\"Normal\",\"FN\":\"Inbox\",\"S\":0,\"R\":\"1409489320701\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"212000000000293\",\"HC\":0,\"SN\":\"sathishkumar.sekar+28\",\"SM\":\"Java SE Development Kit (JDK) Cobundles JDK 8u20 with NetBeans 8.0This distr\",\"NS2\":0,\"AFN\":\"Inbox\",\"PR\":3,\"SB\":\"Potentials 22222\"},{\"F\":\"bala111@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"06:17 PM\",\"M\":\"212000000002007\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1409469462000\",\"SZ\":\"14529\",\"P\":\"Normal\",\"FN\":\"Inbox\",\"S\":0,\"R\":\"1409489267269\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"212000000000293\",\"HC\":0,\"SN\":\"sathishkumar.sekar+28\",\"SM\":\"//$Id$package com.adventnet.crm.iam.actions;import java.io.PrintWriter;impo\",\"NS2\":0,\"AFN\":\"Inbox\",\"PR\":3,\"SB\":\"Potentials 11111\"},{\"F\":\"bala111@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"06:17 PM\",\"M\":\"212000000002005\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1409469440000\",\"SZ\":\"14529\",\"P\":\"Normal\",\"FN\":\"Inbox\",\"S\":0,\"R\":\"1409489245433\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"212000000000293\",\"HC\":0,\"SN\":\"sathishkumar.sekar+28\",\"SM\":\"//$Id$package com.adventnet.crm.iam.actions;import java.io.PrintWriter;impo\",\"NS2\":0,\"AFN\":\"Inbox\",\"PR\":3,\"SB\":\"Contact 222222\"},{\"F\":\"bala111@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"06:15 PM\",\"M\":\"212000000002003\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1409469348000\",\"SZ\":\"3785\",\"P\":\"Normal\",\"FN\":\"Inbox\",\"S\":0,\"R\":\"1409489152586\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"212000000000293\",\"HC\":0,\"SN\":\"sathishkumar.sekar+28\",\"SM\":\"     bala111@zoho.com     bala111@zoho.com     bala111@zoho.com     bala111@z\",\"NS2\":0,\"AFN\":\"Inbox\",\"PR\":3,\"SB\":\"Contact 111\"},{\"F\":\"sara111@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Aug 29\",\"M\":\"212000000002001\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1409300722000\",\"SZ\":\"575\",\"P\":\"Normal\",\"FN\":\"Sent\",\"S\":1,\"R\":\"1409320522238\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"212000000000299\",\"HC\":0,\"SN\":\"sathish\",\"SM\":\"{size=-1}&quot;{size=-1}&quot;{size=-1}&quot;{size=-1}&quot;{size=-1}&quot;\",\"NS2\":0,\"AFN\":\"Sent\",\"PR\":3,\"SB\":\"Is this Chennai\"},{\"F\":\"welcome@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Aug 29\",\"M\":\"212000000000307\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1409232229000\",\"SZ\":\"38681\",\"P\":\"Normal\",\"FN\":\"Inbox\",\"S\":0,\"R\":\"1409252029778\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"212000000000293\",\"HC\":0,\"SN\":\"welcome@zoho.com\",\"SM\":\"            Hi,   Welcome to Zoho Mail! The &#39;always ad-free&#39; email service, f\",\"NS2\":0,\"AFN\":\"Inbox\",\"PR\":3,\"SB\":\"Welcome to Zoho Mail\"}]";
		
		JSONArray jsonArr = new JSONArray( str );
		int len = jsonArr.length();
		String temp = "insert into CrmUserRecentMails values ";
		for ( int i = 0; i < len; i++ )
		{
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			long MessageId = Long.valueOf(jsonObj.getString( "M" ));
			String subject = jsonObj.getString( "SB" );
			
			temp += "( '2000000018520', '"+MessageId+"', 'bala111@zoho.com', 'entityid', 'entityName', 'relen', '"+subject+"', '1409472862000', 0, 0 )";
		}
		
		System.out.println( temp );
		
	}
	
}