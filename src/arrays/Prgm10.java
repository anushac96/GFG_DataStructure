package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// Print left rotation of array in O(n) time and O(1) space

public class Prgm10 {

	Integer a[] = { 1, 2, 3, 4, 5, 6 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of rotations");
		Prgm10 prgm10 = new Prgm10();
		int length = prgm10.a.length;
		int k = in.nextInt() % length;
		for (int i = k; i < (length + k); i++) {
			System.out.print(prgm10.a[i % length] + " ");
		}
		System.out.println();

		// or by using Collections
		Collections.rotate(Arrays.asList(prgm10.a), prgm10.a.length - k);
		System.out.println(Arrays.asList(prgm10.a));
	}
}
