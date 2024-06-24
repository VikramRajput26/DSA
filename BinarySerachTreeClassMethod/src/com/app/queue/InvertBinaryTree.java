package com.app.queue;

public class InvertBinaryTree {
	public Node invertTree(Node root) {
		if (root == null) {
			return null;
		}

		// Swap the left and right children
		Node temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);

		// Recursively invert the left and right subtrees
		invertTree(root.getLeft());
		invertTree(root.getRight());

		return root;
	}

	// Helper method to print the tree in level order (for testing purposes)
	public void printTree(Node root) {
		if (root == null) {
			return;
		}

		java.util.Queue<Node> queue = new java.util.LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			System.out.print(current.getData() + " ");

			if (current.getLeft() != null) {
				queue.add(current.getLeft());
			}

			if (current.getRight() != null) {
				queue.add(current.getRight());
			}
		}

		System.out.println();
	}

	public static void main(String[] args) {
		Node root = new Node(4);
		root.setLeft(new Node(2));
		root.setRight(new Node(7));
		root.getLeft().setLeft(new Node(1));
		root.getLeft().setRight(new Node(3));
		root.getRight().setLeft(new Node(6));
		root.getRight().setRight(new Node(9));

		System.out.println("Original tree:");
		InvertBinaryTree tree = new InvertBinaryTree();
		tree.printTree(root);

		root = tree.invertTree(root);

		System.out.println("Inverted tree:");
		tree.printTree(root);
	}
}
