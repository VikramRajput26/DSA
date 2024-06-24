package com.app.queue;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

public class BSTIterator {
	private Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		pushAllLeft(root);
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		if (node.right != null) {
			pushAllLeft(node.right);
		}
		return node.val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	private void pushAllLeft(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);

		BSTIterator iterator = new BSTIterator(root);
		System.out.println(iterator.next()); // 3
		System.out.println(iterator.next()); // 7
		System.out.println(iterator.hasNext()); // true
		System.out.println(iterator.next()); // 9
		System.out.println(iterator.hasNext()); // true
		System.out.println(iterator.next()); // 15
		System.out.println(iterator.hasNext()); // true
		System.out.println(iterator.next()); // 20
		System.out.println(iterator.hasNext()); // false
	}
}
