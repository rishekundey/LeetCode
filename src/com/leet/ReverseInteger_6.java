package com.leet;

public class ReverseInteger_6 {

	public static int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int lastDigit = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && lastDigit > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && lastDigit < -8))
				return 0;
			rev = rev * 10 + lastDigit;
		}
		return rev;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-123));
		System.out.println(reverse(120));
		System.out.println(reverse(123));
		System.out.println(reverse(1534236469));
		System.out.println(reverse(0));
		System.out.println(reverse(1463847412));
		System.out.println(reverse(-2147483412));
		System.out.println(reverse(-2147483648));
	}

}
