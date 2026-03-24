package com.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_14 {

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String sortedStr = new String(charArray);

			if (!map.containsKey(sortedStr)) {
				map.put(sortedStr, new ArrayList<>());
			}
			map.get(sortedStr).add(str);
		}

		return new ArrayList<>(map.values());
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(strs));
		String[] strs2 = { "" };
		System.out.println(groupAnagrams(strs2));
		String[] strs3 = { "a" };
		System.out.println(groupAnagrams(strs3));
		

	}

}
