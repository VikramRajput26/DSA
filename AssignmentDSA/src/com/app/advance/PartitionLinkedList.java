package com.app.advance;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class PartitionLinkedList {
	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;

		ListNode lessHead = new ListNode(0);
		ListNode greaterHead = new ListNode(0);
		ListNode less = lessHead;
		ListNode greater = greaterHead;

		while (head != null) {
			if (head.val < x) {
				less.next = head;
				less = less.next;
			} else {
				greater.next = head;
				greater = greater.next;
			}
			head = head.next;
		}

		greater.next = null; // Important to end the list
		less.next = greaterHead.next;

		return lessHead.next;
	}
}
