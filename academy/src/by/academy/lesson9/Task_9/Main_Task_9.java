package by.academy.lesson9.Task_9;

public class Main_Task_9 {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		Integer a = Integer.valueOf(18);
		Double b = Double.valueOf(2.5);
		System.out.println("Sum of " + a + " and " + b + ": " + calculator.sum(a, b));
		System.out.println("Multiplication of " + a + " and " + b + ": " + calculator.multiplication(a, b));
		System.out.println("Subtraction of " + b + " from " + a + ": " + calculator.subtraction(a, b));
		System.out.println("Division of " + a + " by " + b + ": " + calculator.division(a, b));
	}
}
