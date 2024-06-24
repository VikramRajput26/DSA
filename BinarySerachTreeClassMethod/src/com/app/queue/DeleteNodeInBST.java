package com.app.queue;

class TreeNodeG {
	int val;
	TreeNodeG left;
	TreeNodeG right;

	TreeNodeG(int x) {
		val = x;
	}
}

public class DeleteNodeInBST {

	public TreeNodeG deleteNode(TreeNodeG root, int key) {
		if (root == null)
			return null;

		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			// Node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// Node with two children: Get the inorder successor (smallest in the right
			// subtree)
			root.val = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteNode(root.right, root.val);
		}

		return root;
	}

	private int minValue(TreeNodeG root) {
		int minValue = root.val;
		while (root.left != null) {
			minValue = root.left.val;
			root = root.left;
		}
		return minValue;
	}

	public static void main(String[] args) {
		// Constructing the BST: [5,3,6,2,4,null,7]
		TreeNodeG root = new TreeNodeG(5);
		root.left = new TreeNodeG(3);
		root.right = new TreeNodeG(6);
		root.left.left = new TreeNodeG(2);
		root.left.right = new TreeNodeG(4);
		root.right.right = new TreeNodeG(7);

		int key = 3;

		DeleteNodeInBST solution = new DeleteNodeInBST();
		TreeNodeG newRoot = solution.deleteNode(root, key);

		printTree(newRoot);
	}

	private static void printTree(TreeNodeG node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val + " ");
		printTree(node.left);
		printTree(node.right);
	}
}
