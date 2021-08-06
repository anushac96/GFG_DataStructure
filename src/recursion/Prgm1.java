package recursion;

import java.util.Scanner;

public class Prgm1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		int k = scn.nextInt();
		if (k < 0)
			k = k * (-1);
		Prgm1 p1 = new Prgm1();
		System.out.println("Number of digits are :" + p1.countDigit(k));
	}

	private int countDigit(int k) {
		if (k < 10)
			return 1;
		int digitCount = countDigit(k / 10);
		digitCount++;
		return digitCount;
	}
}
