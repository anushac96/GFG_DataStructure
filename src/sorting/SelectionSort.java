package sorting;

public class SelectionSort {
	
// 1. consider a[0] as min element
// 2. compare a[0] with all other elements
// 3. if(a[i]<a[0], then swap, then continue compare till a[0] is compared with all the elements
// 4. sorting starts from left
	
	public static void main(String[] args) {

		int a[] = { 4, 1, 10, -3, 12 }; // len = 5 ----> 0-4
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.sort1(a, a.length);
	}

	public void sort1(int a[], int len) {
		for(int i=0;i<len-2;i++) {	//0-2
			for(int j=i+1;j<len;j++) {	//1-4, 2-4, 3-4
				if(a[j]<a[i]) {
					int temp = a[i];
					a[i]= a[j];
					a[j]= temp ;
				}
			}
		}
		for(int i =0;i<len;i++) {
			System.out.print(a[i]+" ");
		}
	}
}
