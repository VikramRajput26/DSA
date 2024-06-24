package com.app.dsa;

public class MergeTwoSortedLL {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head;

	// Method to merge two sorted linked lists
	public static MergeTwoSortedLL mergeLists(MergeTwoSortedLL list1, MergeTwoSortedLL list2) {
		MergeTwoSortedLL mergedList = new MergeTwoSortedLL();
		Node current1 = list1.head;
		Node current2 = list2.head;

		while (current1 != null && current2 != null) {
			if (current1.data <= current2.data) {
				mergedList.insert(current1.data);
				current1 = current1.next;
			} else {
				mergedList.insert(current2.data);
				current2 = current2.next;
			}
		}

		// Add remaining nodes of list1
		while (current1 != null) {
			mergedList.insert(current1.data);
			current1 = current1.next;
		}

		// Add remaining nodes of list2
		while (current2 != null) {
			mergedList.insert(current2.data);
			current2 = current2.next;
		}

		return mergedList;
	}

	// Method to insert a node at the beginning of the linked list
	public void insert(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
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
		MergeTwoSortedLL list1 = new MergeTwoSortedLL();
		list1.insert(8);
		list1.insert(6);
		list1.insert(4);
		list1.insert(2);

		MergeTwoSortedLL list2 = new MergeTwoSortedLL();
		list2.insert(7);
		list2.insert(5);
		list2.insert(3);
		list2.insert(1);

		System.out.println("List 1:");
		list1.printList();

		System.out.println("List 2:");
		list2.printList();

		MergeTwoSortedLL mergedList = mergeLists(list1, list2);
		System.out.println("Merged List:");
		mergedList.printList();
	}
}
