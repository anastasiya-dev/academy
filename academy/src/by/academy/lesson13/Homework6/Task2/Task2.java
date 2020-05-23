package by.academy.lesson13.Homework6.Task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {
	public static void main(String[] args) {
		/*
		 * Создать руками текстовый файл, закинуть следующий текст:
		 * "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
		 * Создать новый файл result.txt. Программно считать файл с текстом, удалить все
		 * пробелы и записать полученный текст в result.txt.
		 */
		File dir = new File("src\\by\\academy\\lesson13\\Homework6\\Task2");
		File fileRes = new File(dir, "Task2_result.txt");
		File fileInit = new File(dir, "Task2_initial.txt");
		if (!fileRes.exists()) {
			try {
				fileRes.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try (BufferedReader br = new BufferedReader(new FileReader(fileInit));
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileRes))) {
			int tech;
			while ((tech = br.read()) != -1) {
				if (tech != 32) {
					bw.write(tech);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
