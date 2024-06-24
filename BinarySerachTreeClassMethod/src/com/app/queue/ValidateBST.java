package com.app.queue;

class TreeNodeSolution {
	int val;
	TreeNodeSolution left;
	TreeNodeSolution right;

	TreeNodeSolution(int x) {
		val = x;
	}
}

public class ValidateBST {

	public boolean isValidBST(TreeNodeSolution root) {
		return isValidBST(root, null, null);
	}

	private boolean isValidBST(TreeNodeSolution node, Integer min, Integer max) {
		if (node == null) {
			return true;
		}

		// Check if current node's value is within the valid range
		if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
			return false;
		}

		// Recursively check left and right subtrees
		return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
	}

	public static void main(String[] args) {
		// Constructing the binary tree: [5,1,4,null,null,3,6]
		TreeNodeSolution root = new TreeNodeSolution(5);
		root.left = new TreeNodeSolution(1);
		root.right = new TreeNodeSolution(4);
		root.right.left = new TreeNodeSolution(3);
		root.right.right = new TreeNodeSolution(6);

		ValidateBST validator = new ValidateBST();
		boolean isValid = validator.isValidBST(root);

		System.out.println("Is the binary tree a valid BST? " + isValid);

		// Additional test case: [2,1,3]
		TreeNodeSolution root2 = new TreeNodeSolution(2);
		root2.left = new TreeNodeSolution(1);
		root2.right = new TreeNodeSolution(3);

		boolean isValid2 = validator.isValidBST(root2);

		System.out.println("Is the binary tree a valid BST? " + isValid2);
	}
}
