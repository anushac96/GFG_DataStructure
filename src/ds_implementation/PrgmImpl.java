package ds_implementation;

import java.util.Arrays;

public class PrgmImpl {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		// DynamicArray
		DynamicArray array = new DynamicArray<>();
		System.out.println("is empty : " + array.isEmpty());
		System.out.println("array is : " + array.toString());
		array.add('1');
		array.add('2');
		array.add('3');
		array.add('4');
		array.add('5');
		System.out.println("is empty : " + array.isEmpty());
		System.out.println("array is : " + array.toString());
		array.removeAt(2);
		System.out.println("removed 2nd element");
		System.out.println("array is : " + array.toString());
		array.remove('4');
		System.out.println("removed 4");
		System.out.println("array is : " + array.toString());
		System.out.println("array size is : " + array.size());
		System.out.println("does an array contains 5 : " + array.contains('5'));
		array.clear();
		System.out.println("array is : " + array.toString());
		System.out.println("array size is : " + array.size());

		int arr[] = new int[3];
		arr[0] = 1;
		System.out.println("array is : " + Arrays.toString(arr));
		System.out.println("array size is : " + arr.length);

		Integer a[] = new Integer[3];
		a[0] = 1;
		System.out.println("array is : " + Arrays.toString(a));
		System.out.println("array size is : " + a.length);

		// Singly LinkedList
	}

}
