package com.app.delete;

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

	// Method to delete the node at the beginning of the list
	public void deleteAtBeginning() {
		if (head == null) {
			System.out.println("List is empty!");
			return;
		}
		if (head.next != null) {
			head = head.next;
			head.prev = null;
		} else {
			head = null;
		}
	}

	// Method to delete the node at the end of the list
	public void deleteAtEnd() {
		if (head == null) {
			System.out.println("List is empty!");
			return;
		}
		if (head.next == null) {
			head = null;
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.prev.next = null;
	}

	// Method to delete the node at a specified position in the list
	public void deleteAtPosition(int position) {
		if (head == null) {
			System.out.println("List is empty!");
			return;
		}
		if (position < 0) {
			System.out.println("Invalid position!");
			return;
		}
		if (position == 0) {
			deleteAtBeginning();
			return;
		}

		Node current = head;
		for (int i = 0; current != null && i < position; i++) {
			current = current.next;
		}

		if (current == null) {
			System.out.println("Position is greater than the length of the list!");
			return;
		}

		if (current.next != null) {
			current.next.prev = current.prev;
		}

		if (current.prev != null) {
			current.prev.next = current.next;
		}
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

		// Delete the node at the beginning
		list.deleteAtBeginning();
		list.printList(); // Output: 20 <-> 10 <-> 40 <-> 50 <-> null

		// Delete the node at the end
		list.deleteAtEnd();
		list.printList(); // Output: 20 <-> 10 <-> 40 <-> null

		// Delete the node at position 1 (middle)
		list.deleteAtPosition(1);
		list.printList(); // Output: 20 <-> 40 <-> null
	}
}
