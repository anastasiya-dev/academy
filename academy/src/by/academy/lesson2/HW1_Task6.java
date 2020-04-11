package by.academy.lesson2;

import java.util.Scanner;

public class HW1_Task6 {
	public static void main(String[] args) {
		
		//get input from console
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter first string:");
		String firstString = sc.nextLine();
		System.out.println("Enter second string:");
		String secondString = sc.nextLine();
		sc.close();
	
		//assign variables;
		//j1 and j2 - chars with which the loop will compare the char under analysis 
		
		int l1 = firstString.length();
		int l2 = secondString.length();
		int counter1 = 0;
		int counter2 = 0;
		int j1 = 0;
		int j2 = 0;
		boolean check = true;
			
		//convert to arrays
		char[] firstStringArray = new char[l1]; 
		char[] secondStringArray = new char[l2]; 
					
		for (int i1 = 0; i1 < l1; i1++) {
			firstStringArray [i1] = firstString.charAt(i1);
			}
	
		for (int i2 = 0; i2 < l2; i2++) {
			secondStringArray [i2] = secondString.charAt(i2);
		}
		
		//for strings with equal length parameters
		//count number of occurrences of each char and compare
	 
		if (l1 == l2) {
			for (int i1 = 0; i1 < l1; i1++) {
				while (j1 < l1 && j2 < l1) {
					if (firstStringArray [i1] == firstStringArray [j1]) {
						counter1++;
					}
					j1++;
					if (firstStringArray [i1] == secondStringArray [j2]) {
						counter2++;
					}
					j2++;
				}
				if (counter1 != counter2) {
					System.out.println("Different strings");
					check = false;
					break;
				}
				else {
					counter1 = 0;
					counter2 = 0;
					j1 = 0;
					j2 = 0;
				}
			}
			if (check == true) {
			System.out.println("Equal strings");
			}
		}
		else {
			System.out.println("Different strings");
		}
	}
}
	

 