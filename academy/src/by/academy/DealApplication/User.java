package by.academy.DealApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import by.academy.lesson7.Homework3.Task5.BelarusPhoneValidator;
//import by.academy.lesson7.Homework3.Task5.EmailValidator;

public class User <P extends Product>{
	String name;
	ArrayList<P> products;
	double moneyQ;
	Calendar dateOfBirth;
	String phone;
	String email;
		
	public User() {
		super();
		setDateOfBirth();		
	}
	
	public User(String name, ArrayList<P> products, double moneyQ) {
		super();
		this.name = name;
		this.products = products;
		this.moneyQ = moneyQ;
		setDateOfBirth();
	}
	
	public ArrayList<P> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<P> products) {
		this.products = products;
	}

	public void setName (String name) {
		this.name = name;
	}
	
	public String getName () {
		return name;
	}
	
	public void setmoneyQ (double moneyQ) {
		this.moneyQ = moneyQ;
	}
	
	public double getMoneyQ () {
		return moneyQ;
	}	
	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth() {
		this.dateOfBirth = checkDate();
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		BelarusPhoneValidator belPhV1 = new BelarusPhoneValidator();
		if(belPhV1.validate(phone)) {
			this.phone = phone;
		}
		else {
			this.phone = "no info";
		}		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
////		EmailValidator emailV1 = new EmailValidator();
//		if(emailV1.validate(email)) {
//			this.email = email;
//		}
//		else {
//			this.email = "no info";
//		}
		this.email = email;
	}
	
	public static Calendar checkDate() {
		String myString = getMyString();
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		boolean check = true;

		if(myString.matches("^(?:(?:31(\\/)(?:0[13578]|1[02]))\\1|"
				+ "(?:(?:29|30)(\\/)(?:0[13-9]|1[0-2])\\2))"
				+ "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)02\\3"
				+ "(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|"
				+ "(?:(?:16|[2468][048]|[3579][26])00))))$|"
				+ "^(?:0[1-9]|1\\d|2[0-8])(\\/)(?:(?:0[1-9])|(?:1[0-2]))\\4"
				+ "(?:(?:1[6-9]|[2-9]\\d)\\d{2})$")) {
			check = true;
			
			SimpleDateFormat format1 = new SimpleDateFormat ("dd/MM/yyyy");
			try {
				date = format1.parse(myString);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}		
		}
		else if (myString.matches("^(?:(?:31(-)(?:0[13578]|1[02]))\\1|"
				+ "(?:(?:29|30)(-)(?:0[13-9]|1[0-2])\\2))"
				+ "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(-)02\\3"
				+ "(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|"
				+ "(?:(?:16|[2468][048]|[3579][26])00))))$|"
				+ "^(?:0[1-9]|1\\d|2[0-8])(-)(?:(?:0[1-9])|(?:1[0-2]))\\4"
				+ "(?:(?:1[6-9]|[2-9]\\d)\\d{2})$")) {
			check = true;
			
			SimpleDateFormat format2 = new SimpleDateFormat ("dd-MM-yyyy");
			try {
				date = format2.parse(myString);				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Doesn't match our patterns or invalid date");
			check = false;
		}
		
		if (check) {
			calendar = Calendar.getInstance();
			calendar.setTime(date);			
		}
		else {
			calendar = null;
		}
		return calendar;
	}
	private static String getMyString () {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter date of birth of the user in the format dd/MM/yyyy or dd-MM-yyyy: ");
		String myString = sc.nextLine();					
		return myString;
	}
}
