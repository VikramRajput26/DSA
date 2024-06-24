package com.app.sort;

class ListNode12 {
	int val;
	ListNode12 prev;
	ListNode12 next;

	ListNode12(int x) {
		val = x;
	}
}

public class SortDoublyLinkedList {

	public ListNode12 sortList(ListNode12 head, boolean ascending) {
		// Base case: if list is empty or has only one node, it is already sorted
		if (head == null || head.next == null) {
			return head;
		}

		// Find the middle node to divide the list into two halves
		ListNode12 middle = findMiddle(head);
		ListNode12 secondHalf = middle.next;
		middle.next = null; // Break link between first and second halves
		if (secondHalf != null) {
			secondHalf.prev = null;
		}

		// Recursively sort the two halves
		ListNode12 left = sortList(head, ascending);
		ListNode12 right = sortList(secondHalf, ascending);

		// Merge the sorted halves and return the merged list
		return merge(left, right, ascending);
	}

	private ListNode12 findMiddle(ListNode12 head) {
		ListNode12 slow = head;
		ListNode12 fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	private ListNode12 merge(ListNode12 left, ListNode12 right, boolean ascending) {
		ListNode12 dummy = new ListNode12(0);
		ListNode12 current = dummy;

		while (left != null && right != null) {
			if ((ascending && left.val <= right.val) || (!ascending && left.val >= right.val)) {
				current.next = left;
				left.prev = current;
				left = left.next;
			} else {
				current.next = right;
				right.prev = current;
				right = right.next;
			}
			current = current.next;
		}

		// Append remaining nodes from left or right lists
		if (left != null) {
			current.next = left;
			left.prev = current;
		}
		if (right != null) {
			current.next = right;
			right.prev = current;
		}

		// Return the merged list
		ListNode12 result = dummy.next;
		if (result != null) {
			result.prev = null; // Ensure prev of the new head is null
		}
		return result;
	}

	private static void printList(ListNode12 head) {
		ListNode12 current = head;
		System.out.print("List: ");
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode12 head = new ListNode12(4);
		ListNode12 node2 = new ListNode12(2);
		ListNode12 node1 = new ListNode12(1);
		ListNode12 node3 = new ListNode12(3);
		ListNode12 node5 = new ListNode12(5);
		ListNode12 node0 = new ListNode12(0);

		head.next = node2;
		node2.prev = head;
		node2.next = node1;
		node1.prev = node2;
		node1.next = node3;
		node3.prev = node1;
		node3.next = node5;
		node5.prev = node3;
		node5.next = node0;
		node0.prev = node5;

		SortDoublyLinkedList solution = new SortDoublyLinkedList();

		// Sort in ascending order
		ListNode12 ascSorted = solution.sortList(head, true);
		printList(ascSorted); // Output: List: 0 1 2 3 4 5

		// Sort in descending order
		ListNode12 descSorted = solution.sortList(head, false);
		printList(descSorted); // Output: List: 5 4 3 2 1 0
	}
}
