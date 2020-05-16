package by.academy.lesson11.Homework5.Task3;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class IteratorDouble<T> implements Iterator {

	private T[][] array;
	public int row;
	public int column;

	public IteratorDouble(T[][] array) {
		super();
		this.array = array;
	}

	@Override
	public boolean hasNext() {
		if (row + 1 == array.length) {
			return column < array[row].length;
		}
		return row < array.length;
	}

	@Override
	public Object next() {
		if (column == array[row].length) {
			column = 0;
			row++;
		}		
		return array[row][column++];	
	}
}
