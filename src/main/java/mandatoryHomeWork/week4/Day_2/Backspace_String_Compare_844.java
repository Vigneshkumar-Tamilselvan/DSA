package mandatoryHomeWork.week4.Day_2;

import java.util.Stack;
import org.junit.Test;

public class Backspace_String_Compare_844 {

	@Test
	public void test_01() {
		String s = "ab#c";
		String t = "ad#c";
		System.out.println(backspaceCompare(s, t)); // Output: true
	}

	@Test
	public void test_02() {
		String s = "ab##";
		String t = "c#d#";
		System.out.println(backspaceCompare(s, t)); // Output: true
	}

	@Test
	public void test_03() {
		String s = "a#c";
		String t = "b";
		System.out.println(backspaceCompare(s, t)); // Output: false
	}

	public boolean backspaceCompare(String s, String t) {
		return buildString(s).equals(buildString(t));
	}

	private String buildString(String str) {
		Stack<Character> stack = new Stack<Character>();

		for (char c : str.toCharArray()) {
			if (c == '#') {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(c);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}

		return sb.toString();
	}

}
