//$Id$
package classes.innerclass;

public class NestedClass {

	
	static class NestedInnerClass
	{
		private String str = null;
		
		public void call ()
		{
			System.out.println( "NestedInnerClass" );
		}

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}
	}
	
}
