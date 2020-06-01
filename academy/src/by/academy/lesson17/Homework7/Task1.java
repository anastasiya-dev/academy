package by.academy.lesson17.Homework7;

import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
	public static void main(String[] args) {

		List<Long> myList = generateIntegerList(100, 100);
		System.out.println("Initial list:");
		System.out.println(myList);
		System.out.println();
		System.out.println("Final list:");
		System.out.println(myList.stream().map(i -> i * Math.PI - 20).filter(i -> i < 100).sorted().skip(3).collect(
				Collectors.toMap(i -> "Number " + i, Function.identity(), (iPrevious, iNew) -> iNew, TreeMap::new)));
	}

	private static List<Long> generateIntegerList(Integer bound, Integer size) {
		return Stream.generate(() -> new Random().nextInt(bound)).limit(size).mapToLong(Integer::longValue).boxed()
				.collect(Collectors.toList());
	}
}
