package mandatoryHomeWork.week4.Day_1;

import java.util.Stack;

import org.junit.Test;

public class Baseball_Game_682 {
	
	@Test
	public void example1() {
		String[] ops = { "5", "2", "C", "D", "+" };
		System.out.println(base_Ball(ops)); // Output: 30
	}

	@Test
	public void example2() {
		String[] ops = { "5", "-2", "4", "C", "D", "9", "+", "+" };
		System.out.println(base_Ball(ops)); // Output: 27
	}

	@Test
	public void example3() {
		String[] ops = { "1", "C" };
		System.out.println(base_Ball(ops)); // Output: 0
	}

	public int base_Ball(String[] ops) {
		Stack<Integer> stack = new Stack<Integer>();

		for (String op : ops) {
			if (op.equals("+")) {
				int top = stack.pop();
				int newTop = top + stack.peek();
				stack.push(top);
				stack.push(newTop);
			} else if (op.equals("D")) {
				stack.push(2 * stack.peek());
			} else if (op.equals("C")) {
				stack.pop();
			} else {
				stack.push(Integer.parseInt(op));
			}
		}

		int sum = 0;
		for (int score : stack) {
			sum += score;
		}

		return sum;
	}

}
