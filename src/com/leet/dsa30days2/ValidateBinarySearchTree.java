package com.leet.dsa30days2;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
	
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
	
	public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;

       List<Integer> array = new ArrayList<>();
       findInorder(root, array);

       for (int i = 1; i < array.size(); i++) {
           if (array.get(i) <= array.get(i - 1)) {
               return false;
           }
       }
       return true;
   }

   private static void findInorder(TreeNode root, List<Integer> list) {
       if (root == null) return;

       findInorder(root.left, list);
       list.add(root.val);
       findInorder(root.right, list);
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new ValidateBinarySearchTree().new TreeNode(2);
		root.left = new ValidateBinarySearchTree().new TreeNode(1);
		root.right = new ValidateBinarySearchTree().new TreeNode(3);
		System.out.println(isValidBST(root)); // Output: true
		
		TreeNode root2 = new ValidateBinarySearchTree().new TreeNode(5);
		root2.left = new ValidateBinarySearchTree().new TreeNode(1);
		root2.right = new ValidateBinarySearchTree().new TreeNode(4);
		root2.right.left = new ValidateBinarySearchTree().new TreeNode(3);
		root2.right.right = new ValidateBinarySearchTree().new TreeNode(6);
		System.out.println(isValidBST(root2)); // Output: false
	}

}
