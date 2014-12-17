//$Id$
package logs;

import java.util.HashMap;

/**
 * Call this below URL for creating the authtoken, after logging into ur official account.
 * https://accounts.zoho.com/apiauthtoken/create?SCOPE=ZohoLogs/logsearchapi
 * AUTHTOKEN ::: 67ea8424d422032e850249092ea4440c
 * @author sathish-1343
 *
 */
public class ProcessLogs {
	
	private static final String URL = "https://prelogs.zoho.com/search";
	
	private static final String AUTHTOKEN = "authtoken";
	private static final String AUTHTOKEN_VALUE = "67ea8424d422032e850249092ea4440c";
	
	private static final String SERVICE = "service"; 
	private static final String SERVICE_VALUE = "crm"; 
	
	private static final String ORDER = "order"; 
	private static final String ORDER_VALUE = "desc"; 
	
	private static final String RANGE = "range"; 
	private static final String RANGE_VALUE = "1-10"; 
	
	private static final String TOTIME = "toTime"; 
	private static final String TOTIME_VALUE = "23:59"; 
	
	private static final String FROMTIME = "fromTime"; 
	private static final String FROMTIME_VALUE = "00:00"; 
	
	private static final String DATE = "date"; 
	private static final String DATE_VALUE = "2013-06-09"; 
	
	private static final String TYPE = "type"; 
	//private static final String TYPE_VALUE = "access"; 
	private static final String TYPE_VALUE = "application"; 
	
	/*Chang the crieteia and criteria value to make a search based on this. */
	private static final String CRITERIA = "logs_all"; 
	private static String CRITERIA_VALUE = "*:*";
	
	public static void main (String [] arg) throws Exception
	{
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put( SERVICE, SERVICE_VALUE);
		params.put( TYPE, TYPE_VALUE );
		params.put( DATE, DATE_VALUE );
		params.put( FROMTIME, FROMTIME_VALUE );
		params.put( TOTIME, TOTIME_VALUE );
		params.put( RANGE, RANGE_VALUE );
		params.put( CRITERIA, CRITERIA_VALUE );
		params.put( ORDER, ORDER_VALUE );
		params.put( AUTHTOKEN, AUTHTOKEN_VALUE );
		
		//System.out.println( "Number Of User Configured BCC Dropbox ::: " + DATE_VALUE + " ::: " + BCCDropboxLogsHandler.getNumberOfUsersConfiguredBCC(URL, params) );
		System.out.println( "Number Of Mails Fetched ::: " + DATE_VALUE + " ::: " + BCCDropboxLogsHandler.getNumberOfMailsFetched(URL, params)  );
		//System.out.println( "Number Of Mails Associated ::: " + DATE_VALUE + " ::: " + BCCDropboxLogsHandler.getNumberOfMailsAssociated(URL, params)  );
	}

}
