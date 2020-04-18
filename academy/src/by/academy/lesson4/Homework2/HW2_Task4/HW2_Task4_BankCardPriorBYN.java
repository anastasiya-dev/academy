package by.academy.lesson4.Homework2.HW2_Task4;

public class HW2_Task4_BankCardPriorBYN extends HW2_Task4_BankCardPrior {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String currency = "BYN";
	double amountOfPurchase;
	final private double threshold = 1_000;
	final private double cashBackPerc = 0.02;
	double cashBack = 0;
	
	public double receiveCashBack (double amountOfPurchase) {
		if (amountOfPurchase > threshold) {
			cashBack = amountOfPurchase * cashBackPerc;
		}
		return cashBack;
	}
	
	public String getCurrency() {
		return currency;
	}

}
