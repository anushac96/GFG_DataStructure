package ds_implementation;

import java.util.Iterator;
import java.util.LinkedList;

public class StackFromLinkedList<T> implements Iterable<T> {

	LinkedList<T> list = new LinkedList<T>();

	public void push(T object) {
		list.addLast(object);
	}

	public void pop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
		} else {
			list.removeLast();
		}
	}

	@SuppressWarnings("unchecked")
	public T peek() {
		if (isEmpty()) {
			// System.out.println("stack is empty");
			return (T) "stack is empty";
		} else {
			return list.peekLast();
		}
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	public Iterator<T> print() {
		return list.iterator();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
