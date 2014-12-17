//$Id$
package generics;

public class BMW<T> implements Car {

	public int getEngineCC() {
		return 2000;
	}

	public String getCarMake() {
		return this.getClass().getName();
	}
	
	public T getPrice( String t )
	{
		return T;
	}
}
