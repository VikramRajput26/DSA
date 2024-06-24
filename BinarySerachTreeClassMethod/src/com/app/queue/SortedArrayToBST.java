package com.app.queue;

public class SortedArrayToBST {
	public Node sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	private Node sortedArrayToBST(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}

		int mid = left + (right - left) / 2;
		Node node = new Node(nums[mid]);
		node.setLeft(sortedArrayToBST(nums, left, mid - 1));
		node.setRight(sortedArrayToBST(nums, mid + 1, right));

		return node;
	}

	// Helper method to print the tree in level order (for testing purposes)
	public void printTree(Node root) {
		if (root == null) {
			return;
		}

		java.util.Queue<Node> queue = new java.util.LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			System.out.print(current.getData() + " ");

			if (current.getLeft() != null) {
				queue.add(current.getLeft());
			}

			if (current.getRight() != null) {
				queue.add(current.getRight());
			}
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = { -10, -3, 0, 5, 9 };

		SortedArrayToBST tree = new SortedArrayToBST();
		Node root = tree.sortedArrayToBST(nums);

		System.out.println("BST from sorted array:");
		tree.printTree(root);
	}
}
