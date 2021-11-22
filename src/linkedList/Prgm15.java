package linkedList;

import java.util.Stack;

// Reverse a Doubly Linked List

public class Prgm15 {

	Node headNode;
	Node tailNode;
	int size;

	public static void main(String[] args) {
		Prgm15 prgm15 = new Prgm15();
		prgm15.push(1);
		prgm15.push(2);
		prgm15.push(3);
		prgm15.push(4);
		prgm15.push(5);
		prgm15.push(6);
		prgm15.push(7);
		System.out.println("Doubly linked list before reversing");
		prgm15.print();
		System.out.println("Doubly linked list after reversing");
		// swapping from both the side till mid is reached
		prgm15.reverseBySwapping1();
		prgm15.print();
		System.out.println("Doubly linked list after reversing");
		// swapping from tail with each element till we reach head
		prgm15.reverseBySwapping2();
		prgm15.print();
		System.out.println("Doubly linked list after reversing using stack");
		// swapping from tail with each element till we reach head
		prgm15.reverseByStack();
		prgm15.print();
	}

	public void reverseByStack() {

		Stack<Node> stack = new Stack<>();
		Node currNode = headNode;
		headNode = tailNode;
		while (currNode.nextNode != null) {
			stack.push(currNode);
			currNode = currNode.nextNode;
		}

		currNode.prevNode = null;
		Node prevNode = currNode;

		while (!stack.isEmpty()) {
			currNode.nextNode = stack.peek();
			currNode = stack.pop();
			currNode.prevNode = prevNode;
			prevNode = currNode;
		}
		currNode.nextNode = null;
		tailNode = currNode;
	}

	public void reverseBySwapping2() {
		if (headNode.nextNode == null) {
			return;
		} else {
			// Stack<Node> stack = new Stack<>();
			Node currNode = tailNode;
			headNode = tailNode;
			while (currNode != null) {
				Node newnNode = currNode.prevNode;
				currNode.prevNode = currNode.nextNode;
				currNode.nextNode = newnNode;
				tailNode = currNode;
				currNode = currNode.nextNode;
			}
		}
	}

	public void reverseBySwapping1() {
		if (headNode.nextNode == null) {
			return;
		} else {
			Node fromStartNode = headNode;
			Node fromLastNode = tailNode;
			int count = 1;
			while (count != size / 2) {
				fromStartNode.data = fromLastNode.data + fromStartNode.data;
				fromLastNode.data = fromStartNode.data - fromLastNode.data;
				fromStartNode.data = fromStartNode.data - fromLastNode.data;
				fromStartNode = fromStartNode.nextNode;
				fromLastNode = fromLastNode.prevNode;
				++count;
			}
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

	public void push(int data) {
		if (headNode == null) {
			headNode = new Node(data, null, null);
			++size;
		} else {
			Node currNode = headNode;
			while (currNode.nextNode != null) {
				currNode = currNode.nextNode;
			}
			Node newNode = new Node(data, currNode, null);
			currNode.nextNode = newNode;
			tailNode = newNode;
			++size;
		}
	}

	class Node {
		int data;
		Node nextNode;
		Node prevNode;

		Node(int data, Node prev, Node next) {
			this.data = data;
			this.prevNode = prev;
			this.nextNode = next;
		}
	}
}
