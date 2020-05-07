package by.academy.lesson10.Homework4.Task2;

public class Task2_Main {
	public static <T> void main (String[] args) {
		ArrayClass<String> a = new ArrayClass<>(3);
		a.print();
		System.out.println(a.get(2) == null);
		System.out.println("Last filled: " + a.lastFilled());
		System.out.println("Array size: " + a.getSize());
		a.add("A");
		System.out.println("Last filled: " + a.lastFilled());
		a.add("B");
		System.out.println("Last filled: " + a.lastFilled());
		a.add("C");
		System.out.println("Last filled: " + a.lastFilled());
		a.print();
		System.out.println("First element: " + a.getFirst());
		System.out.println("Last element: " + a.getLast());
		a.print();
		System.out.println("Array size: " + a.getSize());
		a.remove("5");
		a.print();
		a.remove(Integer.valueOf(5));
		a.print();
		a.remove("C");
		a.print();
		System.out.println("Last filled: " + a.lastFilled());
		a.remove(5);
	}
}
