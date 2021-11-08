package linkedList;

import java.util.LinkedList;
import java.util.Stack;

// Function to check if a singly linked list is palindrome

public class Prgm5 {

	public static void main(String[] args) {
		Prgm5 prgm5 = new Prgm5();
		LinkedList<Character> linkedList = new LinkedList<>();
		linkedList.add('A');
		linkedList.add('B');
		linkedList.add('C');
		linkedList.add('C');
		linkedList.add('B');
		linkedList.add('A');
		// space complexity : O(N/2)
		// time complexity : O(N)
		System.out.println("is the list palindrom by using stack: " + prgm5.isPalindromByStack(linkedList));
		// space complexity : O(1)
		// time complexity : O(N)
		System.out
				.println("is the list palindrom by reversing linkedList: " + prgm5.isPalindromByReversing(linkedList));

	}

	private boolean isPalindromByReversing(LinkedList<Character> linkedList) {
		if (linkedList.size() == 0 || linkedList.size() == 1) {
			return false;
		} else {
			if (linkedList.size() % 2 == 0) {
				return reverse((linkedList.size() / 2), linkedList.size() - 1, linkedList);
			} else {
				return reverse((linkedList.size() / 2)+1, linkedList.size() - 1, linkedList);
			}
		}
	}

	public boolean reverse(int start, int end, LinkedList<Character> linkedList) {
		Character tempCharacter = '\0';
		int compareIndex = start;
		while (start < end) {
			tempCharacter = linkedList.get(end);
			linkedList.set(end, linkedList.get(start));
			linkedList.set(start, tempCharacter);
			++start;
			--end;
		}
		return checkLinkList(linkedList, compareIndex);
	}

	public boolean checkLinkList(LinkedList<Character> linkedList, int compareIndex) {
		int i = 0;
		while (i < linkedList.size() / 2) {
			if (linkedList.get(i) == linkedList.get(compareIndex)) {
				i++;
				compareIndex++;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isPalindromByStack(LinkedList<Character> linkedList) {
		if (linkedList.size() == 0 || linkedList.size() == 1) {
			return false;
		} else {
			int i = 0;
			Stack<Character> stack = new Stack<>();
			while (i < (linkedList.size() / 2)) {
				stack.add(linkedList.get(i));
				i++;
			}
			if (linkedList.size() % 2 == 0) {
				return check((linkedList.size() / 2), linkedList, stack);
			} else {
				return check((linkedList.size() / 2) + 1, linkedList, stack);
			}
		}
	}

	private boolean check(int i, LinkedList<Character> linkedList, Stack<Character> stack) {
		while (!stack.isEmpty()) {
			if (stack.peek() == linkedList.get(i)) {
				i++;
				stack.pop();
			} else {
				return false;
			}
		}
		return true;
	}

}
