package com.app.validbst;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode node, long minVal, long maxVal) {
		if (node == null) {
			return true;
		}
		if (node.val >= maxVal || node.val <= minVal) {
			return false;
		}
		return isValidBST(node.left, minVal, node.val) && isValidBST(node.right, node.val, maxVal);
	}

	public static void main(String[] args) {
		ValidateBST validator = new ValidateBST();

		// Create the example BST
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);

		boolean isValid = validator.isValidBST(root);
		System.out.println("The tree is a valid BST: " + isValid);
	}
}
