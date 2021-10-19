package ds_implementation;

public class DoublyLinkedList<T> {
	int size;
	Node headNode;
	Node tailNode;

	public class Node {
		T data;
		Node prevNode;
		Node nextNode;

		public Node(T d) {
			data = d;
		}
	}

	public void insertFirst(T data) {
		Node newNode = new Node(data);
		if (headNode == null) {
			tailNode = headNode = newNode;
			++size;
		} else if (tailNode == headNode) {
			headNode = newNode;
			headNode.nextNode = tailNode;
			tailNode.prevNode = headNode;
			++size;
		} else {
			newNode.nextNode = headNode;
			headNode.prevNode = newNode;
			headNode = newNode;
			++size;
		}
	}

	public void insertLast(T data) {
		Node newNode = new Node(data);
		if (headNode == null) {
			tailNode = headNode = newNode;
			++size;
		} else if (tailNode == headNode) {
			tailNode = newNode;
			headNode.nextNode = tailNode;
			tailNode.prevNode = headNode;
			++size;
		} else {
			tailNode.nextNode = newNode;
			newNode.prevNode = tailNode;
			tailNode = newNode;
			++size;
		}
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		if (headNode == null && tailNode == null) {
			System.out.println("No elements to clear");
		} else if (headNode == tailNode) {
			headNode = tailNode = null;
			--size;
		} else {
			Node currNode = headNode;
			while (currNode != tailNode) {
				Node nextNode = currNode.nextNode;
				currNode.data = null;
				currNode.nextNode = null;
				currNode.prevNode = null;
				currNode = nextNode;
				nextNode = currNode.nextNode;
				--size;
			}
			headNode = currNode = null;
			--size;
		}
	}

	// TODO: remove(node)

	public void deletefirst() {
		if (headNode == null) {
			System.out.println("no element to delete");
		} else {
			Node currNode = headNode.nextNode;
			headNode.data = null;
			headNode.nextNode = null;
			currNode.prevNode = null;
			headNode = currNode;
			--size;
		}
	}

	public void deleteLast() {
		if (headNode == null) {
			System.out.println("No element to delete");
		} else {
			Node secondLastNode = headNode;
			while (secondLastNode.nextNode.nextNode != null) {
				secondLastNode = secondLastNode.nextNode;
			}
			secondLastNode.nextNode = null;
			tailNode = secondLastNode;
			--size;
		}
	}

	public void addAt(int index, T data) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			int count = 0;
			Node prevNode = headNode;
			Node newNode = new Node(data);
			Node nextNode = headNode.nextNode;
			while ((count + 1) != index) {
				prevNode = nextNode;
				nextNode = nextNode.nextNode;
				++count;
			}
			prevNode.nextNode = newNode;
			newNode.prevNode = prevNode;
			nextNode.prevNode = newNode;
			newNode.nextNode = nextNode;
			++size;
		}
	}

	public void show() {
		if (headNode == null) {
			System.out.println("no element");
		} else {
			Node currNode = headNode;
			while (currNode != tailNode) {
				System.out.println(currNode.data);
				currNode = currNode.nextNode;
			}
			System.out.println(currNode.data);
		}
	}
}
