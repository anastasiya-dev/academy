package by.academy.lesson11.Homework5.Task4;

import java.util.ArrayList;
import java.util.Random;

public class Task4 {
	public static void main(String[] args) {
		
		/*
		 * Создать список оценок учеников с помощью ArryList, заполнить случайными
		 * оценками. Найти самую высокую оценку с использованием итератора.
		 */

		
		int pupils = 20;
		int maxMark = 10;
		int counter = 0;
		Random rnd = new Random();
		
		ArrayList<Integer>marks = new ArrayList<>();
		while (counter < pupils) {
			marks.add(rnd.nextInt(maxMark + 1));
			counter++;
		}			
		
		CustomIteratorAL <Integer> myIterator = new CustomIteratorAL<>(marks);
		System.out.println("All the marks:");
		int maxMarkLocal = 0;
		while (myIterator.hasNext()) {			
			Integer temp;
			System.out.println(temp = myIterator.next());
			if(temp > maxMarkLocal) {
				maxMarkLocal = temp;
			}
		}		
		System.out.println("Max mark is " + maxMarkLocal);
		
		System.out.println("Number of pupils with max mark:");
		myIterator.setCurrentIndex(0);
		int bestPupils = 0;
		while (myIterator.hasNext()) {			
			Integer temp = myIterator.next();
			if(temp.equals(maxMarkLocal)) {
				bestPupils++;				
			}			
		}
		System.out.println(bestPupils);
	}
}
