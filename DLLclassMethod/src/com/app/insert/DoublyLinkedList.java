package com.app.insert;

//Define the Node class
class Node {
	int data;
	Node next;
	Node prev;

	// Constructor to create a new node
	Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

//Define the DoublyLinkedList class
public class DoublyLinkedList {
	Node head;

	// Constructor to create an empty list
	public DoublyLinkedList() {
		this.head = null;
	}

	// Method to insert a new node at the beginning of the list
	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		if (head != null) {
			head.prev = newNode;
		}
		newNode.next = head;
		head = newNode;
	}

	// Method to insert a new node at the end of the list
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		newNode.prev = current;
	}

	// Method to insert a new node at a specified position in the list
	public void insertAtPosition(int data, int position) {
		if (position < 0) {
			System.out.println("Invalid position!");
			return;
		}

		Node newNode = new Node(data);

		if (position == 0) {
			insertAtBeginning(data);
			return;
		}

		Node current = head;
		for (int i = 0; current != null && i < position - 1; i++) {
			current = current.next;
		}

		if (current == null) {
			System.out.println("Position is greater than the length of the list!");
			return;
		}

		newNode.next = current.next;
		if (current.next != null) {
			current.next.prev = newNode;
		}
		current.next = newNode;
		newNode.prev = current;
	}

	// Method to print the list
	public void printList() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.data + " <-> ");
			currentNode = currentNode.next;
		}
		System.out.println("null");
	}

	// Main method to test the linked list
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();

		// Insert nodes at the beginning
		list.insertAtBeginning(10);
		list.insertAtBeginning(20);
		list.insertAtBeginning(30);

		// Print the list
		list.printList(); // Output: 30 <-> 20 <-> 10 <-> null

		// Insert nodes at the end
		list.insertAtEnd(40);
		list.insertAtEnd(50);

		// Print the list again
		list.printList(); // Output: 30 <-> 20 <-> 10 <-> 40 <-> 50 <-> null

		// Insert a node at position 2 (middle)
		list.insertAtPosition(25, 2);

		// Print the list again
		list.printList(); // Output: 30 <-> 20 <-> 25 <-> 10 <-> 40 <-> 50 <-> null

		// Insert a node at position 5 (middle)
		list.insertAtPosition(45, 5);

		// Print the list again
		list.printList(); // Output: 30 <-> 20 <-> 25 <-> 10 <-> 40 <-> 45 <-> 50 <-> null
	}
}
