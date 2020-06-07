package by.academy.lesson19;

import java.util.ArrayList;

public class Merger {

	ArrayList<Integer> a;
	ArrayList<Integer> b;

	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int counterA = 0;
		int counterB = 0;

		while (counterB < b.size()) {
			try {
				while (a.get(counterA + 1) < b.get(counterB)) {
					counterA++;
				}
			} catch (IndexOutOfBoundsException e) {
			}

			if (a.get(counterA) > b.get(counterB)) {
				a.add(counterA, b.get(counterB));
			} else {
				a.add(counterA + 1, b.get(counterB));
			}
			counterB++;
		}

		for (Integer i : a) {
			System.out.println(i);
		}
	}
}
