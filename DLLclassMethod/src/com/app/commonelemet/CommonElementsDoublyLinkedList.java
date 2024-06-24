package com.app.commonelemet;

class DoublyNode {
	int data;
	DoublyNode next;
	DoublyNode prev;

	DoublyNode(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class CommonElementsDoublyLinkedList {

	public static void printCommonElements(DoublyNode list1, DoublyNode list2) {
		DoublyNode temp1 = list1;
		DoublyNode temp2 = list2;

		System.out.print("Common elements: ");
		while (temp1 != null && temp2 != null) {
			if (temp1.data == temp2.data) {
				System.out.print(temp1.data + " ");
				temp1 = temp1.next;
				temp2 = temp2.next;
			} else if (temp1.data < temp2.data) {
				temp1 = temp1.next;
			} else {
				temp2 = temp2.next;
			}
		}
		System.out.println();
	}

	public static void printList(DoublyNode head) {
		DoublyNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Creating first sorted doubly linked list
		DoublyNode list1 = new DoublyNode(1);
		list1.next = new DoublyNode(2);
		list1.next.prev = list1;
		list1.next.next = new DoublyNode(4);
		list1.next.next.prev = list1.next;
		list1.next.next.next = new DoublyNode(6);
		list1.next.next.next.prev = list1.next.next;
		list1.next.next.next.next = new DoublyNode(8);
		list1.next.next.next.next.prev = list1.next.next.next;

		// Creating second sorted doubly linked list
		DoublyNode list2 = new DoublyNode(2);
		list2.next = new DoublyNode(4);
		list2.next.prev = list2;
		list2.next.next = new DoublyNode(6);
		list2.next.next.prev = list2.next;
		list2.next.next.next = new DoublyNode(8);
		list2.next.next.next.prev = list2.next.next;
		list2.next.next.next.next = new DoublyNode(10);
		list2.next.next.next.next.prev = list2.next.next.next;

		System.out.println("List 1:");
		printList(list1);

		System.out.println("List 2:");
		printList(list2);

		printCommonElements(list1, list2);
	}
}
