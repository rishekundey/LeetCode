package com.leet.dsa30days2;

/*
 * 55. Jump Game
 * Given an array of non-negative integers nums, you are initially positioned at the first 
 * index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 
 * 0, which makes it impossible to reach the last index.
 * Constraints:
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i] <= 10^5
 * 
 * Solution:
 * The idea is to keep track of the last position that we need to reach (initially set to the 
 * last index). We iterate through the array from right to left, and for each index, we check 
 * if we can jump from that index to the last position. If we can, we update the last position 
 * to that index. Finally, if the last position is 0, it means we can reach the end from the 
 * start.
 * Time Complexity: O(n), where n is the length of the input array.
 * Space Complexity: O(1), since we are using only a constant amount of extra space.
 * 
 * Example Walkthrough:
 * For the input nums = [2,3,1,1,4]:
 * - Start with lastPos = 4 (the last index).
 * - i = 4: nums[4] = 4, we can jump from index 4 to index 4 (lastPos), so we update lastPos to 4.
 * - i = 3: nums[3] = 1, we can jump from index 3 to index 4 (lastPos), so we update lastPos to 3.
 * - i = 2: nums[2] = 1, we can jump from index 2 to index 3 (lastPos), so we update lastPos to 2.
 * - i = 1: nums[1] = 3, we can jump from index 1 to index 2 (lastPos), so we update lastPos to 1.
 * - i = 0: nums[0] = 2, we can jump from index 0 to index 1 (lastPos), so we update lastPos to 0.
 * Since lastPos is now 0, we can reach the end from the start, and the function returns true.
 * For the input nums = [3,2,1,0,4]:
 * - Start with lastPos = 4 (the last index).
 * - i = 4: nums[4] = 4, we can jump from index 4 to index 4 (lastPos), so we update lastPos to 4.
 * - i = 3: nums[3] = 0, we cannot jump from index 3 to index 4 (lastPos), so lastPos remains 4.
 * - i = 2: nums[2] = 1, we cannot jump from index 2 to index 4 (lastPos), so lastPos remains 4.
 * - i = 1: nums[1] = 2, we cannot jump from index 1 to index 4 (lastPos), so lastPos remains 4.
 * - i = 0: nums[0] = 3, we cannot jump from index 0 to index 4 (lastPos), so lastPos remains 4.
 * Since lastPos is not 0, we cannot reach the end from the start, and the function returns false.
 * 
 * This solution efficiently determines whether the end of the array can be reached from the 
 * start by iterating through the array once, making it suitable for large input sizes within 
 * the given constraints.
 * 
 * Note: The provided code includes a main method with example test cases to demonstrate the 
 * functionality of the canJump method. You can modify the input arrays to test with different 
 * scenarios.
 * 
 * Explanation video: https://www.youtube.com/watch?v=YBSt1jYwVfU
 * 
 * Related problems:
 * - 45. Jump Game II
 * - 134. Gas Station
 * 
 * Additional resources:
 * - LeetCode problem page: https://leetcode.com/problems/jump-game/
 * - LeetCode discuss: https://leetcode.com/problems/jump-game/discuss/
 * - GeeksforGeeks: https://www.geeksforgeeks.org/jump-game/
 * - YouTube explanation: https://www.youtube.com/watch?v=YBSt1jYwVfU
 * 
 * - Time complexity analysis: O(n)
 * - Space complexity analysis: O(1)	
 * 
 */

public class JumpGame {

	public static boolean canJump(int[] nums) {
		int lastPos = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= lastPos) {
				lastPos = i;
			}
		}
		return lastPos == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(canJump(nums));
		
		nums = new int[] { 3, 2, 1, 0, 4 };
		System.out.println(canJump(nums));
	}

}
