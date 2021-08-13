package recursion;

public class BinarySearchRecursion {

	public static void main(String[] args) {
		int a[] = { 10, 20, 30, 50, 60, 80, 100, 110, 130, 170 };
		int key = 170;
		BinarySearchRecursion b = new BinarySearchRecursion();
		if (!b.search(0, a.length - 1, a, key))
			System.out.println("not found");
	}

	private boolean search(int start, int end, int[] a, int key) {
		if (start <= end) {
			int mid = (start + end) / 2;
			if (a[mid] == key) {
				System.out.println("found at index " + mid);
				return true;
			} else if (a[mid] > key) {
				return search(start, mid - 1, a, key);
			} else {
				return search(mid + 1, end, a, key);
			}
		}
		return false;
	}
}
