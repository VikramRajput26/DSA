package com.app.reverse;

import java.util.PriorityQueue;

class ListNodeTTT {
	int val;
	ListNodeTTT next;

	ListNodeTTT(int x) {
		val = x;
	}
}

public class MergeKSortedLists1 {

	public ListNodeTTT mergeKLists(ListNodeTTT[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		// Min-heap to keep track of the smallest elements
		PriorityQueue<ListNodeTTT> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

		// Add the head of each list to the min-heap
		for (ListNodeTTT list : lists) {
			if (list != null) {
				minHeap.add(list);
			}
		}

		// Dummy node to help with the result list construction
		ListNodeTTT dummy = new ListNodeTTT(0);
		ListNodeTTT tail = dummy;

		// Build the result list
		while (!minHeap.isEmpty()) {
			ListNodeTTT minNode = minHeap.poll();
			if (tail == dummy || tail.val != minNode.val) {
				tail.next = minNode;
				tail = tail.next;
			}

			if (minNode.next != null) {
				minHeap.add(minNode.next);
			}
		}

		// Set the last node's next to null to terminate the list
		if (tail != null) {
			tail.next = null;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		// Example input: lists = [[1,4,5],[1,3,4],[2,6]]
		ListNodeTTT[] lists = new ListNodeTTT[3];

		lists[0] = new ListNodeTTT(1);
		lists[0].next = new ListNodeTTT(4);
		lists[0].next.next = new ListNodeTTT(5);

		lists[1] = new ListNodeTTT(1);
		lists[1].next = new ListNodeTTT(3);
		lists[1].next.next = new ListNodeTTT(4);

		lists[2] = new ListNodeTTT(2);
		lists[2].next = new ListNodeTTT(6);

		MergeKSortedLists1 solution = new MergeKSortedLists1();
		ListNodeTTT result = solution.mergeKLists(lists);

		// Print the resulting merged and deduplicated linked list
		printList(result); // Output: [1,2,3,4,5,6]
	}

	// Helper method to print the linked list
	private static void printList(ListNodeTTT head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}
