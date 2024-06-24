package com.app.fractionalelement;

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
			tail.next = newNode;
			newNode.prev = tail;
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

	// Method to find the fractional node (n/k-th node) in the doubly linked list
	public Node findFractionalNode(int k) {
		if (head == null || k <= 0) {
			return null; // Return null if list is empty or k is non-positive
		}

		Node fractionalNode = null;
		int count = 0;

		// Traverse the doubly linked list
		for (Node current = head; current != null; current = current.next) {
			if (count % k == 0) {
				if (fractionalNode == null) {
					fractionalNode = head;
				} else {
					fractionalNode = fractionalNode.next;
				}
			}
			count++;
		}

		return fractionalNode;
	}

	// Main method to test finding fractional node in doubly linked list
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);

		System.out.print("Original Doubly Linked List: ");
		list.printList();

		int k = 2;
		Node fractionalNode = list.findFractionalNode(k);

		if (fractionalNode != null) {
			System.out.println("Fractional node (n/k-th node where k=" + k + "): " + fractionalNode.data);
		} else {
			System.out.println("Fractional node (n/k-th node where k=" + k + ") not found.");
		}
	}
}
