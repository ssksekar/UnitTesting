//$Id$
package enumanalysis;

public class EnumConstructor {

	public static void main(String arg [])
	{
		System.out.println(enum1.high.getVal());
	}
	
	
	enum enum1
	{
		high(1),
		low(3),
		medium(2);
		
		private final int level;
		
		enum1( int level )
		{
			this.level = level;
		}
		
		int getVal()
		{
			return this.level;
		}
	}
	
}
