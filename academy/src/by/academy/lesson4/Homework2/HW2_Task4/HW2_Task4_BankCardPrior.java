package by.academy.lesson4.Homework2.HW2_Task4;

import java.time.LocalDateTime;
import java.util.Scanner;

public class HW2_Task4_BankCardPrior implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected double balance;
	protected long bankAccount;
	protected String cardHolderName;
	protected int pinCode;
	boolean authorizedAccess;
	LocalDateTime openDate;
	LocalDateTime expireDate;
	String status;
	
	public HW2_Task4_BankCardPrior() {
		super();
		System.out.println("--------------------------");
	}
	
	protected void setStatus (String status) {
		this.status = status;	
	}

	public String getStatus() {
		return status;
	}
	
	protected void setBankAccount (long bankAccount) {
		this.bankAccount = bankAccount;	
	}

	protected long getBankAccount() {
		return bankAccount;
	}
	
	public double getBalance() {
		System.out.println("Your balance is " + balance);
		return balance;
	}
	
	protected void setCardHolderName (String cardHolderName) {
		this.cardHolderName = cardHolderName;	
	}

	protected String getCardHolderName() {
		return cardHolderName;
	}
	
	protected void setPinCode (int pinCode) {
		this.pinCode = pinCode;	
	}

	final boolean authentification () {
		Scanner sc = new Scanner (System.in);
		if (status == "Active") {
			int counter = 3;
			int userPinCode = 0000;
						
			while (counter > 0) {
				System.out.println("Please enter PIN");
				userPinCode = sc.nextInt();
				if (this.pinCode == userPinCode) {
					System.out.println("Pin OK");
					this.authorizedAccess = true;
					break;
				}
				else {
					System.out.println("Incorrect pin code");
					counter--;
					System.out.println(counter + " attempts left");
				}				
			}
			if (this.pinCode != userPinCode) {
				status = "Blocked";
				System.out.println("The card is blocked");
			}
//			sc.close();
		}
		else {
			System.out.println("Sorry, the card is blocked");
		}
		return authorizedAccess;
	}
			
	protected void setOpenDate (int yearO, int monthO, int dayO) {
		this.openDate = LocalDateTime.of(yearO, monthO, dayO, 0, 0, 0, 0);		
	}

	public LocalDateTime getOpenDate() {
		return openDate;
	}
	
	protected void setExpireDate (int yearE, int monthE, int dayE) {
		this.expireDate = LocalDateTime.of(yearE, monthE, dayE, 0, 0, 0, 0);
	}

	public LocalDateTime getExpireDate() {
		return expireDate;
	}
	
	public double transactions (double amount) {
		if (amount < 0) {
			authentification();
		}
		else {
			authorizedAccess = true;
		}
		if (this.authorizedAccess == true) {
			balance += amount;
				if (balance < 0) {
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
	public double transactions (double amount, double cashInATM) {
		authentification();
		if (this.authorizedAccess == true) {
			if (cashInATM >= amount && balance >= amount) {
				balance -= amount;
				System.out.println("Transaction succeeded. Take your cash: " + amount);
			}
			else {
				System.out.println("Transaction denied");
			}			
		}
		else {
			System.out.println("Denied. Please perform authentification");
		}
		return balance;	
	}
}
