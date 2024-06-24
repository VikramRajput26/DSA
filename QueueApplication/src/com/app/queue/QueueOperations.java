package com.app.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueOperations {
	private Queue<Integer> queue;

	public QueueOperations() {
		queue = new LinkedList<>();
	}

	// Method to insert an element into the queue
	public void insert(int value) {
		queue.offer(value);
		System.out.println(value + " inserted into the queue.");
	}

	// Method to delete an element from the queue
	public int delete() {
		if (queue.isEmpty()) {
			System.out.println("Queue underflow. Cannot delete. Queue is empty.");
			return -1; // Return a default value indicating queue underflow
		} else {
			return queue.poll();
		}
	}

	// Method to print all elements in the queue
	public void print() {
		if (queue.isEmpty()) {
			System.out.println("Queue is empty.");
		} else {
			System.out.print("Queue elements: ");
			for (Integer element : queue) {
				System.out.print(element + " ");
			}
			System.out.println(); // Print a new line after printing all elements
		}
	}

	// Method to sort the queue in ascending order
	public void sortAscending() {
		Queue<Integer> tempQueue = new LinkedList<>(queue);
		Queue<Integer> sortedQueue = new LinkedList<>();

		while (!tempQueue.isEmpty()) {
			int min = Integer.MAX_VALUE;
			// Find minimum element in tempQueue
			for (int i = 0; i < tempQueue.size(); i++) {
				int current = tempQueue.poll();
				if (current < min) {
					min = current;
				}
				tempQueue.offer(current);
			}
			// Remove the found minimum element from tempQueue and add to sortedQueue
			for (int i = 0; i < tempQueue.size(); i++) {
				int current = tempQueue.poll();
				if (current != min) {
					tempQueue.offer(current);
				}
			}
			sortedQueue.offer(min);
		}
		queue = sortedQueue;
		System.out.println("Queue sorted in ascending order.");
	}

	// Method to sort the queue in descending order
	public void sortDescending() {
		Queue<Integer> tempQueue = new LinkedList<>(queue);
		Queue<Integer> sortedQueue = new LinkedList<>();

		while (!tempQueue.isEmpty()) {
			int max = Integer.MIN_VALUE;
			// Find maximum element in tempQueue
			for (int i = 0; i < tempQueue.size(); i++) {
				int current = tempQueue.poll();
				if (current > max) {
					max = current;
				}
				tempQueue.offer(current);
			}
			// Remove the found maximum element from tempQueue and add to sortedQueue
			for (int i = 0; i < tempQueue.size(); i++) {
				int current = tempQueue.poll();
				if (current != max) {
					tempQueue.offer(current);
				}
			}
			sortedQueue.offer(max);
		}
		queue = sortedQueue;
		System.out.println("Queue sorted in descending order.");
	}

	// Method to search for an element in the queue
	public boolean search(int value) {
		return queue.contains(value);
	}

	// Method to count the number of elements in the queue
	public int count() {
		return queue.size();
	}

	// Method to find the maximum element in the queue
	public int maximum() {
		if (queue.isEmpty()) {
			return Integer.MIN_VALUE; // Return minimum integer value if queue is empty
		}
		int max = Integer.MIN_VALUE;
		for (Integer element : queue) {
			if (element > max) {
				max = element;
			}
		}
		return max;
	}

	// Method to find the minimum element in the queue
	public int minimum() {
		if (queue.isEmpty()) {
			return Integer.MAX_VALUE; // Return maximum integer value if queue is empty
		}
		int min = Integer.MAX_VALUE;
		for (Integer element : queue) {
			if (element < min) {
				min = element;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		QueueOperations queue = new QueueOperations();
		int choice, element;

		while (true) {
			System.out.println("\nQueue Operations Menu:");
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Print Queue");
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
				queue.insert(element);
				break;
			case 2:
				int deletedElement = queue.delete();
				if (deletedElement != -1) {
					System.out.println("Deleted element: " + deletedElement);
				}
				break;
			case 3:
				queue.print();
				break;
			case 4:
				queue.sortAscending();
				break;
			case 5:
				queue.sortDescending();
				break;
			case 6:
				System.out.print("Enter element to search: ");
				element = scanner.nextInt();
				if (queue.search(element)) {
					System.out.println(element + " found in the queue.");
				} else {
					System.out.println(element + " not found in the queue.");
				}
				break;
			case 7:
				System.out.println("Number of elements in the queue: " + queue.count());
				break;
			case 8:
				System.out.println("Maximum element in the queue: " + queue.maximum());
				break;
			case 9:
				System.out.println("Minimum element in the queue: " + queue.minimum());
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
