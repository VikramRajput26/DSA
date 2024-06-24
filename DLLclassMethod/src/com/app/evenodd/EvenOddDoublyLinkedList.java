package com.app.evenodd;

class DoublyNode {
	int data;
	DoublyNode next;
	DoublyNode prev;

	DoublyNode(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class EvenOddDoublyLinkedList {

	public static DoublyNode rearrangeEvenOdd(DoublyNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		// Dummy nodes to represent the beginning of even and odd lists
		DoublyNode evenStart = null;
		DoublyNode evenEnd = null;
		DoublyNode oddStart = null;
		DoublyNode oddEnd = null;

		DoublyNode current = head;

		while (current != null) {
			int element = current.data;
			DoublyNode nextNode = current.next; // Save next node
			current.next = null; // Disconnect current node from list

			if (element % 2 == 0) { // Even node
				if (evenStart == null) {
					evenStart = current;
					evenEnd = evenStart;
				} else {
					evenEnd.next = current;
					current.prev = evenEnd;
					evenEnd = evenEnd.next;
				}
			} else { // Odd node
				if (oddStart == null) {
					oddStart = current;
					oddEnd = oddStart;
				} else {
					oddEnd.next = current;
					current.prev = oddEnd;
					oddEnd = oddEnd.next;
				}
			}

			current = nextNode; // Move to next node
		}

		// If there are no even nodes
		if (evenStart == null) {
			return oddStart;
		}

		// If there are no odd nodes
		if (oddStart == null) {
			return evenStart;
		}

		// Connect even list to odd list
		evenEnd.next = oddStart;
		oddStart.prev = evenEnd;

		return evenStart;
	}

	public static void printList(DoublyNode head) {
		DoublyNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DoublyNode head = new DoublyNode(1);
		head.next = new DoublyNode(2);
		head.next.prev = head;
		head.next.next = new DoublyNode(3);
		head.next.next.prev = head.next;
		head.next.next.next = new DoublyNode(4);
		head.next.next.next.prev = head.next.next;
		head.next.next.next.next = new DoublyNode(5);
		head.next.next.next.next.prev = head.next.next.next;
		head.next.next.next.next.next = new DoublyNode(6);
		head.next.next.next.next.next.prev = head.next.next.next.next;
		head.next.next.next.next.next.next = new DoublyNode(7);
		head.next.next.next.next.next.next.prev = head.next.next.next.next.next;
		head.next.next.next.next.next.next.next = new DoublyNode(8);
		head.next.next.next.next.next.next.next.prev = head.next.next.next.next.next.next;

		System.out.println("Original list:");
		printList(head);

		head = rearrangeEvenOdd(head);

		System.out.println("Modified list:");
		printList(head);
	}
}
