package com.app.reverse;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1) {
			return head;
		}

		// Dummy node initialization
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		// Initialize pointers
		ListNode curr = head;
		ListNode prev = dummy;
		ListNode next = null;

		// Count the number of nodes in the list
		int count = 0;
		while (curr != null) {
			count++;
			curr = curr.next;
		}

		// Reverse in groups of k
		while (count >= k) {
			curr = prev.next;
			next = curr.next;
			for (int i = 1; i < k; i++) {
				curr.next = next.next;
				next.next = prev.next;
				prev.next = next;
				next = curr.next;
			}
			prev = curr;
			count -= k;
		}

		return dummy.next;
	}

	// Helper method to print the linked list
	public void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ReverseNodesInKGroup solution = new ReverseNodesInKGroup();

		// Construct the linked list [1, 2, 3, 4, 5]
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		int k = 2;

		// Reverse nodes in k group
		ListNode newHead = solution.reverseKGroup(head, k);

		// Print the resulting linked list
		solution.printList(newHead); // Output: [2, 1, 4, 3, 5]
	}
}
