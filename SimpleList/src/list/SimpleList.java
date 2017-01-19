package list;

public class SimpleList<T> {
	
	private ListElement<T> primaryListElement = null;

	public SimpleList() {
		
	}

	public void add(T t) {
		
		ListElement<T> elem = new ListElement<T>(t);
		
		if(primaryListElement==null) {
			primaryListElement=elem;
		}
		else {
			getLastListElement().setNextListElement(elem);
		}
	}
	
	private ListElement<T> getLastListElement() {
		
		ListElement<T> elem = primaryListElement;
		
		while(elem.getNextListElement()!=null) {
			elem=elem.getNextListElement();
		}
		return elem;
	}
	
	private ListElement<T> getListElement(int k) {
		
		ListElement<T> elem = primaryListElement;
		
		for(int i=0; i<k; i++) {
			elem=elem.getNextListElement();
		}
		return elem;
	}
	
	public void delete(int k) {
		
		ListElement<T> elem;
		
		if(k==0) {
			primaryListElement=primaryListElement.getNextListElement();
		}
		else {
			elem = getListElement(k-1);
			elem.setNextListElement(elem.getNextListElement().getNextListElement());
		}
	}
	
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
	
	public int count() {
		int sum=0;
		
		ListElement<T> elem = primaryListElement;
		
		while(elem!=null) {
			sum++;
			elem=elem.getNextListElement();
		}
		return sum;
	}
	
	public T get(int k) {
		return getListElement(k).getData();
	}
	
	public T getLast() {
		return getLastListElement().getData();
	}

}
