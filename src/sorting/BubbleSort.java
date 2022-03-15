package sorting;

public class BubbleSort {
	
// 1. compare adjacent element
// 2. if(a[i]>a[j]), then swap
// 3. sorting starts happening from right
	
	public static void main(String[] args) {

		int a[] = { 4, 1, 10, -3, 12 }; // len = 5 ----> 0-4
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort1(a, a.length);
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
}
