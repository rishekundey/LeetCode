package com.binarytree;

// Definition for a binary tree node.
// public class TreeNode {
//   int val;
//  TreeNode left;
//  TreeNode right;
// TreeNode() {}
// TreeNode(int val) { this.val = val; }
// TreeNode(int val, TreeNode left, TreeNode right) {
//     this.val = val;
//     this.left = left;
//     this.right = right;
//	}
//}
// Given two integer arrays preorder and inorder where preorder is the preorder traversal of 
// a binary tree and inorder is the inorder traversal of the same tree, construct and return 
// the binary tree.
// Example 1:
// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
// Example 2:
// Input: preorder = [-1], inorder = [-1]
// Output: [-1]
// Constraints:
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder and inorder consist of unique values.
// Each value of inorder also appears in preorder.
// preorder is guaranteed to be the preorder traversal of the tree.
// inorder is guaranteed to be the inorder traversal of the tree.
// Approach:
// 1. Create a HashMap to store the index of each value in the inorder array for O(1) lookups.
// 2. Use a recursive helper function to construct the tree. The helper function will take 
// the current range of the inorder array and the current index in the preorder array.
// 3. The base case for the recursion will be when the start index is greater than the end 
// index, in which case we return null.
// 4. In each recursive call, we will create a new TreeNode with the value at the current 
// index of the preorder array, and then find the index of that value in the inorder array 
// using the HashMap.
// 5. We will then recursively build the left subtree using the left portion of the inorder 
// array and the right subtree using the right portion of the inorder array.
// 6. Finally, we will return the root of the constructed tree.
// Time Complexity: O(n) where n is the number of nodes in the tree, since we are visiting 
// each node once.
// Space Complexity: O(n) for the HashMap and the recursive call stack in the worst case 
// (when the tree is skewed).
// Alternative Approach:
// 1. Instead of using a HashMap, we can find the index of the root value in the inorder 
// array by iterating through it. This will result in a time complexity of O(n^2) in the 
// worst case (when the tree is skewed), but it will reduce the space complexity to O(1) if 
// we don't consider the recursive call stack.
// Time Complexity: O(n^2) in the worst case (when the tree is skewed).
// Space Complexity: O(n) for the recursive call stack in the worst case (when the tree is 
// skewed).
// LeetCode Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Youtube Link: https://www.youtube.com/watch?v=ihj8uYjTnXo


import java.util.HashMap;
import java.util.Map;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {

	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	
	static int preIndex = 0;
    static Map<Integer, Integer> inMap = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);

        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);
        int inIndex = inMap.get(root.val);

        root.left = helper(preorder, inorder, inStart, inIndex - 1);
        root.right = helper(preorder, inorder, inIndex + 1, inEnd);
        return root;
    }

	public static TreeNode buildTreeHelper_2(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        int k = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                k = i;
                break;
            }
        }

        root.left = buildTreeHelper_2(preorder, preStart + 1, preStart + k - inStart, inorder, inStart, k - 1);
        root.right = buildTreeHelper_2(preorder, preStart + k - inStart + 1, preEnd, inorder, k + 1, inEnd);

        return root;
    }
	
	public static TreeNode buildTree_2(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length) {
			return null;
		}
		return buildTreeHelper_2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode root = buildTree(preorder, inorder);
		System.out.println("Root: " + root.val); // Output: Root: 3
		
		
	}

}
