package com.leet.dsa30days2;

/*
 * 287. Find the Duplicate Number
 * Given an array of integers nums containing n + 1 integers where each integer is in the 
 * range [1, n] inclusive, there is only one repeated number in nums, return this repeated 
 * number.
 * You must solve the problem without modifying the array nums and uses only constant extra 
 * space.
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * Example 3:
 * Input: nums = [1,1]
 * Output: 1
 * Example 4:
 * Input: nums = [1,1,2]
 * Output: 1
 * Constraints:
 *   1. 1 <= n <= 10^5
 *   2. nums.length == n + 1
 *   3. 1 <= nums[i] <= n
 *   4. All the integers in nums appear only once except for precisely one integer which 
 *   appears two or more times.
 *   Follow up:
 *   1. How can we prove that at least one duplicate number must exist in nums?
 *   2. Can you solve the problem in linear runtime complexity?
 *   Explanation:
 *   1. Since there are n + 1 integers and each integer is in the range [1, n], by the 
 *   Pigeonhole Principle, at least one duplicate number must exist in nums.
 *   2. To solve the problem in linear runtime complexity, we can use the "Floyd's Tortoise 
 *   and Hare" algorithm (also known as the Cycle Detection algorithm). This algorithm uses 
 *   two pointers to detect a cycle in a linked list, which can be adapted to find the 
 *   duplicate number in the array. The idea is to treat the values in the array as pointers 
 *   to indices, creating a cycle due to the duplicate number. By using two pointers (one 
 *   slow and one fast), we can detect the cycle and find the duplicate number without 
 *   modifying the array and using only constant extra space.
 *   Here's how the algorithm works:
 *   1. Initialize two pointers, slow and fast, to the first element of the array.
 *   2. Move the slow pointer one step at a time and the fast pointer two steps at a time 
 *   until they meet.
 *   3. Once they meet, reset one pointer to the start of the array and keep the other 
 *   pointer at the meeting point.
 *   4. Move both pointers one step at a time until they meet again. The point at which they 
 *   meet will be the duplicate number.
 *   This algorithm runs in 
 *   O(n) time complexity 
 *   and uses O(1) extra space, making it an efficient solution to the problem.
 *   Example implementation of the "Floyd's Tortoise and Hare" algorithm to find the 
 *   duplicate number:
 *   
 *   Explanation Video: https://www.youtube.com/watch?v=wjYnzkAhcNk
 *   
 */

public class FindTheDuplicateNumber {
	
	public static int findDuplicate(int[] nums) {
		int n = nums.length;
		boolean[] seen = new boolean[n];
		for (int num : nums) {
			if (seen[num]) {
				return num;
			}
			seen[num] = true;
		}
		return -1; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 })); // Output: 2
	}

}
