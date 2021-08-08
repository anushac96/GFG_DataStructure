package recursion;

import java.util.Scanner;

public class Prgm5 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Prgm5 p1 = new Prgm5();
		// System.out.println("enter number of inputs");
		int times = scn.nextInt();
		String[] ans1 = new String[times + 1];
		String[] ans2 = new String[times + 1];
		for (int i = 1; i <= times; i++) {
			// System.out.println("enter generation");
			int generation = scn.nextInt();
			// System.out.println("enter kid Number");
			int kidNumber = scn.nextInt();
			ans1[i] = p1.findGenderRecursion(generation, kidNumber);
			ans2[i] = p1.findGenderWhileLoop(generation, kidNumber);

		}
		for (int i = 1; i <= times; i++)
			System.out.println(ans1[i]);
		System.out.println("============");
		for (int i = 1; i <= times; i++)
			System.out.println(ans2[i]);

		// root root node can be male or female
		System.out.println("Enter root");
		scn.nextLine();
		String root = scn.nextLine();
		System.out.println("Enter generation");
		int generation = scn.nextInt();
		System.out.println("Enter kid number");
		int kidNumber = scn.nextInt();
		System.out.println("gender is :" + findGenderRecursion1(root, generation, kidNumber));

	}

	private static String findGenderRecursion1(String root, int generation, int kidNumber) {
		if (generation == 1)
			return root;
		if (kidNumber % 2 == 0) {
			root = findGenderRecursion1(root, generation - 1, kidNumber / 2);
			if (root.equals("Male"))
				return "Female";
			else
				return "Male";
		} else {
			root = findGenderRecursion1(root, generation - 1, (kidNumber + 1) / 2);
			if (root.equals("Male"))
				return "Male";
			else
				return "Female";
		}
	}

	private String findGenderWhileLoop(int generation, int kidNumber) {
		String root = null;
		int count = generation;
		int[] parentNode = new int[generation + 1];
		parentNode[generation] = kidNumber;
		while (count > 1) {
			if (parentNode[count] % 2 == 0) {
				parentNode[count - 1] = parentNode[count] / 2;
			} else {
				parentNode[count - 1] = (parentNode[count] + 1) / 2;
			}
			count--;
		}
		while (count <= generation) {
			if (parentNode[count] == 1)
				root = "Male";
			else if (parentNode[count] % 2 == 0) {
				if (root.equals("Male"))
					root = "Female";
				else
					root = "Male";
			} else {
				if (root.equals("Male"))
					root = "Male";
				else
					root = "Female";
			}
			count++;
		}
		return root;
	}

	private String findGenderRecursion(int generation, int kidNumber) {
		if (generation == 1)
			return "Male";
		if (kidNumber % 2 == 0) {
			String root = findGenderRecursion(generation - 1, kidNumber / 2);
			if (root.equals("Male"))
				return "Female";
			else
				return "Male";
		} else {
			String root = findGenderRecursion(generation - 1, (kidNumber + 1) / 2);
			if (root.equals("Male"))
				return "Male";
			else
				return "Female";
		}
	}
}
