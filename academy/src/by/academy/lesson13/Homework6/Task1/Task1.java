package by.academy.lesson13.Homework6.Task1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/*Прочесть информацию введеную из клавиатури 
 * и записать в созданный вами txt файл,
 * если введена "stop" строка тогда закончить запись в файл.*/
import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {

		/*
		 * Прочесть информацию введеную из клавиатури и записать в созданный вами txt
		 * файл, если введена "stop" строка тогда закончить запись в файл.
		 */

		// create file
		File dir = new File("src\\by\\academy\\lesson13\\Homework6\\Task1");
		File file = new File(dir, "Task1_File.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// write info to the file
		try (Scanner sc = new Scanner(System.in); FileOutputStream fileOut = new FileOutputStream(file, true)) {
			System.out.println("Please enter info for saving in the file " + file.getName());
			String line = sc.nextLine();
			while (!line.equals("stop")) {
				fileOut.write(line.getBytes());
				line = sc.nextLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finished. Info saved in the file");
		}

	}
}
