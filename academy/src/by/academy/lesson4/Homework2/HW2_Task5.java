package by.academy.lesson4.Homework2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW2_Task5 {
	public static void main (String[] args) {
		
		String myString = getMyString();
		Pattern p = Pattern.compile("[a-zA-zа-яА-я]+[(\\s=\\p{Punct})]");
		Matcher matcher = p.matcher(myString);
		StringBuilder answer = new StringBuilder();
		while (matcher.find()) {
			answer.append(myString.charAt(matcher.end() - 2));
		}				
	}
	
	public static String getMyString () {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter your string: ");
		String myString = sc.nextLine();
		myString = myString.trim();							
		sc.close();
		return myString;
	}
}
