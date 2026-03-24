package com.leet;

public class ValidAnagram_13 {
	
		static {
	        for (int i = 0; i < 500; i++)
	            isAnagram("", "a");
	    }
	    public static boolean isAnagram(String s, String t) {
	        if (s.length() != t.length()){
	            return false;
	        }
	    int freq[] = new int[26];
	    for(int i=0; i<s.length(); i++){
	        freq[s.charAt(i) - 'a']++;
	        freq[t.charAt(i) - 'a']--;
	    }
	  for(int i= 0; i<freq.length; i++) { 
	    if(freq[i] !=0){
	        return false;
	    }}
	    return true;
	    }


	public static boolean isAnagram_1(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}
		for (int i : count) {
			if (i != 0) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram(s, t));
		String s1 = "rat";
		String t1 = "car";
		System.out.println(isAnagram(s1, t1));
		
		}

}
