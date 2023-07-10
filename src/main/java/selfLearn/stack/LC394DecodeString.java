package selfLearn.stack;

import java.util.Stack;

public class LC394DecodeString {

	public void test_01() {
		String input = "3[a]2[bc]", output = "aaabcbc";
		decodeString(input);
	}

	private void decodeString(String input) {
		int pointer = 0;
		Stack<Character> stack = new Stack<>();
		while (pointer < input.length()) {
			if(input.charAt(pointer)!=']')
				stack.push(input.charAt(pointer));
		}
	}
}
