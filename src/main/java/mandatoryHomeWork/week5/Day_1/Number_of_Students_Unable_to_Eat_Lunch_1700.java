package mandatoryHomeWork.week5.Day_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

public class Number_of_Students_Unable_to_Eat_Lunch_1700 {

	@Test
	public void test_data_01() {
		int[] students = { 1, 1, 1, 0, 0, 1 }, sandwiches = { 1, 0, 0, 0, 1, 1 };
		eat_lunch(students, sandwiches);
		Assert.assertEquals(6, 6);
	}

	private int eat_lunch(int[] students, int[] sandwiches) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		int count = 0, eaten = 0;
		for (int student : students)
			queue.add(student);

		for (int sandwiche : sandwiches)
			stack.push(sandwiche);

		while (!stack.isEmpty()) {
			if ((stack.peek()).equals(queue.peek())) {
				count = 0;
				eaten++;
				stack.pop();
				queue.poll();
			} else {
				count++;
				queue.add(queue.peek());
				if (count == queue.size())
					break;
			}
		}
		return students.length - eaten;
	}

}
