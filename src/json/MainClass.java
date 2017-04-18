//$Id$
package json;

import java.util.HashMap;

import org.json.JSONArray;


public class MainClass {

	public static void main(String arg[]) throws Exception
	{
		String str = "[{\"Potentials_FirstQuery\":\"6\",\"Colleagues_FirstQuery\":\"6\",\"UnMatched_SecondQuery\":\"5\",\"UnMatched_FirstQuery\":\"7\",\"ServerOverallTime\":\"57\",\"UserId\":\"2248729000000124187\",\"Leads_FirstQuery\":\"7\",\"FolderId\":\"2248729000000202014\",\"UnMatched_LabelAndEntityQuery\":\"3\",\"UnMatched_CassandraQuery_70\":\"11\",\"ViewRendering\":\"9\"},{\"Potentials_FirstQuery\":\"3\",\"Potentials_CassandraQuery_13\":\"10\",\"Potentials_LabelAndEntityQuery\":\"32\",\"UnMatched_FirstQuery\":\"4\",\"Colleagues_SecondQuery\":\"5\",\"ServerOverallTime\":\"95\",\"Colleagues_LabelAndEntityQuery\":\"5\",\"FolderId\":\"1335595000001684001\",\"Colleagues_FirstQuery\":\"5\",\"Potentials_SecondQuery\":\"3\",\"UnMatched_SecondQuery\":\"5\",\"Leads_CassandraQuery_86\":\"26\",\"Leads_SecondQuery\":\"6\",\"Leads_LabelAndEntityQuery\":\"26\",\"UserId\":\"1335595000000075001\",\"Colleagues_CassandraQuery_58\":\"23\",\"Leads_FirstQuery\":\"6\",\"UnMatched_LabelAndEntityQuery\":\"3\",\"UnMatched_CassandraQuery_61\":\"27\",\"ViewRendering\":\"9\"},{\"Colleagues_FirstQuery\":\"6\",\"Potentials_FirstQuery\":\"7\",\"UnMatched_SecondQuery\":\"5\",\"UnMatched_CassandraQuery_54\":\"8\",\"UnMatched_FirstQuery\":\"7\",\"ServerOverallTime\":\"46\",\"UserId\":\"2248729000000124187\",\"Leads_FirstQuery\":\"10\",\"FolderId\":\"2248729000000202016\",\"UnMatched_LabelAndEntityQuery\":\"3\",\"ViewRendering\":\"8\"},{\"Colleagues_FirstQuery\":\"3\",\"Potentials_FirstQuery\":\"4\",\"UnMatched_FirstQuery\":\"4\",\"ServerOverallTime\":\"14\",\"UserId\":\"2248729000000124187\",\"Leads_FirstQuery\":\"8\",\"FolderId\":\"2248729000000202028\"},{\"Potentials_FirstQuery\":\"3\",\"Colleagues_FirstQuery\":\"3\",\"UnMatched_SecondQuery\":\"4\",\"UnMatched_CassandraQuery_54\":\"8\",\"UnMatched_FirstQuery\":\"4\",\"ServerOverallTime\":\"42\",\"UserId\":\"2248729000000124187\",\"Leads_FirstQuery\":\"5\",\"FolderId\":\"2248729000000202016\",\"UnMatched_LabelAndEntityQuery\":\"3\",\"ViewRendering\":\"8\"},{\"ServerOverallTime\":\"166\",\"UserId\":\"2248729000000124187\"},{\"Colleagues_FirstQuery\":\"4\",\"Colleagues_SecondQuery\":\"4\",\"UserId\":\"915083000000336001\",\"Colleagues_LabelAndEntityQuery\":\"2\",\"Colleagues_CassandraQuery_2\":\"5\",\"ViewRendering\":\"1\"},{\"Leads_SecondQuery\":\"3\",\"UserId\":\"1207738000000080009\",\"Leads_LabelAndEntityQuery\":\"8\",\"Leads_FirstQuery\":\"9\",\"Leads_CassandraQuery_2\":\"4\",\"ViewRendering\":\"0\"},{\"Potentials_FirstQuery\":\"3\",\"Colleagues_FirstQuery\":\"2\",\"UnMatched_SecondQuery\":\"5\",\"UnMatched_FirstQuery\":\"4\",\"UnMatched_CassandraQuery_78\":\"10\",\"ServerOverallTime\":\"47\",\"UserId\":\"2248729000000124187\",\"Leads_FirstQuery\":\"6\",\"FolderId\":\"2248729000000202014\",\"UnMatched_LabelAndEntityQuery\":\"4\",\"ViewRendering\":\"13\"}]";
		JSONArray jsonArr = new JSONArray( str );
		
		System.out.println( jsonArr );
	}
}
