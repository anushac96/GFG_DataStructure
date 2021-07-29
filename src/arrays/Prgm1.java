package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Prgm1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("Enter a number: ");
		int d = scn.nextInt();
		// if d > a.len
		d = d % a.length;
		Prgm1 p1 = new Prgm1();
		//p1.rotate1(a, d); // time = d+a.len	space = d + a
		p1.rotate12(a, d);	//time = d *(n-1)	space = 1
	}

	private void rotate12(int[] a, int d) {
		if (d == 0 || d == a.length) {
			System.out.println(Arrays.toString(a));
		}
		if(d<0) {
			System.out.println("number is less than 0");
		}
		for(int i=0;i<d;i++) {
			int temp = a[0];
			for(int j=1;j<a.length;j++) {
				a[j-1] = a[j];		//d *(n-1)
			}
			a[a.length-1] = temp;
		}
		System.out.println(Arrays.toString(a));
	}

	private void rotate1(int[] a, int d) {
		if (d == 0 || d == a.length) {
			System.out.println(Arrays.toString(a));
		}
		if(d<0) {
			System.out.println("number is less than 0");
		}
		int temp[] = new int[d];
		for (int i = 0; i < d; i++) {
			temp[i] = a[i]; // d
		}
		for (int i = d; i < a.length; i++) {
			a[i - d] = a[i]; // a.len-d
		}
		for (int i = 0; i < temp.length; i++) {
			a[a.length - d + i] = temp[i]; // d
		}
		System.out.println(Arrays.toString(a));
	}
}
