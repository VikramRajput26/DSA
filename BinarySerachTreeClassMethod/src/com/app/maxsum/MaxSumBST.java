package com.app.maxsum;

class TreeNodeI {
	int val;
	TreeNodeI left;
	TreeNodeI right;

	TreeNodeI(int x) {
		val = x;
	}
}

public class MaxSumBST {
	private static class NodeInfo {
		boolean isBST;
		int min;
		int max;
		int sum;

		NodeInfo(boolean isBST, int min, int max, int sum) {
			this.isBST = isBST;
			this.min = min;
			this.max = max;
			this.sum = sum;
		}
	}

	private int maxSum = 0;

	public int maxSumBST(TreeNodeI root) {
		postOrder(root);
		return maxSum;
	}

	private NodeInfo postOrder(TreeNodeI node) {
		if (node == null) {
			return new NodeInfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		NodeInfo leftInfo = postOrder(node.left);
		NodeInfo rightInfo = postOrder(node.right);

		if (leftInfo.isBST && rightInfo.isBST && node.val > leftInfo.max && node.val < rightInfo.min) {
			int currentSum = node.val + leftInfo.sum + rightInfo.sum;
			maxSum = Math.max(maxSum, currentSum);
			return new NodeInfo(true, Math.min(node.val, leftInfo.min), Math.max(node.val, rightInfo.max), currentSum);
		} else {
			return new NodeInfo(false, 0, 0, 0);
		}
	}

	public static void main(String[] args) {
		TreeNodeI root = new TreeNodeI(1);
		root.left = new TreeNodeI(4);
		root.right = new TreeNodeI(3);
		root.left.left = new TreeNodeI(2);
		root.left.right = new TreeNodeI(4);
		root.right.left = new TreeNodeI(2);
		root.right.right = new TreeNodeI(5);
		root.right.right.left = new TreeNodeI(4);
		root.right.right.right = new TreeNodeI(6);

		MaxSumBST solution = new MaxSumBST();
		int result = solution.maxSumBST(root);
		System.out.println("Maximum sum of all keys of any sub-tree which is also a BST: " + result);
	}
}
