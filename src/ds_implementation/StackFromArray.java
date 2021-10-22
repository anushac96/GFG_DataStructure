package ds_implementation;

public class StackFromArray {

	static final int MAX = 1000;
	Object a[] = new Object[MAX];
	int top = -1;

	void push(Object object) {
		a[++top] = object;
	}

	public void pop() {
		if (top < 0) {
			System.out.println("no element to delete");
		} else {
			--top;
		}
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public Object peek() {
		return a[top];
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("stack is empty");
		} else {
			for (int i = 0; i <= top; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}
	}
}