package com.app.maxsum;

class TreeNodeH {
	int val;
	TreeNodeH left;
	TreeNodeH right;

	TreeNodeH(int x) {
		val = x;
	}
}

public class MaxPathSum {
	private int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNodeH root) {
		calculateMaxGain(root);
		return maxSum;
	}

	private int calculateMaxGain(TreeNodeH node) {
		if (node == null) {
			return 0;
		}

		// Recursively calculate the maximum gain from left and right subtrees
		int leftGain = Math.max(calculateMaxGain(node.left), 0);
		int rightGain = Math.max(calculateMaxGain(node.right), 0);

		// Current path sum including the node itself
		int currentPathSum = node.val + leftGain + rightGain;

		// Update the global maximum path sum
		maxSum = Math.max(maxSum, currentPathSum);

		// Return the maximum gain to be used by the parent node's calculation
		return node.val + Math.max(leftGain, rightGain);
	}

	public static void main(String[] args) {
		// Constructing the binary tree: [-10,9,20,null,null,15,7]
		TreeNodeH root = new TreeNodeH(-10);
		root.left = new TreeNodeH(11);
		root.right = new TreeNodeH(20);
		root.right.left = new TreeNodeH(15);
		root.right.right = new TreeNodeH(10);

		MaxPathSum solution = new MaxPathSum();
		int result = solution.maxPathSum(root);

		// Print the maximum path sum
		System.out.println("Maximum path sum: " + result); // Output: 42
	}
}
