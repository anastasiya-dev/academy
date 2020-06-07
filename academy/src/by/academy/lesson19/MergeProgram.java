package by.academy.lesson19;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeProgram {
	public static void main(String[] args) {
		Integer[] a0 = { 1, 3, 5 };
		Integer[] b0 = { 2, 6, 8 };
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(a0));
		ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(b0));
		Merger merger = new Merger();
		merger.merge(a, b);
	}
}
