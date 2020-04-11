package by.academy.lesson2;

import java.util.Scanner;

public class HW1_Task2 {
	public static void main(String[] args) {
		
		//get data type and convert to lower case
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter the datatype: ");
		String dataType = sc.nextLine();
		dataType = dataType.toLowerCase();
		
		//process data depending on type
		switch (dataType) {
		case "int":
			System.out.println("Enter the value: ");
			int dataInt = sc.nextInt();
			dataInt  = dataInt % 2;
			System.out.println(dataInt);
			break;
		case "double":
			System.out.println("Enter the value: ");
			double dataDouble = sc.nextDouble();
			dataDouble = 0.7 * dataDouble;
			System.out.println(dataDouble);
			break;
		case "float":
			System.out.println("Enter the value: ");
			float dataFloat = sc.nextFloat();
			dataFloat = dataFloat * dataFloat;
			System.out.println(dataFloat);
			break;
		case "char":
			System.out.println("Enter the value: ");
			String dataCharStart = sc.nextLine();
			char dataChar = dataCharStart.charAt(0);
			System.out.println((int) dataChar);
			break;
		case "string":
			System.out.println("Enter the value: ");
			String dataString = sc.nextLine();
			System.out.println("Hello, " + dataString);	
			break;
		default:
			System.out.println("Unsupported type");
			break;
		}
		sc.close();			
	}
}
