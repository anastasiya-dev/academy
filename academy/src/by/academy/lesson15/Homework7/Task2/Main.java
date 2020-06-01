package by.academy.lesson15.Homework7.Task2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;

public class Main {
	public static void main(String[] args) {

		Person person = new Person("Ivan", "Ivanov", "17/03/1987");
		User user = new User("Petr", "Petrov", "02/01/1991", "ppetrov", "qwerty", "ppetrov@gmail.com");
		user.printUserInfo();

		Class<? extends User> userClass = user.getClass();
		Class<? extends Person> personClass = person.getClass();

		System.out.println();
		System.out.println("User methods via .getMethods:");
		Method[] methodsU = userClass.getMethods();
		for (Method method : methodsU) {
			System.out.println(method.getName());
		}
		
		System.out.println();
		System.out.println("User methods via .getMethod(name):");
		// сделала из массива, чтобы не писать каждый метод вручную
		for (Method method : methodsU) {
			try {
				Method methodSep = userClass.getMethod(method.getName());
				System.out.println(methodSep.getName());
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println();
		System.out.println("User methods via .getDeclaredMethods:");
		Method[] methodsUDecl = userClass.getDeclaredMethods();
		for (Method method : methodsUDecl) {
			System.out.println(method.getName());
		}

		System.out.println();
		System.out.println("User methods via .getDeclaredMethod(name):");		
		try {

			Method m1 = userClass.getDeclaredMethod("setLogin", String.class);
			Method m2 = userClass.getDeclaredMethod("getLogin");
			Method m3 = userClass.getDeclaredMethod("setPassword", String.class);
			Method m4 = userClass.getDeclaredMethod("getPassword");
			Method m5 = userClass.getDeclaredMethod("setEmail", String.class);
			Method m6 = userClass.getDeclaredMethod("getEmail");
			Method m7 = userClass.getDeclaredMethod("printUserInfo");
			Method[] methodsSep = { m1, m2, m3, m4, m5, m6, m7 };
			for (Method method : methodsSep) {
				System.out.println(method.getName());				
			}
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("User fields via .getFields:");
		Field[] fieldsU = userClass.getFields();
		for (Field field : fieldsU) {
			System.out.println(field.getName());
		}
		
		System.out.println();
		// сделала из массива, чтобы не писать каждый раз вручную
		System.out.println("User fields via .getField(name):");		
		for (Field field : fieldsU) {
			Field fieldSep;
			try {
				fieldSep = userClass.getField(field.getName());
				System.out.println(fieldSep.getName());
			} catch (NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}

		System.out.println();
		System.out.println("User fields via .getDeclaredFields:");
		Field[] fieldsUDecl = userClass.getDeclaredFields();
		for (Field field : fieldsUDecl) {
			System.out.println(field.getName());
		}
		
		System.out.println();
		System.out.println("User fields via .getDeclaredField(name):");		
		try {

			Field f1 = userClass.getDeclaredField("login");
			Field f2 = userClass.getDeclaredField("password");
			Field f3 = userClass.getDeclaredField("email");			
			Field[] fieldsSep = { f1, f2, f3 };
			for (Field field : fieldsSep) {
				System.out.println(field.getName());				
			}
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("Set and get user fields:");
		try {
			Field login = userClass.getDeclaredField("login");
			login.setAccessible(true);			
			login.set(user, "ssidorov");
			System.out.println("Login: " + login.get(user));
			Field password = userClass.getDeclaredField("password");
			password.setAccessible(true);			
			password.set(user, "12345");
			System.out.println("Password: " + password.get(user));
			Field email = userClass.getDeclaredField("email");
			email.setAccessible(true);			
			email.set(user, "ssidorov@yandex.ru");
			System.out.println("Email: " + email.get(user));
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		user.printUserInfo();
		
		System.out.println();
		System.out.println("Invoke for user:");
		try {
			Method printUserInfo = userClass.getDeclaredMethod("printUserInfo");			
			printUserInfo.invoke(user);
			
		} catch (NoSuchMethodException | SecurityException| IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		System.out.println();
		System.out.println("Person methods via .getMethods:");
		Method[] methodsP = personClass.getMethods();
		for (Method method : methodsP) {
			System.out.println(method.getName());
		}
		
		System.out.println();
		System.out.println("Person methods via .getMethod(name):");
		// сделала из массива, чтобы не писать каждый метод вручную
		for (Method method : methodsP) {
			try {
				Method methodSep = personClass.getMethod(method.getName());
				System.out.println(methodSep.getName());
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println();
		System.out.println("Person methods via .getDeclaredMethods:");
		Method[] methodsPDecl = personClass.getDeclaredMethods();
		for (Method method : methodsPDecl) {
			System.out.println(method.getName());
		}
		
		System.out.println();
		System.out.println("Person methods via .getDeclaredMethod(name):");		
		try {

			Method m1 = personClass.getDeclaredMethod("setFirstName", String.class);
			Method m2 = personClass.getDeclaredMethod("getFirstName");
			Method m3 = personClass.getDeclaredMethod("setLastName", String.class);
			Method m4 = personClass.getDeclaredMethod("getLastName");
			Method m5 = personClass.getDeclaredMethod("setDateOfBirth", String.class);
			Method m6 = personClass.getDeclaredMethod("getDateOfBirth");
			Method m7 = personClass.getDeclaredMethod("getAge");
			Method[] methodsSep = { m1, m2, m3, m4, m5, m6, m7 };
			for (Method method : methodsSep) {
				System.out.println(method.getName());				
			}
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("Person fields via .getFields:");
		Field[] fieldsP = personClass.getFields();
		for (Field field : fieldsP) {
			System.out.println(field.getName());
		}
		
		System.out.println();
		System.out.println("Person fields via .getField(name):");		
		for (Field field : fieldsP) {
			Field fieldSep;
			try {
				fieldSep = personClass.getField(field.getName());
				System.out.println(fieldSep.getName());
			} catch (NoSuchFieldException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}

		System.out.println();
		System.out.println("Person fields via .getDeclaredFields:");
		Field[] fieldsPDecl = personClass.getDeclaredFields();
		for (Field field : fieldsPDecl) {
			System.out.println(field.getName());
		}
		
		System.out.println();
		System.out.println("Person fields via .getDeclaredField(name):");		
		try {

			Field f1 = personClass.getDeclaredField("firstName");
			Field f2 = personClass.getDeclaredField("lastName");
			Field f3 = personClass.getDeclaredField("age");
			Field f4 = personClass.getDeclaredField("dateOfBirth");
			Field[] fieldsSep = { f1, f2, f3, f4 };
			for (Field field : fieldsSep) {
				System.out.println(field.getName());				
			}
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("Set and get person fields:");
		try {
			Field firstNamefield = personClass.getDeclaredField("firstName");
			firstNamefield.setAccessible(true);			
			firstNamefield.set(person, "John");
			System.out.println("First Name: " + firstNamefield.get(person));
			Field lastNameField = personClass.getDeclaredField("lastName");
			lastNameField.setAccessible(true);			
			lastNameField.set(person, "Dory");
			System.out.println("Last Name: " + lastNameField.get(person));
			Field dateOfBirthfield = personClass.getDeclaredField("dateOfBirth");
			dateOfBirthfield.setAccessible(true);
			Calendar calendar = Calendar.getInstance();
			dateOfBirthfield.set(person, calendar);
			System.out.println("Date of Birth: " + person.sdf.format(((Calendar) dateOfBirthfield.get(person)).getTime()));
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
