//$Id$
package classanalysis;

public class GenericClass<T,K,V> {

	V v = null;
	
	public GenericClass( V v )
	{
		this.v = v;
	}
	
	public V getInfo(  )
	{
		return v; 
	}
	
}
