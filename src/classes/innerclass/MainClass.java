//$Id$
package classes.innerclass;

public class MainClass {

	public static void main(String arg [])
	{
		nestedClass();
		innerClass();
	}
	
	private static void innerClass()
	{
		InnerClass innerClass = new InnerClass();
		InnerClass.Inner inner = innerClass.new Inner();
		InnerClass.Inner inner2 = innerClass.new Inner();
		
		inner.setStr( "1111111" );
		inner2.setStr( "22222222" );
		
		System.out.println( inner.getStr() );
		System.out.println( inner2.getStr() );
	}

	private static void nestedClass()
	{
		NestedClass.NestedInnerClass nestedInnerClass = new NestedClass.NestedInnerClass();
		NestedClass.NestedInnerClass nestedInnerClass2 = new NestedClass.NestedInnerClass();

		nestedInnerClass.setStr("111111");
		nestedInnerClass2.setStr("22222");
		
		System.out.println( nestedInnerClass.getStr() );
		System.out.println( nestedInnerClass2.getStr() );
	}
	
}
