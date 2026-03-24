package com.leet;

import java.util.HashMap;

public class LongestSubstringWORepCharaters_3 {

	public static int lengthOfLongestSubstring(String str) {
		
		HashMap<Character,Integer> map = new HashMap<>();
        int l=0, r=0, maxLen=0;
        int n = str.length();
        while(r<n)
        {
            if(map.containsKey(str.charAt(r)))
            l = Math.max(l,map.get(str.charAt(r))+1);

            int len = r-l+1;
            maxLen = Math.max(len,maxLen);
            map.put(str.charAt(r),r);
            r++;
        }
		
		/*
		 * for(Map.Entry<Character, Integer> entry : map.entrySet()) {
		 * System.out.println(entry.getKey() + " " + entry.getValue()); }
		 */
        
        return maxLen;
	}
	
	public static void main(String[] args) {
		
		String s1 = "pwwkew";
		String s2 = " ";
		String s3 = "";
		String s4 = "au";
		String s5 = "abcabcbb";
		
		System.out.println(lengthOfLongestSubstring(s1));
		System.out.println(lengthOfLongestSubstring(s2));
		System.out.println(lengthOfLongestSubstring(s3));
		System.out.println(lengthOfLongestSubstring(s4));
		System.out.println(lengthOfLongestSubstring(s5));

	}

}
