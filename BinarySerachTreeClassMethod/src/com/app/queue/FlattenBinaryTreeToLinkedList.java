package com.app.queue;

class TreeNodeE {
	int val;
	TreeNodeE left;
	TreeNodeE right;

	TreeNodeE(int x) {
		val = x;
	}
}

public class FlattenBinaryTreeToLinkedList {

	public void flatten(TreeNodeE root) {
		if (root == null) {
			return;
		}
		flattenTree(root);
	}

	private TreeNodeE flattenTree(TreeNodeE node) {
		if (node == null) {
			return null;
		}

		// Recursively flatten left and right subtrees
		TreeNodeE leftLast = flattenTree(node.left);
		TreeNodeE rightLast = flattenTree(node.right);

		// Save the right subtree to reconnect later
		TreeNodeE rightSubtree = node.right;

		// Connect the flattened left subtree to the right of the current node
		if (leftLast != null) {
			node.right = node.left;
			node.left = null;
			leftLast.right = rightSubtree;
		}

		// Return the last node of the flattened subtree
		return rightLast != null ? rightLast : (leftLast != null ? leftLast : node);
	}

	public static void main(String[] args) {
		// Example usage:
		// Constructing the binary tree: [1,2,5,3,4,null,6]
		TreeNodeE root = new TreeNodeE(1);
		root.left = new TreeNodeE(2);
		root.right = new TreeNodeE(5);
		root.left.left = new TreeNodeE(3);
		root.left.right = new TreeNodeE(4);
		root.right.right = new TreeNodeE(6);

		FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();
		solution.flatten(root);

		// Printing the flattened linked list
		printLinkedList(root);
	}

	private static void printLinkedList(TreeNodeE node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.right;
		}
		System.out.println();
	}
}
