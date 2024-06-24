package com.app.concate;

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
			head = tail = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
	}

	// Method to concatenate two doubly linked lists
	public void concatenate(DoublyLinkedList list1, DoublyLinkedList list2) {
		if (list1.head == null && list2.head == null) {
			System.out.println("Both lists are empty, nothing to concatenate.");
			return;
		}

		if (list1.head == null) {
			head = list2.head;
			tail = list2.tail;
			return;
		}

		if (list2.head == null) {
			head = list1.head;
			tail = list1.tail;
			return;
		}

		// Concatenate list1 and list2
		head = list1.head;
		list1.tail.next = list2.head;
		list2.head.prev = list1.tail;
		tail = list2.tail;
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

	// Main method to test the concatenation of two doubly linked lists
	public static void main(String[] args) {
		// Create two doubly linked lists
		DoublyLinkedList list1 = new DoublyLinkedList();
		list1.insertAtEnd(1);
		list1.insertAtEnd(2);
		list1.insertAtEnd(3);

		DoublyLinkedList list2 = new DoublyLinkedList();
		list2.insertAtEnd(4);
		list2.insertAtEnd(5);

		// Create a new doubly linked list and concatenate list1 and list2
		DoublyLinkedList concatenatedList = new DoublyLinkedList();
		concatenatedList.concatenate(list1, list2);

		// Print the concatenated doubly linked list
		System.out.print("Concatenated Doubly Linked List: ");
		concatenatedList.printList();
	}
}
