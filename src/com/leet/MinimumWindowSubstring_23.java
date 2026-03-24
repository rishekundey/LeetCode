package com.leet;

public class MinimumWindowSubstring_23 {

	public static String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0)
			return "";
		int[] map = new int[128];
		for (char c : t.toCharArray()) {
			map[c]++;
		}
		int left = 0, right = 0, count = t.length(), minLen = Integer.MAX_VALUE, start = 0;
		while (right < s.length()) {
			if (map[s.charAt(right)] > 0) {
				count--;
			}
			map[s.charAt(right)]--;
			right++;
			while (count == 0) {
				if (right - left < minLen) {
					minLen = right - left;
					start = left;
				}
				map[s.charAt(left)]++;
				if (map[s.charAt(left)] > 0) {
					count++;
				}
				left++;
			}
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
		System.out.println(minWindow("a", "a")); // a
		System.out.println(minWindow("a", "aa")); // ""
		System.out.println(minWindow("ab", "A")); // ""
		System.out.println(minWindow("a", "b")); // ""
		System.out.println(minWindow("aa", "aa")); // aa
		System.out.println(minWindow("aaflslflsldkalskaaa", "aaa")); // aaa

	}

}
