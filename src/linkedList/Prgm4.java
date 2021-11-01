package linkedList;

import java.util.HashSet;

// Detect and Remove Loop in a Linked List

public class Prgm4 {

	Node headNode;

	public static void main(String[] args) {
		Prgm4 prgm4 = new Prgm4();
		prgm4.insert(1);
		prgm4.insert(2);
		prgm4.insert(3);
		prgm4.insert(4);
		prgm4.insert(5);
		prgm4.insert(6);
		prgm4.insert(7);
		prgm4.insert(8);
		prgm4.insert(9);
		prgm4.insert(10);
		prgm4.print();
		System.out.println("is a loop: " + prgm4.isLoop());
		System.out.println("creating loop: 1 2 3 4 5 6 7 3 4 5 6 7 3  ....");
		// prgm4.headNode.nextNode.nextNode.nextNode.nextNode.nextNode =
		// prgm4.headNode.nextNode;
		prgm4.headNode.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode = prgm4.headNode.nextNode.nextNode;
		// prgm4.print();
		System.out.println("is a loop: " + prgm4.isLoop());
		System.out.println("removing loop using Floyd Algo");
		prgm4.removeLoopByFloydAlgo();
		prgm4.print();
		System.out.println("is a loop: " + prgm4.isLoop());

		System.out.println("creating loop: 1 2 3 4 5 6 7 3 4 5 6 7 3  ....");
		prgm4.headNode.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode = prgm4.headNode.nextNode.nextNode;
		// prgm4.print();
		System.out.println("is a loop: " + prgm4.isLoop());
		System.out.println("removing loop using HashSet");
		prgm4.removeLoopByHashSet();
		prgm4.print();
		System.out.println("is a loop: " + prgm4.isLoop());
	}

	public void removeLoopByHashSet() {
		HashSet<Node> hashSet = new HashSet<>();
		Node currNode = headNode;
		while (true) {
			if (hashSet.contains(currNode.nextNode)) {
				currNode.nextNode = null;
				return;
			} else {
				hashSet.add(currNode);
				currNode = currNode.nextNode;
			}
		}
	}

	public void removeLoopByFloydAlgo() {
		Node slowNode = headNode;
		Node fastNode = headNode;
		while (fastNode.nextNode != null && fastNode.nextNode.nextNode != null) {
			slowNode = slowNode.nextNode;
			fastNode = fastNode.nextNode.nextNode;
			if (fastNode == slowNode) {
				slowNode = headNode;
				while (slowNode != fastNode) {
					slowNode = slowNode.nextNode;
					fastNode = fastNode.nextNode;
				}
				while (fastNode.nextNode != slowNode) {
					fastNode = fastNode.nextNode;
				}
				fastNode.nextNode = null;
			}
		}
	}

	public boolean isLoop() {
		if (headNode == null) {
			return false;
		} else {

			Node slowNode = headNode;
			Node fastNode = headNode;
			while (fastNode.nextNode != null && fastNode.nextNode.nextNode != null) {
				slowNode = slowNode.nextNode;
				fastNode = fastNode.nextNode.nextNode;

				if (fastNode == slowNode)
					return true;
			}
		}
		return false;
	}

	public void print() {
		if (headNode == null) {
			System.out.println("no element");
		} else {
			Node curNode = headNode;
			while (curNode != null) {
				System.out.print(curNode.data + " ");
				curNode = curNode.nextNode;
			}
			System.out.println();
		}
	}

	public void insert(int d) {
		Node newNode = new Node(d);
		if (headNode == null) {
			headNode = newNode;
		} else {
			Node curNode = headNode;
			while (curNode.nextNode != null) {
				curNode = curNode.nextNode;
			}
			curNode.nextNode = newNode;
		}
	}

	public class Node {
		int data;
		Node nextNode;

		public Node(int d) {
			this.data = d;
			this.nextNode = null;
		}
	}
}
