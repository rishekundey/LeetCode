package com.leet.code1;

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
