package by.academy.lesson11.Homework5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class Task1 {
	public static void main(String[] args) {
		
		/*Можно писать все в main. Не нужно создавать новых классов.
		 *Напишите метод, который на вход получает коллекцию объектов, а возвращает коллекцию уже без дубликатов.
		 */
		
//		make list out of array
		String[] array = {"a", "b", "c", "b", "d", "e", "b", "d"};
		List<String> list = Arrays.asList(array);
		System.out.println("Initially: " + list);
		
//		remove duplicates
		LinkedHashSet<String> set = new LinkedHashSet<>(list);
		List<String> listWithoutDuplicates = new ArrayList<>(set);
		System.out.println("Duplicates removed: " + listWithoutDuplicates);
	}
}
