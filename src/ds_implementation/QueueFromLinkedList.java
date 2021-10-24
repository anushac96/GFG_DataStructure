package ds_implementation;

import java.util.Iterator;
import java.util.LinkedList;

public class QueueFromLinkedList<E> implements Iterable<E>{

	LinkedList<E> linkedList = new LinkedList<E>();
	
	public void enqueue(E object) {
		linkedList.addLast(object);
	}
	
	public void dequeue() {
		if(isEmpty()) {
			System.out.println("no element in queue");
		}
		linkedList.removeFirst();
	}
	
	public boolean isEmpty() {
		return linkedList.size()==0;
	}

	public Iterator<E> print() {
		return linkedList.iterator();
	}
	
	public E peek() throws Exception {
		if(linkedList.size()==0) {
			throw new Exception("No element in the queue");
		}
		else {
			return linkedList.peek();
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
