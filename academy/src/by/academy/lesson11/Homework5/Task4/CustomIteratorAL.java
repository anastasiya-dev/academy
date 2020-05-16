package by.academy.lesson11.Homework5.Task4;

import java.util.ArrayList;

public class CustomIteratorAL<T> {
	private ArrayList<T> arrayList;
	private int currentSize;
	private int currentIndex;
		
	protected int getCurrentIndex() {
		return currentIndex;
	}

	protected void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CustomIteratorAL(ArrayList arrayList) {
		super();
		this.arrayList = arrayList;
		this.currentSize = arrayList.size();
	}
		
	public boolean hasNext() {
		return currentIndex < currentSize && arrayList.get(currentIndex) != null;
	}
	
	public T next() {
		return (T) arrayList.get(currentIndex++);
	}	
}
