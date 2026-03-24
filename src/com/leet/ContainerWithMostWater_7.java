package com.leet;

public class ContainerWithMostWater_7 {

	public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;

        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            max = Math.max(max, area);
            if (height[l] < height[r]) l++;
            else r--;
        }
        return max;
    }
	
	public static int maxArea_2(int[] h) {
        int n = h.length;
        int maxA = Integer.MIN_VALUE;
        int l = 0;
        int r = n - 1;
        while(l < r) {
            if(h[l] < h[r]) {
                int a = h[l] * (r - l);
                if(maxA < a) { maxA = a; }
                l++;
            } else {
                int a = h[r] * (r - l);
                if(maxA < a) { maxA = a; }
                r--;
            }
        }
        return maxA;
    }
	
	public static int maxArea_1(int[] height) {
		int maxWater = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			int currentArea = Math.min(height[left], height[right]) * (right - left);
			maxWater = Math.max(maxWater, currentArea);
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxWater;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		System.out.println(maxArea(new int[] { 1, 1 }));
		System.out.println(maxArea(new int[] { 4, 3, 2, 1, 4 }));
	}

}
