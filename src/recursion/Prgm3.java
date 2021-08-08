package recursion;

import java.util.Scanner;

public class Prgm3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter total number of disc");
		int k = scn.nextInt();
		Prgm3 p1 = new Prgm3();
		p1.towerOfHanoi(k, 'A', 'C', 'B'); // time complexity = (2^n)-1
	}

	private void towerOfHanoi(int k, char source, char destination, char helper) {
		if (k == 1) {
			System.out.println("Moved " + k + "st disk from " + source + " to " + destination);
			return;
		}
		towerOfHanoi((k - 1), source, helper, destination);
		System.out.println("Moved " + k + "th disk from " + source + " to " + destination);
		towerOfHanoi((k - 1), helper, destination, source);
	}
}
