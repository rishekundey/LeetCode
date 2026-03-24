package com.leet;

public class BestTimeToBuyAndSellStock_17 {

	public static int maxProfit(int[] prices) {
		int profit=0;
	       int price=Integer.MAX_VALUE;
	       for(int i=0;i<prices.length;i++) {
	            if(prices[i]<price) {
	                price=prices[i];
	            }
	            else {
	                profit=Math.max(profit,prices[i]-price);
	            }
	       }
	       return profit;
	}
	
	public static int maxProfit_1(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int price : prices) {
			if (price < minPrice) {
				minPrice = price;
			} else if (price - minPrice > maxProfit) {
				maxProfit = price - minPrice;
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));

		int [] prices2 = {7,6,4,3,1};
		System.out.println(maxProfit(prices2));
		
		int [] prices3 = {2,4,1};
		System.out.println(maxProfit(prices3));
	}

}
