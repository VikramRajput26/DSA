package com.app.dsa;

public class RemoveDuplicate {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	// Method to remove duplicates from a sorted linked list
	public void removeDuplicates() {
		Node current = head;

		while (current != null && current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next; // Skip the duplicate node
			} else {
				current = current.next; // Move to the next node
			}
		}
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
		RemoveDuplicate list = new RemoveDuplicate();
		list.insert(5);
		list.insert(4);
		list.insert(4);
		list.insert(3);
		list.insert(3);
		list.insert(2);
		list.insert(1);

		System.out.println("Original List:");
		list.printList();

		list.removeDuplicates();

		System.out.println("List after removing duplicates:");
		list.printList();
	}
}
