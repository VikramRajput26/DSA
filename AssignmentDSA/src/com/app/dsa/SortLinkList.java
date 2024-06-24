package com.app.dsa;

public class SortLinkList {
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
	private Node merge(Node left, Node right) {
		Node result = null;
		if (left == null)
			return right;
		if (right == null)
			return left;

		if (left.data <= right.data) {
			result = left;
			result.next = merge(left.next, right);
		} else {
			result = right;
			result.next = merge(left, right.next);
		}
		return result;
	}

	// Method to perform Merge Sort on linked list
	public Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node middle = getMiddle(head);
		Node nextToMiddle = middle.next;
		middle.next = null;

		Node left = mergeSort(head);
		Node right = mergeSort(nextToMiddle);

		return merge(left, right);
	}

	// Method to find the middle node of linked list
	private Node getMiddle(Node head) {
		if (head == null)
			return head;

		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	// Method to insert a node at the beginning of the linked list
	public void insert(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	// Method to print the linked list
	public void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SortLinkList list = new SortLinkList();
		list.insert(5);
		list.insert(2);
		list.insert(4);
		list.insert(1);
		list.insert(3);

		System.out.println("Original List:");
		list.printList(list.head);

		list.head = list.mergeSort(list.head);

		System.out.println("Sorted List:");
		list.printList(list.head);
	}
}
