package by.academy.lesson4.Homework2.HW2_Task4;

public class HW2_Task4_BankCardPriorBYNOverdraft extends HW2_Task4_BankCardPriorBYN {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double overdraftLimit = 500;
	
	@Override
	public double transactions (double amount) {
		if (amount < 0) {
			authentification();
		}
		else {
			authorizedAccess = true;
		}
		if (this.authorizedAccess == true) {
			balance += amount;
			if (balance < -overdraftLimit) {
				System.out.println("Transaction cannot be processed. Amount exceeds balance available.");
				balance -= amount;
			}			
			else {
				if (amount > 0) {
					System.out.println("Receipt of " + amount);
				}
				else {
					System.out.println("Withdrawal of " + (- amount));
				}				
			}		
		}
		else {
			System.out.println("Denied. Please perform authentification");
		}
		return balance;		
		}
	@Override
	public double getBalance() {
		System.out.println("Your balance is " + balance);
		System.out.println("Overdraft facility remaining: " + (overdraftLimit + Math.min(balance, 0)));
		return balance;
	}
}
