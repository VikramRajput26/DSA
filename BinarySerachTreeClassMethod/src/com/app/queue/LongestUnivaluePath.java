package com.app.queue;

class TreeNodeCustom {
	int val;
	TreeNodeCustom left, right;

	public TreeNodeCustom(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

public class LongestUnivaluePath {
	private int maxLength;

	public int longestUnivaluePath(TreeNodeCustom root) {
		maxLength = 0;
		dfs(root);
		return maxLength;
	}

	private int dfs(TreeNodeCustom node) {
		if (node == null) {
			return 0;
		}

		int leftPath = dfs(node.left);
		int rightPath = dfs(node.right);

		int left = 0, right = 0;
		if (node.left != null && node.left.val == node.val) {
			left = leftPath + 1;
		}
		if (node.right != null && node.right.val == node.val) {
			right = rightPath + 1;
		}

		maxLength = Math.max(maxLength, left + right);

		return Math.max(left, right);
	}

	public static void main(String[] args) {
		TreeNodeCustom root = new TreeNodeCustom(5);
		root.left = new TreeNodeCustom(4);
		root.right = new TreeNodeCustom(5);
		root.left.left = new TreeNodeCustom(1);
		root.left.right = new TreeNodeCustom(1);
		root.right.right = new TreeNodeCustom(5);

		LongestUnivaluePath solution = new LongestUnivaluePath();
		System.out.println("Longest Univalue Path Length: " + solution.longestUnivaluePath(root)); // Output: 2
	}
}
