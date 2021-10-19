package ds_implementation;

public class SinglyLinkedList<T> {

	Node headNode;
	int size = 0;

	public class Node {
		T data;
		Node nextNode;

		public Node(T d) {
			data = d;
			nextNode = null;
		}
	}

	public void insertFirst(T data) {
		Node newNode = new Node(data);
		newNode.nextNode = headNode;
		headNode = newNode;
		++size;
	}

	public void insertLast(T data) {
		Node newNode = new Node(data);
		if (headNode == null) {
			headNode = newNode;
			++size;
		} else {
			Node currentNode = headNode;
			while (currentNode.nextNode != null) {
				currentNode = currentNode.nextNode;
			}
			currentNode.nextNode = newNode;
			++size;
		}
	}

	public void clear() {
		if (headNode == null) {
			System.out.println("No elements to clear");
		} else {
			Node currentNode = headNode;
			Node nextNode = headNode.nextNode;
			while (currentNode.nextNode != null) {
				currentNode.data = null;
				nextNode = currentNode.nextNode;
				currentNode.nextNode = null;
				currentNode = nextNode;
				--size;
			}
			headNode = currentNode = null;
			--size;
		}
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(T data) {
		insertLast(data);
	}

	public void add(int index, T data) {
		insertAt(index, data);
	}

	public void insertAt(int index, T data) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			Node newNode = new Node(data);
			int count = 0;
			Node currentNode = headNode;
			while (currentNode.nextNode != null) {
				if (count + 1 == index) {
					Node nextNode = currentNode.nextNode;
					currentNode.nextNode = newNode;
					newNode.nextNode = nextNode;
					++size;
					break;
				} else {
					currentNode = currentNode.nextNode;
					++count;
				}
			}
		}
	}

	public void deletefirst() {
		if (headNode == null) {
			System.out.println("no element to delete");
		} else {
			Node currNode = headNode.nextNode;
			headNode.data = null;
			headNode.nextNode = null;
			headNode = currNode;
			--size;
		}
	}

	public void deleteLast() {
		if (headNode == null) {
			System.out.println("No element to delete");
		}
		if (headNode.nextNode == null) {
			headNode = null;
			--size;
		} else {
			Node secondLastNode = headNode;
			while (secondLastNode.nextNode.nextNode != null) {
				secondLastNode = secondLastNode.nextNode;
			}
			secondLastNode.nextNode = null;
			--size;
		}
	}

	public void show() {
		if (headNode == null) {
			System.out.println("No element");
		} else {
			Node currentNode = headNode;
			while (currentNode.nextNode != null) {
				System.out.println(currentNode.data);
				currentNode = currentNode.nextNode;
			}
			System.out.println(currentNode.data);
		}
	}
}
