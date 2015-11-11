//$Id$
package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.mysql.jdbc.Driver;

public class InsertOrgAndTemplateTables implements Runnable{
	
	String tableName = null;
	String column = null;
	int count = 0;
	int batchSize = 0;
	int startingCount = 0;
	
	private static String DOUBLE_QUOTES = "\"";
	private static String COMMA_DELIMTER = ",";
	private static String MD5 = "MD5(";
	private static String CLOSE_MD5 = ")";


	public void run()
	{
		Connection con = null;
		try
		{
			Class.forName( Driver.class.getName() );		
			
			String insertSql = "insert into " + tableName + " values(?, md5(?), md5(?), ?, ?, ?, ?, ?, ?, ?, ?)";
			boolean isOrgTable = tableName.contains( "Org" );
			
			if ( isOrgTable )
			{
				insertSql = "insert into " + tableName + " values(?, md5(?), md5(?), ?, ?, md5(?), ?, ?, ?, ?, ?)";
			}
			

			/* Local mysql */
			con = DriverManager.getConnection( "jdbc:mysql://localhost/sathish", "root", "" );
			
			/* IDC mysql */
			//con = DriverManager.getConnection( "jdbc:mysql://localhost/sathish", "root", "qazwsx" );
			
			PreparedStatement preparedStatement = con.prepareStatement(insertSql);
			PreparedStatement updatePreparedStatement = null;
			Random random = new Random();

			long receivedTime = 1230748200000l;
			long threadId = 0l;
			
			int totalEntities = 75000;
			int totalFolders = 100;
			int totalUsers = 100;
			int setype = 0;
			int endCount = count + startingCount;
			int threadIdStartCount = startingCount;
			
			/* assuming 60% mails are threaded */
			long totalThreadMails = Math.round( batchSize * 0.6 );
			
			long userId = ( random.nextInt(totalUsers) + 6083648792183l ) * 727535l;
			
			HashMap<Long, Long> threadIdVsReceivedTime = new HashMap<Long, Long>();
			HashMap<Long, Object> threadIdVsColumn = new HashMap<Long, Object>();
			
			for ( int i = startingCount; i < endCount; i++ )
			{
				setype = random.nextInt(5) + 1;
				receivedTime = receivedTime + ( ( random.nextInt(21) + 1l ) * 1000 );
				threadId = threadIdStartCount + random.nextInt( Integer.valueOf( String.valueOf( totalThreadMails ) ) );
				
				if ( isOrgTable )
				{
					preparedStatement.setLong( 1, userId );
				}
				else
				{
					preparedStatement.setLong( 1, i );
				}
				
				preparedStatement.setLong( 2, i );
				preparedStatement.setLong( 3, threadId );
				preparedStatement.setLong( 4,  receivedTime );
				preparedStatement.setLong( 5, receivedTime );
				preparedStatement.setLong( 6, i );
				preparedStatement.setInt( 7, ( random.nextInt(10000) + 1)%2 );
				preparedStatement.setInt( 8, ( random.nextInt(10000) + 1)%2 );
				preparedStatement.setLong( 9, ( random.nextInt(totalFolders) + 983648712183l ) * 827535l );
				preparedStatement.setInt( 10, setype );
				
				/* entityId only for contacts/leads/potentials */
				if ( setype < 4 )
				{
					preparedStatement.setLong( 11, ( random.nextInt(totalEntities) + 892691012119l ) * 951129l );
				}
				else
				{
					preparedStatement.setNull( 11, java.sql.Types.BIGINT );
				}
				
				preparedStatement.addBatch();
				
				threadIdVsReceivedTime.put( threadId, receivedTime );
				threadIdVsColumn.put( threadId, i );
				
				if ( i % batchSize == 0 )
				{
					System.out.println( Thread.currentThread().getName() + " ::: " + i );
					preparedStatement.executeBatch();
					Thread.sleep(500);
					
					updatePreparedStatement = con.prepareStatement( getUpdateAllLastMessageInfoByThreadIdQuery( tableName, column, threadIdVsReceivedTime, threadIdVsColumn ) );;
					updatePreparedStatement.execute();
					
					threadIdVsReceivedTime = new HashMap<Long, Long>();
					threadIdVsColumn = new HashMap<Long, Object>();
					threadIdStartCount += batchSize; 
					
					if( isOrgTable )
					{
						userId = ( random.nextInt(totalUsers) + 6083648792183l ) * 727535l;
					}
				}
			}						
		}
		catch( Exception ex)
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
					e.printStackTrace();
				}
			}
		}
	}
	
	private String getUpdateAllLastMessageInfoByThreadIdQuery( String tableName, String column, HashMap<Long, Long> threadIdVsReceivedTime, HashMap<Long, Object> threadIdVsColumn ) throws Exception
	{
		if ( threadIdVsReceivedTime != null && !threadIdVsReceivedTime.isEmpty() && threadIdVsColumn != null && !threadIdVsColumn.isEmpty() )
		{
			StringBuilder givenColumnLastValue = new StringBuilder();
			givenColumnLastValue.append( " ( CASE " );//No I18N
			givenColumnLastValue.append( "THREADID" );
			
			
			StringBuilder lastMessageTime = new StringBuilder();
			lastMessageTime.append( " ( CASE " );//No I18N
			lastMessageTime.append( "THREADID" );
			
			StringBuilder threadIdCondition = new StringBuilder();
			
			for ( Map.Entry<Long, Long> entry : threadIdVsReceivedTime.entrySet() )
			{
				givenColumnLastValue.append( " WHEN " );//No I18N
				givenColumnLastValue.append( MD5 + entry.getKey() + CLOSE_MD5 );
				givenColumnLastValue.append( " THEN " );//No I18N
				
				if ( tableName.equals( "CrmOrg_MailClient" ) )
				{
					givenColumnLastValue.append( MD5 + threadIdVsColumn.get( entry.getKey() ) + CLOSE_MD5 );
				}
				else
				{
					givenColumnLastValue.append( DOUBLE_QUOTES + threadIdVsColumn.get( entry.getKey() ) + DOUBLE_QUOTES );
				}
				
				lastMessageTime.append( " WHEN " );//No I18N
				lastMessageTime.append( MD5 + entry.getKey() + CLOSE_MD5 );
				lastMessageTime.append( " THEN " );//No I18N
				lastMessageTime.append( entry.getValue() );
				
				threadIdCondition.append( MD5 + entry.getKey() + CLOSE_MD5 );
				threadIdCondition.append( COMMA_DELIMTER );
			}
			
			givenColumnLastValue.append( " END ) " );//No I18N
			lastMessageTime.append( " END ) " );//No I18N
			
			
			/* constructing  the update query */
			StringBuilder updateQuery = new StringBuilder();

			//Sample Query : UPDATE CrmTPL_MailClient_2000000027480 SET LAST_MESSAGE_TIME =  ( CASE THREADID WHEN "ee31142761a6bdd51681536b87a1ecfe" THEN 1435737349000 WHEN "4bf0ec7eb2df78a33f1232e91d3c0ebe" THEN 1435769116000 WHEN "a4a9a060bb6f50d3748a952a3a475ce7" THEN 1435837605000 END ) ,LAST_MESSAGE_ID =  ( CASE THREADID WHEN "ee31142761a6bdd51681536b87a1ecfe" THEN 1000000030803 WHEN "4bf0ec7eb2df78a33f1232e91d3c0ebe" THEN 1000000030137 WHEN "a4a9a060bb6f50d3748a952a3a475ce7" THEN 1000000030117 END )  where THREADID IN ( "ee31142761a6bdd51681536b87a1ecfe","4bf0ec7eb2df78a33f1232e91d3c0ebe","a4a9a060bb6f50d3748a952a3a475ce7" ); 
			updateQuery.append( "UPDATE " );//No I18N
			updateQuery.append( tableName );
			updateQuery.append( " SET " );//No I18N

			updateQuery.append( "LAST_MESSAGE_TIME" );
			updateQuery.append( " = " );//No I18N
			updateQuery.append( lastMessageTime.toString() );
			
			updateQuery.append( COMMA_DELIMTER );
			
			updateQuery.append( column );
			updateQuery.append( " = " );//No I18N
			updateQuery.append( givenColumnLastValue.toString() );
			
			updateQuery.append( " where " );//No I18N
			updateQuery.append( "THREADID" );
			updateQuery.append( " IN ( " );//No I18N
			updateQuery.append( threadIdCondition.substring( 0, threadIdCondition.length() - 1 ) );
			
			updateQuery.append( " ) " );
			
			return updateQuery.toString();
		}			
		
		return null;
	}
	
}
