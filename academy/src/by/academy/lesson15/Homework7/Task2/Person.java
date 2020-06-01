package by.academy.lesson15.Homework7.Task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Person {
	protected String firstName;
	protected String lastName;
	protected Calendar dateOfBirth = Calendar.getInstance();
	protected int age;
	SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");	

	public Person(String firstName, String lastName, String dateOfBirthString) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;	
			
		Date dateOfBirthDate;
		try {
			dateOfBirthDate = sdf.parse(dateOfBirthString);
			this.dateOfBirth.setTime(dateOfBirthDate);
		} catch (ParseException e) {
			System.out.println("Incorrect date format");
			e.printStackTrace();
		}
		this.age = Period
				.between(
						LocalDate.of(dateOfBirth.get(Calendar.YEAR), dateOfBirth.get(Calendar.MONTH) + 1,
								dateOfBirth.get(Calendar.DAY_OF_MONTH)),
						LocalDate.of(Calendar.getInstance().get(Calendar.YEAR),
								Calendar.getInstance().get(Calendar.MONTH) + 1, dateOfBirth.get(Calendar.DAY_OF_MONTH)))
				.getYears();
	}

	public Person() {
		super();
	}

	protected String getFirstName() {
		return firstName;
	}

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected String getLastName() {
		return lastName;
	}

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected int getAge() {
		return age;
	}

	protected Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	protected void setDateOfBirth(String dateOfBirthString) {
		Date dateOfBirthDate;
		try {
			dateOfBirthDate = sdf.parse(dateOfBirthString);
			this.dateOfBirth.setTime(dateOfBirthDate);
		} catch (ParseException e) {
			System.out.println("Incorrect date format");
			e.printStackTrace();
		}
	}
}
