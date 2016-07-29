//$Id$
package mysql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;

import com.mysql.jdbc.Driver;

public class CRMMailUIDUniqueAnalysis {
	
	private static ArrayList<HashMap<String, String>> insertionData = new ArrayList<HashMap<String,String>>();

	public static void main(String [] arg) throws Exception
	{
		readFile( "/Users/sathish-1343/temporaryFiles/cassandraStats/88.txt" );
		readFile( "/Users/sathish-1343/temporaryFiles/cassandraStats/93.txt" );
		readFile( "/Users/sathish-1343/temporaryFiles/cassandraStats/94.txt" );				
		readFile( "/Users/sathish-1343/temporaryFiles/cassandraStats/95.txt" );				
		//readFile( "/Users/sathish-1343/temporaryFiles/cassandraStats/96.txt" );				
	}
	
	
	
	private static void readFile(String str) throws Exception
	{
		BufferedReader reader = null;
        
		String currentLine = null;

        try
        {
            reader =  new BufferedReader( new FileReader( str ) );
            
            while( ( currentLine = reader.readLine() ) != null )
            {
            	currentLine = currentLine.trim();
            	parseAndPopulate( currentLine );
            	
            	if ( insertionData.size() >= 1000 )
        		{
        			insert(insertionData);
        			insertionData = new ArrayList<HashMap<String,String>>();
        		}
            }
            
            insert( insertionData );//to insert the remaining data's
            
            System.out.println( str + " Insertion Done..." );
        }
        finally
        {
            if(reader != null){
                try{
                    reader.close();
                }catch(IOException ioe){
                    //ioe.printStackTrace();
                }
            }
        }
	}
	
