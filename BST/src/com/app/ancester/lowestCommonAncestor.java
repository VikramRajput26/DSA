package com.app.ancester;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class lowestCommonAncestor {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;

		int curr = root.val;

		if (curr < p.val && curr < q.val) {
			// If both p and q are greater than root, then LCA lies in right subtree
			return lowestCommonAncestor(root.right, p, q);
		}

		if (curr > p.val && curr > q.val) {
			// If both p and q are less than root, then LCA lies in left subtree
			return lowestCommonAncestor(root.left, p, q);
		}

		// If p and q lie on either side or one of them is equal to root, then root is
		// LCA
		return root;
	}

	public static void main(String[] args) {
		lowestCommonAncestor sol = new lowestCommonAncestor();

		// Create the example BST
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);

		TreeNode p = root.left; // Node with value 2
		TreeNode q = root.right; // Node with value 8

		TreeNode lca = sol.lowestCommonAncestor(root, p, q);
		System.out.println("The LCA of nodes " + p.val + " and " + q.val + " is: " + lca.val);
	}
}
