package com.app.advance;

class ListNode1 {
	int val;
	ListNode1 next;

	ListNode1(int x) {
		val = x;
		next = null;
	}
}

public class RemoveElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;

		while (current.next != null) {
			if (current.next.val == val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);

		RemoveElements solution = new RemoveElements();
		ListNode result = solution.removeElements(head, 6);

		// Print the result
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
