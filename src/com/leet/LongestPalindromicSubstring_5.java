package com.leet;

public class LongestPalindromicSubstring_5 {
	
	static int maxLen = 0;
    static int lo = 0;
    public static String longestPalindrome(String s) {
        char[] input = s.toCharArray();
        if(s.length() < 2) {
            return s;
        }
        
        for(int i = 0; i<input.length; i++) {
            expandPalindrome(input, i, i);
            expandPalindrome(input, i, i+1);
        }
        return s.substring(lo, lo+maxLen);
    }
    
    public static void expandPalindrome(char[] s, int j, int k) {
        while(j >= 0 && k < s.length && s[j] == s[k]) {
            j--;
            k++;
        }
        if(maxLen < k - j - 1) {
            maxLen = k - j - 1;
            lo = j+1;
        }
    }
	
	public static String longestPalindrome_1(String s) {
		String res = "";
		int maxLen = 0;
		int n = s.length();
		boolean dp[][] = new boolean[n][n];
		for (int g = 0; g < n; g++) {
			for (int i = 0, j = g; j < n; i++, j++) {
				if (g == 0) {
					dp[i][j] = true;
				} else if (g == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				}

				if (dp[i][j] == true) {
					int currLen = j - i + 1;
					if (currLen > maxLen) {
						maxLen = currLen;
						res = s.substring(i, j + 1);
					}
				}
			}
		}
		return res;
	}

	public static void main(String args[]) {
		String s = "babad";
		String s1 = "cbbd";
		System.out.println(longestPalindrome(s));
		System.out.println(longestPalindrome(s1)); // wrong answer
	}
}
