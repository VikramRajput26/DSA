package com.app.exchange;

//Define the ListNode class for singly linked list
class ListNode {
	int val;
	ListNode next;

	// Constructor to create a new node
	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

//Define the LinkedList class
public class LinkedList {

	// Method to exchange adjacent nodes in the linked list
	public ListNode exchangeAdjacentNodes(ListNode head) {
		// Create a dummy node to handle edge cases
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;
		ListNode curr = head;

		while (curr != null && curr.next != null) {
			ListNode next = curr.next;
			ListNode tmp = next.next;

			// Swap adjacent nodes
			prev.next = next;
			next.next = curr;
			curr.next = tmp;

			// Move to the next pair of adjacent nodes
			prev = curr;
			curr = tmp;
		}

		return dummy.next;
	}

	// Method to print the linked list
	public void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val);
			if (current.next != null) {
				System.out.print(" -> ");
			}
			current = current.next;
		}
		System.out.println();
	}

	// Main method to test exchangeAdjacentNodes method
	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		// Example 1: 1 -> 2 -> 3 -> 4 -> 5
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(5);

		System.out.print("Original List 1: ");
		list.printList(head1);

		ListNode exchanged1 = list.exchangeAdjacentNodes(head1);
		System.out.print("Exchanged List 1: ");
		list.printList(exchanged1);

		// Example 2: 1 -> 2 -> 3 -> 4 -> 5 -> 6
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(3);
		head2.next.next.next = new ListNode(4);
		head2.next.next.next.next = new ListNode(5);
		head2.next.next.next.next.next = new ListNode(6);

		System.out.print("\nOriginal List 2: ");
		list.printList(head2);

		ListNode exchanged2 = list.exchangeAdjacentNodes(head2);
		System.out.print("Exchanged List 2: ");
		list.printList(exchanged2);
	}
}
