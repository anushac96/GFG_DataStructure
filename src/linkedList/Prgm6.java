package linkedList;

import java.util.HashSet;
import java.util.LinkedList;

// Remove duplicates from a sorted linked list
// Remove duplicates from an unsorted linked list

public class Prgm6 {
	Node headNode;

	public static void main(String[] args) {
		LinkedList<Integer> linkedList1 = new LinkedList<>();
		Prgm6 prgm6 = new Prgm6();
		linkedList1.add(1);
		linkedList1.add(2);
		linkedList1.add(2);
		linkedList1.add(2);
		linkedList1.add(5);
		linkedList1.add(6);
		linkedList1.add(6);
		linkedList1.add(6);
		System.out.println("///////// Using built-in linked list /////////");
		System.out.println("Before removing duplicates: " + linkedList1.toString());
		// Time Complexity: O(n)
		prgm6.removeDuplicates1(linkedList1);
		System.out.println("After removing duplicates: " + linkedList1.toString());

		System.out.println();

		prgm6.push(1);
		prgm6.push(2);
		prgm6.push(2);
		prgm6.push(2);
		prgm6.push(5);
		prgm6.push(6);
		prgm6.push(6);
		prgm6.push(6);
		prgm6.push(6);
		System.out.println("///////// Using created linked list /////////");
		System.out.println("Before removing duplicates: ");
		prgm6.print();
		// Time Complexity: O(n)
		prgm6.removeDuplicates1(linkedList1);
		System.out.println("After removing duplicates: ");
		prgm6.removeDuplicates2();
		prgm6.print();

		System.out.println();

		prgm6.headNode = null;
		prgm6.push(1);
		prgm6.push(2);
		prgm6.push(2);
		prgm6.push(2);
		prgm6.push(5);
		prgm6.push(6);
		prgm6.push(6);
		prgm6.push(6);
		prgm6.push(6);
		prgm6.push(1);
		prgm6.push(1);
		prgm6.push(1);
		System.out.println("///////// Using HashMap /////////");
		System.out.println("Before removing duplicates: ");
		prgm6.print();
		// Time Complexity: O(n)
		prgm6.removeDuplicates3();
		System.out.println("After removing duplicates: ");
		prgm6.print();
	}

	public void removeDuplicates3() {
		Node currNode = headNode.nextNode;
		Node prevNode = headNode;
		HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(prevNode.dataNode);
		while (currNode != null) {
			if (hashSet.contains(currNode.dataNode)) {
				prevNode.nextNode = currNode.nextNode;
				currNode = currNode.nextNode;
			} else {
				hashSet.add(currNode.dataNode);
				currNode = currNode.nextNode;
				prevNode = prevNode.nextNode;
			}
		}
	}

	public void removeDuplicates2() {
		Node currNode = headNode;
		Node nextNode = headNode.nextNode;
		while (nextNode != null) {
			if (currNode.dataNode == nextNode.dataNode) {
				currNode.nextNode = nextNode.nextNode;
				nextNode = currNode.nextNode;
			} else {
				currNode = currNode.nextNode;
				nextNode = nextNode.nextNode;
			}
		}
	}

	public void print() {
		Node currNode = headNode;
		while (currNode != null) {
			System.out.print(currNode.dataNode + " ");
			currNode = currNode.nextNode;
		}
		System.out.println();
	}

	public void push(int data) {
		Node newNode = new Node();
		newNode.dataNode = data;
		newNode.nextNode = null;
		if (headNode == null) {
			headNode = newNode;
		} else {
			Node currNode = headNode;
			while (currNode.nextNode != null) {
				currNode = currNode.nextNode;
			}
			currNode.nextNode = newNode;
		}
	}

	class Node {
		int dataNode;
		Node nextNode;
	}

	public void removeDuplicates1(LinkedList<Integer> linkedList) {
		int i = 0;
		while (i + 1 < linkedList.size()) {
			if (linkedList.get(i) != linkedList.get(i + 1))
				++i;
			else
				linkedList.remove(i + 1);
		}
	}

}
