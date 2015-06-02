//$Id$
package httprelated;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.adventnet.crm.common.util.PMDConstants;
import com.adventnet.crm.integration.util.IntegrationUtil;

public class SendMailWithAPICall {

	
	public static void main(String arg []) throws Exception
	{
		//getEmailIdsVsAuthtoken();	
		//populateEmailIdVsAuthokenMap( getEmailIdsVsAuthtoken() );
		populateEmailIdVsAuthokenMap( null );

		
		for ( int i = 1; i <= 25; i ++ )
		{
			System.out.println( "Loop ::: " + i );
			
			for ( String fromAddr : mailAccountsEmails )
			{
				System.out.println( "==========================================" );
				System.out.println( fromAddr );
				
				for ( String toAddr : mailAccountsEmails )
				{
					sendMail( emailIdVsAuthtoken.get( fromAddr ), fromAddr + "@zohocorpin.com", toAddr + "@zohocorpin.com" );
				}
			}
			
			Thread.sleep( 60000 );
			
			System.out.println( "==========================================" );
		}
	}
	
	static void sendMail( String authtoken, String fromAddr, String toAddr ) throws Exception
	{
		String description = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?<br><br>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?";//No I!8N
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put( "authtoken", authtoken );
		params.put( "scope", "crmapi" );
		params.put( "fromAddress", fromAddr );
		params.put( "toAddress", toAddr );
		params.put( "subject", "Right Panel Design Excellent!!!" );
		params.put( "description", description );		
		params.put( "moduleName", "" );		
		
		String response = IntegrationUtil.connectToZohoServiceAPI( params, crmUrl );
		
		System.out.println( response );
	}
	
	/**
	 * Sample result :::
	 * crmemail2:::4d7870c78fb939ce87391bfca22bd5ec,crmemail21:::f1db8654082a86a54f6ecd1c416f1b0d,crmemail22:::a5d8141d471bee777d1929eec0069497,crmemail23:::2221fa2780c4a70ea3dc9be27fc05733,crmemail24:::c7b435a3bf2040d6448476ebe3c6a845,crmemail25:::4cc6a6254c30ae3b0c50c7e24ba6ad51,crmemail26:::1345fd530ad6bbcb78d6c5a42ed5d8fd,crmemail27:::3761036cc20dc809d0a195d89d52912f,crmemail28:::51415927b37935fa45a54395925290ea,crmemail29:::916be92ca4ec0d7b9957847ff64b6591,crmemail3:::447ed948438e10575a0c8c69561b5558,crmemail31:::ff792bc059ce2e9fe63a95fbcfdfd426,crmemail32:::26b8b07ead1c0195ff9debca309f0226,crmemail33:::a4a23267512e4ba4663ff5e7589beea4,crmemail34:::6c45a698729eee29d17fe87abe9d1673,crmemail35:::1a6444015c34510cdca1e2d3c25c18da,crmemail36:::e3d114151782bc89562b0105018393b9,crmemail37:::8c5d97f01280bf1726e76df76725a4ed,crmemail38:::460e1e146523bc13028726d683c038a3,crmemail39:::c717cabceca939e1793380754b099cb8,crmemail4:::1c66a62e6c81a8b550df12c0a259e8be,crmemail41:::29828f20def300ce09e00ee3064e334a,crmemail42:::1ee36f9f44a0298e06ef12874a19fb06,crmemail43:::e5f63e11d6dff94676a685738302f766,crmemail44:::422ebb8c1983e5a8cd291b77b5498be7,crmemail45:::704f318510af8dcc5fa88437e599b826,crmemail46:::f1529e9afc7c042d0745f5dfcebe4bb0,crmemail47:::d46b6eab97d3a1ca486b748d8f97b90e,crmemail48:::e15e976e4f279e78fe5be092becf32df,crmemail49:::c5427034be422b491d3dd7efdbd2fe68
	 * @return
	 * @throws Exception
	 */
	static String getEmailIdsVsAuthtoken() throws Exception
	{
		String response = null;
		String authtoken = null;
		String result = null;
		
		StringBuilder sb = new StringBuilder();
		
		for ( String emailId : mailAccountsEmails )
		{
			response = IntegrationUtil.connectToZohoServiceAPI( new HashMap<String, String>(), accountsUrl.replace( "EMAILADDRESS", emailId ) );
			
			/*SAMPLE REPONSE : 
			#
			#Sun Jan 11 20:01:12 IST 2015
			AUTHTOKEN=6c10b8340d23d2a76fe1811c8f64529e
			RESULT=TRUE
			*/
			
			authtoken = response.substring( response.indexOf( "=" ) + 1, response.indexOf( "RESULT" ) );

			sb.append( emailId );
			sb.append( PMDConstants.COLON_DELIMITER );
			sb.append( authtoken );
			sb.append( PMDConstants.COMMA_DELIMTER );
		}
		
		int lastComma = sb.lastIndexOf( PMDConstants.COMMA_DELIMTER );
		result = sb.toString().substring( 0, lastComma );
		
		System.out.println( result );
		
		return result;
	}
	
