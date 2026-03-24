package com.leet;

public class HouseRobber_20 {

	public static int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int[] res = new int[nums.length];
		res[0] = nums[0];
		res[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
		}
		return res[nums.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rob(new int[] {1,2,3,1}));
		System.out.println(rob(new int[] {2,7,9,3,1}));
		System.out.println(rob(new int[] {2,1,1,2}));
	}

}
