package com.app.coins;

class TreeNodeG {
	int val;
	TreeNodeG left;
	TreeNodeG right;

	TreeNodeG(int x) {
		val = x;
	}
}

public class DistributeCoinsInBinaryTree {
	private int moves = 0;

	public int distributeCoins(TreeNodeG root) {
		postOrder(root);
		return moves;
	}

	private int postOrder(TreeNodeG node) {
		if (node == null) {
			return 0;
		}

		int left = postOrder(node.left);
		int right = postOrder(node.right);

		// Calculate the number of moves needed for the current node
		moves += Math.abs(left) + Math.abs(right);

		// Return the balance of coins: number of coins in the current node - 1 (for the
		// current node)
		// plus the balance of coins from the left and right subtrees
		return node.val + left + right - 1;
	}

	public static void main(String[] args) {
		// Constructing the binary tree: [3, 0, 0]
		TreeNodeG root = new TreeNodeG(3);
		root.left = new TreeNodeG(0);
		root.right = new TreeNodeG(0);

		DistributeCoinsInBinaryTree solution = new DistributeCoinsInBinaryTree();
		int result = solution.distributeCoins(root);

		// Print the minimum number of moves
		System.out.println("Minimum number of moves required: " + result); // Output: 2
	}
}
