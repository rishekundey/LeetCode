package com.leet.code1;

/*
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 * 
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * 
 * Constraints:
 * 
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is 0, 1, or 2.
 * 
 * Explanation Video: https://www.youtube.com/watch?v=oaVa-9wmpns
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Data Structure: Array
 * Algorithm: Two Pointers
 * 
 */

public class SortColors {

	public static void sortColors(int[] nums) {
		
		int low = 0,mid = 0;
		int high = nums.length-1;
		while(mid<=high) {

			if (nums[mid] == 0) 
				swap(nums, low++, mid++);
			else if (nums[mid] == 1) 
				mid++;
			else 
				swap(nums, mid, high--);
		}		
	}
	
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 0, 1};
		sortColors(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		// Output: 0 1 2
	}
}
