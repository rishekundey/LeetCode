package com.leet.dsa30days2;

public class ProductOfArrayExceptSelf {

	static{
        for(int i=0;i<500;i++){
            productExceptSelf(new int[]{1,2});
        }
    }
	
	public static int[] productExceptSelf(int[] nums) {
		
		int n = nums.length;
		int res[] = new int[n];
		
		int prefix = 1;
		int suffix = 1;
		
		for(int i=0; i<n; i++) {
			res[i] = prefix;
			prefix *= nums[i];
		}
		
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= suffix;
			suffix *= nums[i];
		}
		
		return res;
	}
	
	public static int[] productExceptSelf_2(int[] nums) {
		int n = nums.length;
		int res[] = new int[n];

		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}

		int suff = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= suff;
			suff *= nums[i];
		}

		return res;
	}
	
	public static int[] productExceptSelf_1(int[] nums) {
		int n = nums.length;
		int LP[] = new int[n];
		int RP[] = new int[n];
		int res[] = new int[n];
		
		LP[0]=1;
		RP[n-1]=1;
		
		for(int i=1, j=n-2; i<n||j>0; i++, j--) {
			LP[i] = LP[i-1]*nums[i-1];
			RP[j] = RP[j+1]*nums[j+1];
		}
		
		for (int i = 0; i < n; i++) {
			res[i] = LP[i] * RP[i];
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i : productExceptSelf(new int[] { 1, 2, 3, 4 }))
			System.out.print(i + " ");
		System.out.println();
		for (int i : productExceptSelf(new int[] { -1, 1, 0, -3, 3 }))
			System.out.print(i + " ");
	}

}
