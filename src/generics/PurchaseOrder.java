//$Id$
package generics;

public class PurchaseOrder {

	public Class<? extends Car> getCarPurchaseEngineCC()
	{
		return new Ford();		
	}
	
}
