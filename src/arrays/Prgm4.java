package arrays;

//Given a sorted and rotated array, find if there is a pair with a given sum

/*Note:
Here we are using 
	int mid = low + (high – low)/2;
Maybe, you wonder why we are calculating the middle index this way, we can simply add the lower and higher index and divide it by 2.
	int mid = (low + high)/2;
But if we calculate the middle index like this means our code is not 100% correct, it contains bugs.
That is, it fails for larger values of int variables low and high. Specifically, it fails if the sum of low and high is greater than the maximum positive int value(231 – 1 ).
The sum overflows to a negative value and the value stays negative when divided by 2. In java, it throws ArrayIndexOutOfBoundException.
	int mid = low + (high – low)/2;
So it’s better to use it like this. This bug applies equally to merge sort and other divide and conquer algorithms.
*/
public class Prgm4 {
	int a[] = { 1, 2, 3 };
	int start = 0;
	int end = a.length - 1;

	public static void main(String[] args) {
		// Enter the sum to find its first pair
		int k = 9;
		Prgm4 p1 = new Prgm4();
		if (p1.findHighestValue(p1.a, k)) { // time complexity = log(n)+n = n
			System.out.println("pair is (" + p1.a[p1.start] + "," + p1.a[p1.end] + ")");
		} else {
			System.out.println("There is no pair with sum " + k);
		}
	}

	private boolean findHighestValue(int[] a, int k) { // time complexity = log(n)
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (start == mid) {
				if (a[mid] < a[mid + 1]) {
					end = mid + 1;
				} else {
					end = mid;
				}
				break;
			}
			if (a[mid] > a[start]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (end + 1 == a.length)
			return findPairs(0, end, a, k);
		else
			return findPairs(end + 1, end, a, k);
	}

//1,2,3	end=3
//3,1,2	
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