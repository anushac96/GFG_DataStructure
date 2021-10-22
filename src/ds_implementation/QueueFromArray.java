package ds_implementation;

public class QueueFromArray {

	static final int MAX = 1000;
	Object a[] = new Object[MAX];

	int front = -1;
	int end = -1;
	int size = 0;

	public void enqueue(Object object) {
		if (front == -1) {
			a[++front] = object;
			++end;
			++size;
		} else {
			a[++end] = object;
			++size;
		}
	}

	public void dequeue() {
		if (front == -1 || front > end) {
			System.out.println("No element in the queue");
		} else {
			++front;
			--size;
		}
	}

	public Object peek() {
		return a[front];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("No element to print");
		} else {
			for (int i = front; i <= end; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}
	}
}
