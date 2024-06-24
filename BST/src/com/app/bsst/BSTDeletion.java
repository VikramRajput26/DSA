package com.app.bsst;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BSTDeletion {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;

		if (key < root.val) {
			// The key to be deleted is in the left subtree
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			// The key to be deleted is in the right subtree
			root.right = deleteNode(root.right, key);
		} else {
			// This node needs to be deleted
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				// Node with two children: Get the inorder successor (smallest in the right
				// subtree)
				TreeNode successor = findMin(root.right);
				// Copy the inorder successor's content to this node
				root.val = successor.val;
				// Delete the inorder successor
				root.right = deleteNode(root.right, successor.val);
			}
		}

		return root;
	}

	private TreeNode findMin(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public static void main(String[] args) {
		BSTDeletion bst = new BSTDeletion();

		// Create the BST from the example
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);

		int key = 3;
		root = bst.deleteNode(root, key);

		// Code to print the tree in-order (optional, for verification)
		printInOrder(root);
	}

	// Helper method to print the tree in-order
	public static void printInOrder(TreeNode root) {
		if (root != null) {
			printInOrder(root.left);
			System.out.print(root.val + " ");
			printInOrder(root.right);
		}
	}
}
