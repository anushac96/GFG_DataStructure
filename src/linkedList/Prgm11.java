package linkedList;

import java.util.HashSet;

// Write a function to get the intersection point of two Linked Lists

public class Prgm11 {

	static Node headNode1;
	static Node headNode2;

	public static void main(String[] args) {

		Prgm11 prgm11 = new Prgm11();
		// Method 1(Simply use two loops)
		// Use 2 nested for loops. The outer loop will be for each node of the 1st list
		// and inner loop will be for 2nd list.
		// In the inner loop, check if any of nodes of the 2nd list is same as the
		// current node of the first linked list.
		// The time complexity of this method will be O(M * N) where m and n are the
		// numbers of nodes in two lists.

		// Method 2 (Mark Visited Nodes)
		// This solution requires modifications to basic linked list data structure.
		// Have a visited flag with each node.
		// Traverse the first linked list and keep marking visited nodes.
		// Now traverse the second linked list, If you see a visited node again then
		// there is an intersection point,
		// return the intersecting node. This solution works in O(m+n) but requires
		// additional information with each node.
		// A variation of this solution that doesn’t require modification to the basic
		// data structure can be implemented using a hash.
		// Traverse the first linked list and store the addresses of visited nodes in a
		// hash.
		// Now traverse the second linked list and if you see an address that already
		// exists in the hash then return the
		// intersecting node.

		// Method 3(Using difference of node counts)
		// Get count of the nodes in the first list, let count be c1.
		// Get count of the nodes in the second list, let count be c2.
		// Get the difference of counts d = abs(c1 – c2)
		// Now traverse the bigger list from the first node till d nodes so that from
		// here onwards both the lists have equal no of nodes
		// Then we can traverse both the lists in parallel till we come across a common
		// node. (Note that getting a common
		// node is done by comparing the address of the nodes)
		// Time Complexity: O(m+n)
		// Auxiliary Space: O(1)
		headNode1 = new Node(3);
		headNode1.nextNode = new Node(6);
		headNode1.nextNode.nextNode = new Node(9);
		headNode1.nextNode.nextNode.nextNode = new Node(15);
		headNode1.nextNode.nextNode.nextNode.nextNode = new Node(30);
		System.out.println("elements in linkedlist 1 are: ");
		prgm11.print(headNode1);

		headNode2 = new Node(10);
		headNode2.nextNode = headNode1.nextNode.nextNode.nextNode;
		System.out.println("elements in linkedlist 2 are: ");
		prgm11.print(headNode2);

		int diff = Math.abs(prgm11.size(headNode1) - prgm11.size(headNode2));

		if (prgm11.size(headNode1) > prgm11.size(headNode2)) {
			prgm11.compare(headNode1, headNode2, diff);
		} else {
			prgm11.compare(headNode2, headNode1, diff);
		}

		// Method 7 (Use Hashing)
		// Basically, we need to find a common node of two linked lists.
		// So we hash all nodes of the first list and then check the second list.
		// 1) Create an empty hash set.
		// 2) Traverse the first linked list and insert all nodes’ addresses in the hash
		// set.
		// 3) Traverse the second list. For every node check if it is present in the
		// hash set. If we find a node in the hash set, return the node.
		// This method required O(n) additional space and not very efficient if one list
		// is large.
		prgm11.compareUsingHashSet(headNode1, headNode2);

		// Method 8( 2-pointer technique ):
		// Using Two pointers :
		// Initialize two pointers ptr1 and ptr2 at the head1 and head2.
		// Traverse through the lists,one node at a time.
		// When ptr1 reaches the end of a list, then redirect it to the head2.
		// similarly when ptr2 reaches the end of a list, redirect it the head1.
		// Once both of them go through reassigning, they will be equidistant from
		// the collision point
		// If at any node ptr1 meets ptr2, then it is the intersection node.
		// After second iteration if there is no intersection node it returns NULL.

		// TODO:
		// https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/

	}

	public void compareUsingHashSet(Node headNode1, Node headNode2) {
		HashSet<Integer> set = new HashSet<>();
		Node currNode = headNode1;
		while (currNode != null) {
			set.add(currNode.data);
			currNode = currNode.nextNode;
		}
		currNode = headNode2;
		while (currNode != null) {
			if (set.contains(currNode.data)) {
				System.out.println("intersection node using hashset is: " + currNode.data);
				return;
			}
			currNode = currNode.nextNode;
		}
	}

	public void compare(Node largeNode, Node smallNode, int diff) {
		Node currLargeNode = largeNode;
		Node currsmallNode = smallNode;
		int count = 0;
		while (count != diff) {
			currLargeNode = currLargeNode.nextNode;
			++count;
		}
		while (currLargeNode.data != currsmallNode.data) {
			currLargeNode = currLargeNode.nextNode;
			currsmallNode = currsmallNode.nextNode;
		}
		System.out.println("intersection node is: " + currLargeNode.data);
	}

	public int size(Node headNode) {
		int count = 0;
		Node currNode = headNode;
		while (currNode != null) {
			currNode = currNode.nextNode;
			++count;
		}
		return count;
	}

	public void print(Node headNode) {
		Node currNode = headNode;
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.nextNode;
		}
		System.out.println();
	}

	static class Node {
		int data;
		Node nextNode;

		Node(int d) {
			data = d;
			nextNode = null;
		}
	}
}
