package arrays;

//Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed

public class Prgm5 {
	int a[] = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	int start = 0;
	int end = a.length - 1;

	public static void main(String[] args) {
		Prgm5 p = new Prgm5();
		System.out.println("maximum sum is " + p.findHighestValue(p.a)); // time complexity = n

	}

	private int findHighestValue(int[] a) { // time complexity = n+n=2n =>n
		int indexOfHighestNumber = 0;
		int i = 0;
		while (i < a.length - 1) {
			if (a[i] >= a[indexOfHighestNumber]) {
				indexOfHighestNumber = i; // time complexity = n
			}
			i++;
		}
		return rotate(indexOfHighestNumber); // time complexity = n
	}

	private int rotate(int indexOfHighestNumber) { // time complexity = n+n=2n => n
		if (indexOfHighestNumber + 1 == a.length)
			return calculate(); // time complexity = n
		else {
			reverse(indexOfHighestNumber + 1, a.length - 1); // time complexity = d/2
			reverse(0, indexOfHighestNumber); // time complexity = (n-d)/2
			reverse(0, a.length - 1); // time complexity = n/2
			// total = (d/2)+(n/2)-(d/2)+(n/2) = n
			return calculate(); // time complexity = n
		}
	}

	private void reverse(int start1, int end1) {
		while (start1 < end1) {
			int temp = a[start1];
			a[start1] = a[end1];
			a[end1] = temp;
			start1++;
			end1--;
		}
	}

	private int calculate() { // time complexity = n
		int sum = 0;
		for (int i = 0; i < a.length; i++)
			sum = sum + (i * a[i]);
		return sum;
	}
}