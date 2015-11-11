package mysql;



public class Insert {

	private static int count = 200000;
	private static int startingCount = 1000000;

	public static void main( String [] arg ) throws Exception
	{
		//initTemplateTable( false );
		initTemplateTable( true );
	}
	
	private static void initTemplateTable( boolean isOrgTable )
	{
		int iteration = 10 * count;
		
		for ( int i = 1; i <= iteration; i = i+count  )
		{
			System.out.println( i );
			InsertOrgAndTemplateTables insertTemplateTable = new InsertOrgAndTemplateTables();
			insertTemplateTable.count = count;
			insertTemplateTable.startingCount = startingCount + i;
			insertTemplateTable.batchSize =  count <= 1000 ? count : 1000;
			
			if ( isOrgTable )
			{
				insertTemplateTable.tableName = "CrmOrg_MailClient";
				insertTemplateTable.column = "LAST_CRMMAILUID";
			}
			else
			{
				insertTemplateTable.tableName = "CrmTPL_MailClient";
				insertTemplateTable.column = "LAST_MESSAGE_ID";
			}
			
			Thread templateTable = new Thread( insertTemplateTable );
			templateTable.start();
		}
	}
}

