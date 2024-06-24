package com.app.delete;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Definition for a binary tree node
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

// Helper class to keep track of the node and its state
class Pair {
	TreeNode node;
	int num;

	Pair(TreeNode node, int num) {
		this.node = node;
		this.num = num;
	}
}

public class DeleteNode {
	TreeNode root;

	// Method to insert a value into the BST
	public void insert(int val) {
		root = insertRec(root, val);
	}

	private TreeNode insertRec(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
			return root;
		}
		if (val < root.val) {
			root.left = insertRec(root.left, val);
		} else if (val > root.val) {
			root.right = insertRec(root.right, val);
		}
		return root;
	}

	// Method to perform pre-order, in-order, and post-order traversals
	public void preInPostTraversal(TreeNode root) {
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(root, 1));
		List<Integer> pre = new ArrayList<>();
		List<Integer> in = new ArrayList<>();
		List<Integer> post = new ArrayList<>();

		if (root == null)
			return;

		while (!st.isEmpty()) {
			Pair it = st.pop();

			// This is part of pre-order
			if (it.num == 1) {
				pre.add(it.node.val);
				it.num++;
				st.push(it);
				if (it.node.left != null) {
					st.push(new Pair(it.node.left, 1));
				}
			}
			// This is part of in-order
			else if (it.num == 2) {
				in.add(it.node.val);
				it.num++;
				st.push(it);
				if (it.node.right != null) {
					st.push(new Pair(it.node.right, 1));
				}
			}
			// This is part of post-order
			else {
				post.add(it.node.val);
			}
		}

		System.out.println("Pre-order Traversal: " + pre);
		System.out.println("In-order Traversal: " + in);
		System.out.println("Post-order Traversal: " + post);
	}

	// Method to delete a node from the BST
	public void delete(int key) {
		root = deleteRec(root, key);
	}

	private TreeNode deleteRec(TreeNode root, int key) {
		if (root == null)
			return root;

		// Recur down the tree
		if (key < root.val)
			root.left = deleteRec(root.left, key);
		else if (key > root.val)
			root.right = deleteRec(root.right, key);
		else {
			// Node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// Node with two children: Get the inorder successor (smallest in the right
			// subtree)
			root.val = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.val);
		}

		return root;
	}

	private int minValue(TreeNode root) {
		int minv = root.val;
		while (root.left != null) {
			minv = root.left.val;
			root = root.left;
		}
		return minv;
	}

	public static void main(String[] args) {
		DeleteNode bst = new DeleteNode();
		bst.insert(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(3);
		bst.insert(7);
		bst.insert(13);
		bst.insert(18);

		System.out.println("Before deletion:");
		bst.preInPostTraversal(bst.root);

		bst.delete(10); // Delete node with value 10

		System.out.println("After deletion:");
		bst.preInPostTraversal(bst.root);
	}
}
