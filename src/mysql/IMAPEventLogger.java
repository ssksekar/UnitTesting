//$Id$
package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import com.mysql.jdbc.Driver;

public class IMAPEventLogger {
	
	
	public static void main(String arg [])
	{
		Connection con = null;
		try
		{
			Class.forName( Driver.class.getName() );		
			
			String insertSql = "insert into log ( userid, event, logtime, topic_partition ) values (?, ?, ?, ?)";

			
			/* Local mysql */
			con = DriverManager.getConnection( "jdbc:mysql://localhost/sathish", "root", "" );
			
			/* IDC mysql */
			//con = DriverManager.getConnection( "jdbc:mysql://localhost/sathish", "root", "qazwsx" );
			
			PreparedStatement preparedStatement = con.prepareStatement(insertSql);
			Random random = new Random();

			
			Long [] userId = new Long[]{1928658000002019081l, 1525432000000083003l, 1743563000000098178l, 15842000004428360l, 15842000017203141l, 2126915000000160008l, 1058801000000067001l, 15842000164575506l, 113720000000033001l, 2119782000001123001l, 2160002000000107005l, 198432000000033001l, 1515120000000084047l, 1202303000000071001l, 1424460000000083001l, 15842000006731919l, 1589286000000084003l, 330955000000037003l, 15842000016608076l, 1550146000000083003l, 1371605000001373003l, 15842000000074007l, 1788879000000091003l, 15842000000024019l, 2070659000000104007l, 238998000000034003l, 2048446000000104007l, 15842000016962893l, 1928658000000097003l, 1580654000000084003l, 1175187000000068001l, 1086459000000068001l, 1902320000000097003l, 837883000000061001l, 1627275000000085003l, 1371605000000576007l, 189162000000033001l, 1928658000002019187l, 1928658000002019155l, 1351652000000075001l, 173336000000033001l, 373722000000040003l, 1928658000002019171l, 251664000001103015l, 1905691000000116007l, 1928658000002019139l, 1514543000004865001l, 424523000003980003l, 984106000003679001l, 1032161000000066001l, 1928658000002019195l, 1517013000000083003l, 533880000000051003l, 318829000000037003l, 1928658000002019179l, 168098000000033001l, 1352102000000075001l, 1827835000000095003l, 1928658000002019147l, 617933000000053003l, 1928658000002019023l, 1708831000000091003l, 1486524000000248003l, 1596773000000084003l, 1776605000000091003l, 1364734000000090007l, 1435005000000083001l, 1345970000000075001l, 1574287000000084003l, 15842000384729234l, 1485887000000083003l, 636173000000053003l, 1093766000000068001l, 1928658000002019113l, 1928658000002019097l, 15842000056285299l, 1128327000000068001l, 899369000000064001l, 551000069437825l, 1373479000000078001l, 1536173000000083003l, 268199000000045003l, 2030142000000101003l, 1131260000000068001l, 1075933000000068001l, 1283654000000073001l, 1777078000000094003l, 18732000000022001l, 1497817000000083046l, 1174265000000068001l, 15842000065471304l, 1295007000000085027l, 1098310000000068001l, 511811000000050003l, 880426000000062001l, 18732000000836003l, 1751761000000091003l, 1928658000002019011l, 1265647000000150103l, 1342903000000165006l};
			String [] events = new String []{ "mail.loginsuccess", "mail.loginfailure", "mail.loginsuccess", "mail.loginfailure", "mail.loginsuccess", "mail.loginfailure", "mail.create", "mail.delete", "mail.create", "mail.delete", "mail.create", "mail.delete", "mail.create", "mail.delete", "mail.update", "mail.create", "mail.delete", "mail.update", "mail.create", "mail.delete", "mail.update", "mail.create", "mail.delete", "mail.update", "mail.create", "mail.delete", "mail.update", "mail.create", "mail.delete", "mail.update", "mail.initialsynccompletion", "mail.uidlist", "mail.sessionexist", "mail.folderdelete", "mail.foldercreate", "handlefailover", "mail.lastupdateduids", "mail.recentflag", "mail.recentflag", "mail.recentflag", "mail.recentflag", "mail.accountdelete", "mail.resynccompletion" };
			
			for ( int i = 1; i <= 3000000; i++ )
			{
				int k = random.nextInt(100);
				preparedStatement.setLong( 1, userId[k] );
				preparedStatement.setString( 2, events[random.nextInt(43)] );
				preparedStatement.setLong( 3,  System.currentTimeMillis() );
				preparedStatement.setString( 4, "imap0-" + k/2 );
				
				preparedStatement.addBatch();
				
				if ( i % 10000 == 0 )
				{
					System.out.println( Thread.currentThread().getName() + " ::: " + i );
					preparedStatement.executeBatch();
					//Thread.sleep(500);
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
	
}
