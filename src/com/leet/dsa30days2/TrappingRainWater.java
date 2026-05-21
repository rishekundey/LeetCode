package com.leet.dsa30days2;

// 
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
// 
// Example 1:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
//
// Example 2:
// Input: height = [4,2,0,3,2,5]
// Output: 9
// 
// Constraints: 
// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105
// 
// https://leetcode.com/problems/trapping-rain-water/
// 
// Two Pointer Approach: Time Complexity: O(n), Space Complexity: O(1)
// 
// The idea is to use two pointers, one starting from the left and the other from the right. We will keep track of the maximum height seen so far from both sides. The water trapped at any point will be determined by the shorter of the two maximum heights. We will move the pointers towards each other, updating the maximum heights and calculating the trapped water accordingly.
// 
// Algorithm:
// 1. Initialize two pointers, left and right, at the beginning and end of the array respectively.
// 2. Initialize two variables, leftMax and rightMax, to keep track of the maximum height seen so far from the left and right sides.
// 3. Initialize a variable totalWater to store the total amount of trapped water.
// 4. While left is less than right:
//    a. If height[left] is less than height[right]:
//      i. If height[left] is greater than or equal to leftMax, update leftMax.
//     ii. Else, calculate the water trapped at left and add it to totalWater.
//   b. Else:
//     i. If height[right] is greater than or equal to rightMax, update rightMax.
//    ii. Else, calculate the water trapped at right and add it to totalWater.
//   c. Move the pointers towards each other (increment left or decrement right).
// 5. Return totalWater as the result.
// This approach ensures that we are always calculating the trapped water based on the shorter side, which guarantees that we are not overestimating the amount of water trapped.
// 
// YouTube Explanation: https://www.youtube.com/watch?v=ZI2z5pq0TqA
// Another Explanation: https://www.youtube.com/watch?v=U2TQbqUYnYw
// Another approach: https://www.youtube.com/watch?v=JYHj2kZP4aA

public class TrappingRainWater {

	public static int trap(int[] height) {
		int left = 0, right = height.length - 1;
		int leftMax = 0, rightMax = 0;
		int totalWater = 0;

		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] >= leftMax) {
					leftMax = height[left];
				} else {
					totalWater += leftMax - height[left];
				}
				left++;
			} else {
				if (height[right] >= rightMax) {
					rightMax = height[right];
				} else {
					totalWater += rightMax - height[right];
				}
				right--;
			}
		}

		return totalWater;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1})); // Output: 6
		System.out.println(trap(new int[] {4,2,0,3,2,5})); // Output: 9
	}

}
