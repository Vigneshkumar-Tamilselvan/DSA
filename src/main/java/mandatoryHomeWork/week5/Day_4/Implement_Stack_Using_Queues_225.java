package mandatoryHomeWork.week5.Day_4;

import java.util.Stack;

public class Implement_Stack_Using_Queues_225 {

	private Stack<Integer> stack1; // Stack for enqueue operation
	private Stack<Integer> stack2; // Stack for dequeue operation

	public Implement_Stack_Using_Queues_225() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void push(int x) {
		stack1.push(x);
	}

	public int pop() {
		if (stack2.isEmpty()) {
			// Move elements from stack1 to stack2 in reverse order
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public int peek() {
		if (stack2.isEmpty()) {
			// Move elements from stack1 to stack2 in reverse order
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}

	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}
