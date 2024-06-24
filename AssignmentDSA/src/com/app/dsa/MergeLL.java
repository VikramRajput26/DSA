package com.app.dsa;

public class MergeLL {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	// Method to merge two linked lists at alternate positions
	public void mergeAlternate(MergeLL list2) {
		Node current1 = head;
		Node current2 = list2.head;

		while (current1 != null && current2 != null) {
			Node temp1 = current1.next;
			Node temp2 = current2.next;

			current1.next = current2;
			current2.next = temp1;

			current1 = temp1;
			current2 = temp2;
		}

		list2.head = current2;
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
		MergeLL list1 = new MergeLL();
		list1.head = new Node(1);
		list1.head.next = new Node(3);
		list1.head.next.next = new Node(5);

		MergeLL list2 = new MergeLL();
		list2.head = new Node(2);
		list2.head.next = new Node(4);
		list2.head.next.next = new Node(6);

		System.out.println("List 1:");
		list1.printList();
		System.out.println("List 2:");
		list2.printList();

		list1.mergeAlternate(list2);

		System.out.println("Merged List:");
		list1.printList();
		System.out.println("Remaining List 2:");
		list2.printList();
	}
}
