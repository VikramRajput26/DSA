package com.app.dsa;

public class DuplicateNodeLL {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	// Method to remove duplicates from an unsorted linked list
	public void removeDuplicates() {
		Node current = head;

		while (current != null) {
			Node runner = current;
			// Compare current node with every other node after it
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next; // Remove duplicate
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	// Method to print the linked list
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DuplicateNodeLL list = new DuplicateNodeLL();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(2);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(1);

		System.out.println("Original List:");
		list.printList();

		list.removeDuplicates();

		System.out.println("List after removing duplicates:");
		list.printList();
	}
}
