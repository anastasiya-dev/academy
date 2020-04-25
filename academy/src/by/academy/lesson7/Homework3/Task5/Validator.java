package by.academy.lesson7.Homework3.Task5;

public interface Validator {
	boolean validate (String phoneNumber);
	default void unValidated() {
		System.out.println("The info has not been validated");
	}
}
