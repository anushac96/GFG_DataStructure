package recursion;

import java.util.Scanner;

public class Prgm2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number greater than 0");
		int k = scn.nextInt();
		Prgm2 p1 = new Prgm2();
		System.out.println(p1.printFromOneToN1(k));
		System.out.println(p1.printFromNToOne1(k, 1));
		p1.printFromOneToN2(k);
		System.out.println();
		p1.printFromNToOne2(k);
	}

	private void printFromNToOne2(int k) {
		if (k == 0)
			return;
		System.out.print(k + " ");
		printFromNToOne2(k - 1);
	}

	private void printFromOneToN2(int k) {
		if (k == 0)
			return;
		printFromOneToN2(k - 1);
		System.out.print(k + " ");
	}

	private int printFromNToOne1(int end, int start) {
		if (start == end)
			return end;
		System.out.print(printFromNToOne1(end, start + 1) + " ");
		return start;
	}

	private int printFromOneToN1(int k) {
		if (k == 1)
			return 1;
		System.out.print(printFromOneToN1(k - 1) + " ");
		return k;
	}
}
