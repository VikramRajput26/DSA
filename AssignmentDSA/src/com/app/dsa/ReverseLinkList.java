package com.app.dsa;

public class ReverseLinkList {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	// Method to reverse the linked list
	public void reverse() {
		Node prev = null;
		Node current = head;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;
	}

	// Method to insert a node at the beginning of the linked list
	public void insert(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
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
		ReverseLinkList list = new ReverseLinkList();
		list.insert(5);
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);

		System.out.println("Original List:");
		list.printList();

		list.reverse();

		System.out.println("Reversed List:");
		list.printList();
	}
}
