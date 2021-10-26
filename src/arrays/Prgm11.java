package arrays;

import java.util.Scanner;

// Find element at given index after a number of rotations

public class Prgm11 {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		Scanner in = new Scanner(System.in);
		System.out.println("enter an index to find it's value");
		int index = in.nextInt();
		int rotations = 3;
		int rotationInput[][] = {{1,3},{0,3},{1,2}};
		
		for(int i= rotations-1;i>=0;i--) {
			int left = (rotationInput[i][0])%a.length;
			int right =(rotationInput[i][1])%a.length;
			
			if(left<index && index<right) {
				--index;
			}
			else if(left==index) {
				index = right;
			}
		}
		System.out.println("value at given index after rotations is: "+a[index]);
	}
}
