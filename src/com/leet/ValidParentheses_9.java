package com.leet;

import java.util.Stack;

public class ValidParentheses_9 {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ValidParentheses_9().isValid("()"));
		System.out.println(new ValidParentheses_9().isValid("()[]{}"));
		System.out.println(new ValidParentheses_9().isValid("(]"));
		System.out.println(new ValidParentheses_9().isValid("([)]"));
		System.out.println(new ValidParentheses_9().isValid("{[]}"));
		System.out.println(new ValidParentheses_9().isValid("]"));
		System.out.println(new ValidParentheses_9().isValid("((()))"));
		System.out.println(new ValidParentheses_9().isValid("((())"));
		System.out.println(new ValidParentheses_9().isValid("(){}[][][}"));

	}

}
