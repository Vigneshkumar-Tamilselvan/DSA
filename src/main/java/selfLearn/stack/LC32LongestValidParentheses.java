package selfLearn.stack;

import java.util.Stack;

public class LC32LongestValidParentheses {

	public void data_01() {
		String s = ")()((())()()";
		longestValidParentheses(s);
	}

	private void longestValidParentheses(String s) {
		Stack<Character> st = new Stack<>();
		int open = 0, close = 0, max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				st.push(s.charAt(i));
				open+=2;
			} else {
			
				if (!st.isEmpty())
					st.pop();
				
				max = Math.max(max, i - st.peek());
			}
		}

	}
}
