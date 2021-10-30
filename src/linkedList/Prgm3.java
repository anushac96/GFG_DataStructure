package linkedList;

// Find length of loop in linked list

public class Prgm3 {

	Node headNode;

	public static void main(String[] args) {
		Prgm3 prgm3 = new Prgm3();
		prgm3.insert(1);
		prgm3.insert(2);
		prgm3.insert(3);
		prgm3.insert(4);
		prgm3.insert(5);
		prgm3.insert(6);
		prgm3.insert(7);
		prgm3.insert(8);
		prgm3.insert(9);
		prgm3.insert(10);
		prgm3.print();
		prgm3.headNode.nextNode.nextNode.nextNode.nextNode = prgm3.headNode.nextNode;
		System.out.println("number of nodes in a loop: " + prgm3.countNodeInLoop());
	}

	public int countNodeInLoop() {
		Node slowNode = headNode;
		Node fastNode = headNode;
		while (fastNode != null && fastNode.nextNode != null && fastNode.nextNode.nextNode != null) {
			fastNode = fastNode.nextNode.nextNode;
			slowNode = slowNode.nextNode;

			if (fastNode == slowNode) {
				Node tempNode = slowNode.nextNode;
				int count = 1;
				while (tempNode != slowNode) {
					tempNode = tempNode.nextNode;
					++count;
				}
				return ++count;
			}
		}
		return 0;
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
