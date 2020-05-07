package by.academy.lesson10.Homework4.Task3;

public class CustomIterator<T> {

	private T[] arrayList;
	private int currentSize;
	private int currentIndex;
	
	public CustomIterator(T[] arrayList) {
		super();
		this.arrayList = arrayList;
		this.currentSize = arrayList.length;
	}
		
	public boolean hasNext() {
		return currentIndex < currentSize && arrayList [currentIndex] != null;
	}
	
	public T next() {
		return (T) arrayList[currentIndex++];
	}	
}
