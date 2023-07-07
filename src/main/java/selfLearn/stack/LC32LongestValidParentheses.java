package selfLearn.stack;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class LC32LongestValidParentheses {
	@Test
	public void data_01() {
		String s = ")([]})";
		longestValidParentheses(s);
		Assert.assertEquals(longestValidParentheses(s), true);
	}

	private boolean longestValidParentheses(String s) {
		Stack<Character> stack = new Stack<>();
		int pointer = 0;
		while (pointer < s.length()) {
			if (s.charAt(pointer) == '{')
				stack.push('}');
			else if (s.charAt(pointer) == '[')
				stack.push(']');
			else if (s.charAt(pointer) == '(')
				stack.push(')');
			else if (stack.isEmpty() || stack.pop() != s.charAt(pointer))
				return false;
		}
		return stack.isEmpty();
	}
}