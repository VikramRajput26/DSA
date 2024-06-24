package com.app.delete;

class TreeNodeI {
	int val;
	TreeNodeI left;
	TreeNodeI right;

	TreeNodeI(int x) {
		val = x;
	}
}

public class DeleteNodeInBST {

	public TreeNodeI deleteNode(TreeNodeI root, int key) {
		if (root == null)
			return null;

		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			// Node to be deleted is found
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			// Node with two children: Get the inorder successor (smallest in the right
			// subtree)
			root.val = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteNode(root.right, root.val);
		}

		return root;
	}

	private int minValue(TreeNodeI root) {
		int minValue = root.val;
		while (root.left != null) {
			minValue = root.left.val;
			root = root.left;
		}
		return minValue;
	}

	public static void main(String[] args) {
		// Constructing the BST: [5,3,6,2,4,null,7]
		TreeNodeI root = new TreeNodeI(5);
		root.left = new TreeNodeI(3);
		root.right = new TreeNodeI(6);
		root.left.left = new TreeNodeI(2);
		root.left.right = new TreeNodeI(4);
		root.right.right = new TreeNodeI(7);

		int key = 3;

		DeleteNodeInBST solution = new DeleteNodeInBST();
		TreeNodeI newRoot = solution.deleteNode(root, key);

		printTree(newRoot);
	}

	private static void printTree(TreeNodeI node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val + " ");
		printTree(node.left);
		printTree(node.right);
	}
}
