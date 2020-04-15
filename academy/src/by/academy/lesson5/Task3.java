package by.academy.lesson5;

import java.util.Arrays;

public class Task3 {
	public static void main(String[] args) {
		
		/*не добавляла саму сборку массива.
		 *если указывать длину вспом массива как макс Инт, то потом выдает ошибку 
		 *Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit
		 *at by.academy.lesson5.Task3.main(Task3.java:13)
		 *Поэтому взяла для него макс значение из основного массива
		 */
		
		int analyzedArray [] = {1, 3, 5, 7, 9, 3, 1, 9};
		int supportArray [] = new int [Arrays.stream(analyzedArray).max().getAsInt()];
	
		for (int j = 0; j < analyzedArray.length; j++) {
			supportArray[analyzedArray[j] - 1]++;			
		}
				
		System.out.println("Maximum repeating values:");
		for (int k = 0; k < supportArray.length; k++) {
			if (supportArray[k] == Arrays.stream(supportArray).max().getAsInt()) {
				System.out.println(k + 1);
			}
		}
	}		
}
