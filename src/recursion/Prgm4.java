package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Prgm4 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number from 2 to 9, both inclusive");
		int k = scn.nextInt();
		Prgm4 p1 = new Prgm4();
		System.out.println(Arrays.toString(p1.printStrings(k)));
	}

	private String[] printStrings(int k) {
		if (k == 0) {
			String[] output = new String[1];
			output[0] = "";
			return output;
		}
		int lastDigit = k % 10;
		int remainingNumbers = k / 10;
		String[] smallOutput = printStrings(remainingNumbers);
		String keyAlphabet = getKeypadAlphabet(lastDigit);
		String[] nextOutput = new String[smallOutput.length * keyAlphabet.length()];
		int nextOutputIndex = 0;
		for (int i = 0; i < smallOutput.length; i++) {
			for (int j = 0; j < keyAlphabet.length(); j++) {
				nextOutput[nextOutputIndex] = smallOutput[i] + keyAlphabet.charAt(j);
				nextOutputIndex++;
			}
		}
		return nextOutput;
	}

	private String getKeypadAlphabet(int remainingNumbers) {
		switch (remainingNumbers) {
		case 2:
			return "abc";
		case 3:
			return "def";
		case 4:
			return "ghi";
		case 5:
			return "jkl";
		case 6:
			return "mno";
		case 7:
			return "pqrs";
		case 8:
			return "tuv";
		default:
			return "wxyz";
		}
	}

}
