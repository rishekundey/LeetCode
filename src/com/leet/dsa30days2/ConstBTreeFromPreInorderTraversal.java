package com.leet.dsa30days2;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConstBTreeFromPreInorderTraversal {

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode root = buildTree(preorder, inorder);

		// Simple print to verify the root value
		System.out.println("Root of constructed tree: " + root.val); // Output: 3
		
		
		
	}

}
