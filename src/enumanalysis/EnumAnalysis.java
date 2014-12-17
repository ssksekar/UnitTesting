//$Id$
package enumanalysis;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;

import com.adventnet.crm.common.util.DateTimeUtils;

public class EnumAnalysis {

	public static void main(String [] arg)
	{
		//Days day = Days("okka");
		
		//sunday;
		//for ( Days day : Days.values() )
		{
			//System.out.println(day);
			//System.out.println(day.str);
			//System.out.println(day.dates());
		}	
		
		
		String INTEGER = "DATE";
		Long date = (Long) CAST_MYSQL_DATATYPE_TO_JAVA_DATATYPE.valueOf("BIGINT").cast("");
		System.out.println( date );
		//System.out.println( EMAIL_DEFAULT_VIEWS.getDisplayName("ADDRESSED_TO_ME_OR_FROM_MY_ENTITIES") );
	}	
}

enum EMAIL_DEFAULT_VIEWS 
{ 
	ADDRESSED_TO_ME_OR_FROM_MY_ENTITIES 
	{
		public String getDisplayName()
		{
			return "Mine";//No I18n
		}
	},
	
	INBOX 
	{
		public String getDisplayName()
		{
			return "Inbox";//No I18n
		}
	},
	
	SENT
	{
		public String getDisplayName()
		{
			return "Sent";//No I18n
		}
	},
	
	DRAFT
	{
		public String getDisplayName()
		{
			return "Draft";//No I18n
		}
	},
	
	TRASH 
	{
		public String getDisplayName()
		{
			return "Trash";//No I18n
		}
	};
	
	
	public String getDisplayName()
	{
		return null;
	}

	public static String getDisplayName( String name )
	{
		try{
			name = EMAIL_DEFAULT_VIEWS.valueOf(name).getDisplayName();
		}
		catch (Exception ex){
			System.out.println( "No enum found" );
		}
		
		return name;
	}
}

enum Days
{
	sunday("1"){ public String dates(){return "first day";}; },
	monday("2"),
	tuesday("3"),
	wednesday("4"),
	thrusday("5"),
	friday("6"),
	saturday("7");
	
	public String str = "";
	Days(String s){
		System.out.println( "before ::: " + str );
		this.str = s;
		System.out.println( "after ::: " + str );
	}
	
	public String dates()
	{
		return "default dates";
	}
}

enum CAST_MYSQL_DATATYPE_TO_JAVA_DATATYPE
{
	CHAR { public String cast( String str ) { return str; }; },
	
	INTEGER 
	{ 
		public Integer cast( String str ) 
		{ 
			Integer val = null;
			if ( str != null )
			{
				val = Integer.valueOf( str );
			}
			return val;				
		}
	},
	
	BIGINT
	{ 
		public Long cast( String str ) 
		{ 
			Long val = null;
			if ( str != null )
			{
				val = Long.valueOf( str );
			}
			return val;				
		} 
	},
	
	BOOLEAN
	{ 
		public Boolean cast( String str ) 
		{ 
			Boolean val = null;
			if ( str != null )
			{
				val = Boolean.valueOf( str );
			}
			return val;				
		} 
	},
	
	FLOAT
	{ 
		public Float cast( String str ) 
		{ 
			Float val = null;
			if ( str != null )
			{
				val = Float.valueOf( str );
			}
			return val;				
		}
	},
	
	DOUBLE
	{ 
		public Double cast( String str ) 
		{ 
			Double val = null;
			if ( str != null )
			{
				val = Double.valueOf( str );
			}
			return val;				
		}; 
	},
	
	DATE
	{ 
		public Date cast( String str ) 
		{ 
			Date val = null;
			if ( str != null )
			{
				val = DateTimeUtils.StringToDate( str, DateTimeUtils.DB_DATE_PATTERN );
			}
			return val;				
		}; 
	},
	
	TIME
	{ 
		public Timestamp cast( String str ) 
		{
			return stringToTimestamp( str );
		}			
	},
	
	DATETIME
	{ 
		public Timestamp cast( String str ) 
		{
			return stringToTimestamp( str );
		}; 
	},
	
	TIMESTAMP
	{ 
		public Timestamp cast( String str ) 
		{
			return stringToTimestamp( str );
		} 
	},
	
	BLOB
	{ 
		public InputStream cast( String str ) 
		{
			InputStream val = null;
			if ( str != null )
			{
				val = new ByteArrayInputStream( str.getBytes() );
			}
			return val;	
		}
	};
	
	
	public Object cast( String str )
	{
		return null;
	}
	
	private static Timestamp stringToTimestamp( String str ) 
	{ 
		Timestamp val = null;
		if ( str != null )
		{
			val = Timestamp.valueOf( str );
		}
		return val;				
	}
}