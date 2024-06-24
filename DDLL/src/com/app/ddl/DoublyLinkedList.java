package com.app.ddl;

import java.util.Scanner;

public class DoublyLinkedList {
	// Node class representing each element in the doubly linked list
	private static class Node {
		int data;
		Node prev;
		Node next;

		Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	// Method to insert a new node at a specified position in the doubly linked list
	public void insertAtPosition(int data, int position) {
		if (position < 1 || position > size + 1) {
			System.out.println("Invalid position. Position should be between 1 and " + (size + 1));
			return;
		}

		Node newNode = new Node(data);
		if (position == 1) {
			// Insert at the beginning
			newNode.next = head;
			if (head != null) {
				head.prev = newNode;
			}
			head = newNode;
			if (tail == null) {
				tail = newNode;
			}
		} else if (position == size + 1) {
			// Insert at the end
			if (tail == null) {
				head = tail = newNode;
			} else {
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}
		} else {
			// Insert at the specified position
			Node current = head;
			for (int i = 1; i < position - 1; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			newNode.prev = current;
			current.next.prev = newNode;
			current.next = newNode;
		}
		size++;
	}

	// Method to delete a node from the doubly linked list at a specified position
	public boolean deleteAtPosition(int position) {
		if (position < 1 || position > size) {
			System.out.println("Invalid position. Position should be between 1 and " + size);
			return false;
		}

		if (head == null) {
			return false;
		}

		Node current = head;
		if (position == 1) {
			// Delete at the beginning
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
			if (head == null) {
				tail = null;
			}
		} else if (position == size) {
			// Delete at the end
			current = tail;
			tail = tail.prev;
			if (tail != null) {
				tail.next = null;
			}
			if (tail == null) {
				head = null;
			}
		} else {
			// Delete at the specified position
			for (int i = 1; i < position; i++) {
				current = current.next;
			}
			current.prev.next = current.next;
			if (current.next != null) {
				current.next.prev = current.prev;
			}
		}
		size--;
		return true;
	}

	// Method to print the doubly linked list from head to tail
	public void printForward() {
		Node current = head;
		System.out.print("List (head to tail): ");
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	// Method to print the doubly linked list from tail to head
	public void printBackward() {
		Node current = tail;
		System.out.print("List (tail to head): ");
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.prev;
		}
		System.out.println();
	}

	// Method to sort the doubly linked list in ascending order
	public void sortAscending() {
		Node current = head;
		Node index = null;
		int temp;

		if (head == null) {
			return;
		} else {
			while (current != null) {
				index = current.next;

				while (index != null) {
					if (current.data > index.data) {
						temp = current.data;
						current.data = index.data;
						index.data = temp;
					}
					index = index.next;
				}
				current = current.next;
			}
		}
	}

	// Method to sort the doubly linked list in descending order
	public void sortDescending() {
		Node current = head;
		Node index = null;
		int temp;

		if (head == null) {
			return;
		} else {
			while (current != null) {
				index = current.next;

				while (index != null) {
					if (current.data < index.data) {
						temp = current.data;
						current.data = index.data;
						index.data = temp;
					}
					index = index.next;
				}
				current = current.next;
			}
		}
	}

	// Method to search for a specific element in the doubly linked list
	public boolean search(int data) {
		Node current = head;
		while (current != null) {
			if (current.data == data) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Method to count the number of elements in the doubly linked list
	public int count() {
		return size;
	}

	// Method to find the maximum element in the doubly linked list
	public int maximum() {
		if (head == null) {
			throw new IllegalStateException("List is empty");
		}
		Node current = head;
		int max = current.data;
		while (current != null) {
			if (current.data > max) {
				max = current.data;
			}
			current = current.next;
		}
		return max;
	}

	// Method to find the minimum element in the doubly linked list
	public int minimum() {
		if (head == null) {
			throw new IllegalStateException("List is empty");
		}
		Node current = head;
		int min = current.data;
		while (current != null) {
			if (current.data < min) {
				min = current.data;
			}
			current = current.next;
		}
		return min;
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		Scanner scanner = new Scanner(System.in);
		int choice, data, position;

		while (true) {
			System.out.println("\nDoubly Linked List Operations:");
			System.out.println("1. Insert at Position");
			System.out.println("2. Delete at Position");
			System.out.println("3. Print Forward");
			System.out.println("4. Print Backward");
			System.out.println("5. Sort Ascending");
			System.out.println("6. Sort Descending");
			System.out.println("7. Search");
			System.out.println("8. Count");
			System.out.println("9. Maximum Element");
			System.out.println("10. Minimum Element");
			System.out.println("11. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter data to insert: ");
				data = scanner.nextInt();
				System.out.print("Enter position to insert: ");
				position = scanner.nextInt();
				list.insertAtPosition(data, position);
				break;
			case 2:
				System.out.print("Enter position to delete: ");
				position = scanner.nextInt();
				if (list.deleteAtPosition(position)) {
					System.out.println("Node at position " + position + " deleted from the list.");
				} else {
					System.out.println("Unable to delete. Invalid position or list is empty.");
				}
				break;
			case 3:
				list.printForward();
				break;
			case 4:
				list.printBackward();
				break;
			case 5:
				list.sortAscending();
				list.printForward();
				break;
			case 6:
				list.sortDescending();
				list.printForward();
				break;
			case 7:
				System.out.print("Enter data to search: ");
				data = scanner.nextInt();
				if (list.search(data)) {
					System.out.println(data + " found in the list.");
				} else {
					System.out.println(data + " not found in the list.");
				}
				break;
			case 8:
				System.out.println("Size of the list: " + list.count());
				break;
			case 9:
				System.out.println("Maximum element: " + list.maximum());
				break;
			case 10:
				System.out.println("Minimum element: " + list.minimum());
				break;
			case 11:
				System.out.println("Exiting...");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}
