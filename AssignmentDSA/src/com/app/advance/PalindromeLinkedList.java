package com.app.advance;

class ListNode3 {
	int val;
	ListNode3 next;

	ListNode3(int x) {
		val = x;
		next = null;
	}
}

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		// Find the end of first half and reverse second half
		ListNode firstHalfEnd = endOfFirstHalf(head);
		ListNode secondHalfStart = reverseList(firstHalfEnd.next);

		// Check whether or not there is a palindrome
		ListNode p1 = head;
		ListNode p2 = secondHalfStart;
		boolean result = true;
		while (result && p2 != null) {
			if (p1.val != p2.val)
				result = false;
			p1 = p1.next;
			p2 = p2.next;
		}

		// Restore the list and return the result
		firstHalfEnd.next = reverseList(secondHalfStart);
		return result;
	}

	private ListNode endOfFirstHalf(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);

		PalindromeLinkedList solution = new PalindromeLinkedList();
		boolean result = solution.isPalindrome(head);

		System.out.println("Is palindrome: " + result);
	}
}
