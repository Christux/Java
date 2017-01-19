package list;

/**
 * Simple List class
 * 
 * @author Christux
 *
 * @param <T> Generic object
 */
public class SimpleList<T> {
	
	/**
	 * Root of list element chain
	 */
	private ListElement<T> primaryListElement = null;

	/**
	 * Constructor
	 */
	public SimpleList() {}

	/**
	 * Add elment at the end of the list
	 * 
	 * @param t object
	 */
	public void add(T t) {
		
		ListElement<T> elem = new ListElement<T>(t);
		
		if(primaryListElement==null) {
			primaryListElement=elem;
		}
		else {
			getLastListElement().setNextListElement(elem);
		}
	}
	
	/**
	 * Gets last element of the list
	 * 
	 * @return last element of the list
	 */
	private ListElement<T> getLastListElement() {
		
		ListElement<T> elem = primaryListElement;
		
		while(elem.getNextListElement()!=null) {
			elem=elem.getNextListElement();
		}
		return elem;
	}
	
	/**
	 * Gets kth element of the list
	 * 
	 * @param k index of element
	 * @return kth element of the list
	 */
	private ListElement<T> getListElement(int k) {
		
		ListElement<T> elem = primaryListElement;
		
		for(int i=0; i<k; i++) {
			elem=elem.getNextListElement();
		}
		return elem;
	}
	
	/**
	 * Deletes kth element
	 * 
	 * @param k index of element
	 */
	public void delete(int k) {
		
		ListElement<T> parent;
		
		if(k==0) {
			primaryListElement=primaryListElement.getNextListElement();
		}
		else {
			parent = getListElement(k-1);
			parent.setNextListElement(parent.getNextListElement().getNextListElement());
		}
	}
	
	/**
	 * Find index of element
	 * 
	 * @param t object to find
	 * @return index of element
	 */
	public int find(T t) {
		
		int idx=0;
		ListElement<T> elem = primaryListElement;
		
		if(elem==null) return -1;
		
		while(elem.getNextListElement()!=null) {
			
			if(t.equals(elem.getData())) return idx;
			
			elem=elem.getNextListElement();
			idx++;
		}
		return -1;
	}
	
	/**
	 * Delete element
	 * 
	 * @param t object to delete
	 */
	public void delete(T t) {
		
		ListElement<T> elem = primaryListElement;
		
		if(elem==null) return;
		
		if(t.equals(primaryListElement.getData())) {
			primaryListElement=primaryListElement.getNextListElement();
			return;
		}
		
		while(elem.getNextListElement()!=null) {
			
			if(t.equals(elem.getNextListElement().getData())) {
				
				elem.setNextListElement(elem.getNextListElement().getNextListElement());
				return;
			}
			
			elem=elem.getNextListElement();
		}
	}
	
	/**
	 * Counts number of elements of the list 
	 * 
	 * @return number of elements
	 */
	public int count() {
		int sum=0;
		
		ListElement<T> elem = primaryListElement;
		
		while(elem!=null) {
			sum++;
			elem=elem.getNextListElement();
		}
		return sum;
	}
	
	/**
	 * Gets kth object from the list
	 * 
	 * @param k index of element
	 * @return object from the list
	 */
	public T get(int k) {
		return getListElement(k).getData();
	}
	
	/**
	 * Gets last object from the list
	 * 
	 * @return last object
	 */
	public T getLast() {
		return getLastListElement().getData();
	}

	/**
	 * Inserts element at kth position
	 * 
	 * @param k index of element
	 * @param t object to insert
	 */
	public void insert(int k, T t) {
		
		ListElement<T> elem = new ListElement<T>(t);
		
		ListElement<T> parent;
		ListElement<T> child;
		
		if(k==0) {
			parent = primaryListElement;
		}
		else {
			parent = getListElement(k-1);
		}
		
		child = parent.getNextListElement();
		
		parent.setNextListElement(elem);
		elem.setNextListElement(child);
	}

}
