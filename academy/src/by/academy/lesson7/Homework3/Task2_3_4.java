package by.academy.lesson7.Homework3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Task2_3_4 {
	public static void main(String[] args) {
		String myString = getMyString();	
		Date date = new Date();
		Calendar calendar;
		boolean check = true;

		if(myString.matches("^(?:(?:31(\\/)(?:0[13578]|1[02]))\\1|"
				+ "(?:(?:29|30)(\\/)(?:0[13-9]|1[0-2])\\2))"
				+ "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)02\\3"
				+ "(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|"
				+ "(?:(?:16|[2468][048]|[3579][26])00))))$|"
				+ "^(?:0[1-9]|1\\d|2[0-8])(\\/)(?:(?:0[1-9])|(?:1[0-2]))\\4"
				+ "(?:(?:1[6-9]|[2-9]\\d)\\d{2})$")) {
			System.out.println("1st pattern");
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
			System.out.println("2nd pattern");
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
			System.out.println("----------------------------------");
			System.out.println("Initial date info:");
			printer(calendar);
			
			calendar.add(Calendar.MONTH, 3);
			calendar.add(Calendar.DAY_OF_MONTH, 2);
			calendar.add(Calendar.HOUR, 4);
			System.out.println("----------------------------------");
			System.out.println("Modified date info:");
			printer(calendar);
		}
	}
	
	public static String getMyString () {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter your string: ");
		String myString = sc.nextLine();					
		sc.close();
		return myString;
	}
	public static void printer (Calendar calendar) {
		System.out.println("Day: " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("Month: " + (calendar.get(Calendar.MONTH) + 1));
		System.out.println("Year: " + calendar.get(Calendar.YEAR));
		System.out.println("Hours: " + calendar.get(Calendar.HOUR));
	}
}
