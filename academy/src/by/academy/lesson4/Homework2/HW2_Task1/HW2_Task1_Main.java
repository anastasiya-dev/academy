package by.academy.lesson4.Homework2.HW2_Task1;

public class HW2_Task1_Main {
	public static void main(String[] args) {
		
		HW2_Task1_ATM ATM1 = new HW2_Task1_ATM(10, 10, 10);
				
		System.out.println(ATM1);
		ATM1.disbursement(110);
		System.out.println(ATM1);
		ATM1.upLoad20(20);
		System.out.println(ATM1);
		ATM1.disbursement(1500);
		System.out.println(ATM1);
		ATM1.disbursement(10_000);
		System.out.println(ATM1);
		
		HW2_Task1_ATM ATM2 = new HW2_Task1_ATM(10, 0, 10);
		
		System.out.println(ATM2);
		ATM2.disbursement(110);
		System.out.println(ATM2);
		ATM2.upLoad50(10);
		System.out.println(ATM2);
		ATM2.disbursement(1500);
		System.out.println(ATM2);
					
	}
}
