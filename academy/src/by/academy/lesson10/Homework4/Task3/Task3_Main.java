package by.academy.lesson10.Homework4.Task3;

public class Task3_Main {
	public static void main(String[] args) {
		Integer [] myArray = {1, 2, 3, 7, 5, 4, 2};
		CustomIterator <Integer> myIterator = new CustomIterator<>(myArray);
		while (myIterator.hasNext()) {
			System.out.println(myIterator.next());
		}		
	}
}
