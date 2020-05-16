package by.academy.lesson12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task1 {
	public static void main(String[] args) {

		try (FileInputStream fileIn1 = new FileInputStream("src\\io\\file.txt");
				FileOutputStream fileOut1 = new FileOutputStream("src\\io\\copied_file.txt")) {
			int a;
			while ((a = fileIn1.read()) != -1) {
				fileOut1.write(a);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
