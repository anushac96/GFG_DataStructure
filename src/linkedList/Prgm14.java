package linkedList;

// XOR Linked List – A Memory Efficient Doubly Linked List | Set 1
// XOR Linked List – A Memory Efficient Doubly Linked List | Set 2

public class Prgm14 {

	public static void main(String[] args) {
		
	}

	/*
	 * // C++ Implementation of Memory // efficient Doubly Linked List
	 * 
	 * // Importing libraries #include <bits/stdc++.h> #include <cinttypes>
	 * 
	 * using namespace std;
	 * 
	 * // Class 1 // Helepr class(Node structure) class Node { public : int data; //
	 * Xor of next node and previous node Node* xnode; };
	 * 
	 * // Method 1 // It returns Xored value of the node addresses Node* Xor(Node*
	 * x, Node* y) { return reinterpret_cast<Node*>( reinterpret_cast<uintptr_t>(x)
	 * ^ reinterpret_cast<uintptr_t>(y)); }
	 * 
	 * // Method 2 // Insert a node at the start of the Xored LinkedList and // mark
	 * the newly inserted node as head void insert(Node** head_ref, int data) { //
	 * Allocate memory for new node Node* new_node = new Node(); new_node -> data =
	 * data;
	 * 
	 * // Since new node is inserted at the // start , xnode of new node will always
	 * be // Xor of current head and NULL new_node -> xnode = *head_ref;
	 * 
	 * // If linkedlist is not empty, then xnode of // present head node will be Xor
	 * of new node // and node next to current head
	 */
/*	if(*head_ref!=NULL)

	{
	        // *(head_ref)->xnode is Xor of (NULL and next).
	        // If we Xor Null with next we get next
	        (*head_ref)
	            -> xnode = Xor(new_node, (*head_ref) -> xnode);
	    }

	// Change head
	*head_ref=new_node;
	}
*/
	// Method 3
	// It simply prints contents of doubly linked
	// list in forward direction
/*	void printList(Node* head)
	{
	    Node* curr = head;
	    Node* prev = NULL;
	    Node* next;
	 
	    cout << "The nodes of Linked List are: \n";
	 
	    // Till condition holds true
	    while (curr != NULL) {
	        // print current node
	        cout << curr -> data << " ";
	 
	        // get address of next node: curr->xnode is
	        // next^prev, so curr->xnode^prev will be
	        // next^prev^prev which is next
	        next = Xor(prev, curr -> xnode);
	 
	        // update prev and curr for next iteration
	        prev = curr;
	        curr = next;
	    }
	}
*/
	// Method 4
	// main driver method
	/*int main()
	{
	    Node* head = NULL;
	    insert(&head, 10);
	    insert(&head, 100);
	    insert(&head, 1000);
	    insert(&head, 10000);
	 
	    // Printing the created list
	    printList(head);
	 
	    return (0);
	}*/	
	
	
/////////////////////	
		
/*
we will discuss the implementation of memory-efficient doubly linked list. 
We will mainly discuss the following two simple functions.
	A function to insert a new node at the beginning.
	A function to traverse the list in forward direction.	
In the following code, insert() function inserts a new node at the beginning. 
We need to change the head pointer of Linked List, that is why a double pointer is used (See this). 
Let us first discuss few things again that have been discussed in the previous post. 
We store XOR of next and previous nodes with every node and we call it npx, which is the only 
address member we have with every node. When we insert a new node at the beginning, npx of new node 
will always be XOR of NULL and current head. And npx of the current head must be changed to XOR of 
new node and node next to the current head.

printList() traverses the list in forward direction. It prints data values from every node. 
To traverse the list, we need to get pointer to the next node at every point. 
We can get the address of next node by keeping track of current node and previous node. 
If we do XOR of curr->npx and prev, we get the address of next node. 
*/
	/* C++ Implementation of Memory
	efficient Doubly Linked List */
/*	#include <bits/stdc++.h>
	#include <cinttypes>
	using namespace std;
	 
	// Node structure of a memory
	// efficient doubly linked list
	class Node
	{
	    public:
	    int data;
	    Node* npx; /* XOR of next and previous node 
	};
*/	 
	/* returns XORed value of the node addresses */
/*	Node* XOR (Node *a, Node *b)
	{
	    return reinterpret_cast<Node *>(
	      reinterpret_cast<uintptr_t>(a) ^
	      reinterpret_cast<uintptr_t>(b));
	}
*/	 
	/* Insert a node at the beginning of the
	XORed linked list and makes the newly
	inserted node as head */
/*	void insert(Node **head_ref, int data)
	{
	    // Allocate memory for new node
	    Node *new_node = new Node();
	    new_node->data = data;
	 
	    /* Since new node is being inserted at the
	    beginning, npx of new node will always be
	    XOR of current head and NULL */
	   // new_node->npx = *head_ref;
	 
