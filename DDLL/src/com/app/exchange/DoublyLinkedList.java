package com.app.exchange;

//Define the Node class for doubly linked list
class ListNode {
	int val;
	ListNode prev;
	ListNode next;

	// Constructor to create a new node
	ListNode(int val) {
		this.val = val;
		this.prev = null;
		this.next = null;
	}
}

//Define the DoublyLinkedList class
public class DoublyLinkedList {
	ListNode head;
	ListNode tail;

	// Constructor to create an empty list
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	// Method to insert a new node at the end of the doubly linked list
	public void insertAtEnd(int val) {
		ListNode newNode = new ListNode(val);
		if (head == null) {
			head = tail = newNode;
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
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " <-> ");
			current = current.next;
		}
		System.out.println("null");
	}

	// Method to exchange adjacent nodes in the doubly linked list
	public ListNode exchangeAdjacentNodes(ListNode head) {
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode prev = temp, curr = head;

		while (curr != null && curr.next != null) {
			ListNode tmp = curr.next.next;

			// Exchange adjacent nodes
			curr.next.next = prev.next;
			prev.next = curr.next;
			curr.next = tmp;
			if (tmp != null) {
				tmp.prev = curr;
			}

			// Move to the next pair
			prev = curr;
			curr = curr.next;
		}

		return temp.next;
	}

	// Main method to test exchange of adjacent nodes in doubly linked list
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);

		System.out.print("Original Doubly Linked List: ");
		list.printList();

		ListNode newHead = list.exchangeAdjacentNodes(list.head);

		System.out.print("Doubly Linked List after exchanging adjacent nodes: ");
		printList(newHead);
	}

	// Helper method to print the doubly linked list
	public static void printList(ListNode head) {
		if (head == null) {
			System.out.println("List is empty!");
			return;
		}
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " <-> ");
			current = current.next;
		}
		System.out.println("null");
	}
}
