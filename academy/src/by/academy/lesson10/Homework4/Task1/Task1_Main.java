package by.academy.lesson10.Homework4.Task1;

public class Task1_Main {
	public static void main(String[] args) {
		Date date1 = new Date(2019, 12, 4);
		Date date2 = new Date(2020, 5, 4);
		Date date3 = new Date(2100, 12, 4);
		Date date4 = new Date(2000, 12, 4);
		System.out.println(date4.toString());
		
		System.out.println(date1.timePeriod(date2));
		
		Date date5 = new Date(2020, 5, 3);
		System.out.println(date5.dayOfWeek());
		System.out.println(date1.dayOfWeek());
		
		Date date6 = new Date("20/12/2019");
		Date date7 = new Date("35/12/2019");
		Date date8 = new Date("12-15-2019");
		Date date9 = new Date("iueriysf");
		
	}
}
