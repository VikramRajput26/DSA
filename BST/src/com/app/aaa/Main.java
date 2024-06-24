package com.app.aaa;

public class Main {
	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(50);
		bst.insert(20);
		bst.insert(10);
		bst.insert(40);
		bst.insert(90);
		bst.insert(80);
		bst.insert(60);
		bst.insert(70);
		bst.insert(100);
		bst.insert(90);
		bst.insert(30);

		System.out.println("Pre order");
		bst.preOrder();
		System.out.println();

		System.out.println("In order");
		bst.inOrder();
		System.out.println();

		System.out.println("Post order");
		bst.postOrder();
		System.out.println();

		System.out.println("The element Present : " + bst.search(50));

		bst.delete(50);

		System.out.println();

		bst.preOrder();
		System.out.println();

		bst.inOrder();
		System.out.println();

		bst.postOrder();
		System.out.println();

		bst.delete(80);

		System.out.println();

		bst.preOrder();
		System.out.println();

		bst.inOrder();
		System.out.println();

		bst.postOrder();
		System.out.println();
	}
}

class Node {
	int val;
	Node left;
	Node right;

	Node(int x) {
		val = x;
		left = null;
		right = null;
	}
}

class BinarySearchTree {
	private Node root;

	public void insert(int val) {
		root = insertRec(root, val);
	}

	private Node insertRec(Node root, int val) {
		if (root == null) {
			root = new Node(val);
			return root;
		}
		if (val < root.val) {
			root.left = insertRec(root.left, val);
		} else if (val > root.val) {
			root.right = insertRec(root.right, val);
		}
		return root;
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		}
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.val + " ");
		}
	}

	public boolean search(int key) {
		return search(root, key);
	}

	private boolean search(Node root, int key) {
		if (root == null) {
			return false;
		}
		if (root.val == key) {
			return true;
		}
		if (key < root.val) {
			return search(root.left, key);
		} else {
			return search(root.right, key);
		}
	}

	public boolean delete(int data) {
		root = deleteRec(root, data);
		return true; // Assume successful deletion for simplicity
	}

	private Node deleteRec(Node root, int data) {
		if (root == null) {
			return null;
		}
		if (data < root.val) {
			root.left = deleteRec(root.left, data);
		} else if (data > root.val) {
			root.right = deleteRec(root.right, data);
		} else {
			// Case 1: No child or only one child
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			// Case 2: Two children
			root.val = minValue(root.right);
			root.right = deleteRec(root.right, root.val);
		}
		return root;
	}

	private int minValue(Node root) {
		int minv = root.val;
		while (root.left != null) {
			minv = root.left.val;
			root = root.left;
		}
		return minv;
	}
}
