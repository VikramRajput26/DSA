package com.app.dsa;

public class RemoveNthNodeFromLast {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	// Method to remove the Nth node from the end
	public void removeNthFromEnd(int n) {
		if (head == null) {
			return;
		}

		Node dummy = new Node(0);
		dummy.next = head;
		Node mainPointer = dummy;
		Node refPointer = dummy;

		// Move refPointer n+1 nodes ahead
		for (int i = 0; i <= n; i++) {
			if (refPointer == null) {
				return; // Less than n nodes
			}
			refPointer = refPointer.next;
		}

		// Move both pointers until refPointer reaches the end
		while (refPointer != null) {
			mainPointer = mainPointer.next;
			refPointer = refPointer.next;
		}

		// Remove the nth node from end
		mainPointer.next = mainPointer.next.next;

		head = dummy.next; // Update head if necessary
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
		RemoveNthNodeFromLast list = new RemoveNthNodeFromLast();
		list.insert(5);
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);

		System.out.println("Original List:");
		list.printList();

		int n = 3; // Remove the 3rd node from the end
		list.removeNthFromEnd(n);

		System.out.println("List after removing " + n + "th node from the end:");
		list.printList();
	}
}
