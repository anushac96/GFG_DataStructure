package linkedList;

// Segregate even and odd nodes in a Linked List

public class Prgm12 {

	Node headNode;

	public static void main(String[] args) {
		Prgm12 prgm12 = new Prgm12();
		prgm12.insert(1);
		prgm12.insert(2);
		prgm12.insert(3);
		prgm12.insert(4);
		prgm12.insert(5);
		prgm12.insert(6);
		prgm12.insert(7);
		System.out.println("elements in the linkedlist are: ");
		prgm12.print();
		prgm12.segregate();	// time complexity = O(n)
		prgm12.print();

	}

	public void segregate() {
		Node oddNode = headNode;
		// Node evenNode = headNode;
		Node prevOddNode = null;
		// Node prevEvenNode = null;
		Node tailNode = headNode;
		int count = 0;

		while (tailNode.nextNode != null) {
			tailNode = tailNode.nextNode;
			++count;
		}
		++count;
		Node stopNode = tailNode;
		// Node currNode = headNode;

		while (count != 0) {
			if (prevOddNode == null) {
				if (oddNode.data % 2 != 0) {
					headNode = headNode.nextNode;
					tailNode.nextNode = oddNode;
					oddNode.nextNode = null;
					oddNode = headNode;
					tailNode = tailNode.nextNode;
				} else {
					prevOddNode = oddNode;
					oddNode = oddNode.nextNode;
				}
			} else {
				if (oddNode.data % 2 != 0) {
					prevOddNode.nextNode = oddNode.nextNode;
					tailNode.nextNode = oddNode;
					oddNode.nextNode = null;
					tailNode = tailNode.nextNode;
					oddNode = prevOddNode.nextNode;
				} else {
					prevOddNode = oddNode;
					oddNode = oddNode.nextNode;
				}
			}
			--count;
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

	public void insert(int d) {
		Node newNode = new Node(d);
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

		Node(int d) {
			data = d;
			nextNode = null;
		}
	}
}
