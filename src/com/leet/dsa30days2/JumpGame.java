package com.leet.dsa30days2;

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
