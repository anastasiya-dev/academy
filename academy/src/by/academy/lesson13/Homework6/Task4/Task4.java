package by.academy.lesson13.Homework6.Task4;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Task4 {
	public static void main(String[] args) {

		/*
		 * Создайте каталог(папку). Создайте в папке 100 txt файлов (Например, 1.txt,
		 * 2.txt ... 100.txt). Считываем текст из 2-ого задания, получаем его длинну
		 * (576 символов). Для каждого файла генерируем рандомное число от 0 до 576,
		 * достаем из текста (из 2 задания) такое-же количество символов
		 * (string.substring()) и сохраняем в наш файл. Создайте файл result.txt и
		 * запишите туда список всех файлов и их размеры.
		 */

		// create folder
		File dirTask = new File(
				"C:\\Users\\admin\\git\\repository\\academy\\src\\by\\academy\\lesson13\\Homework6\\Task4");
		File dirNew = new File(dirTask, "Test files");
		if (!dirNew.exists()) {
			dirNew.mkdir();
		}
		File resultFile = new File(dirTask, "Task4_result.txt");
		if (!resultFile.exists()) {
			try {
				resultFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// create files
		int counter = 0;
		while (counter < 100) {
			File file = new File(dirNew, String.valueOf(counter + 1) + ".txt");
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			counter++;
		}
		// read source file
		File source = new File(
				"C:\\Users\\admin\\git\\repository\\academy\\src\\by\\academy\\lesson13\\Homework6\\Task2",
				"Task2_initial.txt");
		try (FileReader fr = new FileReader(source);) {
			int tech;
			StringBuilder sb = new StringBuilder();
			while ((tech = fr.read()) != -1) {
				sb.append((char) tech);
			}
			String text = sb.toString();
			// test correct reading
			System.out.println("The lenth of the source file " + text.length());

			// generate random numbers in the range and add substrings to files
			Random rnd = new Random();
			File[] files = dirNew.listFiles();
			for (File file : files) {				
				try (FileWriter fw = new FileWriter(file)) {
					fw.write(text.substring(0, rnd.nextInt(text.length())));
				}
			}

			for (File file : files) {
				try (FileWriter fw = new FileWriter(resultFile, true)) {
					fw.write("File " + file.getName() + " - length " + file.length() + "\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
