package com.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

import com.leet.dsa30days2.TreeNode;

public class VerticalOrderTraversalBinaryTree {

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		// Map: Column -> (Map: Row -> Sorted Values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        dfs(root, 0, 0, map);
        
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> currentColumn = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : rows.values()) {
                // Empty the PQ to maintain sorted order for identical coordinates
                while (!nodes.isEmpty()) {
                    currentColumn.add(nodes.poll());
                }
            }
            result.add(currentColumn);
        }
        return result;
	}
	
	private void dfs(TreeNode node, int col, int row, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) return;
        
        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        map.get(col).get(row).offer(node.val);
        
        dfs(node.left, col - 1, row + 1, map);
        dfs(node.right, col + 1, row + 1, map);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		VerticalOrderTraversalBinaryTree solution = new VerticalOrderTraversalBinaryTree();
		List<List<Integer>> result = solution.verticalTraversal(root);
		for (List<Integer> level : result) {
			for (Integer val : level) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(5);
		root2.right.left = new TreeNode(6);
		root2.right.right = new TreeNode(7);
		result = solution.verticalTraversal(root2);
		for (List<Integer> level : result) {
			for (Integer val : level) {
				System.out.print(val + " ");
			}
			System.out.println();
		}

	}

}
