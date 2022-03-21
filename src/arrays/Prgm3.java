package arrays;

import java.util.Scanner;

//Search an element in a sorted and rotated array
public class Prgm3 {

	public static void main(String[] args) {
		int a[] = { 4, 5, 6, 7, 8, 1, 2, 3 };
		Prgm3 p1 = new Prgm3();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number to search");
		int k = scn.nextInt();
		scn.close();
		int index = p1.search1(a, 0, a.length - 1, k); // time = log(n) space = 1
		if (index >= 0) {
			System.out.println("number found at index: " + index);
		} else {
			System.out.println("not found");
		}
	}

	public int search1(int a[], int low, int high, int key) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key == a[mid]) {
				return mid;
			}
			if (a[low] < a[mid]) {
				if (key >= a[low] && key < a[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (key > a[mid] && key <= a[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
}