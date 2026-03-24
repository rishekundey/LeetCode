package com.leet.dsa30days2;

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
