package com.app.bst;

// Definition for a binary tree node.
class TreeNode2 {
	int val;
	TreeNode2 left;
	TreeNode2 right;

	TreeNode2(int x) {
		val = x;
	}
}

public class BSTinsertNode {
	public static void main(String[] args) {
		// Construct the example tree:
		// 5
		// / \
		// 1 7
		// \
		// 2
		// \
		// 3
		TreeNode2 root = new TreeNode2(5);
		root.left = new TreeNode2(1);
		root.right = new TreeNode2(7);
		root.left.right = new TreeNode2(2);
		root.left.right.right = new TreeNode2(3);

		int X = 6;
		root = insertIntoBST(root, X);

		System.out.println("The tree after inserting " + X + " is:");
		System.out.print("In-order: ");
		printInOrder(root); // Print the tree in in-order traversal
		System.out.println();
		System.out.print("Pre-order: ");
		printPreOrder(root); // Print the tree in pre-order traversal
		System.out.println();
		System.out.print("Post-order: ");
		printPostOrder(root); // Print the tree in post-order traversal
		System.out.println();
	}

	public static TreeNode2 insertIntoBST(TreeNode2 root, int key) {
		if (root == null) {
			return new TreeNode2(key);
		}
		TreeNode2 cur = root;
		while (true) {
			if (cur.val <= key) {
				if (cur.right != null) {
					cur = cur.right;
				} else {
					cur.right = new TreeNode2(key);
					break;
				}
			} else {
				if (cur.left != null) {
					cur = cur.left;
				} else {
					cur.left = new TreeNode2(key);
					break;
				}
			}
		}
		return root;
	}

	// Helper method to print the tree in in-order traversal
	public static void printInOrder(TreeNode2 node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.print(node.val + " ");
			printInOrder(node.right);
		}
	}

	// Helper method to print the tree in pre-order traversal
	public static void printPreOrder(TreeNode2 node) {
		if (node != null) {
			System.out.print(node.val + " ");
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}

	// Helper method to print the tree in post-order traversal
	public static void printPostOrder(TreeNode2 node) {
		if (node != null) {
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.print(node.val + " ");
		}
	}
}
