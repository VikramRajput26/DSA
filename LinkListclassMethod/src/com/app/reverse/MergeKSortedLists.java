package com.app.reverse;

import java.util.PriorityQueue;

class ListNodeTT {
	int val;
	ListNodeTT next;

	ListNodeTT(int x) {
		val = x;
	}
}

public class MergeKSortedLists {

	public ListNodeTT mergeKLists(ListNodeTT[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		// Min-heap to keep track of the smallest elements
		PriorityQueue<ListNodeTT> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

		// Add the head of each list to the min-heap
		for (ListNodeTT list : lists) {
			if (list != null) {
				minHeap.add(list);
			}
		}

		// Dummy node to help with the result list construction
		ListNodeTT dummy = new ListNodeTT(0);
		ListNodeTT tail = dummy;

		// Build the result list
		while (!minHeap.isEmpty()) {
			ListNodeTT minNode = minHeap.poll();
			tail.next = minNode;
			tail = tail.next;

			if (minNode.next != null) {
				minHeap.add(minNode.next);
			}
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		// Example input: lists = [[1,4,5],[1,3,4],[2,6]]
		ListNodeTT[] lists = new ListNodeTT[3];

		lists[0] = new ListNodeTT(1);
		lists[0].next = new ListNodeTT(4);
		lists[0].next.next = new ListNodeTT(5);

		lists[1] = new ListNodeTT(1);
		lists[1].next = new ListNodeTT(3);
		lists[1].next.next = new ListNodeTT(4);

		lists[2] = new ListNodeTT(2);
		lists[2].next = new ListNodeTT(6);

		MergeKSortedLists solution = new MergeKSortedLists();
		ListNodeTT result = solution.mergeKLists(lists);

		// Print the resulting merged linked list
		printList(result); // Output: [1,1,2,3,4,4,5,6]
	}

	// Helper method to print the linked list
	private static void printList(ListNodeTT head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}
