package by.academy.lesson2;

import java.io.IOException;
import java.util.Scanner;

public class HW1_Task5 {
	// Complete the pairs function below.
	static int pairs(int k, int[] arr) {
		int pairsCount = 0;
		// write code here
		for (int j1 = 0; j1 < arr.length; j1++) {
			for (int j2 = 0; j2 < arr.length; j2++) {
				if (arr [j1] - arr [j2] == k) {
					pairsCount++;
				}
			}
		}
		return pairsCount;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(arrItems[i]);
		}

		int result = pairs(k, arr);
		System.out.println(result);

		scanner.close();
	}


}
