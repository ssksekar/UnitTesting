//$Id$
package oops;

import java.util.HashMap;

public class Players {

	public String sports = "Volley Ball";
	public HashMap<Long, String> map = new HashMap<Long, String>(){{ put( 1111l, "Sathish" ); put( 2222l, "Kumar" ); }}; 
	
	public void isPlayer(String fromSports)
	{
		System.out.println( "From Sports " + fromSports + " ::: " + sports );
		
		if ( fromSports.equals("cricket") )
		{
			map.put( 3333l, "sekar" );
		}
		
		System.out.println( map );
	}
	
}
