package com.app.duplicateremove;

class ListNodeGG {
	int val;
	ListNodeGG next;

	ListNodeGG(int x) {
		val = x;
	}
}

public class DeleteDuplicatesLinkedList {

	public ListNodeGG deleteDuplicates(ListNodeGG head) {
		// Handle edge case where head is null or only one node
		if (head == null || head.next == null) {
			return head;
		}

		// Create a dummy node to handle cases where the head itself might be removed
		ListNodeGG dummy = new ListNodeGG(0);
		dummy.next = head;
		ListNodeGG prev = dummy;
		ListNodeGG current = head;

		while (current != null) {
			// Move current to the last node of duplicates
			while (current.next != null && current.val == current.next.val) {
				current = current.next;
			}

			// Check if current is pointing to the last duplicate node
			if (prev.next == current) {
				prev = current;
			} else {
				// Skip all duplicates
				prev.next = current.next;
			}

			// Move to the next node
			current = current.next;
		}

		return dummy.next;
	}

	// Helper method to print the linked list
	private static void printList(ListNodeGG head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Example input: head = [1,2,3,3,4,4,5]
		ListNodeGG head = new ListNodeGG(1);
		head.next = new ListNodeGG(2);
		head.next.next = new ListNodeGG(3);
		head.next.next.next = new ListNodeGG(3);
		head.next.next.next.next = new ListNodeGG(4);
		head.next.next.next.next.next = new ListNodeGG(4);
		head.next.next.next.next.next.next = new ListNodeGG(5);

		DeleteDuplicatesLinkedList solution = new DeleteDuplicatesLinkedList();
		ListNodeGG result = solution.deleteDuplicates(head);

		// Print the resulting linked list
		printList(result); // Output: 1 2 5
	}
}
