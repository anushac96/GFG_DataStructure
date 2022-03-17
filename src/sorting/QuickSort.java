package sorting;

public class QuickSort {

	public static void main(String[] args) {

		int a[] = { 10, 9, 8, 7, 6, 1, 2, 3, 4, 5 }; // len = 5 ----> 0-4
		QuickSort quickSort = new QuickSort();
		quickSort.sort1(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public void sort1(int a[], int low, int high) {
		if (low < high) {
			int sortedPosition = partition1(a, low, high);
			sort1(a, low, sortedPosition - 1);
			sort1(a, sortedPosition + 1, high);
		}
	}

	public int partition1(int a[], int stopAtGreater, int stopAtSmaller) {
		int pivot = (stopAtGreater + stopAtSmaller) / 2;

		while (stopAtGreater < stopAtSmaller) {
			while (a[stopAtGreater] < a[pivot]) {
				++stopAtGreater;
			}
			while (a[stopAtSmaller] > a[pivot]) {
				--stopAtSmaller;
			}
			if (stopAtGreater < stopAtSmaller) {
				int temp = a[stopAtGreater];
				a[stopAtGreater] = a[stopAtSmaller];
				a[stopAtSmaller] = temp;
			}
		}
		// int temp = a[stopAtGreater];
		// a[stopAtGreater] = a[pivot];
		// a[pivot] = temp;
		return stopAtGreater + 1;
	}
}
