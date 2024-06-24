package com.app.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class TreeNodeB {
	int val;
	TreeNodeB left;
	TreeNodeB right;

	TreeNodeB(int x) {
		val = x;
	}
}

public class BinaryTreeDistanceK {

	public List<Integer> distanceK(TreeNodeB root, int target, int k) {
		List<Integer> result = new ArrayList<>();
		if (root == null || k < 0) {
			return result;
		}

		// Build the graph from the root array
		Map<Integer, List<Integer>> graph = new HashMap<>();
		buildGraph(root, null, graph);

		// Find the target node
		TreeNodeB targetNode = findTargetNode(root, target);
		if (targetNode == null) {
			return result;
		}

		// Perform BFS to find nodes at distance k
		Queue<TreeNodeB> queue = new LinkedList<>();
		Set<TreeNodeB> visited = new HashSet<>();
		queue.offer(targetNode);
		visited.add(targetNode);

		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (level == k) {
				for (int i = 0; i < size; i++) {
					TreeNodeB node = queue.poll();
					result.add(node.val);
				}
				return result;
			}

			for (int i = 0; i < size; i++) {
				TreeNodeB node = queue.poll();
				List<Integer> neighbors = graph.getOrDefault(node.val, new ArrayList<>());
				for (int neighbor : neighbors) {
					TreeNodeB next = findTargetNode(root, neighbor);
					if (next != null && !visited.contains(next)) {
						visited.add(next);
						queue.offer(next);
					}
				}
			}
			level++;
		}

		return result;
	}

	private void buildGraph(TreeNodeB node, TreeNodeB parent, Map<Integer, List<Integer>> graph) {
		if (node == null)
			return;

		if (!graph.containsKey(node.val)) {
			graph.put(node.val, new ArrayList<>());
		}

		if (parent != null) {
			graph.get(node.val).add(parent.val);
			graph.get(parent.val).add(node.val);
		}

		buildGraph(node.left, node, graph);
		buildGraph(node.right, node, graph);
	}

	private TreeNodeB findTargetNode(TreeNodeB node, int target) {
		if (node == null)
			return null;

		if (node.val == target) {
			return node;
		}

		TreeNodeB left = findTargetNode(node.left, target);
		TreeNodeB right = findTargetNode(node.right, target);

		return left != null ? left : right;
	}

	public static void main(String[] args) {
		// Example usage:
		// Constructing the binary tree: [3,5,1,6,2,0,8,null,null,7,4]
		TreeNodeB root = new TreeNodeB(3);
		root.left = new TreeNodeB(5);
		root.right = new TreeNodeB(1);
		root.left.left = new TreeNodeB(6);
		root.left.right = new TreeNodeB(2);
		root.left.right.left = new TreeNodeB(7);
		root.left.right.right = new TreeNodeB(4);
		root.right.left = new TreeNodeB(0);
		root.right.right = new TreeNodeB(8);

		int target = 5;
		int k = 2;

		BinaryTreeDistanceK solution = new BinaryTreeDistanceK();
		List<Integer> result = solution.distanceK(root, target, k);

		System.out.println("Nodes at distance " + k + " from target " + target + ": " + result);
	}
}
