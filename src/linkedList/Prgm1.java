package linkedList;

// Find the middle of a given linked list

public class Prgm1 {
	Node headNode;

	public static void main(String[] args) {

		Prgm1 prgm1 = new Prgm1();
		prgm1.insert(1);
		prgm1.insert(2);
		prgm1.insert(3);
		prgm1.insert(4);
		prgm1.insert(5);
		prgm1.insert(6);
		prgm1.insert(7);
		prgm1.insert(8);
		prgm1.insert(9);
		prgm1.insert(10);
		prgm1.print();
		System.out.println("mid element is: " + prgm1.findMid());

	}

	private int findMid() {
		// if (headNode == null) {
		// System.out.println("no element to find mid");
		// return -1;
		// } else if (headNode.nextNode == null || headNode.nextNode.nextNode == null) {
		// return headNode.data;
		// } else {
		// Node midNode = headNode.nextNode;
		// Node tailNode = headNode.nextNode.nextNode;
		// while (tailNode.nextNode != null && tailNode.nextNode.nextNode != null) {
		// midNode = midNode.nextNode;
		// tailNode = tailNode.nextNode.nextNode;
		// }
		// return midNode.data;
		// }

		// updated
		if (headNode == null) {
			return -1;
		} else {
			Node fastNode = headNode;
			Node slowNode = headNode;

			while (fastNode.nextNode != null && fastNode.nextNode.nextNode != null) {
				fastNode = fastNode.nextNode.nextNode;
				slowNode = slowNode.nextNode;
			}
			return slowNode.data;
		}

		// or

		// Node midNode = headNode;
		// Node tailNode = headNode;
		// while (tailNode != null && tailNode.nextNode != null) {
		// midNode = midNode.nextNode;
		// tailNode = tailNode.nextNode.nextNode;
		// }
		// return midNode.data;
	}

	private void print() {
		if (headNode == null) {
			System.out.println("no element to print, list is empty");
		} else {
			Node curNode = headNode;
			while (curNode.nextNode != null) {
				System.out.print(curNode.data + " ");
				curNode = curNode.nextNode;
			}
			System.out.println(curNode.data + " ");
		}
	}

	public void insert(int data) {
		Node newNode = new Node(data);
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
			data = d;
			nextNode = null;
		}
	}
}
