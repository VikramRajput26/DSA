package com.app.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNodeD {
	int val;
	TreeNodeD left;
	TreeNodeD right;

	TreeNodeD(int x) {
		val = x;
	}
}

public class DuplicateSubtrees {

	public List<TreeNodeD> findDuplicateSubtrees(TreeNodeD root) {
		List<TreeNodeD> duplicateSubtrees = new ArrayList<>();
		Map<String, Integer> subtreeMap = new HashMap<>();
		serializeSubtree(root, subtreeMap, duplicateSubtrees);
		return duplicateSubtrees;
	}

	private String serializeSubtree(TreeNodeD node, Map<String, Integer> subtreeMap, List<TreeNodeD> duplicates) {
		if (node == null) {
			return "#";
		}

		String left = serializeSubtree(node.left, subtreeMap, duplicates);
		String right = serializeSubtree(node.right, subtreeMap, duplicates);

		String subtree = node.val + "," + left + "," + right;
		subtreeMap.put(subtree, subtreeMap.getOrDefault(subtree, 0) + 1);

		if (subtreeMap.get(subtree) == 2) {
			duplicates.add(node);
		}

		return subtree;
	}

	public static void main(String[] args) {
		// Example usage:
		// Constructing the binary tree: [2,2,2,3,null,3,null]
		TreeNodeD root = new TreeNodeD(2);
		root.left = new TreeNodeD(2);
		root.right = new TreeNodeD(2);
		root.left.left = new TreeNodeD(3);
		root.right.right = new TreeNodeD(3);

		DuplicateSubtrees solution = new DuplicateSubtrees();
		List<TreeNodeD> result = solution.findDuplicateSubtrees(root);

		// Printing the values of nodes in duplicate subtrees
		for (TreeNodeD subtreeRoot : result) {
			printTree(subtreeRoot);
			System.out.println();
		}
	}

	private static void printTree(TreeNodeD node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val + " ");
		printTree(node.left);
		printTree(node.right);
	}
}
