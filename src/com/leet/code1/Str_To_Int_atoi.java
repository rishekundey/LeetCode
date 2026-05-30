package com.leet.code1;

/*
 * 8. String to Integer (atoi)
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer 
 * (similar to C/C++'s atoi function).
 * The algorithm for myAtoi(string s) is as follows:
 * 1. Read in and ignore any leading whitespace.
 * 2. Check if the next character (if not already at the end of the string) is '-' or '+'. 
 * Read this character in if it is either. This determines if the final result is negative or 
 * positive respectively. Assume the result is positive if neither is present.
 * 3. Read in next the characters until the next non-digit character or the end of the input 
 * is reached. The rest of the string is ignored.
 * 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits 
 * were read, then the integer is 0. Change the sign as necessary (from step 2).
 * 5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp 
 * the integer so that it remains in the range. Specifically, integers less than
 * -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 
 * 231 - 1.
 * Return the integer as the final result.
 * Example 1:
 * Input: s = "42"
 * Output: 42
 * Example 2:
 * Input: s = "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which makes the number negative. 
 * Then, we read in "42".
 * Example 3:
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation: We read in "4193" and ignore the rest of the string.
 * 
 * Explanation Video: https://www.youtube.com/watch?v=VYpXn4r1i8w
 * Constraints:
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', 
 * and '.'.
 * 
 * Time Complexity: O(n), where n is the length of the input string.
 * Space Complexity: O(1), as we are using a constant amount of space to store the result and 
 * other variables.
 * 
 */

public class Str_To_Int_atoi {

	public static int myAtoi(String s) {
		s = s.trim();
		if (s.isEmpty()) {
			return 0;
		}

		int sign = 1;
		int index = 0;
		if (s.charAt(0) == '+' || s.charAt(0) == '-') {
			sign = (s.charAt(0) == '-') ? -1 : 1;
			index++;
		}

		long result = 0; // Use long to handle overflow
		while (index < s.length() && Character.isDigit(s.charAt(index))) {
			result = result * 10 + (s.charAt(index) - '0');
			if (sign * result > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if (sign * result < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			index++;
		}

		return (int) (sign * result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(myAtoi("042"));
		System.out.println(myAtoi(" -042"));
		System.out.println(myAtoi("  1232we424"));
		System.out.println(myAtoi("wr 132 dsfsg"));
		
	}

}
