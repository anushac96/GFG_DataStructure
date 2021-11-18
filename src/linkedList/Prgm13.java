package linkedList;

import java.util.Stack;

// Reverse a linked list

public class Prgm13 {
	static Node headNode;

	public static void main(String[] args) {

		Prgm13 prgm13 = new Prgm13();
		headNode = new Node(1);
		headNode.nextNode = new Node(2);
		headNode.nextNode.nextNode = new Node(3);
		headNode.nextNode.nextNode.nextNode = new Node(4);
		headNode.nextNode.nextNode.nextNode.nextNode = new Node(5);
		headNode.nextNode.nextNode.nextNode.nextNode.nextNode = new Node(6);
		headNode.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode = new Node(7);
		System.out.println("elements in linkedlist");
		prgm13.print();
		System.out.println("elements in linkedlinst after reversing using Iterative Method");
		// Time Complexity: O(n)
		// Space Complexity: O(1)
		prgm13.reverse();
		prgm13.print();
		System.out.println("elements in linkedlinst after reversing using Stack ");
		// Time Complexity: O(n)
		// Space Complexity: O(n)
		prgm13.reverseUsingStack();
		prgm13.print();
		System.out.println("elements in linkedlinst after reversing using Array ");
		// Time Complexity: O(n)
		// Space Complexity: O(n)
		prgm13.reverseUsingArray();
		prgm13.print();
	}

	public void reverseUsingArray() {
		Node currNode = headNode;
		int length = 0;
		while (currNode != null) {
			++length;
			currNode = currNode.nextNode;
		}
		currNode = headNode;
		Node arr[] = new Node[length - 1];
		int i = 0;
		while (currNode.nextNode != null) {
			arr[i++] = currNode;
			currNode = currNode.nextNode;
		}
		headNode = currNode;
		--i;
		while (i >= 0) {
			currNode.nextNode = arr[i--];
			currNode = currNode.nextNode;
		}
		currNode.nextNode = null;
	}

	public void reverseUsingStack() {
		Node currNode = headNode;
		Stack<Node> stack = new Stack<>();
		while (currNode.nextNode != null) {
			stack.add(currNode);
			currNode = currNode.nextNode;
		}
		headNode = currNode;
		while (!stack.isEmpty()) {
			currNode.nextNode = stack.peek();
			stack.pop();
			currNode = currNode.nextNode;
		}
		currNode.nextNode = null;
	}

	public void reverse() {
		Node prevNode = null;
		Node currNode = headNode;
		Node nextNode;
		while (currNode != null) {
			nextNode = currNode.nextNode;
			currNode.nextNode = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		headNode = prevNode;
	}

	public void print() {
		Node currNode = headNode;
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.nextNode;
		}
		System.out.println();
	}

	static class Node {
		int data;
		Node nextNode;

		Node(int d) {
			this.data = d;
			this.nextNode = null;
		}
	}
}
