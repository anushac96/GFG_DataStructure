package arrays;

import java.util.Arrays;
import java.util.Scanner;

//Reversal algorithm for right rotation of an array

public class Prgm9 {
	int a[] = { 1, 2, 3, 4, 5 };

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of queries you want to enter");
		int no_of_query = scn.nextInt();
		int netRotation=0;
		int start = 0;
		Prgm9 prgm9 = new Prgm9();
		for (int i = 1; i <= no_of_query; i++) {
			System.out.print("query " + i + " = ");
			String inputarray[] = new String[3];
			String inputString = scn.next();
			inputarray = prgm9.stringToArray(inputString);
			inputarray = Arrays.stream(inputarray).filter(s -> s != null).toArray(String[]::new);
			// if we are rotating the array for every query, that will be highly
			// inefficient.
//			switch (inputarray[0]) {
//			case "1":
//				prgm9.right_circular_shift(inputarray, prgm9.a);  //time complexity: n
//				System.out.println(Arrays.toString(prgm9.a));
//				break;
//			case "2":
//				prgm9.left_circular_shift(inputarray, prgm9.a);	  //time complexity: n
//				System.out.println(Arrays.toString(prgm9.a));
//				break;
//			case "3":
//				int sum = prgm9.sum(inputarray, prgm9.a);
//				System.out.println(sum);
//				break;
//			}
//			System.out.println();
			
			// We just need to track the net rotation. If the tracked number is
			// negative, it means left rotation has dominated else right rotation
			// has dominated.
			
			switch (inputarray[0]) {
			case "1":
				netRotation = netRotation+Integer.parseInt(inputarray[1]);
				netRotation = netRotation % prgm9.a.length;
				break;
			case "2":
				netRotation = netRotation-Integer.parseInt(inputarray[1]);
				netRotation = netRotation % prgm9.a.length;
				break;
			case "3":
				int sum = prgm9.sum1(inputarray, prgm9.a, netRotation);
				System.out.println(sum);
				break;
			}
		}
	}

	private int sum1(String[] inputarray, int[] a, int netRotation) {
		// netRotation = netRotation%a.length;
		if (netRotation < 0) {
			netRotation = Math.abs(netRotation);
		} else {
			netRotation = a.length - netRotation;
		}
		int start = (Integer.parseInt(inputarray[1]) + netRotation) % a.length;
		int end = (Integer.parseInt(inputarray[2]) + netRotation) % a.length;
		int sum = 0;
		while (start != end) {
			sum = sum + a[start];
			start = (++start) % a.length;
		}
		sum = sum + a[end];
		return sum;
	}

	private String[] stringToArray(String inputString) {
		int i = 0, j = 0;
		String inputarray[] = new String[3];
		while (i < inputString.length()) {
			inputarray[j] = Character.toString(inputString.charAt(i));
			j++;
			i = i + 2;
		}
		return inputarray;
	}

	private int sum(String[] inputarray, int[] a) {
		int start = Integer.parseInt(inputarray[1]);
		int end = Integer.parseInt(inputarray[2]);
		int sum = 0;
		while (start < end) {
			sum = sum + a[start] + a[end];
			start++;
			end--;
		}
		if (start == end) {
			sum = sum + a[start];
		}
		return sum;
	}

	private void left_circular_shift(String[] inputarray, int[] a) {
		// rotate left part
		rotate(0, Integer.parseInt(inputarray[1]) - 1, a);
		// rotate right part
		rotate(Integer.parseInt(inputarray[1]), a.length - 1, a);
		// rotate whole
		rotate(0, a.length - 1, a);
	}

	public void right_circular_shift(String[] inputarray, int[] a) {
		// rotate left part
		rotate(0, a.length - Integer.parseInt(inputarray[1]) - 1, a);
		// rotate right part
		rotate(a.length - Integer.parseInt(inputarray[1]), a.length - 1, a);
		// rotate whole
		rotate(0, a.length - 1, a);
	}

	private void rotate(int start, int end, int[] a) {
		if (end > 0) {
			while (start < end) {
				a[start] = a[start] + a[end];
				a[end] = a[start] - a[end];
				a[start] = a[start] - a[end];
				start++;
				end--;
			}
		}
	}
}