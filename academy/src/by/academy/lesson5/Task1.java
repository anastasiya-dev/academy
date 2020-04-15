package by.academy.lesson5;

import java.util.Random;

public class Task1 {
		
	public static void main(String[] args) {
		
		int arraySize = 10;
		int maxRange = 100;
		int a[] = new int [arraySize];
		int max = 0;
		int min = maxRange;
		int sum = 0;
		
		Random rnd = new Random ();
		for (int i = 0; i< a.length; i++) {
			a[i] = rnd.nextInt(maxRange);
			System.out.println(a[i]);
		}
				    			    		    
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[j] > max) {
					max = a[j];
				}	       
				if (a[j] < min) {
					min = a[j];
				}
			}
		}
			    
		for (int k = 0; k < a.length; k++) {
			if (a[k] != max && a[k] != min) {
				sum += a[k];
			}
		}
		
		System.out.println("Max element: " + max);
		System.out.println("Min element: " + min);
		System.out.println("Sum: " + sum);
	}
}
			    


