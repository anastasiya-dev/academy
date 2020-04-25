package by.academy.lesson7.Homework3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1_2 {
	public static void main(String[] args) {
		String myString = getMyString();
		Pattern p = Pattern.compile("\\b[abcABC]+");
		Matcher matcher = p.matcher(myString);
		StringBuilder answer = new StringBuilder();
		while (matcher.find()) {
			answer.append(myString.charAt(matcher.end() - 1));
			answer.append(" ");
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
