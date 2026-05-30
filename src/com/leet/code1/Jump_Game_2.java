package com.leet.code1;

/*
 * Jump Game II
 * Given an array of non-negative integers nums, you are initially positioned at the first 
 * index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * You can assume that you can always reach the last index.
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from 
 * index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from 
 * index 0 to 1, then 3 steps to the last index.
 * Constraints:
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 1000
 * Note: This question is the same as Jump Game, but with an added requirement of finding the 
 * minimum number of jumps to reach the last index.
 * The solution uses a greedy approach to keep track of the farthest reachable index at each 
 * step and the current end of the jump.
 * The algorithm iterates through the array and updates the farthest reachable index based 
 * on the current position and jump length.
 * When the current index reaches the end of the current jump, it increments the jump count 
 * and updates the current end to the farthest reachable index.
 * This approach ensures that we are always making the optimal jump to reach the last index 
 * in the minimum number of jumps.
 * Time Complexity: O(n), where n is the length of the input array. We iterate through the 
 * array once.
 * Space Complexity: O(1), as we are using only a constant amount of extra space to store 
 * the jump count, current end, and farthest reachable index.
 * This solution efficiently computes the minimum number of jumps required to reach the last 
 * index of the array, ensuring that we are always making the optimal jump at each step.
 * 
 * The algorithm works as follows:
 * 1. Initialize three variables: jumps to count the number of jumps, currentEnd to track 
 * the end of the current jump, and farthest to track the farthest reachable index.
 * 2. Iterate through the array from the first index to the second-to-last index (since we 
 * don't need to jump from the last index).
 * 3. For each index, update the farthest reachable index by taking the maximum of the 
 * current farthest and the sum of the current index and its jump length.
 * 4. If the current index reaches the current end of the jump, it means we need to make a 
 * jump. Increment the jump count and update the current end to the farthest reachable index.
 * 5. Continue iterating until we reach the end of the array, at which point the jump count 
 * will represent the minimum number of jumps required to reach the last index.
 * This greedy approach ensures that we are always making the optimal jump to reach the last 
 * index in the minimum number of jumps, and it runs efficiently with a time complexity of 
 * O(n) and a space complexity of O(1).
 * Example Walkthrough:
 * For the input array [2,3,1,1,4]:
 * - Start at index 0: jumps = 0, currentEnd = 0, farthest = 0
 * - At index 0: farthest = max(0, 0 + 2) = 2
 * - At index 1: farthest = max(2, 1 + 3) = 4
 * - At index 2: farthest = max(4, 2 + 1) = 4
 * - At index 3: farthest = max(4, 3 + 1) = 4
 * - At index 4: farthest = max(4, 4 + 4) = 8
 * - When we reach index 0 (currentEnd), we increment jumps to 1 and update currentEnd to 2.
 * - When we reach index 2 (currentEnd), we increment jumps to 2 and update currentEnd to 4.
 * - We have reached the last index, so the total jumps required is 2.
 * For the input array [2,3,0,1,4]:
 * - Start at index 0: jumps = 0, currentEnd = 0, farthest = 0
 * - At index 0: farthest = max(0, 0 + 2) = 2
 * - At index 1: farthest = max(2, 1 + 3) = 4
 * - At index 2: farthest = max(4, 2 + 0) = 4
 * - At index 3: farthest = max(4, 3 + 1) = 4
 * - At index 4: farthest = max(4, 4 + 4) = 8
 * - When we reach index 0 (currentEnd), we increment jumps to 1 and update currentEnd to 2.
 * - When we reach index 2 (currentEnd), we increment jumps to 2 and update currentEnd to 4.
 * - We have reached the last index, so the total jumps required is 2.
 * For the input array [0]:
 * - Start at index 0: jumps = 0, currentEnd = 0, farthest = 0
 * - At index 0: farthest = max(0, 0 + 0) = 0
 * - We are already at the last index, so the total jumps required is 0.
 * 
 * Explanation video: https://www.youtube.com/watch?v=Y0lT9Fck7qI
 * 
 */

public class Jump_Game_2 {

	public static int jump(int[] nums) {
		int jumps = 0;
		int currentEnd = 0;
		int farthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			farthest = Math.max(farthest, i + nums[i]);
			if (i == currentEnd) {
				jumps++;
				currentEnd = farthest;
			}
		}
		return jumps;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(jump(new int[] {2,3,1,1,4})); // Output: 2
		System.out.println(jump(new int[] {2,3,0,1,4})); // Output: 2
		System.out.println(jump(new int[] {0})); // Output: 0
		System.out.println(jump(new int[] {1,2,1,1,1})); // Output: 3
		

	}

}
