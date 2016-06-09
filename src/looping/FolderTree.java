//$Id$
package looping;

import java.util.ArrayList;

public class FolderTree<T> {

	private T parent = null;
	private T current = null;
	private ArrayList<T> children = null;

	public T getParent() {
		return parent;
	}
	public void setParent(T parent) {
		this.parent = parent;
	}
	public ArrayList<T> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<T> children) {
		this.children = children;
	}
	public T getCurrent() {
		return current;
	}
	public void setCurrent(T current) {
		this.current = current;
	}	
}
