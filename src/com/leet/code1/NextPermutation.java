package com.leet.code1;

/*
 *  URL: https://leetcode.com/problems/next-permutation/description/
 *  Problem: Next Permutation
 *  
 *  A permutation of an array of integers is an arrangement of its members into a sequence or
 *  linear order.
 *  For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], 
 *  [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *  The next permutation of an array of integers is the next lexicographically greater 
 *  permutation of its integer. More formally, if all the permutations of the array are 
 *  sorted in one container according to their lexicographical order, then the next 
 *  permutation of that array is the permutation that follows it in the sorted container. 
 *  If such arrangement is not possible, the array must be rearranged as the lowest possible 
 *  order (i.e., sorted in ascending order).
 *  
 *  For example, the next permutation of arr = [1,2,3] is [1,3,2]. Similarly, the next 
 *  permutation of arr = [2,3,1] is [3,1,2]. While the next permutation of arr = [3,2,1] is 
 *  [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 *  
 *  Example 1:
 *  Input: nums = [1,2,3]
 *  Output: [1,3,2]
 *  
 *  Example 2:
 *  Input: nums = [3,2,1]
 *  Output: [1,2,3]
 *  
 *  Example 3:
 *  Input: nums = [1,1,5]
 *  Output: [1,5,1]
 *  
 *  Constraints:
 *  
 *  1 <= nums.length <= 100
 *  0 <= nums[i] <= 100
 *  
 *  Explanation Video: https://www.youtube.com/watch?v=LuLCLgMElus
 *  
 *  Time Complexity: O(n)
 *  Space Complexity: O(1)
 *  
 *  Data Structure: Array
 *  Algorithm: Two Pointers
 *  
 */

public class NextPermutation {

	public static void nextPermutation(int[] nums) {

		int i = nums.length - 2; // Find the first decreasing element from the end
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private static void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nextPermutation(new int[] { 1, 2, 3 });
		nextPermutation(new int[] { 3, 2, 1 });
		nextPermutation(new int[] { 1, 1, 5 });
		
	}

}
