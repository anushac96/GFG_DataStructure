package linkedList;

import java.util.HashSet;

// Detect loop in a linked list

public class Prgm2 {

	Node headNode;
	NodeFlag headNodeFlag;

	public static void main(String[] args) {
		Prgm2 prgm2 = new Prgm2();
		prgm2.insert(1);
		prgm2.insert(2);
		prgm2.insert(3);
		prgm2.insert(4);
		prgm2.insert(5);
		prgm2.insert(6);
		prgm2.insert(7);
		prgm2.insert(8);
		prgm2.insert(9);
		prgm2.insert(10);
		prgm2.print();
		System.out.println("is linked list having loop: " + prgm2.usingHashMap());
		// creating loop
		prgm2.headNode.nextNode.nextNode.nextNode.nextNode = prgm2.headNode;
		System.out.println("after creating loop");
		System.out.println("is linked list having loop: " + prgm2.usingHashMap());
		System.out.println();
		System.out.println("is linked list having loop: " + prgm2.usingFlag());
		// creating loop
		prgm2.headNodeFlag.nextNode.nextNode.nextNode.nextNode = prgm2.headNodeFlag;
		System.out.println("after creating loop");
		System.out.println("is linked list having loop: " + prgm2.checkLoop());
		System.out.println();
		// using Floyd’s Cycle-Finding Algorithm
		System.out.println("using Floyd Algo is linked list having loop: " + prgm2.usingFloydAlgo());

	}

	private boolean usingFloydAlgo() {
		if (headNode == null) {
			return false;
		} else {
			Node slowNode = headNode;
			Node fastNode = headNode;
			while (fastNode.nextNode != null && fastNode.nextNode.nextNode != null) {
				fastNode = fastNode.nextNode.nextNode;
				slowNode = slowNode.nextNode;
				if (fastNode == slowNode) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean usingFlag() {
		insertWithFlag(1);
		insertWithFlag(2);
		insertWithFlag(3);
		insertWithFlag(4);
		insertWithFlag(5);
		insertWithFlag(6);
		insertWithFlag(7);
		insertWithFlag(8);
		insertWithFlag(9);
		insertWithFlag(10);
		printNodeFlag();
		return checkLoop();
	}

	private boolean checkLoop() {
		if (headNodeFlag == null) {
			return false;
		} else {
			NodeFlag curNodeFlag = headNodeFlag;
			while (curNodeFlag != null) {
				if (curNodeFlag.flag == 1) {
					return true;
				} else {
					curNodeFlag.flag = 1;
					curNodeFlag = curNodeFlag.nextNode;
				}
			}
			return false;
		}
	}

	public void printNodeFlag() {
		if (headNodeFlag == null) {
			System.out.println("list is empty");
		} else {
			NodeFlag curNodeFlag = headNodeFlag;
			while (curNodeFlag != null) {
				System.out.print(curNodeFlag.data + " ");
				curNodeFlag = curNodeFlag.nextNode;
			}
			System.out.println();
		}
	}

	public void insertWithFlag(int data) {
		NodeFlag newNodeFlag = new NodeFlag(data);
		if (headNodeFlag == null) {
			headNodeFlag = newNodeFlag;
		} else {
			NodeFlag curNode = headNodeFlag;
			while (curNode.nextNode != null) {
				curNode = curNode.nextNode;
			}
			curNode.nextNode = newNodeFlag;
		}

	}

	public boolean usingHashMap() {
		HashSet<Node> hashSet = new HashSet<>();
		if (headNode == null) {
			return false;
		} else {
			Node curNode = headNode;
			while (curNode != null) {
				if (hashSet.contains(curNode))
					return true;
				else {
					hashSet.add(curNode);
					curNode = curNode.nextNode;
				}
			}
			return false;
		}
	}

	public void print() {
		if (headNode == null) {
			System.out.println("list is empty");
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
		Node newnNode = new Node(data);
		if (headNode == null) {
			headNode = newnNode;
		} else {
			Node currNode = headNode;
			while (currNode.nextNode != null) {
				currNode = currNode.nextNode;
			}
			currNode.nextNode = newnNode;
		}
	}

	public class Node {
		int data;
		Node nextNode;

		Node(int d) {
			this.data = d;
			this.nextNode = null;
		}
	}

	public class NodeFlag {
		int data;
		NodeFlag nextNode;
		int flag;

		NodeFlag(int d) {
			this.data = d;
			this.nextNode = null;
			this.flag = 0;
		}
	}
}
