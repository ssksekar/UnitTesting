//$Id$
package objectanalysis;

import java.util.ArrayList;

public class BeanAnalysis {
	
	private ArrayList<Bean> beanList = null;
	
	public static void main( String [] a )
	{
		BeanAnalysis ba = new BeanAnalysis();
		ba.process();
	}
	
	private void process()
	{
		beanList = new ArrayList<Bean>();
		Bean b = new Bean();
		Bean b1 = new Bean();
		
		beanList.add(b);
		beanList.add(b1);
		
		
		display();
		alter();
		display();
	}
	
	private void alter()
	{
		for ( int i = 0; i < beanList.size(); i++ )
		{
			Bean b = beanList.get(i);
			b.setName("Mokishta");
			//beanList.set(i, b);
		}
	}

	private void display()
	{
		for ( int i = 0; i < beanList.size(); i++ )
		{
			Bean b = beanList.get(i);
			System.out.println( b.getName() );
		}
	}

}


class Bean
{
	private String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}