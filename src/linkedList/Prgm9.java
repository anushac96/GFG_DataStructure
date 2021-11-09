package linkedList;

// Move last element to front of a given Linked List

public class Prgm9 {

	Node headNode;

	public static void main(String[] args) {
		Prgm9 prgm9 = new Prgm9();
		prgm9.insert(1);
		prgm9.insert(2);
		prgm9.insert(3);
		prgm9.insert(4);
		prgm9.insert(5);
		prgm9.insert(6);
		prgm9.insert(7);
		System.out.println("LinkedList before swapping");
		prgm9.print();
		System.out.println("LinkedList after swapping");
		prgm9.swap();
		prgm9.print();
	}

	public void swap() {

		// find last element
		if (headNode == null || headNode.nextNode == null) {
			return;
		} else {
			Node currNode = headNode;
			Node prevNode = null;
			while (currNode.nextNode != null) {
				prevNode = currNode;
				currNode = currNode.nextNode;
			}
			prevNode.nextNode = null;
			currNode.nextNode = headNode;
			headNode = currNode;
		}
	}

	public void print() {
		Node currNode = headNode;
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.nextNode;
		}
		System.out.println();
	}

	public void insert(int data) {
		Node newNode = new Node();
		newNode.data = data;
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
		int data;
		Node nextNode;
	}
}
