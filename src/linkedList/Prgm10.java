package linkedList;

import java.util.HashSet;

// Intersection of two Sorted Linked Lists

public class Prgm10 {

	Node headNode1;
	Node headNode2;
	Node headNode3;
	Node headNode4;
	int count;

	public static void main(String[] args) {
		Prgm10 prgm10 = new Prgm10();
		prgm10.headNode1 = prgm10.insert(prgm10.headNode1, 1);
		prgm10.headNode1 = prgm10.insert(prgm10.headNode1, 2);
		prgm10.headNode1 = prgm10.insert(prgm10.headNode1, 3);
		prgm10.headNode1 = prgm10.insert(prgm10.headNode1, 4);
		prgm10.headNode1 = prgm10.insert(prgm10.headNode1, 6);
		System.out.println("elements in linkedlist 1");
		prgm10.print(prgm10.headNode1);
		System.out.println();
		prgm10.headNode2 = prgm10.insert(prgm10.headNode2, 2);
		prgm10.headNode2 = prgm10.insert(prgm10.headNode2, 4);
		prgm10.headNode2 = prgm10.insert(prgm10.headNode2, 6);
		prgm10.headNode2 = prgm10.insert(prgm10.headNode2, 8);
		System.out.println("elements in linkedlist 2");
		prgm10.print(prgm10.headNode2);
		System.out.println();
		// time complexity = O(size(headNode1)+size(headNode2))
		prgm10.headNode3 = prgm10.intersect(prgm10.headNode1, prgm10.headNode2, prgm10.headNode3);
		System.out.println("by using 2 pointer to compare method, elements in linkedlist 3");
		prgm10.print(prgm10.headNode3);
		System.out.println();
		// time complexity = O(size(headNode1)+size(headNode2))
		prgm10.headNode4 = prgm10.intersectHashSet(prgm10.headNode1, prgm10.headNode2, prgm10.headNode4);
		System.out.println("by using JashSet, elements in linkedlist 3");
		prgm10.print(prgm10.headNode4);
	}

	public Node intersectHashSet(Node headNode1, Node headNode2, Node headNode3) {

		Node currNode = headNode1;
		HashSet<Integer> set = new HashSet<>();
		while (currNode != null) {
			set.add(currNode.data);
			currNode = currNode.nextNode;
		}

		currNode = headNode2;
		while (set.contains(currNode.data)) {
			headNode3 = insert(headNode3, currNode.data);
			currNode = currNode.nextNode;
		}
		return headNode3;
	}

	public Node intersect(Node headNode1, Node headNode2, Node headNode3) {

		if (size(headNode1) > size(headNode2))
			headNode3 = compare(headNode2, headNode1, headNode3);
		else {
			headNode3 = compare(headNode1, headNode2, headNode3);
		}
		return headNode3;

	}

	public Node compare(Node headNode1, Node headNode2, Node headNode3) {
		Node c1 = headNode1;
		Node c2 = headNode2;
		while (c1 != null && c2 != null) {
			if (c1.data == c2.data) {
				headNode3 = insert(headNode3, c1.data);
				c1 = c1.nextNode;
				c2 = c2.nextNode;
			} else if (c1.data < c2.data) {
				c1 = c1.nextNode;
			} else {
				c2 = c2.nextNode;
			}
		}
		return headNode3;
	}

	public int size(Node headNode) {
		int count = 0;
		Node currNode = headNode;
		while (currNode.nextNode != null) {
			++count;
			currNode = currNode.nextNode;
		}
		return ++count;
	}

	public void print(Node headNode) {
		Node currNode = headNode;
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.nextNode;
		}
		System.out.println();
	}

	public Node insert(Node headNode, int data) {
		Node newNode = new Node();
		newNode.data = data;
		if (headNode == null) {
			headNode = newNode;
			++count;
			return headNode;
		} else {
			Node currNode = headNode;
			while (currNode.nextNode != null) {
				currNode = currNode.nextNode;
			}
			currNode.nextNode = newNode;
			++count;
			return headNode;
		}
	}

	class Node {
		int data;
		Node nextNode;
	}
}
