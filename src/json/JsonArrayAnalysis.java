//$Id$
package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.adventnet.crm.common.util.PMDConstants;
import com.adventnet.crm.integration.emails.util.EmailJSONUtil;
import com.adventnet.crm.integration.emails.util.ZMailConstants;

public class JsonArrayAnalysis {

	public static void main( String arg []) throws JSONException
	{
		//sendViewsNewMailNotification();
		
		checkStartsWith();
	}
	
	
	private static void sendViewsNewMailNotification() throws JSONException
	{
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonObj = null;
		HashMap<Long, Integer> emailViewIdVsNoOfNewMails = new HashMap<Long, Integer>();
		emailViewIdVsNoOfNewMails.put(11111l, 10);
		emailViewIdVsNoOfNewMails.put(22222l, 20);
		emailViewIdVsNoOfNewMails.put(33333l, 30);
		
		for ( Map.Entry<Long, Integer> entry : emailViewIdVsNoOfNewMails.entrySet() )
		{
			jsonObj = new JSONObject();
			jsonObj.put( String.valueOf( entry.getKey() ), String.valueOf( entry.getKey() ) );
			
			jsonArr.put( jsonObj );
		}
		System.out.println( jsonArr );
		System.out.println( jsonArr.toString() );
	}
	
	public static JSONObject createJsonObjFromJsonArr( JSONArray JsonArr ) throws JSONException
	{
		//"[{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002042\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1450726222000\",\"SZ\":\"271876\",\"P\":\"Normal\",\"S\":1,\"R\":\"1450746031636\",\"DELIVEREDTO\":\"sathish01@zoho.com\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000233\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"Wimpy Player ||| Users Manual Home PageMySQL Commands ListHere you will find a\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Contacts 22222\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002041\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1450726222000\",\"SZ\":\"271876\",\"P\":\"Normal\",\"S\":1,\"R\":\"1450746025507\",\"DELIVEREDTO\":\"Not Provided\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000239\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"Wimpy Player ||| Users Manual Home PageMySQL Commands ListHere you will find a\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Contacts 22222\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002039\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1450726196000\",\"SZ\":\"284678\",\"P\":\"Normal\",\"S\":0,\"R\":\"1450746008694\",\"DELIVEREDTO\":\"sathish01@zoho.com\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000233\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"Wimpy Player ||| Users Manual Home PageMySQL Commands ListHere you will find a\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Contacts 111111\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002037\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1450726196000\",\"SZ\":\"284678\",\"P\":\"Normal\",\"S\":1,\"R\":\"1450745999864\",\"DELIVEREDTO\":\"Not Provided\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000239\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"Wimpy Player ||| Users Manual Home PageMySQL Commands ListHere you will find a\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Contacts 111111\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002034\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1450726110000\",\"SZ\":\"53941\",\"P\":\"Normal\",\"S\":1,\"R\":\"1450745916417\",\"DELIVEREDTO\":\"sathish01@zoho.com\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000233\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"This is a list of handy MySQL commands that I use time and time again. At the bo\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Unknown 222222\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002033\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1450726110000\",\"SZ\":\"53819\",\"P\":\"Normal\",\"S\":1,\"R\":\"1450745911039\",\"DELIVEREDTO\":\"Not Provided\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000239\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"This is a list of handy MySQL commands that I use time and time again. At the bo\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Unknown 222222\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002030\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1450726083000\",\"SZ\":\"54861\",\"P\":\"Normal\",\"S\":0,\"R\":\"1450745889756\",\"DELIVEREDTO\":\"sathish01@zoho.com\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000233\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"This is a list of handy MySQL commands that I use time and time again. At the bo\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Unknown 11111\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002029\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1450726083000\",\"SZ\":\"54741\",\"P\":\"Normal\",\"S\":1,\"R\":\"1450745884354\",\"DELIVEREDTO\":\"Not Provided\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000239\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"This is a list of handy MySQL commands that I use time and time again. At the bo\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Unknown 11111\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002024\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1450726007000\",\"SZ\":\"21398\",\"P\":\"Normal\",\"S\":0,\"R\":\"1450745812951\",\"DELIVEREDTO\":\"sathish01@zoho.com\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000233\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"DRUGS:1 Indications and contraindication of drugs;2.List of banned drugs as no\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Leads 2222222\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002023\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1450726007000\",\"SZ\":\"21398\",\"P\":\"Normal\",\"S\":1,\"R\":\"1450745807579\",\"DELIVEREDTO\":\"Not Provided\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000239\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"DRUGS:1 Indications and contraindication of drugs;2.List of banned drugs as no\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Leads 2222222\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002020\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1450725976000\",\"SZ\":\"21438\",\"P\":\"Normal\",\"S\":0,\"R\":\"1450745782454\",\"DELIVEREDTO\":\"sathish01@zoho.com\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000233\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"DRUGS:1 Indications and contraindication of drugs;2.List of banned drugs as no\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Leads 11111\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002019\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1450725976000\",\"SZ\":\"21438\",\"P\":\"Normal\",\"S\":1,\"R\":\"1450745777038\",\"DELIVEREDTO\":\"Not Provided\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000239\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"DRUGS:1 Indications and contraindication of drugs;2.List of banned drugs as no\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Leads 11111\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002016\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1450725934000\",\"SZ\":\"28279\",\"P\":\"Normal\",\"S\":0,\"R\":\"1450745740514\",\"DELIVEREDTO\":\"sathish01@zoho.com\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000233\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"This website is the first of it’s kind and is an easily accessible source of inf\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Potentials 222222\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002015\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1450725934000\",\"SZ\":\"28279\",\"P\":\"Normal\",\"S\":1,\"R\":\"1450745735173\",\"DELIVEREDTO\":\"Not Provided\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000239\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"This website is the first of it’s kind and is an easily accessible source of inf\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Potentials 222222\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002012\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1450725908000\",\"SZ\":\"28665\",\"P\":\"Normal\",\"S\":1,\"R\":\"1450745714964\",\"DELIVEREDTO\":\"sathish01@zoho.com\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000233\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"This website is the first of it’s kind and is an easily accessible source of inf\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Potentials 11111\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002011\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1450725908000\",\"SZ\":\"28665\",\"P\":\"Normal\",\"S\":1,\"R\":\"1450745709559\",\"DELIVEREDTO\":\"Not Provided\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000239\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"This website is the first of it’s kind and is an easily accessible source of inf\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Potentials 11111\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002008\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1450725843000\",\"SZ\":\"47248\",\"P\":\"Normal\",\"S\":1,\"R\":\"1450745650083\",\"DELIVEREDTO\":\"sathish01@zoho.com\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000233\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"(CNN)  Trying to decode the many variations of the head bobble.Figuring out w\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Internal 22222\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002007\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1450725843000\",\"SZ\":\"47179\",\"P\":\"Normal\",\"S\":1,\"R\":\"1450745644410\",\"DELIVEREDTO\":\"Not Provided\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000239\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"(CNN)  Trying to decode the many variations of the head bobble.Figuring out w\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Internal 22222\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002004\",\"NT\":0,\"S1\":\"unread\",\"ST\":\"1450725812000\",\"SZ\":\"53059\",\"P\":\"Normal\",\"S\":0,\"R\":\"1450745619925\",\"DELIVEREDTO\":\"sathish01@zoho.com\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000233\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"(CNN)  Trying to decode the many variations of the head bobble.Figuring out w\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Internal 11111\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 22\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000002003\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1450725812000\",\"SZ\":\"52992\",\"P\":\"Normal\",\"S\":1,\"R\":\"1450745614121\",\"DELIVEREDTO\":\"Not Provided\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000239\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"(CNN)  Trying to decode the many variations of the head bobble.Figuring out w\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Internal 11111\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 9\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000000265\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1449591876000\",\"SZ\":\"567999\",\"P\":\"Normal\",\"S\":1,\"R\":\"1449611688527\",\"DELIVEREDTO\":\"sathish01@zoho.com\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000233\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Support Columns\"},{\"F\":\"sathish01@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 9\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000000263\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1449591876000\",\"SZ\":\"567999\",\"P\":\"Normal\",\"S\":1,\"R\":\"1449611680590\",\"DELIVEREDTO\":\"Not Provided\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000239\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Support Columns\"},{\"F\":\"sathish01@zoho.com\",\"A\":true,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 9\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000000260\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1449591806000\",\"SZ\":\"945377\",\"P\":\"Normal\",\"S\":1,\"R\":\"1449611614671\",\"DELIVEREDTO\":\"sathish01@zoho.com\",\"NFG\":\"0\",\"AT\":1,\"AR\":0,\"FD\":\"35000000000233\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Help Page\"},{\"F\":\"sathish01@zoho.com\",\"A\":true,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 9\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000000259\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1449591806000\",\"SZ\":\"945377\",\"P\":\"Normal\",\"S\":1,\"R\":\"1449611608822\",\"DELIVEREDTO\":\"Not Provided\",\"NFG\":\"0\",\"AT\":1,\"AR\":0,\"FD\":\"35000000000239\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Help Page\"},{\"F\":\"sathish01@zoho.com\",\"A\":true,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 9\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000000256\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1449591734000\",\"SZ\":\"9487650\",\"P\":\"Normal\",\"S\":1,\"R\":\"1449611552557\",\"DELIVEREDTO\":\"sathish01@zoho.com\",\"NFG\":\"0\",\"AT\":1,\"AR\":0,\"FD\":\"35000000000233\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"1111111111111111\"},{\"F\":\"sathish01@zoho.com\",\"A\":true,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 9\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000000255\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1449591734000\",\"SZ\":\"9487567\",\"P\":\"Normal\",\"S\":1,\"R\":\"1449611541602\",\"DELIVEREDTO\":\"Not Provided\",\"NFG\":\"0\",\"AT\":1,\"AR\":0,\"FD\":\"35000000000239\",\"HC\":0,\"SN\":\"sathish01\",\"SM\":\"\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"1111111111111111\"},{\"F\":\"welcome@zoho.com\",\"A\":false,\"TH\":0,\"S2\":\"\",\"DT\":\"Dec 9\",\"TO\":\" <sathish01@zoho.com>\",\"M\":\"35000000000249\",\"NT\":0,\"S1\":\"read\",\"ST\":\"1449591005000\",\"SZ\":\"14538\",\"P\":\"Normal\",\"S\":1,\"R\":\"1449610816018\",\"DELIVEREDTO\":\"Not Provided\",\"NFG\":\"0\",\"AT\":0,\"AR\":0,\"FD\":\"35000000000233\",\"HC\":0,\"SN\":\"welcome@zoho.com\",\"SM\":\"   Welcome to The Zoho Family! Thanks for choosing Zoho Mail - Email built f\",\"NS2\":0,\"PR\":3,\"CC\":\"Not Provided\",\"SB\":\"Welcome to Zoho Mail\"},{\"AccountID\":\"35000000000221\"}]"   
		
		JSONObject resultJsonObj = null;
		JSONObject jsonObj = null;
		int len = JsonArr != null ? JsonArr.length() : 0;
		
		if ( len > 0 )
		{
			resultJsonObj = new JSONObject();
			for ( int i = 0; i < len; i ++ )
			{
				jsonObj = JsonArr.getJSONObject( i );
				System.out.println("jsonObj ::: " + jsonObj);
				if ( jsonObj.has( ZMailConstants.MESSAGEID_LK ) )
				{
					System.out.println(jsonObj.getString( ZMailConstants.MESSAGEID_LK ));
					resultJsonObj.put( jsonObj.getString( ZMailConstants.MESSAGEID_LK ), jsonObj );
				}
			}
		}
		return jsonObj;
	}

	
	public static void checkStartsWith() throws JSONException
	{
		JSONArray jsonArr =  null;
		JSONObject jsonObj =  null;

		String searchFor = "chris";
		
		JSONArray resultsJsonArr = new JSONArray("[{\"SEID\":\"2000000182464\",\"FULLNAME\":\" christopher.lck\",\"EMAIL\":\"christopher.lck@gmail.com\"},{\"SEID\":\"2000000182463\",\"FULLNAME\":\" Christian Pazmi\",\"EMAIL\":\"christian.pazmino@refundation.com\"},{\"SEID\":\"2000000182462\",\"FULLNAME\":\" chris@netgilman.com\",\"EMAIL\":\"chris@netgilman.com\"},{\"SEID\":\"2000000182419\",\"FULLNAME\":\" Christopher W. DeLaurentis\",\"EMAIL\":\"billing@lazybeardesigns.com\"},{\"SEID\":\"2000000182357\",\"FULLNAME\":\" cbloor\",\"EMAIL\":\"christopher@gtslearning.com\"},{\"SEID\":\"2000000182341\",\"FULLNAME\":\" Christine O&#39;Brien\",\"EMAIL\":\"christine@shopangels.com.au\"},{\"SEID\":\"2000000182327\",\"FULLNAME\":\" chrishatzistamou@athensproaudio.gr\",\"EMAIL\":\"chrishatzistamou@athensproaudio.gr\"},{\"SEID\":\"2000000182320\",\"FULLNAME\":\" christine@visualsspeak.com\",\"EMAIL\":\"christine@visualsspeak.com\"},{\"SEID\":\"2000000182278\",\"FULLNAME\":\"null Chris\",\"EMAIL\":\"stroud.c@gmail.com\"},{\"SEID\":\"2000000181199\",\"FULLNAME\":\" Chris Sinclair\",\"EMAIL\":\"csinclair@nbenergy.com\"}]");
		if ( resultsJsonArr != null && resultsJsonArr.length() > 0 )
		{
			jsonArr = new JSONArray();
			int jsonArrLen = resultsJsonArr.length(); 

			
			for ( int i = 0; i < jsonArrLen; i++ )
			{
				jsonObj = resultsJsonArr.getJSONObject(i);
				
				if ( jsonObj != null &&  
					( ( jsonObj.getString( ZMailConstants.FULLNAME_UPPER ) != null && jsonObj.getString( ZMailConstants.FULLNAME_UPPER ).toLowerCase().startsWith( searchFor ) ) || 
					( jsonObj.getString( ZMailConstants.EMAIL ) != null && jsonObj.getString( ZMailConstants.EMAIL ).toLowerCase().startsWith( searchFor ) ) ) )
				{
					jsonArr.put( jsonObj );
				}
			}
		}
		
		System.out.println ( jsonArr );
		

	}
	
}
