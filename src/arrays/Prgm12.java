package arrays;

import java.util.Arrays;
import java.util.Scanner;

// Split the array and add the first part to the end

public class Prgm12 {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6};
		Scanner in = new Scanner(System.in);
		System.out.println("enter any number from where you want to split");
		int split = (in.nextInt())%a.length;
		Prgm12 prgm12 = new Prgm12();
		prgm12.rotate(0,split-1,a);
		prgm12.rotate(split, a.length-1, a);
		prgm12.rotate(0, a.length-1, a);
		System.out.println(Arrays.toString(a));
	}

	public void rotate(int start, int end, int[] a) {
		while(start<end) {
			a[start] = a[start]+a[end];
			a[end] = a[start]-a[end];
			a[start] = a[start] - a[end];
			++start;
			--end;
		}
	}
}
