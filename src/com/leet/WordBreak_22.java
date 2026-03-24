package com.leet;

import java.util.*;

//https://leetcode.com/problems/word-break/
//Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
//Note that the same word in the dictionary may be reused multiple times in the segmentation.
//Example 1:
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
//Example 2:
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//Note that you are allowed to reuse a dictionary word.
//Example 3:
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false


public class WordBreak_22 {
		//complexity O(n^2) n is s.length
		//space O(n)
	    public static boolean wordBreak(String s, List<String> wordDict) {
	        int n = s.length();
	        boolean[] dp = new boolean[n+1];
	        dp[0]=true;
	        Set<String> set = new HashSet<>(wordDict);
	        int maxLen = 0;
	        for(String name: wordDict) {
	            maxLen = Math.max(name.length(), maxLen);
	        }
	        for(int i=1; i<=n; i++){
	            for(int j=i-1; j>=Math.max(0,i-maxLen);j--){
	                if(dp[j] && set.contains(s.substring(j,i))){
	                    dp[i]=true;
	                }
	            }
	        }
	        return dp[n];
	    }

	//complexity O(n^2) n is s.length
	//space O(n)
	public static boolean wordBreak_1(String s, List<String> wordDict) {
		//wordDict = ["cats","dog","sand","and","cat"]
		Set<String> wordSet = new HashSet<>(wordDict); 	//wordSet = ["cats","dog","sand","and","cat"]
		// s = "catsandog", s.length = 9
		boolean[] dp = new boolean[s.length() + 1]; //dp = new boolean[10] 
		dp[0] = true; // Empty string can be segmented

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				// Check if s[0..j-1] can be segmented and s[j..i-1] is in wordSet
				if (dp[j] && wordSet.contains(s.substring(j, i))) { 
					// If true, mark dp[i] as true and break the inner loop
					dp[i] = true;
					break;
				}
			}
		}
		// dp[s.length()] will be true if s can be segmented, otherwise false
		return dp[s.length()];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code"))); // true
		//System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen"))); // true
		System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // false
	}

}
