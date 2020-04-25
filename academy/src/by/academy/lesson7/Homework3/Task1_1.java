package by.academy.lesson7.Homework3;

import java.util.Scanner;

public class Task1_1 {
	public static void main(String[] args) {
		String myString = getMyString();
		StringBuilder answer = new StringBuilder();
		char [] letters = {'a', 'b', 'c', 'A', 'B', 'C'};

		for (String word : myString.split(" ")) {
			for (char i : letters) {
				if(word.charAt(0) == i){
					answer.append(word.charAt(0));
					answer.append(" ");
				}
			}
		}
		System.out.println(answer);
	}
			
	public static String getMyString () {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter your string: ");
		String myString = sc.nextLine();						
		sc.close();
		return myString;
	}
}

