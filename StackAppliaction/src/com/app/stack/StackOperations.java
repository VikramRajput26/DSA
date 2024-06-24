package com.app.stack;

import java.util.Scanner;

public class StackOperations {
	private int maxSize; // Maximum size of stack
	private int[] stackArray; // Array to hold stack elements
	private int top; // Top of the stack

	public StackOperations(int size) {
		maxSize = size;
		stackArray = new int[maxSize];
		top = -1; // Initialize top to -1 (empty stack)
	}

	// Method to push an element onto the stack
	public void push(int value) {
		if (top == maxSize - 1) {
			System.out.println("Stack overflow. Cannot push " + value + ". Stack is full.");
		} else {
			stackArray[++top] = value;
			System.out.println(value + " pushed to stack.");
		}
	}

	// Method to pop the top element from the stack
	public int pop() {
		if (top == -1) {
			System.out.println("Stack underflow. Cannot pop. Stack is empty.");
			return -1; // Return a default value indicating stack underflow
		} else {
			return stackArray[top--];
		}
	}

	// Method to peek the top element of the stack
	public int peek() {
		if (top == -1) {
			System.out.println("Stack is empty. No elements to peek.");
			return -1; // Return a default value indicating stack is empty
		} else {
			return stackArray[top];
		}
	}

	// Method to check if the stack is empty
	public boolean isEmpty() {
		return (top == -1);
	}

	// Method to check if the stack is full
	public boolean isFull() {
		return (top == maxSize - 1);
	}

	// Method to get the size of the stack
	public int size() {
		return top + 1;
	}

	// Method to search for an element in the stack
	public boolean search(int value) {
		for (int i = 0; i <= top; i++) {
			if (stackArray[i] == value) {
				return true;
			}
		}
		return false;
	}

	// Method to sort the stack in ascending order using a temporary array
	public void sortAscending() {
		int[] tempArray = new int[maxSize];
		int tempTop = top;

		for (int i = 0; i <= top; i++) {
			int currentMin = stackArray[i];
			int minIndex = i;
			// Find the minimum element in the remaining unsorted part
			for (int j = i + 1; j <= top; j++) {
				if (stackArray[j] < currentMin) {
					currentMin = stackArray[j];
					minIndex = j;
				}
			}
			// Swap the found minimum element with the first element of the unsorted part
			int temp = stackArray[i];
			stackArray[i] = stackArray[minIndex];
			stackArray[minIndex] = temp;
		}
		System.out.println("Stack sorted in ascending order.");
	}

	// Method to sort the stack in descending order using a temporary array
	public void sortDescending() {
		int[] tempArray = new int[maxSize];
		int tempTop = top;

		for (int i = 0; i <= top; i++) {
			int currentMax = stackArray[i];
			int maxIndex = i;
			// Find the maximum element in the remaining unsorted part
			for (int j = i + 1; j <= top; j++) {
				if (stackArray[j] > currentMax) {
					currentMax = stackArray[j];
					maxIndex = j;
				}
			}
			// Swap the found maximum element with the first element of the unsorted part
			int temp = stackArray[i];
			stackArray[i] = stackArray[maxIndex];
			stackArray[maxIndex] = temp;
		}
		System.out.println("Stack sorted in descending order.");
	}

	// Method to print all elements in the stack
	public void print() {
		if (top == -1) {
			System.out.println("Stack is empty.");
		} else {
			System.out.print("Stack elements: ");
			for (int i = top; i >= 0; i--) {
				System.out.print(stackArray[i] + " ");
			}
			System.out.println(); // Print a new line after printing all elements
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the size of the stack: ");
		int size = scanner.nextInt();

		StackOperations stack = new StackOperations(size);
		int choice, element;

		while (true) {
			System.out.println("\nStack Operations Menu:");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Peek");
			System.out.println("4. Check if Empty");
			System.out.println("5. Check if Full");
			System.out.println("6. Get Size");
			System.out.println("7. Search");
			System.out.println("8. Sort Ascending");
			System.out.println("9. Sort Descending");
			System.out.println("10. Print Stack");
			System.out.println("11. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter element to push: ");
				element = scanner.nextInt();
				stack.push(element);
				break;
			case 2:
				int poppedElement = stack.pop();
				if (poppedElement != -1) {
					System.out.println("Popped element: " + poppedElement);
				}
				break;
			case 3:
				int peekedElement = stack.peek();
				if (peekedElement != -1) {
					System.out.println("Top element: " + peekedElement);
				}
				break;
			case 4:
				System.out.println("Stack empty: " + stack.isEmpty());
				break;
			case 5:
				System.out.println("Stack full: " + stack.isFull());
				break;
			case 6:
				System.out.println("Stack size: " + stack.size());
				break;
			case 7:
				System.out.print("Enter element to search: ");
				element = scanner.nextInt();
				if (stack.search(element)) {
					System.out.println(element + " found in the stack.");
				} else {
					System.out.println(element + " not found in the stack.");
				}
				break;
			case 8:
				stack.sortAscending();
				break;
			case 9:
				stack.sortDescending();
				break;
			case 10:
				stack.print();
				break;
			case 11:
				System.out.println("Exiting...");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}
}
