package sorting;

public class BubbleSort {

// 1. compare adjacent element
// 2. if(a[i]>a[j]), then swap
// 3. sorting starts happening from right

	public static void main(String[] args) {

		int a[] = { 4, 1, 10, -3, 12 }; // len = 5 ----> 0-4
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort1(a, a.length); // time complexity: O(n*n)
		System.out.println();
		int b[] = { 4, 1, 10, -3, 12 };
		bubbleSort.sort2(b, b.length); // time complexity: O(n)
		System.out.println();
		int c[] = { 4, 1, 10, -3, 12 };
		bubbleSort.sort3(c, c.length); // recursion time complexity: O(n*n)
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();
		int d[] = { 4, 1, 10, -3, 12 };
		bubbleSort.sort4(d, d.length); // recursion time complexity: O(n)
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i] + " ");
		}
		System.out.println();
	}

	public void sort1(int a[], int len) {
		for (int i = 0; i < a.length - 1; i++) { // 0-2
			for (int j = 0; j < a.length - i - 1; j++) { // 0-3,0-2,0-1
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public void sort2(int a[], int len) {
		for (int i = 0; i < a.length - 1; i++) { // 0-2
			boolean ifSwapped = false;
			for (int j = 0; j < a.length - i - 1; j++) { // 0-3,0-2,0-1
				if (a[j] > a[j + 1]) {
					ifSwapped = true;
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			if (!ifSwapped)
				break;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public void sort3(int a[], int len) {
		if (len == 1)
			return;
		for (int j = 0; j < len - 1; j++) {
			if (a[j] > a[j + 1]) {
				int temp = a[j];
				a[j] = a[j + 1];
				a[j + 1] = temp;
			}
		}
		sort3(a, len - 1);
	}

	public void sort4(int a[], int len) {
		if (len == 1) {
			return;
		}
		boolean isSwapped = false;
		for (int j = 0; j < len - 1; j++) {
			if (a[j] > a[j + 1]) {
				isSwapped = true;
				int temp = a[j];
				a[j] = a[j + 1];
				a[j + 1] = temp;
			}
		}
		if (isSwapped) {
			sort4(a, len - 1);
		} else {
			return;
		}
	}
}
