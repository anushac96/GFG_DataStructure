package sorting;

public class MergeSort {

	public static void main(String[] args) {

		int a[] = { 10, 9, 8, 8, 6, 1, 2, 3, 4, 5 }; // len = 5 ----> 0-4
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort1(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public void sort1(int a[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			sort1(a, low, mid);
			sort1(a, mid + 1, high);
			merge1(a, low, mid, high);
		}
	}

	public void merge1(int a[], int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int k = 0;
		int b[] = new int[high - low + 1];
		// System.out.println(b.length);
		while (i <= mid && j <= high) {
			if (a[i] < a[j]) {
				b[k] = a[i];
				++i;
			} else {
				b[k] = a[j];
				++j;
			}
			++k;
		}
		if (i <= mid) {
			while (i <= mid) {
				b[k] = a[i];
				++i;
				++k;
			}
		} else {
			while (j <= high) {
				b[k] = a[j];
				++j;
				++k;
			}
		}
		for (int l = low, n = 0; l <= high; l++, n++) {
			a[l] = b[n];
		}
	}
}
