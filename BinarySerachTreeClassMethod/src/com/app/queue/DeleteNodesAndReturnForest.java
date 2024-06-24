package com.app.queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Renamed TreeNode to TreeNodeDM
class TreeNodeDM {
	int val;
	TreeNodeDM left, right;

	public TreeNodeDM(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

public class DeleteNodesAndReturnForest {
	public List<TreeNodeDM> delNodes(TreeNodeDM root, int[] to_delete) {
		Set<Integer> toDeleteSet = new HashSet<>();
		for (int val : to_delete) {
			toDeleteSet.add(val);
		}

		List<TreeNodeDM> forest = new ArrayList<>();
		root = dfs(root, toDeleteSet, forest);

		if (root != null) {
			forest.add(root);
		}

		return forest;
	}

	private TreeNodeDM dfs(TreeNodeDM node, Set<Integer> toDeleteSet, List<TreeNodeDM> forest) {
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

	public static void main(String[] args) {
		TreeNodeDM root = new TreeNodeDM(1);
		root.left = new TreeNodeDM(2);
		root.right = new TreeNodeDM(3);
		root.left.left = new TreeNodeDM(4);
		root.left.right = new TreeNodeDM(5);
		root.right.left = new TreeNodeDM(6);
		root.right.right = new TreeNodeDM(7);

		int[] to_delete = { 3, 5 };

		DeleteNodesAndReturnForest solution = new DeleteNodesAndReturnForest();
		List<TreeNodeDM> result = solution.delNodes(root, to_delete);

		// Print the resulting forest
		for (TreeNodeDM tree : result) {
			printTree(tree);
			System.out.println();
		}
	}

	private static void printTree(TreeNodeDM node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val + " ");
		printTree(node.left);
		printTree(node.right);
	}
}
