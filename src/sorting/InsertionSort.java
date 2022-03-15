package sorting;

public class InsertionSort {
// 1. start from a[1] element from left
// 2. compare that element with previous element
// 3. then compare previous element with previous-to-previous element
// 4. continue comparing till a[0] os compared with a[1]
// 5. again repeat from step 2 - step4, but instead of a[1] take a[2]
	public static void main(String[] args) {

		int a[] = { 4, 1, 10, -3, 12 }; // len = 5 ----> 0-4
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort1(a, a.length);
		System.out.println();
		int b[] = { 4, 1, 10, -3, 12 };
		insertionSort.sort2(b, b.length);

	}

	public void sort2(int a[], int len) {
		for (int i = 1; i < len; i++) { // 1-4
			int j = i;
			while (j > 0 && a[j - 1] > a[j]) {
				int temp = a[j - 1];
				a[j - 1] = a[j];
				a[j] = temp;
				--j;
				// i=1 compare(a[1],a[0])
				// i=2 compare(a[2],a[1]), compare(a[1],a[0])
				// i=3 compare(a[3],a[2]), compare(a[2],a[1]), compare(a[1],a[0])
			}
		}
		for (int i = 0; i < len; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public void sort1(int a[], int len) {
		for (int i = 1; i < len; i++) { // 1-4
			for (int j = i; j > 0; j--) {
				if (a[j - 1] > a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
				// i=1 compare(a[1],a[0])
				// i=2 compare(a[2],a[1]), compare(a[1],a[0])
				// i=3 compare(a[3],a[2]), compare(a[2],a[1]), compare(a[1],a[0])
			}
		}
		for (int i = 0; i < len; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
