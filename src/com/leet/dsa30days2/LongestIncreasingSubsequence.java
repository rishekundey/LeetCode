package com.leet.dsa30days2;

// Given an integer array nums, return the length of the longest strictly increasing subsequence.
// A subsequence is a sequence that can be derived from an array by deleting some or no 
// elements without changing the order of the remaining elements.
// For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
// Example 1:
// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
// Example 2:
// Input: nums = [0,1,0,3,2,3]
// Output: 4
// Explanation: The longest increasing subsequence is [0,1,2,3], therefore the length is 4.
// Example 3:
// Input: nums = [7,7,7,7,7,7,7]
// Output: 1
// Explanation: The longest increasing subsequence is [7], therefore the length is 1.
// Constraints:
// 1 <= nums.length <= 2500
// -10^4 <= nums[i] <= 10^4
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity? 
// The O(n^2) solution is straightforward, can you optimize it?
// https://leetcode.com/problems/longest-increasing-subsequence/
// Approach:
// 1. Create a dp array of the same length as the input array to store the length of the 
// longest increasing subsequence at each index.
// 2. Initialize the dp array with 1, since each element is an increasing subsequence of 
// length 1.
// 3. Iterate through the input array and for each element, check all previous elements to 
// see if they are smaller than the current element.
//   - If they are, update the dp array at the current index to be the maximum of its current
// 		value and the value at the previous index plus one.
// 4. Keep track of the maximum value in the dp array, which will be the length of the 
// longest increasing subsequence.
// Time Complexity: O(n^2) due to the nested loops.
// Space Complexity: O(n) for the dp array.
// Note: The follow-up question asks for an O(n log(n)) solution, which can be achieved using 
// a binary search approach to maintain a dynamic list of the longest increasing subsequence 
// found so far. However, the provided code is the O(n^2) solution as described in the 
// approach above.
// https://www.youtube.com/watch?v=CE2b_-XfVDk&t=190s
// https://www.youtube.com/watch?v=UoP2aYqYj8A&t=190s
// https://www.youtube.com/watch?v=2iZtYHkK1b0&t=190s
// https://www.youtube.com/watch?v=1f8LhYb2q0o&t=190s
// https://www.youtube.com/watch?v=Qh0bB4qTqD8&t=190s


public class LongestIncreasingSubsequence {

	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;
		int[] dp = new int[n];
		int maxLength = 1;

		for (int i = 0; i < n; i++) {
			dp[i] = 1; // Each element is an increasing subsequence of length 1
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
		}

		return maxLength;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 })); // Output: 4
		System.out.println(lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 })); // Output: 4
		System.out.println(lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7, 7 })); // Output: 1
	}

}
