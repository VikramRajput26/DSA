package com.app.sortkth;

//Define the Node class for singly linked list
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

	// Method to insert a new node at the end of the linked list
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	// Method to print the linked list
	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data);
			if (current.next != null) {
				System.out.print(" -> ");
			}
			current = current.next;
		}
		System.out.println();
	}

	// Method to reverse K nodes in the linked list
	public void reverseKNodes(int k) {
		head = reverseKNodesUtil(head, k);
	}

	// Utility method to reverse K nodes in the linked list
	private Node reverseKNodesUtil(Node head, int k) {
		if (head == null || k <= 1) {
			return head;
		}

		Node current = head;
		Node prev = null;
		Node next = null;
		int count = 0;

		// Reverse first K nodes of the linked list
		while (current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		// Recursively call for the rest of the list and link the reversed part
		if (next != null) {
			head.next = reverseKNodesUtil(next, k);
		}

		// prev now is the new head of the reversed block
		return prev;
	}

	// Main method to test reverse K nodes in the linked list
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
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

		System.out.print("Original Linked List: ");
		list.printList();

		// Reverse blocks of K nodes
		int k1 = 2;
		list.reverseKNodes(k1);
		System.out.print("After reversing blocks of " + k1 + " nodes: ");
		list.printList();

		int k2 = 3;
		list.reverseKNodes(k2);
		System.out.print("After reversing blocks of " + k2 + " nodes: ");
		list.printList();

		int k3 = 4;
		list.reverseKNodes(k3);
		System.out.print("After reversing blocks of " + k3 + " nodes: ");
		list.printList();
	}
}
