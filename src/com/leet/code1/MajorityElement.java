package com.leet.code1;

import java.util.HashMap;

/*
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * 
 * Input: nums = [3,2,3]
 * Output: 3
 * 
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * Constraints:
 * 
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * Explanation Video: https://www.youtube.com/watch?v=8jLOx1hD3_o
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Data Structure used: HashMap, Integer
 * 
 * Algorithm used: Boyer-Moore Voting Algorithm
 * 
 */

public class MajorityElement {

	public int majorityElement_1(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for (int key : map.keySet()) {
			if (map.get(key) > nums.length / 2) {
				return key;
			}
		}
		return -1;
	}
	
	public int majorityElement(int[] nums) {
		int count = 0;
		Integer candidate = null;

		for (int num : nums) {
			//System.out.println("num: " + num + ", candidate: " + candidate + ", count: " + count);
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
			//System.out.println("After update -> candidate: " + candidate + ", count: " + count);
		}

		return candidate;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityElement me = new MajorityElement();
		int[] nums = { 2,2,1,1,1,2,2 };
		System.out.println(me.majorityElement(nums));
		
	}

}
