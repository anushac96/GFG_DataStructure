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

		// TODO: use this constructor to be more optimal
		public Node(T d, Node pNode, Node nNode) {
			this.data = d;
			this.prevNode = pNode;
			this.nextNode = nNode;

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

	public void remove(T data) {
		Node currNode = headNode;
		if (currNode == null) {
			System.out.println("linked linst is empty");
		} else {
			while (currNode != null) {
				if (!currNode.data.equals(data))
					currNode = currNode.nextNode;
				else {
					Node prevNode = currNode.prevNode;
					Node nextNode = currNode.nextNode;
					if (prevNode == null) {
						nextNode.prevNode = null;
						headNode = nextNode;
					} else if (nextNode == null) {
						prevNode.nextNode = null;
						tailNode = prevNode;
					} else {
						prevNode.nextNode = nextNode;
						nextNode.prevNode = prevNode;
					}
					--size;
					return;
				}
			}
			System.out.println("element not found");

		}
	}

	public void removeAt(int index) {
		Node currNode = headNode;
		int count = 1;
		if (index < 0 || index > getSize()) {
			System.out.println("index out of bound");
		} else if (currNode == null) {
			System.out.println("linked linst is empty");
		} else {
			while (count != index) {
				currNode = currNode.nextNode;
				++count;
			}
			Node prevNode = currNode.prevNode;
			Node nextNode = currNode.nextNode;
			if (prevNode == null) {
				nextNode.prevNode = null;
				headNode = nextNode;
			} else if (nextNode == null) {
				prevNode.nextNode = null;
				tailNode = prevNode;
			} else {
				prevNode.nextNode = nextNode;
				nextNode.prevNode = prevNode;
			}
			--size;
		}
	}

	public int indexOf(T data) {
		Node currNode = headNode;
		int count = 0;
		if (currNode == null) {
			System.out.println("linked linst is empty");
		} else {
			while (currNode != null) {
				if (currNode.data.equals(data)) {
					return ++count;
				} else {
					currNode = currNode.nextNode;
					++count;
				}
			}
		}
		return -1;
	}

	public boolean contains(T data) {
		Node currNode = headNode;
		if (currNode == null) {
			System.out.println("linked linst is empty");
		} else {
			while (currNode != null) {
				if (currNode.data.equals(data)) {
					return true;
				}
				currNode = currNode.nextNode;
			}
		}
		return false;
	}

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

			// TODO: check if index > or < that size/2 to reduce time complexity
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

	// TODO: try by implementing Iterator
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
