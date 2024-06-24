package com.app.dsa;

public class CircularQueue {
	private int[] queue;
	private int front;
	private int rear;
	private int size;
	private int capacity;

	public CircularQueue(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}

	// Method to insert an element into the circular queue
	public void enqueue(int value) {
		if (isFull()) {
			System.out.println("Queue is full. Cannot enqueue " + value);
			return;
		}

		if (isEmpty()) {
			front = 0;
		}

		rear = (rear + 1) % capacity;
		queue[rear] = value;
		size++;
		System.out.println(value + " enqueued to queue");
	}

	// Method to remove an element from the circular queue
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty. Cannot dequeue.");
			return -1;
		}

		int removedValue = queue[front];
		queue[front] = 0; // Clearing the dequeued position (optional)

		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			front = (front + 1) % capacity;
		}

		size--;
		System.out.println(removedValue + " dequeued from queue");
		return removedValue;
	}

	// Method to reverse the circular queue
	public void reverse() {
		if (isEmpty() || size == 1) {
			return; // No need to reverse if empty or only one element
		}

		int[] reversedQueue = new int[size];
		int index = 0;

		// Copy elements from queue to reversedQueue in reverse order
		for (int i = rear; i != front; i = (i - 1 + capacity) % capacity) {
			reversedQueue[index++] = queue[i];
		}
		reversedQueue[index] = queue[front]; // Adding the last element

		// Copy reversed elements back to queue
		for (int i = 0; i < size; i++) {
			queue[(front + i) % capacity] = reversedQueue[i];
		}

		System.out.println("Queue reversed");
	}

	// Method to check if the circular queue is empty
	public boolean isEmpty() {
		return size == 0;
	}

	// Method to check if the circular queue is full
	public boolean isFull() {
		return size == capacity;
	}

	// Method to print the circular queue
	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}

		System.out.print("Queue (front to rear): ");
		for (int i = front; i != rear; i = (i + 1) % capacity) {
			System.out.print(queue[i] + " ");
		}
		System.out.println(queue[rear]); // Print the last element
	}

	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue(5);

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		queue.printQueue();

		queue.dequeue();

		queue.printQueue();

		queue.reverse();

		queue.printQueue();
	}
}