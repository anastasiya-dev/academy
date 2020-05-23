package by.academy.lesson13.Homework6.Task3;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6248866710492399564L;
	private String name, surname;
	private int age;
	
	public User(String name, String surname, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	protected synchronized String getName() {
		return name;
	}

	protected synchronized void setName(String name) {
		this.name = name;
	}

	protected synchronized String getSurname() {
		return surname;
	}

	protected synchronized void setSurname(String surname) {
		this.surname = surname;
	}

	protected synchronized int getAge() {
		return age;
	}

	protected synchronized void setAge(int age) {
		this.age = age;
	}	
}
