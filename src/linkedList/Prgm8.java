package linkedList;

// Pairwise swap elements of a given linked list

public class Prgm8 {

	Node headNode;

	public static void main(String[] args) {
		Prgm8 prgm8 = new Prgm8();
		prgm8.insert(1);
		prgm8.insert(2);
		prgm8.insert(3);
		prgm8.insert(4);
		prgm8.insert(5);
		prgm8.insert(6);
		prgm8.insert(7);
		System.out.println("linkedlist before swapping");
		prgm8.print();
		System.out.println("linkedlist after pair swapping");
		prgm8.pairSwapping();
		prgm8.print();
	}

	public void pairSwapping() {
		Node currNode = headNode;
		Node prevNode = currNode;
		if (currNode == null || currNode.nextNode == null) {
			return;
		} else {
			currNode = currNode.nextNode;
			swap(currNode, prevNode);
			headNode = currNode;
			while (prevNode.nextNode != null && prevNode.nextNode.nextNode != null) {
				Node connectNode = prevNode;
				prevNode = prevNode.nextNode;
				currNode = prevNode.nextNode;
				swap(currNode, prevNode);
				connectNode.nextNode = currNode;
			}
		}
	}

	public void swap(Node currNode, Node prevNode) {
		Node tempNode = currNode.nextNode;
		currNode.nextNode = prevNode;
		prevNode.nextNode = tempNode;
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