	/**
	 * Already we called authoken api and that response is
	 * crmemail2:::4d7870c78fb939ce87391bfca22bd5ec,crmemail21:::f1db8654082a86a54f6ecd1c416f1b0d,crmemail22:::a5d8141d471bee777d1929eec0069497,crmemail23:::2221fa2780c4a70ea3dc9be27fc05733,crmemail24:::c7b435a3bf2040d6448476ebe3c6a845,crmemail25:::4cc6a6254c30ae3b0c50c7e24ba6ad51,crmemail26:::1345fd530ad6bbcb78d6c5a42ed5d8fd,crmemail27:::3761036cc20dc809d0a195d89d52912f,crmemail28:::51415927b37935fa45a54395925290ea,crmemail29:::916be92ca4ec0d7b9957847ff64b6591,crmemail3:::447ed948438e10575a0c8c69561b5558,crmemail31:::ff792bc059ce2e9fe63a95fbcfdfd426,crmemail32:::26b8b07ead1c0195ff9debca309f0226,crmemail33:::a4a23267512e4ba4663ff5e7589beea4,crmemail34:::6c45a698729eee29d17fe87abe9d1673,crmemail35:::1a6444015c34510cdca1e2d3c25c18da,crmemail36:::e3d114151782bc89562b0105018393b9,crmemail37:::8c5d97f01280bf1726e76df76725a4ed,crmemail38:::460e1e146523bc13028726d683c038a3,crmemail39:::c717cabceca939e1793380754b099cb8,crmemail4:::1c66a62e6c81a8b550df12c0a259e8be,crmemail41:::29828f20def300ce09e00ee3064e334a,crmemail42:::1ee36f9f44a0298e06ef12874a19fb06,crmemail43:::e5f63e11d6dff94676a685738302f766,crmemail44:::422ebb8c1983e5a8cd291b77b5498be7,crmemail45:::704f318510af8dcc5fa88437e599b826,crmemail46:::f1529e9afc7c042d0745f5dfcebe4bb0,crmemail47:::d46b6eab97d3a1ca486b748d8f97b90e,crmemail48:::e15e976e4f279e78fe5be092becf32df,crmemail49:::c5427034be422b491d3dd7efdbd2fe68
	 * @param result
	 */
	static void populateEmailIdVsAuthokenMap( String result )
	{
		result = result != null ? result : "crmemail2:::4d7870c78fb939ce87391bfca22bd5ec,crmemail21:::f1db8654082a86a54f6ecd1c416f1b0d,crmemail22:::a5d8141d471bee777d1929eec0069497,crmemail23:::2221fa2780c4a70ea3dc9be27fc05733,crmemail24:::c7b435a3bf2040d6448476ebe3c6a845,crmemail25:::4cc6a6254c30ae3b0c50c7e24ba6ad51,crmemail26:::1345fd530ad6bbcb78d6c5a42ed5d8fd,crmemail27:::3761036cc20dc809d0a195d89d52912f,crmemail28:::51415927b37935fa45a54395925290ea,crmemail29:::916be92ca4ec0d7b9957847ff64b6591,crmemail3:::447ed948438e10575a0c8c69561b5558,crmemail31:::ff792bc059ce2e9fe63a95fbcfdfd426,crmemail32:::26b8b07ead1c0195ff9debca309f0226,crmemail33:::a4a23267512e4ba4663ff5e7589beea4,crmemail34:::6c45a698729eee29d17fe87abe9d1673,crmemail35:::1a6444015c34510cdca1e2d3c25c18da,crmemail36:::e3d114151782bc89562b0105018393b9,crmemail37:::8c5d97f01280bf1726e76df76725a4ed,crmemail38:::460e1e146523bc13028726d683c038a3,crmemail39:::c717cabceca939e1793380754b099cb8,crmemail4:::1c66a62e6c81a8b550df12c0a259e8be,crmemail41:::29828f20def300ce09e00ee3064e334a,crmemail42:::1ee36f9f44a0298e06ef12874a19fb06,crmemail43:::e5f63e11d6dff94676a685738302f766,crmemail44:::422ebb8c1983e5a8cd291b77b5498be7,crmemail45:::704f318510af8dcc5fa88437e599b826,crmemail46:::f1529e9afc7c042d0745f5dfcebe4bb0,crmemail47:::d46b6eab97d3a1ca486b748d8f97b90e,crmemail48:::e15e976e4f279e78fe5be092becf32df,crmemail49:::c5427034be422b491d3dd7efdbd2fe68";
		String [] emailIdAndAuthtokenArr = result.split( PMDConstants.COMMA_DELIMTER );
		
		for ( String emailIdAndAuthtoken : emailIdAndAuthtokenArr )
		{
			emailIdVsAuthtoken.put( emailIdAndAuthtoken.split( PMDConstants.COLON_DELIMITER )[0], emailIdAndAuthtoken.split( PMDConstants.COLON_DELIMITER )[1] );
		}
		
	}
	
	static String accountsUrl = "https://accounts.localzoho.com/apiauthtoken/nb/create?SCOPE=ZohoCRM/crmapi&EMAIL_ID=EMAILADDRESS&PASSWORD=12345678";
	static String crmUrl = "https://crmlab.localzoho.com/crm/internal/xml/Emails/sendMail";
	
	static String [] mailAccountsEmails = new String[] {
		"crmemail2",
		"crmemail21",
		"crmemail22",
		"crmemail23",
		"crmemail24",
		"crmemail25",
		"crmemail26",
		"crmemail27",
		"crmemail28",
		"crmemail29",

		"crmemail3",
		"crmemail31",
		"crmemail32",
		"crmemail33",
		"crmemail34",
		"crmemail35",
		"crmemail36",
		"crmemail37",
		"crmemail38",
		"crmemail39",

		"crmemail4",
		"crmemail41",
		"crmemail42",
		"crmemail43",
		"crmemail44",
		"crmemail45",
		"crmemail46",
		"crmemail47",
		"crmemail48",
		"crmemail49"
	};
	
	static LinkedHashMap<String, String> emailIdVsAuthtoken = new LinkedHashMap<String, String>();
	
}
