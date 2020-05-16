package by.academy.lesson11.Homework5;

import java.util.Random;

public class Task6 {
	public static void main(String[] args) {
		
		/*Попробовать добавить в массив int на 8 элементов 10 чисел. 
		 *Обернуть в try/catch, словить ArrayIndexOutOfBoundsException и вывести на экран сообщение:
		 *"Array is to small, expand the array".
		 */
		
		int[] array = new int[8];
		int numbersToAdd = 10;
		Random rnd = new Random();
		try {
			for (int i = 0; i < numbersToAdd; i++) {
				array[i] = rnd.nextInt();
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array is too small, please expand the array");
		}			
	}
}
