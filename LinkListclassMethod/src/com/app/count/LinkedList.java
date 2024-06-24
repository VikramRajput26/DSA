package com.app.count;

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

	// Constructor to create an empty list
	public LinkedList() {
		this.head = null;
	}

	// Method to insert a new node at the beginning of the list
	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
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
			System.out.print(currentNode.data + " -> ");
			currentNode = currentNode.next;
		}
		System.out.println("null");
	}

	// Main method to test the linked list
	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		// Insert nodes at the beginning
		list.insertAtBeginning(10);
		list.insertAtBeginning(20);
		list.insertAtBeginning(30);

		// Print the list
		list.printList(); // Output: 30 -> 20 -> 10 -> null

		// Count the number of nodes
		int nodeCount = list.countNodes();
		System.out.println("Number of nodes in the list: " + nodeCount); // Output: 3
	}
}
