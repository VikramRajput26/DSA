package com.app.dsa;

public class MiddleElementLL {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	// Method to find the middle element of a singly linked list in one pass
	public Node findMiddleElement() {
		if (head == null) {
			return null;
		}

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	// Method to print the linked list
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MiddleElementLL list = new MiddleElementLL();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);

		System.out.println("Original List:");
		list.printList();

		Node middleNode = list.findMiddleElement();
		if (middleNode != null) {
			System.out.println("Middle Element: " + middleNode.data);
		} else {
			System.out.println("List is empty.");
		}
	}
}
