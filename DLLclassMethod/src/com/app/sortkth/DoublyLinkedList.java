package com.app.sortkth;

//Define the Node class for doubly linked list
class Node {
	int data;
	Node prev;
	Node next;

	// Constructor to create a new node
	Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

//Define the DoublyLinkedList class
public class DoublyLinkedList {
	Node head;
	Node tail;

	// Constructor to create an empty list
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	// Method to insert a new node at the end of the doubly linked list
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
	}

	// Method to print the doubly linked list
	public void printList() {
		if (head == null) {
			System.out.println("List is empty!");
			return;
		}
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " <-> ");
			current = current.next;
		}
		System.out.println("null");
	}

	// Method to reverse blocks of K nodes in the doubly linked list
	public void reverseBlocks(int k) {
		head = reverseBlocksUtil(head, k);
	}

	// Utility method to reverse blocks of K nodes
	private Node reverseBlocksUtil(Node node, int k) {
		Node current = node;
		Node next = null;
		Node prev = null;
		int count = 0;

		// Reverse first K nodes of the linked list
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			current.prev = next; // Update previous pointer for doubly linked list
			prev = current;
			current = next;
			count++;
		}

		// If there are remaining nodes, recursively call for the next block
		if (next != null) {
			node.next = reverseBlocksUtil(next, k);
			node.next.prev = node; // Update previous pointer for doubly linked list
		}

		return prev; // prev is the new head of the reversed block
	}

	// Main method to test reverse blocks of K nodes in doubly linked list
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);
		list.insertAtEnd(8);
		list.insertAtEnd(9);
		list.insertAtEnd(10);

		System.out.print("Original Doubly Linked List: ");
		list.printList();

		int k = 3;
		list.reverseBlocks(k);

		System.out.print("Doubly Linked List after reversing blocks of " + k + " nodes: ");
		list.printList();
	}
}
