//$Id$
package looping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;


public class SubFoldersIterations {

	private static LinkedHashMap<Integer, Integer> folderVsParentFolder = new LinkedHashMap<Integer, Integer>();
	
	static
	{
		folderVsParentFolder.put(1,null);
		folderVsParentFolder.put(2,null);
		folderVsParentFolder.put(3,null);
		folderVsParentFolder.put(4,null);
		folderVsParentFolder.put(5,null);
		folderVsParentFolder.put(6,null);
		folderVsParentFolder.put(7,null);
		folderVsParentFolder.put(8,1);
		folderVsParentFolder.put(9,1);
		folderVsParentFolder.put(10,1);
		folderVsParentFolder.put(11,2);
		folderVsParentFolder.put(12,2);
		folderVsParentFolder.put(13,2);
		folderVsParentFolder.put(14,2);
		folderVsParentFolder.put(15,3);
		folderVsParentFolder.put(16,3);
		folderVsParentFolder.put(17,3);
		folderVsParentFolder.put(18,4);
		folderVsParentFolder.put(19,4);
		folderVsParentFolder.put(20,5);
		folderVsParentFolder.put(21,6);
		folderVsParentFolder.put(22,6);
		folderVsParentFolder.put(23,6);
		folderVsParentFolder.put(24,6);
		folderVsParentFolder.put(25,8);
		folderVsParentFolder.put(26,9);
		folderVsParentFolder.put(27,26);
		folderVsParentFolder.put(28,27);
		folderVsParentFolder.put(29,27);
		folderVsParentFolder.put(30,29);
		folderVsParentFolder.put(31,29);
		folderVsParentFolder.put(32,29);
		folderVsParentFolder.put(33,10);
		folderVsParentFolder.put(34,11);
		folderVsParentFolder.put(35,34);
		folderVsParentFolder.put(36,35);
		folderVsParentFolder.put(37,12);
		folderVsParentFolder.put(38,37);
		folderVsParentFolder.put(39,37);
		folderVsParentFolder.put(40,39);
		folderVsParentFolder.put(41,40);
		folderVsParentFolder.put(42,40);
		folderVsParentFolder.put(43,13);
		folderVsParentFolder.put(44,15);
		folderVsParentFolder.put(45,17);
		folderVsParentFolder.put(46,17);
		folderVsParentFolder.put(47,19);
		folderVsParentFolder.put(48,20);
		folderVsParentFolder.put(49,20);
		folderVsParentFolder.put(50,20);
		folderVsParentFolder.put(51,48);
		folderVsParentFolder.put(52,48);
		folderVsParentFolder.put(53,51);
		folderVsParentFolder.put(54,52);
		folderVsParentFolder.put(55,53);
		folderVsParentFolder.put(56,54);
		folderVsParentFolder.put(57,54);
		folderVsParentFolder.put(58,55);
		folderVsParentFolder.put(59,56);
		folderVsParentFolder.put(60,22);
		folderVsParentFolder.put(61,60);
		folderVsParentFolder.put(62,61);
		folderVsParentFolder.put(63,61);
		folderVsParentFolder.put(64,61);
		folderVsParentFolder.put(65,23);
		folderVsParentFolder.put(66,23);
		folderVsParentFolder.put(67,23);
		folderVsParentFolder.put(68,23);
		folderVsParentFolder.put(69,66);
		folderVsParentFolder.put(70,69);
		folderVsParentFolder.put(71,69);
		folderVsParentFolder.put(72,69);
		folderVsParentFolder.put(73,69);
		folderVsParentFolder.put(74,68);
		folderVsParentFolder.put(75,68);
		folderVsParentFolder.put(76,67);
		folderVsParentFolder.put(77,67);
		folderVsParentFolder.put(78,67);
		folderVsParentFolder.put(79,67);
		folderVsParentFolder.put(80,67);
		folderVsParentFolder.put(81,67);
		folderVsParentFolder.put(82,67);
		folderVsParentFolder.put(83,67);
		folderVsParentFolder.put(84,67);
		folderVsParentFolder.put(85,67);
		folderVsParentFolder.put(86,67);
		folderVsParentFolder.put(87,67);
		folderVsParentFolder.put(88,67);
		folderVsParentFolder.put(89,67);
		folderVsParentFolder.put(90,67);
		folderVsParentFolder.put(91,67);
		folderVsParentFolder.put(92,67);
		folderVsParentFolder.put(93,67);
		folderVsParentFolder.put(94,67);
		folderVsParentFolder.put(95,67);
		folderVsParentFolder.put(96,67);
		folderVsParentFolder.put(97,67);
		folderVsParentFolder.put(98,67);
		folderVsParentFolder.put(99,67);
		folderVsParentFolder.put(100,67);
	}
	
	
	public static void main( String arg[] ) throws Exception
	{
		HashMap<Integer, FolderTree<Integer>> hm = new HashMap<Integer, FolderTree<Integer>>();
		FolderTree<Integer> ft = null;
		
		Iterator<Integer> iter = folderVsParentFolder.keySet().iterator();
		ArrayList<Integer> rootFolders = new ArrayList<Integer>();
		
		Integer currentId = null;
		Integer parentId = null;
		
		while( iter.hasNext() )
		{
			currentId = iter.next();
			
			ft = new FolderTree<Integer>();
			ft.setCurrent(currentId);
			
			if ( folderVsParentFolder.get( currentId ) != null )
			{
				ft.setParent( folderVsParentFolder.get( currentId ) );
			}
			else
			{
				rootFolders.add(currentId);
				
				/*Removing if there is no parent.*/
				iter.remove();
			}
			
			hm.put( currentId, ft );
		}
		
		iter = folderVsParentFolder.keySet().iterator();
		
		while( iter.hasNext() )
		{
			currentId = iter.next();
			parentId = folderVsParentFolder.get( currentId );
			
			ft = hm.get(parentId);
			
			if ( ft.getChildren() == null )
			{
				ft.setChildren( new ArrayList<Integer>() );
			}
			
			ft.getChildren().add(currentId);
			
			iter.remove();
		}
		
		
		JSONObject jsonObject = null;
		
		JSONArray outerJsonArr = null;
		JSONArray jsonArr = new JSONArray();
		
		if ( !rootFolders.isEmpty() )
		{
			//while
		}
		
		System.out.println( folderVsParentFolder );
		System.out.println( hm.size() );
		
		for ( Map.Entry<Integer,FolderTree<Integer>> entry : hm.entrySet() )
		{
			//System.out.print( entry.getKey() + " ::: " );
			System.out.print( entry.getValue().getCurrent() + " ::: " );
			System.out.print( entry.getValue().getParent() + " ::: " );
			System.out.println( entry.getValue().getChildren() );
		}
	}
	
	
}
