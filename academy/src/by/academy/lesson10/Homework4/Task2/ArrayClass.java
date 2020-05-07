package by.academy.lesson10.Homework4.Task2;

import java.util.Arrays;

public class ArrayClass <T> {
	private T[] array;
	int size;
	
	public ArrayClass() {
		super();
		@SuppressWarnings("unchecked")
		T[] array = (T[])new Object[16];
		size = 16;
		this.array = array;
	}
	
	public ArrayClass(int size) {
		super();
		@SuppressWarnings("unchecked")
		T[] array = (T[])new Object[size];		
		this.array = array;
		this.size = size;
	}
	
	public void add(T obj) {
		System.out.println("Adding element " + obj);
		int nullIndex = -1;
		for (int i = 0; i < size; i++) {				
			if(array[i] == null) {
				nullIndex = i;
				break;
			}		
		}
		
		if(nullIndex != -1) {
			array[nullIndex] = obj;
		}
		else {
			T[] newArray = Arrays.copyOf(array, size + 1);
			newArray[size] = obj;
			this.array = newArray;
			size++;
		}
	}
	
	public T get(int index) {
		return array[index];
	}
	
	public T getLast() {
		return array[size - 1];
	}
	
	public T getFirst() {
		return array[0];
	}
	
	public int getSize() {
		return size;
	}
	
	public int lastFilled() {
		int lastFilled = -1;
		for (int i = size - 1; i >= 0; i--) {				
			if(array[i] != null) {
				lastFilled = i;
				break;
			}			
		}
		return lastFilled;
	}
	
	public void remove(int index) {
		System.out.println("Removing element number " + index);
		try {
			array[index] = null;
		}
		catch (RuntimeException e) {
			System.out.println("Sorry, can't proceed. The array size is " + this.size);			
		}
	}
	
	public void remove(T obj) {
		System.out.println("Removing element " + obj);
		boolean check = false;		
		for (int i = 0; i < size; i++) {				
			if(array[i] == obj) {
				array[i] = null;
				check = true;
				break;				
			}			
		}
		if(!check) {
			System.out.println("Sorry, there's no such element in the array");
		}
	}
	
	public void print() {
		System.out.println("***");
		System.out.println(Arrays.toString(array));
		System.out.println("***");
	}
}
