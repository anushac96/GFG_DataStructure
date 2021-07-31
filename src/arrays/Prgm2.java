package arrays;

import java.util.Arrays;

public class Prgm2 {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6 };
		Prgm2 p1 = new Prgm2();
		// p1.rotate1(a);	// time = n	space = 1
		p1.rotate2(a);	// time = n	space = 1
	}

	private void rotate2(int[] a) {
		int i = 0;
		int j = a.length - 1;
		while (j > i) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
		}
		System.out.println(Arrays.toString(a));
	}

	private void rotate1(int[] a) {
		int temp = a[a.length - 1];
		for (int i = a.length - 2; i >= 0; i--) {
			a[i + 1] = a[i];
		}
		a[0] = temp;
		System.out.println(Arrays.toString(a));
	}
}
