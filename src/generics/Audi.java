//$Id$
package generics;

public class Audi implements Car {

	public int getEngineCC() {
		return 3000;
	}

	public String getCarMake() {
		return this.getClass().getName();
	}

	
}
