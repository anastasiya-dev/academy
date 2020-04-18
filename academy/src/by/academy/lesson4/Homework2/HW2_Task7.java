package by.academy.lesson4.Homework2;

import java.util.Scanner;

public class HW2_Task7 {
	public static void main (String[] args) {
		
		//get string from console
		Scanner sc = new Scanner (System.in);		
		System.out.println("Enter your string: ");
		String myString = sc.nextLine();										
		sc.close();
				
		/*1st step: trim and length restriction
		 *2nd step: remove multiple spaces from string
		 *and single spaces if followed by punctuation chars
		 */
		
		myString = (myString.trim()).substring(0, Math.min(myString.length(), 1_000));
						
		System.out.println(((myString.replaceAll("\\s+", " "))).replaceAll("\\s+(?=\\p{Punct})", ""));
	}
}
