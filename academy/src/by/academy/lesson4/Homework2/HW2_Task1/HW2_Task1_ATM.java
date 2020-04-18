package by.academy.lesson4.Homework2.HW2_Task1;

public class HW2_Task1_ATM {
	
	int nom20 = 0;
	int nom50 = 0;
	int nom100 = 0;
	boolean check;

	public HW2_Task1_ATM (int nom20, int nom50, int nom100) {
		System.out.println("---------------------------");
		upLoad20 (nom20);
		upLoad50 (nom50);
		upLoad100 (nom100);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Money in ATM: 20RUB = ");
		builder.append(nom20);
		builder.append(", 50RUB = ");
		builder.append(nom50);
		builder.append(", 100RUB = ");
		builder.append(nom100);
		return builder.toString();
	}

	//ATM upload with banknotes of different value
	
	public void upLoad20 (int nom20) {
		this.nom20 += nom20;
	}

	public void upLoad50 (int nom50) {
		this.nom50 += nom50;
	}
	
	public void upLoad100 (int nom100) {
		this.nom100 += nom100;
	}
	
	//ATM disbursement process
	
	public boolean disbursement (int amount) {
		
		System.out.println("***");
		System.out.println("Result of processing the request "
				+ "for the disbursement of " + amount + "RUB:");
		int cashAvailable = nom20 * 20 + nom50 * 50 + nom100 * 100;
		 
		int nom20Result = 0;
		int nom50Result = 0;
		int nom100Result = 0;
		
		/*Initial allocation is based on the principle that necessary amount is composed
		*with least possible number of banknotes in total.
		*I.d. algorithm starts with maximum possible number of banknotes with highest value
		*not exceeding the amount and proceeds step by step
		*to the banknotes of lower value.
		*/
		
		if (amount <= cashAvailable) {
			while (nom100 > 0 && amount >= 100) {
				nom100Result ++;
				nom100 --;
				amount -= 100;
			}
			while (nom50 > 0 && amount >= 50) {
				nom50Result ++;
				nom50 --;
				amount -= 50;
			}
			while (nom20 > 0 && amount >= 20) {
				nom20Result ++;
				nom20 --;
				amount -= 20;
			}
			
			/*1st re-check
			*If optimal combination of banknotes is not available yet:
			*exchange 50RUB banknote with 20RUB ones
			*/
			
			if (amount != 0) {
				if (nom50Result > 0) {
					nom50Result --;
					nom50 ++;
					amount += 50;
					
					while (nom20 > 0 && amount >= 20) {
						nom20Result ++;
						nom20 --;
						amount -= 20;
					}
				}
			}
			
			/*2nd re-check
			*If optimal combination of banknotes is not available yet:
			*exchange 100RUB banknote with 50RUB one and then add 20RUB ones
			*/
			
			if (amount != 0) {
				if (nom100Result > 0 && nom50 > 0) {
					
					nom100Result --;
					nom100 ++;
					amount += 100;
					
					nom50Result ++;
					nom50 --;
					amount -= 50;
					
					while (nom20 > 0 && amount >= 20) {
						nom20Result ++;
						nom20 --;
						amount -= 20;
					}
				}
			}
			
			if (amount == 0) {
				
				System.out.println("100RUB: " + nom100Result);
				System.out.println("50RUB: " + nom50Result);
				System.out.println("20RUB: " + nom20Result);
				System.out.println("***");
				check = true;
			}
			else {
				System.out.println("No available banknotes to return the amount");
				check = false;
				//Quasi-return of banknotes to ATM for unsuccessful transaction
				nom20 += nom20Result;
				nom50 += nom50Result;
				nom100 += nom100Result;
			}
		}
		else {
			System.out.println("Amount exceeds cash available in ATM");
			check = false;
		}
		System.out.println("***");
		return check;
	}
}
