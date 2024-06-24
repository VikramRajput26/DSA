package com.app.queue;

public class DeleteLeavesWithTarget {
	public Node removeLeafNodes(Node root, int target) {
		if (root == null) {
			return null;
		}

		root.setLeft(removeLeafNodes(root.getLeft(), target));
		root.setRight(removeLeafNodes(root.getRight(), target));

		if (root.getLeft() == null && root.getRight() == null && root.getData() == target) {
			return null;
		}

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
		Node root = new Node(1);
		root.setLeft(new Node(2));
		root.setRight(new Node(3));
		root.getLeft().setLeft(new Node(2));
		root.getRight().setLeft(new Node(2));
		root.getRight().setRight(new Node(4));

		int target = 2;

		DeleteLeavesWithTarget tree = new DeleteLeavesWithTarget();
		System.out.println("Original tree:");
		tree.printTree(root);

		root = tree.removeLeafNodes(root, target);

		System.out.println("Tree after removing leaf nodes with target " + target + ":");
		tree.printTree(root);
	}
}