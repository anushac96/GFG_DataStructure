package ds_implementation;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

	private T[] arr;
	private int len = 0;
	private int capacity = 1;

	public DynamicArray() {
	    this(16);
	  }

	  public DynamicArray(int capacity) {
	    if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
	    this.capacity = capacity;
	    arr = (T[]) new Object[capacity];
	  }

	  
	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return len;
	}

	public T get(int index) {
		if(index>len || index<0) {
			throw new IndexOutOfBoundsException();
		}
		return arr[index];
	}

	public void set(int index, T element) {
		if(index>len || index<0) {
			throw new IndexOutOfBoundsException();
		}
		arr[index] = element;
	}

	public void clear() {
		for (int i = 0; i < len; i++) {
			arr[i] = null;
		}
		len = 0;
	}

	public void add(T element) {
		if (len > capacity) {
			if (capacity == 0)
				capacity = 1;
			else {
				capacity *= 2;
			}
			T new_arr[] = (T[]) new Object[capacity];
			for (int i = 0; i < len; i++) {
				new_arr[i] = arr[i];
			}
			arr = new_arr;
		}
		arr[len++] = element;
	}

	public void removeAt(int index) {
		if (index >= len || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		T new_arr[] = (T[]) new Object[len - 1];
		for (int i = 0, j = 0; i < len; i++) {
			if (i != index) {
				new_arr[j] = arr[i];
				++j;
			}
		}
		arr = new_arr;
		capacity = --len;
	}

	public void remove(T element) {
		int index = indexOf(element);
		removeAt(index);
	}

	public int indexOf(T element) {
		for (int i = 0; i < len; i++) {
			if (element == arr[i])
				return i;
		}
		return -1;
	}

	public boolean contains(T element) {
		return indexOf(element) != -1;
	}

	@Override
	public String toString() {
		if (len == 0) {
			return "[]";
		}
		StringBuffer s = new StringBuffer();
		s.append('[');
		for (int i = 0; i < len; i++) {
			s.append(arr[i] + ",");
		}
		s.setCharAt(s.lastIndexOf(","), ']');
		return s.toString();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
