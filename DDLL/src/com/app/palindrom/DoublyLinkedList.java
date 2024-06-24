package com.app.palindrom;

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

	// Method to check if the doubly linked list is palindrome
	public boolean isPalindrome() {
		if (head == null || head.next == null) {
			return true; // Empty or single element list is palindrome
		}

		// Step 1: Find the middle of the doubly linked list
		Node left = head;
		Node right = tail;
		while (left != right && left.prev != right) {
			if (left.data != right.data) {
				return false;
			}
			left = left.next;
			right = right.prev;
		}
		return true;
	}

	// Main method to test palindrome doubly linked list
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(2);
		list.insertAtEnd(1);

		System.out.print("Original Doubly Linked List: ");
		list.printList();

		boolean isPalindrome = list.isPalindrome();
		if (isPalindrome) {
			System.out.println("The doubly linked list is a palindrome.");
		} else {
			System.out.println("The doubly linked list is not a palindrome.");
		}
	}
}
