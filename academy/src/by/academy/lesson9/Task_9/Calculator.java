package by.academy.lesson9.Task_9;

public class Calculator {
		
	Calculator(){
		super();
	}
	
	public static <T extends Number> double sum(T a, T b) {
		double sum = a.doubleValue() + b.doubleValue();
		return sum;
	}
	
	public static <T extends Number> double multiplication(T a, T b) {
		double multiplication = a.doubleValue() * b.doubleValue();
		return multiplication;
	}
	
	public static <T extends Number> double division(T a, T b) {
		double division = a.doubleValue() / b.doubleValue();
		return division;
	}
	
	public static <T extends Number> double subtraction(T a, T b) {
		double subtraction = a.doubleValue() - b.doubleValue();
		return subtraction;
	}
}
