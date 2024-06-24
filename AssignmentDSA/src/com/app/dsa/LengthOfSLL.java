package com.app.dsa;

public class LengthOfSLL {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	// Method to find the length of a singly linked list
	public int length() {
		int length = 0;
		Node current = head;

		while (current != null) {
			length++;
			current = current.next;
		}

		return length;
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
		LengthOfSLL list = new LengthOfSLL();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);

		System.out.println("Original List:");
		list.printList();

		int length = list.length();
		System.out.println("Length of the list: " + length);
	}
}
