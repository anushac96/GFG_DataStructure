package linkedList;

// Swap nodes in a linked list without swapping data

public class Prgm7 {

	Node headNode;

	public static void main(String[] args) {
		Prgm7 prgm7 = new Prgm7();
		prgm7.insert(1);
		prgm7.insert(2);
		prgm7.insert(3);
		prgm7.insert(4);
		prgm7.insert(5);
		prgm7.insert(6);
		prgm7.insert(7);
		System.out.println("linkedlist before swapping:");
		prgm7.print();
		System.out.println("swap 1 and 7");
		prgm7.swap(1, 7);
		prgm7.print();
		System.out.println("swap 7 and 1");
		prgm7.swap(7, 1);
		prgm7.print();
		System.out.println("swap 3 and 6");
		prgm7.swap(3, 6);
		prgm7.print();
		System.out.println("swap 1 and 1");
		prgm7.swap(1, 1);
		prgm7.print();
	}

	public void swap(int a, int b) {
		Node a_Curr_Node = headNode;
		Node b_Curr_Node = headNode;
		Node a_Prev_Node = null;
		Node b_Prev_Node = null;

		while (a_Curr_Node != null && a_Curr_Node.data != a) {
			a_Prev_Node = a_Curr_Node;
			a_Curr_Node = a_Curr_Node.nextNode;
		}

		while (b_Curr_Node != null && b_Curr_Node.data != b) {
			b_Prev_Node = b_Curr_Node;
			b_Curr_Node = b_Curr_Node.nextNode;
		}
		if (a_Curr_Node == b_Curr_Node)
			return;
		else if (a_Curr_Node != null && b_Curr_Node != null) {
			if (a_Prev_Node == null || b_Prev_Node == null) {
				try {
					b_Prev_Node.nextNode = a_Curr_Node;
					Node tempNode = b_Curr_Node.nextNode;
					b_Curr_Node.nextNode = a_Curr_Node.nextNode;
					a_Curr_Node.nextNode = tempNode;
					headNode = b_Curr_Node;
				} catch (Exception e) {
					a_Prev_Node.nextNode = b_Curr_Node;
					Node tempNode = a_Curr_Node.nextNode;
					a_Curr_Node.nextNode = b_Curr_Node.nextNode;
					b_Curr_Node.nextNode = tempNode;
					headNode = a_Curr_Node;
				}
			} else {
				b_Prev_Node.nextNode = a_Curr_Node;
				Node tempNode = b_Curr_Node.nextNode;
				b_Curr_Node.nextNode = a_Curr_Node.nextNode;
				a_Curr_Node.nextNode = tempNode;
				a_Prev_Node.nextNode = b_Curr_Node;
			}
		} else {
			System.out.println("element is not in the list");
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
		newNode.nextNode = null;
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
