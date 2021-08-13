package searching;

public class LinearSearch {

	public static void main(String[] args) {
		int a[] = { 10, 20, 30, 50, 60, 80, 100, 110, 130, 170 };
		int key = 110;
		LinearSearch l = new LinearSearch();
		l.search1(a, key); // time complexity = O(n)
		l.search2(a, key); // Improve Linear Search Worst-Case Complexity
							// if element Found at last O(n) to O(1)
							// if element Not found O(n) to O(n/2)
	}

	private void search2(int[] a, int key) {
		int left = 0;
		int right = a.length - 1;
		while (left <= right) {
			if (a[left] == key) {
				System.out.println("found in " + left + " position");
				break;
			} else if (a[right] == key) {
				System.out.println("found in " + right + " position");
				break;
			} else {
				left++;
				right--;
			}
		}
	}

	private void search1(int[] a, int key) {
		int index = 0;
		while (index < a.length) {
			if (a[index] == key) {
				System.out.println("found in " + index + " position");
				break;
			} else {
				index++;
			}
		}
	}
}
