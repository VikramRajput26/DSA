package com.app.sort;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class SortLinkedList {

	public ListNode sortList(ListNode head, boolean ascending) {
		if (head == null || head.next == null) {
			return head;
		}

		// Step 1: Split the list into two halves
		ListNode middle = findMiddle(head);
		ListNode secondHalf = middle.next;
		middle.next = null;

		// Step 2: Recursively sort each half
		ListNode left = sortList(head, ascending);
		ListNode right = sortList(secondHalf, ascending);

		// Step 3: Merge the sorted halves
		return merge(left, right, ascending);
	}

	private ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		return prev; // Returns the middle node of the first half
	}

	private ListNode merge(ListNode left, ListNode right, boolean ascending) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (left != null && right != null) {
			if ((ascending && left.val < right.val) || (!ascending && left.val > right.val)) {
				current.next = left;
				left = left.next;
			} else {
				current.next = right;
				right = right.next;
			}
			current = current.next;
		}

		if (left != null) {
			current.next = left;
		}
		if (right != null) {
			current.next = right;
		}

		return dummy.next;
	}

	// Helper method to print the linked list
	private static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Example input: head = [4,2,1,3,5,0]
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(0);

		SortLinkedList solution = new SortLinkedList();

		// Sort in ascending order
		ListNode ascSorted = solution.sortList(head, true);
		System.out.print("Ascending order: ");
		printList(ascSorted); // Output: 0 1 2 3 4 5

		// Sort in descending order (use a new instance of head)
		ListNode newHead = new ListNode(4);
		newHead.next = new ListNode(2);
		newHead.next.next = new ListNode(1);
		newHead.next.next.next = new ListNode(3);
		newHead.next.next.next.next = new ListNode(5);
		newHead.next.next.next.next.next = new ListNode(0);

		ListNode descSorted = solution.sortList(newHead, false);
		System.out.print("Descending order: ");
		printList(descSorted); // Output: 5 4 3 2 1 0
	}
}
