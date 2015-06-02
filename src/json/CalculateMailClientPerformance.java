//$Id$
package json;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class CalculateMailClientPerformance {

	public static void main(String arg[]) throws Exception
	{
		String str = "[{\"Starting_email_views_action\":\"1426573401762\"},{\"Starting_populateKanbanViewMails_before_for_loop\":\"1426573401762\"},{\"starting_populateKanbanViewMails_before_calling_getMail_Potentials_2000000021001\":\"1426573401766\"},{\"starting_getMails_before_calling_Cassandra_Potentials_2000000021001\":\"1426573401767\"},{\"ending_getMails_after_calling_Cassandra_Potentials_2000000021001\":\"1426573401945\"},{\"starting_getMails_before_calling_MailAPI_Potentials_2000000021001\":\"1426573401945\"},{\"ending_getMails_after_calling_MailAPI_Potentials_2000000021001\":\"1426573402106\"},{\"Ending_populateKanbanViewMails_after_calling_getMail_Potentials_2000000021001\":\"1426573402106\"},{\"starting_populateKanbanViewMails_before_calling_getMail_Contacts_2000000021001\":\"1426573402106\"},{\"starting_getMails_before_calling_Cassandra_Contacts_2000000021001\":\"1426573402106\"},{\"ending_getMails_after_calling_Cassandra_Contacts_2000000021001\":\"1426573402115\"},{\"starting_getMails_before_calling_MailAPI_Contacts_2000000021001\":\"1426573402115\"},{\"ending_getMails_after_calling_MailAPI_Contacts_2000000021001\":\"1426573402201\"},{\"Ending_populateKanbanViewMails_after_calling_getMail_Contacts_2000000021001\":\"1426573402201\"},{\"starting_populateKanbanViewMails_before_calling_getMail_UnMatched_2000000021001\":\"1426573402201\"},{\"starting_getMails_before_calling_Cassandra_UnMatched_2000000021001\":\"1426573402201\"},{\"ending_getMails_after_calling_Cassandra_UnMatched_2000000021001\":\"1426573402226\"},{\"starting_getMails_before_calling_MailAPI_UnMatched_2000000021001\":\"1426573402226\"},{\"ending_getMails_after_calling_MailAPI_UnMatched_2000000021001\":\"1426573402293\"},{\"Ending_populateKanbanViewMails_after_calling_getMail_UnMatched_2000000021001\":\"1426573402293\"},{\"starting_populateKanbanViewMails_before_calling_getMail_Colleagues_2000000021001\":\"1426573402293\"},{\"starting_getMails_before_calling_Cassandra_Colleagues_2000000021001\":\"1426573402293\"},{\"ending_getMails_after_calling_Cassandra_Colleagues_2000000021001\":\"1426573402298\"},{\"starting_getMails_before_calling_MailAPI_Colleagues_2000000021001\":\"1426573402298\"},{\"ending_getMails_after_calling_MailAPI_Colleagues_2000000021001\":\"1426573402387\"},{\"Ending_populateKanbanViewMails_after_calling_getMail_Colleagues_2000000021001\":\"1426573402387\"},{\"Ending_populateKanbanViewMails_after_for_loop\":\"1426573402387\"},{\"populateKanbanViewMails_before_returning_method\":\"1426573402387\"},{\"Ending_email_views_action\":\"1426573402388\"}]";
		
		JSONArray jsonArr = new JSONArray( str );
		int len = jsonArr.length();
		
		JSONObject jsonObj1 = null;
		JSONObject jsonObj2 = null;
		
		Iterator<String> iter1 = null;
		Iterator<String> iter2 = null;
		
		String key1, key2;
		Long val1, val2;
		
		for ( int i = 0; i < len - 2; i++ )
		{
			jsonObj1 = jsonArr.getJSONObject( i );
			jsonObj2 = jsonArr.getJSONObject( i + 1 );
			
			iter1 = jsonObj1.keys();
			iter2 = jsonObj2.keys();
			
			key1 = iter1.next();
			key2 = iter2.next();
			
			val1 = Long.valueOf( jsonObj1.getString( key1 ) );
			val2 = Long.valueOf( jsonObj2.getString( key2 ) );
			
			System.out.println( key2 + " - " + key1 + " ::: " + ( val2 - val1 ) + " ms" );
		}
	}
	
}
