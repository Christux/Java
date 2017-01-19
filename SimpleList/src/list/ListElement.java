package list;

public class ListElement<T> {
	
	private T data;
	private ListElement<T> nextListElement;
	
	public ListElement(T data) {
		this.data=data;
	}

	public T getData() {
		return data;
	}

	public ListElement<T> getNextListElement() {
		return nextListElement;
	}

	public void setNextListElement(ListElement<T> nextElementList) {
		this.nextListElement = nextElementList;
	}
}
