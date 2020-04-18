package by.academy.lesson4.Homework2.HW2_Task2;

public class HW2_Task2_Main {
	public static void main(String[] args) {
		HW2_Task2_Money money1 = new HW2_Task2_Money(15.50);
		
		System.out.println(money1);
		money1.addition(8.8);
		money1.subtraction(10.7);
		money1.parity(13.5);
		money1.parity(13.6);
		money1.parity(13.7);
		money1.parity(12.7);
		money1.multiplication(12);
		money1.division(0.373);
		money1.division(17.4);
		money1.division(5.17);
		money1.subtraction(1.3);
		money1.multiplication(13.244);
		/*не знаю, как это исправить,
		 *у меня при делении на ноль получается даже не infinity,
		 *просто что-то непонятное
		 */		
		money1.division(0);
		
	}
}
