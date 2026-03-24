package com.leet;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_1 {
	
	// https://leetcode.com/problems/two-sum/
	// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	// You may assume that each input would have exactly one solution, and you may not use the same element twice.
	// You can return the answer in any order.
	// Example 1:
	// Input: nums = [2,7,11,15], target = 9
	// Output: [0,1]
	// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
	// Example 2:
	// Input: nums = [3,2,4], target = 6
	// Output: [1,2]
	// Example 3:
	// Input: nums = [3,3], target = 6
	// Output: [0,1]
	// Constraints:
	// 2 <= nums.length <= 10^4
	// -10^9 <= nums[i] <= 10^9
	// -10^9 <= target <= 10^9
	// Only one valid answer exists.
	// Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
	
	
	// Time Complexity: O(n^2)
	public static int[] twoSum_1(int[] nums, int target) {
		for(int i=0, j=nums.length-1; i<nums.length;) {
			if (nums[i] + nums[j] == target && i != j) {
				return new int[] { i, j };
			}
			if (j == i) {
				i++;
				j = nums.length - 1;
			} else {
				j--;
			}
		}
		return new int[] {};
	}
	
	// Time Complexity: O(n log n) but gives wrong answer for test case 2
	
	public static int[] twoSum_2(int[] nums, int target) {
        // Step 1: Pair numbers with their original indices
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i]; // number
            pairs[i][1] = i;       // original index
        }

        // Step 2: Sort by the numbers
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Two-pointer approach
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = pairs[left][0] + pairs[right][0];
            if (sum == target) {
                // Step 4: Return original indices
                return new int[] { pairs[left][1], pairs[right][1] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // No solution found
        return new int[] {};
    }
	
	// Time Complexity: O(n)
	
	public static int[] twoSum(int[] nums, int target) {
        // Map to store number -> index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                // Return indices of the pair
                return new int[] { map.get(complement), i };
            }

            // Store the index of the current number
            map.put(nums[i], i);
        }

        // If no solution found (though problem guarantees one)
        return new int[] {};
    }
	
	public static void main(String args[]) {
		int nums[] = {2,7,11,15};
		int nums2[] = {-1,-2,-3,-4,-5};
		int nums3[] = {-10,-1,-18,-19};
		int nums4[] = {3,2,4};
		int target = 9;
		int target2 = -8;
		int target3 = -19;
		int target4 = 6;
		int[] result = twoSum(nums2, target2);
		System.out.println("[" + result[0] + ", " + result[1] + "]");
		
	}
}
