package com.app.queue;

public class CompleteBinaryTree {
	public int countNodes(Node root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = getHeight(root, true);
		int rightHeight = getHeight(root, false);

		if (leftHeight == rightHeight) {
			// The left subtree is a perfect binary tree
			return (1 << leftHeight) - 1;
		} else {
			// The right subtree is a perfect binary tree
			return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
		}
	}

	private int getHeight(Node root, boolean isLeft) {
		int height = 0;
		while (root != null) {
			height++;
			root = isLeft ? root.getLeft() : root.getRight();
		}
		return height;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.setLeft(new Node(2));
		root.setRight(new Node(3));
		root.getLeft().setLeft(new Node(4));
		root.getLeft().setRight(new Node(5));
		root.getRight().setLeft(new Node(6));

		CompleteBinaryTree tree = new CompleteBinaryTree();
		System.out.println("Number of nodes in the tree: " + tree.countNodes(root));
	}
}
