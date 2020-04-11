package by.academy.lesson2;

import java.util.Scanner;

public class HW1_Task1 {
	
	public static void main(String[] args) {
		
		//get input from console
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter the amount of purchase:");
		double initialAmount = sc.nextDouble();
		System.out.println("Enter the age of the customer:");
		int age = sc.nextInt();

		sc.close();
		
		//calculate the discount
		double discount = 0;
		double finalAmount;
				
		if (initialAmount < 100) {
			discount = 0.05;
		}
		else if (initialAmount >= 100 && initialAmount < 200) {
			discount = 0.07;
		}
		else if (initialAmount >= 200 && initialAmount < 300) {
			if (age > 18) {
				discount = 0.12 + 0.04;
			}
			else {
				discount = 0.12 - 0.03;
			}
		}
		else if (initialAmount >= 300 && initialAmount < 400) {
			discount = 0.15;
		}
		else if (initialAmount >= 400) {
			discount = 0.2;
		}
		
		//calculate the final amount, round and print it
		finalAmount = initialAmount * (1 - discount);
		finalAmount = (double) ((int) (finalAmount * 100))/ 100;
		System.out.printf("The final amount with the discount equals to %.2f", finalAmount);
						
	}

}
