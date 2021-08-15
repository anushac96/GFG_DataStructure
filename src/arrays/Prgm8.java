package arrays;

import java.util.Arrays;

//Reversal algorithm for right rotation of an array

public class Prgm8 {
	int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	int start = 0;
	int end = a.length - 1;

	public static void main(String[] args) {
		Prgm8 p = new Prgm8();
		int k = 3;
		k = k % p.a.length;
		p.rotate1(k);
		System.out.println(Arrays.toString(p.a));
	}

	private void rotate1(int k) {
		reverse(a.length - k, a.length - 1);
		reverse(0, a.length - k - 1);
		reverse(0, a.length - 1);
	}

	private void reverse(int start, int end) {
		while (start < end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			++start;
			--end;
		}
	}
}