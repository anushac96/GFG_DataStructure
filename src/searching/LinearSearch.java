package searching;

public class LinearSearch {

	public static void main(String[] args) {
		int a[] = { 10, 20, 80, 30, 60, 50, 110, 100, 130, 170 };
		int key = 110;
		LinearSearch l = new LinearSearch();
		l.search1(a, key);
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
