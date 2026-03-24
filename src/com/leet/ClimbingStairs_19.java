package com.leet;

public class ClimbingStairs_19 {

	public static int climbStairs(int n) {
		if (n <= 1) {
			return 1;
		}
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i <= n; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}
		return res[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(5));
		System.out.println(climbStairs(45));

	}

}
