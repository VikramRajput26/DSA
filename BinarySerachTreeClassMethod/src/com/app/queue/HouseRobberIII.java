package com.app.queue;

import java.util.HashMap;
import java.util.Map;

class TreeNodeF {
	int val;
	TreeNodeF left;
	TreeNodeF right;

	TreeNodeF(int x) {
		val = x;
	}
}

public class HouseRobberIII {

	Map<TreeNodeF, int[]> memo = new HashMap<>();

	public int rob(TreeNodeF root) {
		int[] result = robSub(root);
		return Math.max(result[0], result[1]);
	}

	private int[] robSub(TreeNodeF node) {
		if (node == null) {
			return new int[] { 0, 0 };
		}

		if (memo.containsKey(node)) {
			return memo.get(node);
		}

		int[] left = robSub(node.left);
		int[] right = robSub(node.right);

		// dp[0] = max money if not robbing current node
		// dp[1] = max money if robbing current node
		int[] dp = new int[2];

		dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // not rob current
		dp[1] = node.val + left[0] + right[0]; // rob current

		memo.put(node, dp);
		return dp;
	}

	public static void main(String[] args) {
		// Example usage:
		// Constructing the binary tree: [3,2,3,null,3,null,1]
		TreeNodeF root = new TreeNodeF(3);
		root.left = new TreeNodeF(2);
		root.right = new TreeNodeF(3);
		root.left.right = new TreeNodeF(3);
		root.right.right = new TreeNodeF(1);

		HouseRobberIII solution = new HouseRobberIII();
		int maxMoney = solution.rob(root);

		System.out.println("Maximum amount of money the thief can rob: " + maxMoney);
	}
}
