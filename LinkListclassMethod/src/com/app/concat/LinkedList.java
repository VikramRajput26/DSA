package com.app.concat;

//Define the Node class
class Node {
	int data;
	Node next;

	// Constructor to create a new node
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

//Define the LinkedList class
public class LinkedList {
	Node head;

	// Method to insert a new node at the beginning of the list
	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	// Method to print the list
	public void printList() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.data + " -> ");
			currentNode = currentNode.next;
		}
		System.out.println("null");
	}

	// Method to concatenate two linked lists
	public void concatenate(Node list2Head) {
		if (head == null) {
			head = list2Head;
			return;
		}

		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = list2Head;
	}

	// Main method to test the linked list concatenation
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();

		// Insert nodes into the first list
		list1.insertAtBeginning(10);
		list1.insertAtBeginning(20);
		list1.insertAtBeginning(30);

		// Insert nodes into the second list
		list2.insertAtBeginning(40);
		list2.insertAtBeginning(50);

		// Print both lists
		System.out.println("First List:");
		list1.printList(); // Output: 30 -> 20 -> 10 -> null

		System.out.println("Second List:");
		list2.printList(); // Output: 50 -> 40 -> null

		// Concatenate list2 to list1
		list1.concatenate(list2.head);

		// Print the concatenated list
		System.out.println("Concatenated List:");
		list1.printList(); // Output: 30 -> 20 -> 10 -> 50 -> 40 -> null
	}
}
