package by.academy.lesson11.Homework5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task2 {
	public static void main(String[] args) {
		
		/*Можно писать все в main. Не нужно создавать новых классов.
		 *Напишите метод, который добавляет 1 000 000 элементов в ArrayList и LinkedList. 
		 *Напишите еще один метод, который выбирает из заполненного списка элемент наугад 100 000 раз. 
		 *Замерьте время, которое потрачено на это.
		 *Сравните результаты и предположите, почему они именно такие.
		 */

		
		final int units = 1_000_000;
		final int selects = 100_000;
		Random rnd = new Random();
		
		//with array list
		long startTime1 = System.nanoTime();
		List<Integer> arrayL = new ArrayList<>();
		int counterAdd1 = 0;
		int counterSelect1 = 0;		
		while(counterAdd1 < units) {
			arrayL.add(rnd.nextInt());
			counterAdd1++;
		}
		while(counterSelect1 < selects) {
			arrayL.get(rnd.nextInt(units));
			counterSelect1++;
		}
		System.out.println("Array List time in nanoseconds: " + (System.nanoTime() - startTime1));
		
		//with linked list
		long startTime2 = System.nanoTime();
		LinkedList<Integer> linkedL = new LinkedList<>();
		int counterAdd2 = 0;
		int counterSelect2 = 0;
		
		while(counterAdd2 < units) {
			linkedL.add(rnd.nextInt());
			counterAdd2++;
		}
		while(counterSelect2 < selects) {
			linkedL.get(rnd.nextInt(units));
			counterSelect2++;
		}
		System.out.println("Linked List time in nanoseconds: " + (System.nanoTime() - startTime2));		
	}	
}
