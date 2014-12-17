//$Id$
package json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateJsonArr {

	public static void main( String arg [] ) throws JSONException
	{
		JSONArray jsonArr = new JSONArray( "[{\"status\":\"0\",\"emailid\":\"integration@zoho.com\"},{\"status\":\"0\",\"emailid\":\"invoice@zoho.com\"},{\"status\":\"0\",\"emailid\":\"docsteam@zoho.com\"},{\"status\":\"0\",\"emailid\":\"developers@zoho.com\"},{\"status\":\"0\",\"emailid\":\"crm@zoho.com\"},{\"status\":\"0\",\"emailid\":\"core-feature+support's@zoho.com\"},{\"status\":\"0\",\"emailid\":\"campaingn@zoho.com\"},{\"status\":\"1\",\"emailid\":\"support@zoho.com\"},{\"status\":\"1\",\"emailid\":\"unknownmail@labbcc.localzoho.com\"},{\"status\":\"1\",\"emailid\":\"sekar@zoho.com\"},{\"status\":\"1\",\"emailid\":\"vithya@labbcc.localzoho.com\"},{\"status\":\"1\",\"emailid\":\"videos@zoho.com\"},{\"status\":\"1\",\"emailid\":\"security@zoho.com\"},{\"status\":\"1\",\"emailid\":\"mokshitha@zoho.com\"},{\"status\":\"1\",\"emailid\":\"books@zoho.com\"},{\"status\":\"1\",\"emailid\":\"meetingtram@zoho.com\"},{\"status\":\"1\",\"emailid\":\"ui-engineers@zoho.com\"},{\"status\":\"1\",\"emailid\":\"testing-team's+head@zoho.com\"},{\"status\":\"1\",\"emailid\":\"kamal+india@gmail.com\"},{\"status\":\"1\",\"emailid\":\"ssksekar+india@zoho.com\"},{\"status\":\"1\",\"emailid\":\"sheet@zoho.com\"},{\"status\":\"1\",\"emailid\":\"kamal+arr+illa-yuvan.gv@gmail.com\"},{\"status\":\"1\",\"emailid\":\"jagadeesh@zoho.com\"},{\"status\":\"1\",\"emailid\":\"santhil@labbcc.localzoho.com\"},{\"status\":\"1\",\"emailid\":\"productdevlopment@zoho.com\"},{\"status\":\"1\",\"emailid\":\"prem@labbcc.localzoho.com\"},{\"status\":\"1\",\"emailid\":\"ponns@labbcc.localzoho.com\"},{\"status\":\"1\",\"emailid\":\"performance@zoho.com\"},{\"status\":\"1\",\"emailid\":\"india-all@labbcc.localzoho.com\"},{\"status\":\"1\",\"emailid\":\"india-all@google.com\"},{\"status\":\"1\",\"emailid\":\"iam@zoho.com\"},{\"status\":\"1\",\"emailid\":\"mani@labbcc.localzoho.com\"}]" );
		
		for ( int i =0; i < jsonArr.length(); i++ )
		{
			System.out.print( "(9000000017080,\"" + jsonArr.getJSONObject(i).getString( "emailid" )  + "\",-1,0),");
		}
		
		
	}
}
