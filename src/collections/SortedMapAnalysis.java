//$Id$
package collections;

import java.util.ArrayList;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.adventnet.crm.common.util.PMDConstants;
import com.adventnet.crm.entity.util.CrmModuleConstants;

public class SortedMapAnalysis {

	public static void main(String arg []) throws Exception
	{
		JSONObject jsonObj = new JSONObject( "{\"Leads\":[{\"id\":\"2000000000013\",\"name\":\"Big Deal Alert\", \"count\":\"2\"},{\"id\":\"2000000129009\",\"name\":\"Potential Won woth good deal\", \"count\":\"39\"},{\"id\":\"2000000061005\",\"name\":\"0005\", \"count\":\"11\"},{\"id\":\"2000000061007\",\"name\":\"0005\", \"count\":\"8\"},{\"id\":\"2000000127033\",\"name\":\"Explaining Daya\", \"count\":\"88\"},{\"id\":\"2000000129001\",\"name\":\"Leads 1111\", \"count\":\"1\"},{\"id\":\"2000000129005\",\"name\":\"Leads Kill them\", \"count\":\"10\"}],\"Contacts\":[{\"id\":\"2000000061005\",\"name\":\"0005\", \"count\":\"11\"},{\"id\":\"2000000061007\",\"name\":\"0005\", \"count\":\"8\"},{\"id\":\"2000000127033\",\"name\":\"Explaining Daya\", \"count\":\"81\"}],\"Potentials\":[{\"id\":\"2000000000013\",\"name\":\"Big Deal Alert\", \"count\":\"92\"},{\"id\":\"2000000129009\",\"name\":\"Potential Won woth good deal\", \"count\":\"39\"}]} " );

		System.out.println( jsonObj.getJSONArray( CrmModuleConstants.LEADS ) );
		
		JSONArray jsonArr = getTopFavorites(jsonObj.getJSONArray( CrmModuleConstants.LEADS ));
		
		//System.out.println( jsonArr );
		jsonObj.put( CrmModuleConstants.LEADS, jsonArr );
		
		System.out.println( jsonObj.getJSONArray( CrmModuleConstants.LEADS ) );
		
	}
	
	
	
	private static JSONArray getTopFavorites( JSONArray jsonArr ) throws Exception
	{
		JSONArray tempJsonArr = jsonArr;
		
		if ( jsonArr != null )
		{
			int jsonArrLen = jsonArr.length();
			int favoritesCounts = 6;
			int count = 0;
			
			JSONObject jsonObj = null;
			tempJsonArr = new JSONArray();
			TreeMap<Integer, ArrayList<JSONObject>> sortedTreeMap = new TreeMap<Integer, ArrayList<JSONObject>>(); 
			
			/* run for all the json Array elements and form the sortedTreeMap
			 * Output of SortedTreeMap :
			 * 
			 */
			for ( int i = 0; i < jsonArrLen ; i++ )
			{
				jsonObj = jsonArr.getJSONObject( i );
				count = jsonObj.getInt( PMDConstants.COUNT );
				
				if ( sortedTreeMap.get( count ) == null )
				{
					sortedTreeMap.put( count, new ArrayList<JSONObject>() );
				}
				
				sortedTreeMap.get( count ).add( jsonObj );
			}
			
			NavigableMap<Integer, ArrayList<JSONObject>> reversedTreeMap =  sortedTreeMap.descendingMap();
			
			for ( Map.Entry<Integer, ArrayList<JSONObject>> entry : reversedTreeMap.entrySet() )
			{
				ArrayList<JSONObject> jsonObjList = entry.getValue();
				
				for ( JSONObject tempJsonObj : jsonObjList )
				{
					tempJsonArr.put( tempJsonObj );
					favoritesCounts--;
					
					if ( favoritesCounts == 0 )
					{
						break; //Breaks the inner loop
					}
				}
				
				if ( favoritesCounts == 0 )
				{
					break;//Breaks the outer loop
				}
			}
		}
		
		return tempJsonArr;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
