package arrays;

//Find the Rotation Count in Rotated Sorted array

public class Prgm6 {
	int a[] = { 7, 9, 11, 12, 15 };
	int start = 0;
	int end = a.length - 1;

	public static void main(String[] args) {
		Prgm6 p = new Prgm6();
		System.out.println("total number of rotation are " + p.findHighestValue()); // time complexity = log(n)
	}

	private int findHighestValue() {
		while (start < end) {
			int mid = (start + end) / 2;
			if (start == mid) {
				if (a[mid] > a[mid + 1]) {
					return (mid + 1) % (a.length);
				}
				return (mid + 2) % (a.length);
			}
			if (a[mid] > a[start]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return -1;
	}
}