package by.academy.lesson12;

import java.io.File;

public class Task5 {
	
	public static void main(String[] args) {
		File dir = new File("src");
		printAllJavaFiles(dir);
	}	
	
	public static void printAllJavaFiles(File directory) {
		
		if (directory.isDirectory()) {	
		
			File[] subDirectories = directory.listFiles();			
			
			System.out.println("Directory " + directory.getName());	

			for (File file : subDirectories) {
				printAllJavaFiles(file);				
			}			
			
		} else {
			System.out.println("File " + directory.getName());			
		}		
	}	
}
