package com.app.bst;

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BSTMinimum {
	public static void main(String[] args) {
		// Construct the example tree:
		// 5
		// / \
		// 4 6
		// / \
		// 3 7
		// /
		// 1
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(1);

		System.out.println("The minimum value in the BST is: " + findMinValue(root));
	}

	public static int findMinValue(TreeNode root) {
		if (root == null) {
			throw new IllegalArgumentException("The BST is empty");
		}

		TreeNode current = root;
		// Loop down to find the leftmost leaf
		while (current.left != null) {
			current = current.left;
		}

		return current.val;
	}
}
