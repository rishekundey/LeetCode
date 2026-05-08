package com.leet.code1;

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
