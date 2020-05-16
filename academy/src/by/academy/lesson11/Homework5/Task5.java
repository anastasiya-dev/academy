package by.academy.lesson11.Homework5;

import java.util.HashMap;
import java.util.Map;

public class Task5 {
	public static void main(String[] args) {
		
		/*Можно писать все в main. Не нужно создавать новых классов.
		 *Имеется текст. Следует составить для него частотный словарь:
		 *Создать Map<Character, Integer> для символов, в который мы заносим символ и его количество.
   		 */
		
		String testString = "Имеется текст. Следует составить для него частотный словарь";
		Map<Character, Integer> frequency = new HashMap<>();
		for (int i = 0; i < testString.length(); i++) {
			char symbol = testString.charAt(i);
			Integer val = frequency.get(symbol);
			if(val != null) {
				frequency.put(symbol, new Integer(1 + val));
			}
			else {
				frequency.put(symbol, 1);
			}					
		}
		System.out.println(frequency);
	}
}
