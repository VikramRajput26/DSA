package com.app.dsa;

public class AddingElementAtMiddle {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	// Method to add a node at the middle of the linked list
	public void addAtMiddle(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node slow = head;
		Node fast = head;
		Node prev = null;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		Node newNode = new Node(data);
		newNode.next = slow;
		prev.next = newNode;
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
		AddingElementAtMiddle list = new AddingElementAtMiddle();
		list.insert(5);
		list.insert(4);
		list.insert(2);
		list.insert(1);

		System.out.println("Original List:");
		list.printList();

		list.addAtMiddle(3);

		System.out.println("List after adding element in the middle:");
		list.printList();
	}
}
