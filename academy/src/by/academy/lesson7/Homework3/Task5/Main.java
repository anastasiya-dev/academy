package by.academy.lesson7.Homework3.Task5;

public class Main {
	
	public static void main(String[] args) {
		AmericanPhoneValidator amPhV = new AmericanPhoneValidator();
		BelarusPhoneValidator belPhV = new BelarusPhoneValidator();
		EmailValidator emailV = new EmailValidator();
		
		System.out.println(amPhV.validate("+11234567890"));
		System.out.println(belPhV.validate("+37512848484"));
		System.out.println(belPhV.validate("+375292658195"));
		System.out.println(emailV.validate("anastasiya.kalach@gmail.com"));
	}
}
