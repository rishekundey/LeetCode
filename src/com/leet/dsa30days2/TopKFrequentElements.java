package com.leet.dsa30days2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

	public static int[] topKFrequent(int[] nums, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i > 0 && res.size() < k; i--) {
            if (bucket[i] != null) res.addAll(bucket[i]);
        }
        return res.subList(0, k).stream().mapToInt(i -> i).toArray();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		int[] result = topKFrequent(nums, k);
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		int [] nums0 = {1};
		int k0 = 1;
		int[] result0 = topKFrequent(nums0, k0);
		for (int i : result0) {
			System.out.print(i + " ");
		}
		System.out.println();
		int [] nums1 = {-1, -1};
		int k1 = 1;
		int[] result1 = topKFrequent(nums1, k1);
		for (int i : result1) {
			System.out.print(i + " ");
		}
	}

}
