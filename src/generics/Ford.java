//$Id$
package generics;

public class Ford implements Car {

	public int getEngineCC() {
		return 1000;
	}

	public String getCarMake() {
		return this.getClass().getName();
	}

}
