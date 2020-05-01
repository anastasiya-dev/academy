package by.academy.lesson9.Task_8;

import java.util.Random;

public class Main_Task_8 {
	public static void main(String[] args) {
		
		Integer array[] = new Integer [10]; 
		Random rnd = new Random();
		
		StringBuilder arrayString = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.valueOf(rnd.nextInt(100));
			arrayString.append(array[i] + " ");
		}
		System.out.println("Start array");
		System.out.println(arrayString);		
			
		MinMax <Integer>a = new MinMax <Integer>(array);
		System.out.println("Max " + a.max());
		System.out.println("Min " + a.min());
	}
}
