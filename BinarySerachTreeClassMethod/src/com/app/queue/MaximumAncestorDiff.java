package com.app.queue;

class TreeNodeC {
	int val;
	TreeNodeC left;
	TreeNodeC right;

	TreeNodeC(int x) {
		val = x;
	}
}

public class MaximumAncestorDiff {

	public int maxAncestorDiff(TreeNodeC root) {
		return maxAncestorDiff(root, root.val, root.val);
	}

	private int maxAncestorDiff(TreeNodeC node, int minAncestor, int maxAncestor) {
		if (node == null) {
			return 0;
		}

		// Update minAncestor and maxAncestor based on current node's value
		minAncestor = Math.min(minAncestor, node.val);
		maxAncestor = Math.max(maxAncestor, node.val);

		// Compute the potential maximum difference at current node
		int currentMaxDiff = Math.max(Math.abs(node.val - minAncestor), Math.abs(node.val - maxAncestor));

		// Recursively find max diff in left and right subtrees
		int leftMaxDiff = maxAncestorDiff(node.left, minAncestor, maxAncestor);
		int rightMaxDiff = maxAncestorDiff(node.right, minAncestor, maxAncestor);

		// Return the maximum of currentMaxDiff, leftMaxDiff, and rightMaxDiff
		return Math.max(currentMaxDiff, Math.max(leftMaxDiff, rightMaxDiff));
	}

	public static void main(String[] args) {
		// Example usage:
		// Constructing the binary tree: [8,3,10,1,6,null,14,null,null,4,7,13]
		TreeNodeC root = new TreeNodeC(8);
		root.left = new TreeNodeC(3);
		root.right = new TreeNodeC(10);
		root.left.left = new TreeNodeC(1);
		root.left.right = new TreeNodeC(6);
		root.right.right = new TreeNodeC(14);
		root.left.right.left = new TreeNodeC(4);
		root.left.right.right = new TreeNodeC(7);
		root.right.right.left = new TreeNodeC(13);

		MaximumAncestorDiff solution = new MaximumAncestorDiff();
		int maxDiff = solution.maxAncestorDiff(root);

		System.out.println("Maximum ancestor difference: " + maxDiff);
	}
}
