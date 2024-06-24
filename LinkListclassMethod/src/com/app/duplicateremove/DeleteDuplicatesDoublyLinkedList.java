package com.app.duplicateremove;

class ListNodeTTT {
	int val;
	ListNodeTTT prev;
	ListNodeTTT next;

	ListNodeTTT(int x) {
		val = x;
	}
}

public class DeleteDuplicatesDoublyLinkedList {

	public ListNodeTTT deleteDuplicates(ListNodeTTT head) {
		// Handle edge case where head is null or only one node
		if (head == null || head.next == null) {
			return head;
		}

		// Create a dummy node to handle cases where the head itself might be removed
		ListNodeTTT dummy = new ListNodeTTT(0);
		dummy.next = head;
		head.prev = dummy;
		ListNodeTTT current = head;

		while (current != null && current.next != null) {
			if (current.val == current.next.val) {
				// Skip all nodes with the same value as current
				int duplicateValue = current.val;
				while (current != null && current.val == duplicateValue) {
					current = current.next;
				}

				// Remove duplicates from the list
				dummy.next = current;
				if (current != null) {
					current.prev = dummy;
				}
			} else {
				// Move to the next node
				dummy = current;
				current = current.next;
			}
		}

		// Adjust pointers for the remaining list
		head.prev = null;
		return dummy.next;
	}

	// Helper method to print the doubly linked list
	private static void printList(ListNodeTTT head) {
		ListNodeTTT current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Example input: head = [1,2,3,3,4,4,5]
		ListNodeTTT head = new ListNodeTTT(1);
		head.next = new ListNodeTTT(2);
		head.next.prev = head;
		head.next.next = new ListNodeTTT(3);
		head.next.next.prev = head.next;
		head.next.next.next = new ListNodeTTT(3);
		head.next.next.next.prev = head.next.next;
		head.next.next.next.next = new ListNodeTTT(4);
		head.next.next.next.next.prev = head.next.next.next;
		head.next.next.next.next.next = new ListNodeTTT(4);
		head.next.next.next.next.next.prev = head.next.next.next.next;
		head.next.next.next.next.next.next = new ListNodeTTT(5);
		head.next.next.next.next.next.next.prev = head.next.next.next.next.next;

		DeleteDuplicatesDoublyLinkedList solution = new DeleteDuplicatesDoublyLinkedList();
		ListNodeTTT result = solution.deleteDuplicates(head);

		// Print the resulting linked list
		printList(result); // Output: 1 2 5
	}
}
