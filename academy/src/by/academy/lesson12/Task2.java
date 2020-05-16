package by.academy.lesson12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Task2 {
	public static void main(String[] args) throws IOException {

		File dir1 = new File("src");

		if (!dir1.exists()) {
			dir1.mkdir();
		}

		File dir2 = new File(dir1, "io");

		if (!dir2.exists()) {
			dir2.mkdir();
		}

		File file = new File(dir2, "file.txt");

		if (!file.exists()) {
			file.createNewFile();
		}
		
		try (OutputStream output = new FileOutputStream(file); InputStream input = new FileInputStream(file)) {

			char[] symbols = { 'a', 'b', 'c' };

			for (char c : symbols) {
				// Запись каждого символа в текстовый файл
				output.write(c);
			}

			int size = input.available();

			for (int i = 0; i < size; i++) {
				// Чтение текстового файла посимвольно
				System.out.print((char) input.read() + " ");
			}

		} catch (IOException e) {
			System.out.print("Exception");
		}
	}
}
