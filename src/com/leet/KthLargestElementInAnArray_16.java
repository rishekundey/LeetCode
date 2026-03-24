package com.leet;

public class KthLargestElementInAnArray_16 {

	public static int findKthLargest(int[] nums, int k) {
		
		int[] count=new int[20001];
        for(int num: nums)
        count[num+10000]++;

        for(int i=count.length-1;i>=0;i--)
        if(count[i]>0){
            k -= count[i]; // k = k-count[i] = 
            if(k <= 0) 
            	return i - 10000;
        }
        return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		
		System.out.println(findKthLargest(nums, k));
		
		int[] nums2 = {3,2,3,1,2,4,5,5,6};
		int k2 = 4;
		System.out.println(findKthLargest(nums2, k2));

	}

}
