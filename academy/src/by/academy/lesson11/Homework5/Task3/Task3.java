package by.academy.lesson11.Homework5.Task3;

public class Task3 {
	public static void main(String[] args) {
		Integer [][] myArray = {{1, 2, 3, 4}, {5, 6, 7}, {8, 9}};			
		IteratorDouble <Integer> myIterator = new IteratorDouble<>(myArray);
		while (myIterator.hasNext()) {
			System.out.println(myIterator.next());
		}
	}
}