	private static void parseAndPopulate(String str) throws Exception
	{
		//str = "[\"2405617:HEADERS\",\"userId:::1459897000000083003$ssksekar_end$ssk_messageid:::<D0149132-31F8-4EF5-9F89-C621A9018398@accu-italia.com>$ssksekar_end$receivedTime:::1435305778000$ssksekar_end$received:::by10.31.156.21withSMTPidf21csp603880vke;Sat,10Oct201509:53:52-0700(PDT)$ssksekar_end$crmmailuid:::9a93dc5afc5b5e2ff27c39bcff9ab1a9$ssksekar_end$Delivered-To:::stephane.besnard@seatronic.fr$ssksekar_end$Received:::by 10.31.156.21 with SMTP id f21csp603880vke; Sat, 10 Oct 2015\r\n 09:53:52 -0700 (PDT)$ssksekar_end$X-Received:::by 10.31.131.141 with SMTP id f135mr12827730vkd.37.1444494757590;\r\n Sat, 10 Oct 2015 09:32:37 -0700 (PDT)$ssksekar_end$Authentication-Results:::mx.google.com; spf=softfail (google.com: best guess\r\n record for domain of transitioning unknown does not designate <unknown> as\r\n permitted sender) smtp.mailfrom=$ssksekar_end$Received-SPF:::softfail (google.com: best guess record for domain of\r\n transitioning unknown does not designate <unknown> as permitted sender)$ssksekar_end$Received:::by 10.31.70.66 with POP3 id t63mf6534877vka.0; Sat, 10 Oct 2015\r\n 09:32:37 -0700 (PDT)$ssksekar_end$X-Gmail-Fetch-Info:::info@seatronic.fr 1 pop.gmail.com 995 info@seatronic.fr$ssksekar_end$Delivered-To:::info@seatronic.fr$ssksekar_end$Received:::by 10.202.60.8 with SMTP id j8csp1131869oia; Fri, 26 Jun 2015\r\n 01:03:24 -0700 (PDT)$ssksekar_end$X-Received:::by 10.60.78.230 with SMTP id e6mr372800oex.24.1435305804183; Fri,\r\n 26 Jun 2015 01:03:24 -0700 (PDT)$ssksekar_end$Authentication-Results:::mx.google.com; spf=softfail (google.com: best guess\r\n record for domain of transitioning unknown does not designate <unknown> as\r\n permitted sender) smtp.mail=$ssksekar_end$Received-SPF:::softfail (google.com: best guess record for domain of\r\n transitioning unknown does not designate <unknown> as permitted sender)$ssksekar_end$Received:::by 10.202.231.140 with POP3 id e134mf5185605oih.0; Fri, 26 Jun 2015\r\n 01:03:23 -0700 (PDT)$ssksekar_end$X-Gmail-Fetch-Info:::stephane.besnard@seatronic.fr 5 mail.seatronic.fr 110\r\n stephane.besnard@seatronic.fr$ssksekar_end$Received:::from mail.icodia.com id 1520DA0-mailsrv.icodia.com with ICOSV\r\n (ICOAD-SMTP) id A7390904; Fri, 26 Jun 2015 10:03:05 +0200$ssksekar_end$X-Spam-Status:::No, hits=0.1 required=7.5 tests=HTML_MESSAGE: 0.001,RDNS_NONE:\r\n 0,TVD_RCVD_IP: 0.05, TVD_RCVD_IP4: 0.059,TOTAL_SCORE: 0.110,autolearn=ham$ssksekar_end$X-Spam-Level:::$ssksekar_end$Received:::from 195.110.134.211 by mail.icodia.com (ICODIA SecureSMTP\r\n vers.4.5); Fri, 26 Jun 2015 10:03:03 +0200$ssksekar_end$Received:::from [192.168.1.113] (helo=accu113.sica.com) by sica-it.com with\r\n esmtp (Exim 4.69) (envelope-from <DeSantisT@accu-italia.com>) id\r\n NQJKWL-000449-HO for stephane.besnard@seatronic.fr; Fri, 26 Jun 2015 10:00:21\r\n +0200$ssksekar_end$From:::Tina De Santis <DeSantisT@accu-italia.com>$ssksekar_end$Content-Type:::multipart/alternative;\r\n boundary=\\\"Apple-Mail=_BC8CDF68-1E97-4396-862A-0F10BDB3A813\\\"$ssksekar_end$Message-Id:::<D0149132-31F8-4EF5-9F89-C621A9018398@accu-italia.com>$ssksekar_end$Mime-Version:::1.0 (Mac OS X Mail 6.6 \\(1510\\))$ssksekar_end$Subject:::=?iso-8859-1?Q?Re=3A_=5B***SPAM***=5D_r=E9sultat_2014?=$ssksekar_end$Date:::Fri, 26 Jun 2015 10:02:58 +0200$ssksekar_end$References:::<558D0239.9090907@seatronic.fr>\r\n <CAN8aAcd5LHf7QGWWCJBOw8MzLCD6Xauk0SMEWf_seL9Z7ou=bQ@mail.gmail.com>$ssksekar_end$To:::Stephane Besnard <stephane.besnard@seatronic.fr>$ssksekar_end$In-Reply-To:::<CAN8aAcd5LHf7QGWWCJBOw8MzLCD6Xauk0SMEWf_seL9Z7ou=bQ@mail.gmail.com>$ssksekar_end$X-Mailer:::Apple Mail (2.1510)$ssksekar_end$X-Error-Return-Path:::<DeSantisT@accu-italia.com>$ssksekar_end$X-HELO-In-Domain:::sica-it.com$ssksekar_end$X-ORG-IN-IP-Address:::195.110.134.211$ssksekar_end$X-RCPT-TO:::<stephane.besnard@seatronic.fr>$ssksekar_end$Status:::U$ssksekar_end$X-UIDL:::735304570$ssksekar_end$X-IcoServerMsgID:::073901520000a3b6$ssksekar_end$\",1465641460595011],";//No I18N

		str = str.replaceAll( "\r\n", " " );
		
		str = str.substring(0, str.length()-1);
		
		JSONArray jsonArr = null;
		
		try
		{
			jsonArr = new JSONArray(str);
			str = jsonArr.getString(1);
			
			String [] headersArr = str.split( "\\$ssksekar_end\\$" );
			String [] tempArr = null;
			
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put( "full_header", str );
			
			for ( String header : headersArr )
			{
				tempArr = header.split(":::");
				
				if ( tempArr != null && tempArr.length == 2 )
				{
					if ( !hm.containsKey( tempArr[0] ))
					{
						hm.put( tempArr[0], tempArr[1] );
					}
				}			
			}
			
			insertionData.add(hm);
		}
		catch( JSONException jex )
		{
			//jex.printStackTrace();
		}
	}

	
	/*
	drop table CrmMailUidUnique; 
	create table CrmMailUidUnique ( id bigint not null auto_increment, userid bigint, crmmailuid varchar(100), messageid text, rtime bigint, received text, header text, CONSTRAINT CrmMailUidUnique primary key (id) );
	create index userid on  CrmMailUidUnique(userid);
	create index crmmailuid on  CrmMailUidUnique(crmmailuid);
	create index rtime on  CrmMailUidUnique(rtime);
	insert into CrmMailUidUnique (userid, crmmailuid, header)  values (10, '2222', '111'), (20, '4544', '934'); 
	select * from CrmMailUidUnique;
	*/
	private static void insert(ArrayList<HashMap<String, String>> insertionData) throws Exception
	{
		System.out.println( insertionData.size() );
		Connection con = null;
		try
		{
			Class.forName( Driver.class.getName() );		
			
			String insertSql = "insert into CrmMailUidUnique (userid, crmmailuid, messageid, rtime, received, header ) values( ?, ?, ?, ?, ?, ? )";

			/* Local mysql */
			con = DriverManager.getConnection( "jdbc:mysql://localhost/sathish", "root", "" );
			
			/* IDC mysql */
			//con = DriverManager.getConnection( "jdbc:mysql://localhost/CrmMailTesting", "root", "qazwsx" );
			
			PreparedStatement preparedStatement = con.prepareStatement(insertSql);

			for ( HashMap<String, String> hm : insertionData )
			{
				preparedStatement.setLong( 1, Long.valueOf( hm.get( "userId" ) ) );
				preparedStatement.setString( 2, hm.get( "crmmailuid" ) );
				preparedStatement.setString( 3, hm.get( "ssk_messageid" ) );
				preparedStatement.setLong( 4, Long.valueOf( hm.get( "receivedTime" ) ) );
				preparedStatement.setString( 5, hm.get( "received" ) );
				preparedStatement.setString( 6, hm.get( "full_header" ) );

				preparedStatement.addBatch();
			}

			//System.out.println( preparedStatement );
			preparedStatement.executeBatch();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if ( con != null )
			{
				try {
					con.close();
				} catch (SQLException e) {
					//e.printStackTrace();
				}
			}
		}
	}
}