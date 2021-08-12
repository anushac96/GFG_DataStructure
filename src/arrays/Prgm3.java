package arrays;

import java.util.Scanner;

//Search an element in a sorted and rotated array
public class Prgm3 {

	public static void main(String[] args) {
		int a[] = { 4, 5, 6, 7, 1, 2, 3 };
		Prgm3 p1 = new Prgm3();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number to search");
		int k = scn.nextInt();
		p1.search1(a, k); // time = log(n) space = 1
	}

	private void search1(int[] a, int k) {
		int start = 0;
		int end = a.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (k == a[mid]) {
				System.out.println(k + " is found at " + mid + " index");
				return;
			}
			if (k >= a[start] && k < a[mid]) {
				end = mid - 1;
			} else
				start = mid + 1;
		}
		System.out.print("key not found");
	}
}