package by.academy.lesson9.Task_6;

import java.io.Serializable;

public class Main_Task_6 {
	public static <T, V, K> void main(String[] args) {
		
		Cat a = new Cat();	
				
		GenericClass<Comparable<String>, Animal, Serializable, Integer> myObject = 
				new GenericClass<Comparable<String>, Animal, Serializable, Integer>("1", a, 5);
		myObject.printClassName();
	}
}
