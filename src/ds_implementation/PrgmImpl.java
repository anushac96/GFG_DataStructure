package ds_implementation;

import java.util.Arrays;

public class PrgmImpl {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		// DynamicArray
		System.out.println("//////// ARRAYS ////////");
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
		System.out.println();
		System.out.println();

		// Singly LinkedList
		System.out.println("//////// SINGLY LINKED LIST ////////");
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		System.out.println("inserting element at head");
		singlyLinkedList.insertFirst(0);
		singlyLinkedList.insertFirst(1);
		singlyLinkedList.insertFirst(2);
		singlyLinkedList.insertFirst(3);
		System.out.println("before clearing data ");
		System.out.println("Elements in the singly linked list are:");
		singlyLinkedList.show();
		System.out.println("Size of linked list: " + singlyLinkedList.getSize());
		System.out.println("is linked list empty? " + singlyLinkedList.isEmpty());
		singlyLinkedList.clear();
		System.out.println();
		System.out.println("after clearing data ");
		System.out.println();
		System.out.println("Elements in the singly linked list are:");
		singlyLinkedList.show();
		System.out.println("Size of linked list: " + singlyLinkedList.getSize());
		System.out.println("is linked list empty? " + singlyLinkedList.isEmpty());
		System.out.println();
		System.out.println("inserting element at tail");
		singlyLinkedList.insertLast(0);
		singlyLinkedList.insertLast(1);
		singlyLinkedList.insertLast(2);
		singlyLinkedList.insertLast(3);
		singlyLinkedList.show();
		System.out.println("Size of linked list: " + singlyLinkedList.getSize());
		System.out.println();
		System.out.println("insert 0.5 in 1st index");
		singlyLinkedList.add(1, 0.5);
		singlyLinkedList.show();
		System.out.println("Size of linked list: " + singlyLinkedList.getSize());
		System.out.println("insert 2.5 in last index");
		singlyLinkedList.add(4, 2.5);
		singlyLinkedList.show();
		System.out.println("Size of linked list: " + singlyLinkedList.getSize());
		System.out.println("delete from first");
		singlyLinkedList.deletefirst();
		singlyLinkedList.show();
		System.out.println("delete from last");
		singlyLinkedList.deleteLast();
		singlyLinkedList.show();
		System.out.println();
		System.out.println();

		// Doubly LinkedList
		System.out.println("//////// DOUBLY LINKED LIST ////////");
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		System.out.println("inserting element at head");
		doublyLinkedList.insertFirst(0);
		doublyLinkedList.insertFirst(1);
		doublyLinkedList.insertFirst(2);
		doublyLinkedList.insertFirst(3);
		System.out.println("Elements in the singly linked list are:");
		doublyLinkedList.show();
		System.out.println("Size of linked list: " + doublyLinkedList.getSize());
		System.out.println("is linked list empty? " + doublyLinkedList.isEmpty());
		System.out.println();
		doublyLinkedList.clear();
		System.out.println();
		System.out.println("after clearing data ");
		System.out.println();
		System.out.println("Elements in the singly linked list are:");
		doublyLinkedList.show();
		System.out.println("Size of linked list: " + doublyLinkedList.getSize());
		System.out.println("is linked list empty? " + doublyLinkedList.isEmpty());
		System.out.println();
		System.out.println("inserting element at tail");
		doublyLinkedList.insertLast(0);
		doublyLinkedList.insertLast(1);
		doublyLinkedList.insertLast(2);
		doublyLinkedList.insertLast(3);
		System.out.println("Elements in the doubly linked list are:");
		doublyLinkedList.show();
		System.out.println("Size of linked list: " + doublyLinkedList.getSize());
		System.out.println();
		System.out.println("insert 0.5 in 1st index");
		doublyLinkedList.addAt(1, 0.5);
		doublyLinkedList.show();
		System.out.println("Size of linked list: " + doublyLinkedList.getSize());
		System.out.println("insert 2.5 in last index");
		doublyLinkedList.addAt(4, 2.5);
		doublyLinkedList.show();
		System.out.println("Size of linked list: " + doublyLinkedList.getSize());
		System.out.println("delete from first");
		doublyLinkedList.deletefirst();
		doublyLinkedList.show();
		System.out.println("delete from last");
		doublyLinkedList.deleteLast();
		doublyLinkedList.show();
		// System.out.println();
		// System.out.println();

	}

}
