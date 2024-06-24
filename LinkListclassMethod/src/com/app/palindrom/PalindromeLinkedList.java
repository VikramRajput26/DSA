package com.app.palindrom;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class PalindromeLinkedList {
	Node head;

	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public boolean isPalindrome() {
		if (head == null || head.next == null)
			return true;

		Node slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node secondHalf = reverseLinkedList(slow.next);
		Node p1 = head, p2 = secondHalf;
		boolean result = true;

		while (p2 != null) {
			if (p1.data != p2.data) {
				result = false;
				break;
			}
			p1 = p1.next;
			p2 = p2.next;
		}

		slow.next = reverseLinkedList(secondHalf);
		return result;
	}

	private Node reverseLinkedList(Node head) {
		Node prev = null;
		while (head != null) {
			Node next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		PalindromeLinkedList list = new PalindromeLinkedList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(2);
		list.insertAtEnd(1);

		System.out.print("Original Linked List: ");
		list.printList();

		if (list.isPalindrome()) {
			System.out.println("The linked list is a palindrome.");
		} else {
			System.out.println("The linked list is not a palindrome.");
		}
	}
}
