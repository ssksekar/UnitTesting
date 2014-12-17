//$Id$
package classanalysis;

import encapsulationanalysis.ParentClass;

public class MainClass {

	public static void main(String arg[]) throws Exception
	{
		
		System.out.println( InnerClass.class.getName() );
		System.out.println( InnerClass.class.getSimpleName() );
		System.out.println( InnerClass.class.getCanonicalName() );
		
		
		ChildClass c = new ChildClass();
		System.out.println( c instanceof ChildClass );
		System.out.println( c instanceof SuperClass );
		
		System.out.println(c.getClass().getSimpleName());
		
		System.out.println( c.getClass() == ChildClass.class );
		
		ConstructorAnalysis  cs = new ConstructorAnalysis("indian");
		
	}
	
	class InnerClass
	{
		
	}
	
}
