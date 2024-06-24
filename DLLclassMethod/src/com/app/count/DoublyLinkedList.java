package com.app.count;

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

	// Method to count the number of nodes in the list
	public int countNodes() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
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

		// Count the number of nodes
		int nodeCount = list.countNodes();
		System.out.println("Number of nodes in the list: " + nodeCount); // Output: 5
	}
}
