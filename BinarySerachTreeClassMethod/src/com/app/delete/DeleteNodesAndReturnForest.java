package com.app.delete;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNodeD {
	int val;
	TreeNodeD left;
	TreeNodeD right;

	TreeNodeD(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class DeleteNodesAndReturnForest {

	public List<TreeNodeD> delNodes(TreeNodeD root, int[] to_delete) {
		Set<Integer> toDeleteSet = new HashSet<>();
		for (int val : to_delete) {
			toDeleteSet.add(val);
		}

		List<TreeNodeD> forest = new ArrayList<>();
		root = dfs(root, toDeleteSet, forest);

		if (root != null) {
			forest.add(root);
		}

		return forest;
	}

	private TreeNodeD dfs(TreeNodeD node, Set<Integer> toDeleteSet, List<TreeNodeD> forest) {
		if (node == null) {
			return null;
		}

		node.left = dfs(node.left, toDeleteSet, forest);
		node.right = dfs(node.right, toDeleteSet, forest);

		if (toDeleteSet.contains(node.val)) {
			if (node.left != null) {
				forest.add(node.left);
			}
			if (node.right != null) {
				forest.add(node.right);
			}
			return null;
		}

		return node;
	}

	// Helper method to print the forest
	public void printForest(List<TreeNodeD> forest) {
		for (TreeNodeD root : forest) {
			printTree(root);
			System.out.println();
		}
	}

	private void printTree(TreeNodeD node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val + " ");
		printTree(node.left);
		printTree(node.right);
	}

	public static void main(String[] args) {
		// Constructing the binary tree: [1,2,3,4,5,6,7]
		TreeNodeD root = new TreeNodeD(1);
		root.left = new TreeNodeD(2);
		root.right = new TreeNodeD(3);
		root.left.left = new TreeNodeD(4);
		root.left.right = new TreeNodeD(5);
		root.right.left = new TreeNodeD(6);
		root.right.right = new TreeNodeD(7);

		int[] to_delete = { 3, 5 };

		DeleteNodesAndReturnForest solution = new DeleteNodesAndReturnForest();
		List<TreeNodeD> forest = solution.delNodes(root, to_delete);

		// Print the resulting forest
		solution.printForest(forest);
	}
}
