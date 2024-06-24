package com.app.dsa;

public class Find3RDNodeFromLast {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	// Method to find the third node from the end
	public Node findThirdFromEnd() {
		if (head == null || head.next == null || head.next.next == null) {
			return null; // Less than three nodes
		}

		Node mainPointer = head;
		Node refPointer = head;

		// Move refPointer three nodes ahead
		for (int i = 0; i < 3; i++) {
			if (refPointer == null) {
				return null; // Less than three nodes
			}
			refPointer = refPointer.next;
		}

		// Move both pointers until refPointer reaches the end
		while (refPointer != null) {
			mainPointer = mainPointer.next;
			refPointer = refPointer.next;
		}

		return mainPointer;
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
		Find3RDNodeFromLast list = new Find3RDNodeFromLast();
		list.insert(5);
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);

		System.out.println("Original List:");
		list.printList();

		Node thirdFromEnd = list.findThirdFromEnd();
		if (thirdFromEnd != null) {
			System.out.println("Third node from the end: " + thirdFromEnd.data);
		} else {
			System.out.println("List has less than three nodes.");
		}
	}
}
