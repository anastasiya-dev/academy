package by.academy.lesson9.Task_1_2_3_4;

import by.academy.lesson9.Task_1_2_3_4.User.QueryInner;
import by.academy.lesson9.Task_1_2_3_4.User.QueryStatic;

public class Main_Tasks_1_2_3_4 {
	public static void main (String[] args) {
		
		User user1 = new User("anastasiya", "12345qwerty");
		System.out.println("Inner - Create InnerClass object in method of OuterClass");
		user1.createQueryInner();
		System.out.println("Inner - Create InnerClass object in main from OuterClass object");
		User.QueryInner query2 = user1.new QueryInner();
		query2.printToLog();
		System.out.println("Inner - Create InnerClass object in main via double new");
		User.QueryInner query3 = new User("avk", "12345").new QueryInner();
		query3.printToLog();
		System.out.println("***");
		
		System.out.println("Local - Create LocalClass object in method of OuterClass");
		user1.createQueryLocal();
		System.out.println("***");
		
		System.out.println("Static - Create StaticClass object in main");
		System.out.println("OuterClass object is needed if its fields are used for StaticClass methods");
		User.QueryStatic query4 = new User.QueryStatic();
		query4.printToLog(user1);
		System.out.println("***");

		System.out.println("Anonymous class - Create object from Interface");
		Printable p = new Printable() {

			@Override
			public void print() {
				System.out.println("It prints! Hurray!");				
			}			
		};
		p.print();
		System.out.println("***");
		
	}
}
