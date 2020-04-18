package by.academy.lesson4.Homework2.HW2_Task4;

import java.time.format.DateTimeFormatter;

public class HW2_Task4_Main {
	public static void main (String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		HW2_Task4_BankCardPrior bankCard1 = new HW2_Task4_BankCardPrior();
		bankCard1.setStatus("Active");
		bankCard1.setBankAccount(123456789);
		bankCard1.setCardHolderName("Ivan_Ivanov");
		bankCard1.setExpireDate(2020, 12, 02);
		bankCard1.setOpenDate(2018, 12, 03);
		bankCard1.setPinCode(3816);
		bankCard1.transactions(100);
		bankCard1.authentification();
		bankCard1.transactions(100);
		bankCard1.getBalance();
		bankCard1.transactions(-50);
		bankCard1.getBalance();
		bankCard1.transactions(-70);
		bankCard1.getBalance();
		bankCard1.transactions(30, 300);
		bankCard1.getBalance();
		System.out.println(bankCard1.getStatus());
		System.out.println(bankCard1.getBankAccount());
		System.out.println(bankCard1.getCardHolderName());		
		System.out.println(String.valueOf(dtf.format(bankCard1.getOpenDate())));
		System.out.println(String.valueOf(dtf.format(bankCard1.getExpireDate())));
						
		HW2_Task4_BankCardPriorBYN bankCard2 = new HW2_Task4_BankCardPriorBYN();
		System.out.println(bankCard2.getCurrency());
		System.out.println(bankCard2.receiveCashBack(1800));
		
		HW2_Task4_BankCardPriorBYNOverdraft bankCard3 = new HW2_Task4_BankCardPriorBYNOverdraft();
		System.out.println(bankCard3.getCurrency());
		bankCard3.getBalance();
		bankCard3.setStatus("Active");
		bankCard3.setPinCode(9876);
		bankCard3.transactions(100);
		bankCard3.authentification();
		bankCard3.transactions(100);
		bankCard3.getBalance();
		bankCard3.transactions(-50);
		bankCard3.getBalance();
		bankCard3.transactions(-70);
		bankCard3.getBalance();
		bankCard3.transactions(-500);
		bankCard3.getBalance();
		bankCard3.transactions(-100);
		bankCard3.getBalance();	
	}	
}
