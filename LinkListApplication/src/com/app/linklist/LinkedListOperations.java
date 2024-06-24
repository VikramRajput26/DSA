package com.app.linklist;

import java.util.Scanner;

public class LinkedListOperations {
	private Node head;
	private int size;

	// Node class representing each element in the linked list
	private static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public LinkedListOperations() {
		head = null;
		size = 0;
	}

	// Method to insert an element at the end of the linked list
	public void insert(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		size++;
		System.out.println(value + " inserted into the linked list.");
	}

	// Method to delete the first occurrence of an element from the linked list
	public void delete(int value) {
		if (head == null) {
			System.out.println("Linked list is empty. Cannot delete.");
			return;
		}

		if (head.data == value) {
			head = head.next;
			size--;
			System.out.println(value + " deleted from the linked list.");
			return;
		}

		Node current = head;
		Node prev = null;
		while (current != null && current.data != value) {
			prev = current;
			current = current.next;
		}

		if (current == null) {
			System.out.println(value + " not found in the linked list. Cannot delete.");
		} else {
			prev.next = current.next;
			size--;
			System.out.println(value + " deleted from the linked list.");
		}
	}

	// Method to print all elements in the linked list
	public void print() {
		if (head == null) {
			System.out.println("Linked list is empty.");
			return;
		}

		System.out.print("Linked list elements: ");
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	// Method to sort the linked list in ascending order using bubble sort
	public void sortAscending() {
		if (head == null || head.next == null) {
			return;
		}

		Node current = head;
		while (current != null) {
			Node index = current.next;
			while (index != null) {
				if (current.data > index.data) {
					int temp = current.data;
					current.data = index.data;
					index.data = temp;
				}
				index = index.next;
			}
			current = current.next;
		}
		System.out.println("Linked list sorted in ascending order.");
	}

	// Method to sort the linked list in descending order using selection sort
	public void sortDescending() {
		if (head == null || head.next == null) {
			return;
		}

		Node current = head;
		while (current != null) {
			Node index = current.next;
			Node min = current;
			while (index != null) {
				if (index.data > min.data) {
					min = index;
				}
				index = index.next;
			}
			int temp = current.data;
			current.data = min.data;
			min.data = temp;
			current = current.next;
		}
		System.out.println("Linked list sorted in descending order.");
	}

	// Method to search for an element in the linked list
	public boolean search(int value) {
		Node current = head;
		while (current != null) {
			if (current.data == value) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Method to count the number of elements in the linked list
	public int count() {
		return size;
	}

	// Method to find the maximum element in the linked list
	public int maximum() {
		if (head == null) {
			return Integer.MIN_VALUE; // Return minimum integer value if linked list is empty
		}

		int max = head.data;
		Node current = head.next;
		while (current != null) {
			if (current.data > max) {
				max = current.data;
			}
			current = current.next;
		}
		return max;
	}

	// Method to find the minimum element in the linked list
	public int minimum() {
		if (head == null) {
			return Integer.MAX_VALUE; // Return maximum integer value if linked list is empty
		}

		int min = head.data;
		Node current = head.next;
		while (current != null) {
			if (current.data < min) {
				min = current.data;
			}
			current = current.next;
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedListOperations list = new LinkedListOperations();
		int choice, element;

		while (true) {
			System.out.println("\nLinked List Operations Menu:");
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Print Linked List");
			System.out.println("4. Sort Ascending");
			System.out.println("5. Sort Descending");
			System.out.println("6. Search");
			System.out.println("7. Count");
			System.out.println("8. Maximum Element");
			System.out.println("9. Minimum Element");
			System.out.println("10. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter element to insert: ");
				element = scanner.nextInt();
				list.insert(element);
				break;
			case 2:
				System.out.print("Enter element to delete: ");
				element = scanner.nextInt();
				list.delete(element);
				break;
			case 3:
				list.print();
				break;
			case 4:
				list.sortAscending();
				break;
			case 5:
				list.sortDescending();
				break;
			case 6:
				System.out.print("Enter element to search: ");
				element = scanner.nextInt();
				if (list.search(element)) {
					System.out.println(element + " found in the linked list.");
				} else {
					System.out.println(element + " not found in the linked list.");
				}
				break;
			case 7:
				System.out.println("Number of elements in the linked list: " + list.count());
				break;
			case 8:
				System.out.println("Maximum element in the linked list: " + list.maximum());
				break;
			case 9:
				System.out.println("Minimum element in the linked list: " + list.minimum());
				break;
			case 10:
				System.out.println("Exiting...");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}
}
