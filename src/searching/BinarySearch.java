package searching;

public class BinarySearch {

	public static void main(String[] args) {
		int a[] = { 10, 20, 30, 50, 60, 80, 100, 110, 130, 170 };
		int key = 170;
		BinarySearch b = new BinarySearch();
		b.search(a, key);

	}

	private void search(int[] a, int key) {
		int start = 0;
		int end = a.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (a[mid] == key) {
				System.out.println("found at index " + mid);
				return;
			} else if (a[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println("Not found ");
	}
}
