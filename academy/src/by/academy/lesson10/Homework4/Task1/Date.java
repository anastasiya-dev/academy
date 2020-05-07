package by.academy.lesson10.Homework4.Task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {

	private Year year;
	private Month month;
	private DayOfMonth dayOfMonth;
	private final int daysInWeek = 7;
	private final int daysInYear = 365;
	private final int[] calendar = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
	public Date(int year, int month, int dayOfMonth){
		super();
		Year yearO = new Year(year);
		Month monthO = new Month(month);
		DayOfMonth dayOfMonthO = new DayOfMonth(dayOfMonth);
		if(validation(yearO, monthO, dayOfMonthO)) {
			this.year = yearO;
			this.month = monthO;
			this.dayOfMonth = dayOfMonthO;
		}
		else {
			System.out.println("Invalid date, please check");
		}		
	}	
	
	public Date(String dateString) {
		super();
		Pattern p = Pattern.compile("^[0-9]{2}\\/[0-9]{2}\\/[0-9]+$");
		Matcher matcher = p.matcher(dateString);
		if(matcher.matches()) {			
			DayOfMonth dayOfMonthO = new DayOfMonth(Integer.valueOf(dateString.substring(0, 2)));
			Month monthO = new Month(Integer.valueOf(dateString.substring(3, 5)));
			Year yearO = new Year(Integer.valueOf(dateString.substring(6)));			
			
			if(validation(yearO, monthO, dayOfMonthO)) {
				this.year = yearO;
				this.month = monthO;
				this.dayOfMonth = dayOfMonthO;
			}
			else {
				System.out.println("Please check your date");
			}
		}
		else {
			System.out.println("Sorry, incorrect format. Please try again");
		}
	}
	
	public DayOfWeek dayOfWeek() {
		//1st Jan 1000 - Wednesday, take nearest Sunday for reference
		Date referenceDate = new Date(999, 12, 29);
		int dayOfWeekNumber = Math.abs(this.timePeriod(referenceDate)) % daysInWeek;
		return DayOfWeek.values()[dayOfWeekNumber];
	}
	
	public int timePeriod(Date date) {
		return this.convertToDays() - date.convertToDays();				
	}
	
	private int convertToDays() {
		
		int fullYears = this.year.getYearInt() - 1;
		int fullYearsDays = fullYears * daysInYear + (fullYears / 4 - fullYears / 100 + fullYears / 400);
		
		int fullMonths = this.month.getMonthInt() - 1;
		int fullMonthsDays = 0;
		for (int i = 0; i < fullMonths; i++) {
			fullMonthsDays += calendar[i];
		}
		if(fullMonths >= 3 && this.year.leapYear()) {
			fullMonthsDays++;
		}
		return fullYearsDays + fullMonthsDays + this.dayOfMonth.getDayOfMonthInt();
	}	
	
	private boolean validation(Year year, Month month, DayOfMonth dayOfMonth) {
		boolean monthCheck = false;
		boolean dayCheck = false;		
		
		if(month.getMonthInt() >= 1 && month.getMonthInt() <= 12) {
			monthCheck = true;
		}
		if((dayOfMonth.getDayOfMonthInt() <= calendar[month.getMonthInt() - 1]) ||
					(dayOfMonth.getDayOfMonthInt() == 29 && month.getMonthInt() == 2 && year.leapYear())) {
			dayCheck = true;
		}		
		return monthCheck && dayCheck;
	}
	
	@Override
	public String toString() {
		StringBuilder stringDate = new StringBuilder();
		stringDate.append("dd/mm/yyyy: ");
		stringDate.append(this.dayOfMonth.getDayOfMonthInt());
		stringDate.append("/");
		stringDate.append(this.month.getMonthInt());
		stringDate.append("/");
		stringDate.append(this.year.getYearInt());
		return String.valueOf(stringDate);		
	}
		
	//further go getters, setters, nested classes for year(incl leap check)-month-dayOfMonth
	
	public Year getYear() {
		return year;
	}	

	public void setYear(Year year) {
		this.year = year;
	}
	
	public void setYear(int year) {
		Year yearO = new Year(year);
		this.year = yearO;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}
	
	public void setMonth(int month) {
		Month monthO = new Month(month);
		this.month = monthO;
	}

	public DayOfMonth getDayOfMonth() {
		return dayOfMonth;
	}

	public void setDayOfMonth(DayOfMonth dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}
	
	public void setDayOfMonth(int dayOfMonth) {
		DayOfMonth dayOfMonthO = new DayOfMonth(dayOfMonth);
		this.dayOfMonth = dayOfMonthO;
	}

	private static class Year{
		int year;
		Year(int year){
			super();
			this.year = year;
		}
		
		private int getYearInt() {
			return year;
		}
		
		public boolean leapYear() {
			boolean leap = false;
			int yearInt = getYearInt();
			if (yearInt % 4 == 0) {
				if(yearInt % 100 == 0) {
					if(yearInt % 400 == 0) {
						leap = true;
					}
					else {
						leap = false;
					}
				}
				else {
					leap = true;
				}			
			}
			else {
				leap = false;
			}
			return leap;
		}
	}
	
	private static class Month{
		int month;
		Month(int month){
			super();
			this.month = month;			
		}
		
		public int getMonthInt() {
			return month;
		}
	}
	
	private static class DayOfMonth{
		int dayOfMonth;
		DayOfMonth(int dayOfMonth){
			super();
			this.dayOfMonth = dayOfMonth;	
		}
		
		private int getDayOfMonthInt() {
			return dayOfMonth;
		}
	}	
}
