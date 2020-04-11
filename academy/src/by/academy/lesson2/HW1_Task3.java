package by.academy.lesson2;

import java.util.Scanner;

public class HW1_Task3 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner (System.in);
			System.out.println("Enter an integer in the range [1;10]: ");
			int valueStart = sc.nextInt();
				
			if (valueStart >= 1 && valueStart <= 10) {
				for (int i = 0; i < 10; i++) {
					int valueMultiple = valueStart * (i + 1);
					System.out.println(valueMultiple);
				}
			}
			else {
				System.out.println("Value outside the range. Please check and re-run");
			}
				
			sc.close();	
		}
		catch (RuntimeException e) {
			System.out.println("Incorrect datatype. Please check and re-run");
		}
		
	}
}


