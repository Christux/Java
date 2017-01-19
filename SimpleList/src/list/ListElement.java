package list;

/**
 * Simple List Element
 * 
 * @author Christux
 *
 * @param <T> generic object
 */
public class ListElement<T> {
	
	/**
	 * Generic object to store in the list element
	 */
	private T data;
	
	/**
	 * Reference to the next list element of the chain
	 */
	private ListElement<T> nextListElement;
	
	/**
	 * Constructor
	 * 
	 * @param data object to store
	 */
	public ListElement(T data) {
		this.data=data;
	}

	/**
	 * Gets stored data
	 * 
	 * @return stored data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Gets next list element of the chain
	 * 
	 * @return next list element of the chain
	 */
	public ListElement<T> getNextListElement() {
		return nextListElement;
	}

	/**
	 * Sets next list element of the chain
	 * 
	 * @param nextElementList next list element of the chain
	 */
	public void setNextListElement(ListElement<T> nextElementList) {
		this.nextListElement = nextElementList;
	}
}
