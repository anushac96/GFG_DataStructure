package arrays;

//Given a sorted and rotated array, find if there is a pair with a given sum
public class Prgm4 {
	int a[] = { 1, 2, 3, 4, 5, 6 };
	int start = 0;
	int end = a.length - 1;

	public static void main(String[] args) {
		// Enter the sum to find its first pair
		int k = 1;
		Prgm4 p1 = new Prgm4();
		if (p1.findHighestAndLowestValue(p1.a, k)) { // time complexity = log(n)+n = n
			System.out.println("pair is (" + p1.a[p1.start] + "," + p1.a[p1.end] + ")");
		} else {
			System.out.println("There is no pair with sum " + k);
		}
	}

	private boolean findHighestAndLowestValue(int[] a, int k) { // time complexity = log(n)
		while (start < end) {
			int mid = (start + end) / 2;
			if (a[mid] > a[start]) {
				if (a[mid] < a[mid + 1])
					start = mid + 1;
				else {
					start = mid + 1;
					end = mid;
					break;
				}
			} else {
				if (a[mid - 1] > a[mid]) {
					end = mid - 1;
					start = mid;
					break;
				} else {
					end = mid - 1;
				}
			}
		}
		if (start == end)
			return findPairs((++start) % a.length, end, a, k);
		else
			return findPairs(start, end, a, k);
	}

	private boolean findPairs(int start1, int end1, int[] a, int k) { // time complexity n
		while (start1 != end1) {
			int sum = a[start1] + a[end1];
			if (sum == k) {
				start = start1;
				end = end1;
				return true;
			} else if (sum > k) {
				end1 = end1 - 1;
				if (end1 < 0)
					end1 = a.length - 1;
			} else {
				start1 = start1 + 1;
				if (start1 == a.length)
					start1 = 0;
			}
		}
		return false;
	}
}