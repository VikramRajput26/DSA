package com.app.lca;

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

class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// Base case
		if (root == null || root == p || root == q) {
			return root;
		}

		// Recurse on the left and right subtrees
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// Result
		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else {
			// Both left and right are not null, we found our result
			return root;
		}
	}
}

public class Lca {
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

	public static void main(String[] args) {
		Lca bst = new Lca();
		bst.insert(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(3);
		bst.insert(7);
		bst.insert(13);
		bst.insert(18);

		bst.preInPostTraversal(bst.root);

		// Find the lowest common ancestor of two nodes
		Solution solution = new Solution();

		// Use actual node references from the tree
		TreeNode p = bst.root.left; // Node with value 5
		TreeNode q = bst.root.right; // Node with value 15

		TreeNode lca = solution.lowestCommonAncestor(bst.root, p, q);
		if (lca != null) {
			System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
		} else {
			System.out.println("Lowest Common Ancestor not found.");
		}
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
