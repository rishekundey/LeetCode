package com.leet;

import java.util.Arrays;

public class CoinChange_21 {

	//complexity O(n*m) n is amount m is coins.length
	//space O(n)
	//https://leetcode.com/problems/coin-change/
	//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
	//Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
	//You may assume that you have an infinite number of each kind of coin.
	//Example 1:
	//Input: coins = [1,2,5], amount = 11
	//Output: 3
	//Explanation: 11 = 5 + 5 + 1
	//https://www.youtube.com/watch?v=jgiZlGzXMBw
	//https://www.youtube.com/watch?v=H9bfqozjoqs
	//https://www.youtube.com/watch?v=Y0ZqKpToTic
	//https://www.leetcode.com/problems/coin-change/solution/
	//https://www.leetcode.com/problems/coin-change/discuss/173303/Java-DP-solution-with-detailed-explanation
	//https://www.leetcode.com/problems/coin-change/discuss/174373/Java-Solution-with-Explanation
	public static int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		if (coins.length == 0) {
			return -1;
		}
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i - coin >= 0) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
					System.out.println("i: " + i + " coin: " + coin + " dp[i]: " + dp[i]);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(coinChange(new int[] {186,419,83,408}, 6249));
		System.out.println(coinChange(new int[] {1,2,5}, 11));
		//System.out.println(coinChange(new int[] {2}, 3));
		//System.out.println(coinChange(new int[] {1}, 0));
	}

}