	    /* If linked list is not empty, then npx of
	    current head node will be XOR of new node
	    and node next to current head */
	  //  if (*head_ref != NULL)
	  /*  {
	        // *(head_ref)->npx is XOR of NULL and next.
	        // So if we do XOR of it with NULL, we get next
	        (*head_ref)->npx = XOR(new_node, (*head_ref)->npx);
	    }
	 
	    // Change head
	    *head_ref = new_node;
	}
*/	 
	// prints contents of doubly linked
	// list in forward direction
//	void printList (Node *head)
	/*{
	    Node *curr = head;
	    Node *prev = NULL;
	    Node *next;
	 
	    cout << "Following are the nodes of Linked List: \n";
	 
	    while (curr != NULL)
	    {
	        // print current node
	        cout<<curr->data<<" ";
	 
	        // get address of next node: curr->npx is
	        // next^prev, so curr->npx^prev will be
	        // next^prev^prev which is next
	        next = XOR (prev, curr->npx);
	 
	        // update prev and curr for next iteration
	        prev = curr;
	        curr = next;
	    }
	}
*/	 
	// Driver code
/*	int main ()
	{
	    /* Create following Doubly Linked List
	    head-->40<-->30<-->20<-->10 */
/*	    Node *head = NULL;
	    insert(&head, 10);
	    insert(&head, 20);
	    insert(&head, 30);
	    insert(&head, 40);
	 
	    // print the created list
	    printList (head);
	 
	    return (0);
	}
*/	 	
	
}

/* https://www.youtube.com/watch?v=TRH5-QxSNxo
You would be wondering whether it is  possible to implement in java ?. 

The answer to this is very simple and conclusive that one can not implement XOR linked list in a 
programming language such as java because of the presence of pointers in C++ and absence here in java 
language. In Java XOR doubly linked list is not possible because what happens is you don’t have access 
to the actual memory address of any object and the Garbage collector will remove such nodes if there 
is no variable referring to them.  This is also the same in the case of C#.

Your doubly linked list class which uses this node class will keep track of the last node when 
iterating through the list. Similarly, you can also traverse backwards by doing an XOR of the next 
node’s address and the current node’s XOR Pointer. While we store only one previous node at a time 
instead of the previous node for every node, we save a considerable amount of memory. As we all know 
the memory is cheap nowadays so the concept of XOR doubly LinkedList is just theoretical, and it has 
no practical application.

If we need to take the XOR of two addresses we need to cast the memory address into integers which 
is not possible in java. But in C++ we can typecast any pointer that is (Node*), (int *) to any data 
type, depending on your machine that is (4 for 32 bit) and (8 for 64 bit). long is used to handle 
pointers in C++ also uintptr_t is available. Since we cannot Implement this in java, but wait can we 
be not able to do this in any language? Yes we can in C/C++.

Conclusion: The answer to this query is cold frozen NO as we can implement XOR Linked List in C/C++ 
because of its amazing feature i.e pointers with which we can also implement in language such as C#. 

*/