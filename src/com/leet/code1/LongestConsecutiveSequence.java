package com.leet.code1;

/*
 * Longest Consecutive Sequence
 * Given an unsorted array of integers nums, return the length of the longest consecutive 
 * elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its 
 * length is 4.
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * Explanation: The longest consecutive elements sequence is [0, 1, 2, 3, 4, 5, 6, 7, 8]. 
 * Therefore its length is 9.
 * Constraints:
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * Follow up: Could you implement the O(n) solution?
 * 
 * Approach:
 * 1. Create a HashSet to store the unique numbers from the input array.
 * 2. Iterate through the HashSet and for each number, check if it's the start of a sequence 
 * (i.e., num - 1 is not in the set).
 * 3. If it's the start of a sequence, keep checking for the next numbers in the sequence 
 * (num + 1, num + 2, etc.) and count the length of the current streak.
 * 4. Update the longest streak if the current streak is longer than the previously recorded 
 * longest streak.
 * 5. Return the longest streak at the end of the iteration.
 * 
 * This approach ensures that we only check each number once, resulting in an O(n) time 
 * complexity.
 * 
 * Explanation Video: https://www.youtube.com/watch?v=P6RZZMu_maU
 * Time Complexity: O(n) - We traverse the array once to create the HashSet and then traverse 
 * the HashSet to find the longest sequence.
 * Space Complexity: O(n) - In the worst case, all numbers are unique and we store them in 
 * the HashSet.
 * 
 * Note: The input array can contain duplicates, but the HashSet will only store unique 
 * values, so duplicates will not affect the length of the longest consecutive sequence.
 * 
 */

import java.util.HashSet;

public class LongestConsecutiveSequence {

	public static int longestConsecutive(int[] nums) {

		HashSet<Integer> numSet = new HashSet<>();
		for (int num : nums) {
			numSet.add(num);
		}

		int longestStreak = 0;

		for (int num : numSet) {
			if (!numSet.contains(num - 1)) { // Check if it's the start of a sequence
				int currentNum = num;
				int currentStreak = 1;

				while (numSet.contains(currentNum + 1)) {
					currentNum++;
					currentStreak++;
				}

				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}

		return longestStreak;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = { 100, 4, 200, 1, 3, 2 };
		int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		System.out.println(longestConsecutive(nums2));
	}
}
