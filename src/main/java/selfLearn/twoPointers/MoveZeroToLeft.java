package selfLearn.twoPointers;

import java.util.Arrays;

import org.junit.Test;

public class MoveZeroToLeft {
	@Test
	public void test_01() {
		int[] nums = { 1, 0, 9, 8, 0, 0, 5, 6, 0 };
		moveLeft(nums);
	}

	private int[] moveLeft(int[] nums) {
		int p1 = 0, p2 = 0;
		while (p2 < nums.length) {
			//if (nums[p2] != 0) To move zeros to right
			if (nums[p2] == 0) {
				int temp = nums[p1];
				nums[p1] = nums[p2];
				nums[p2] = temp;
				p1++;
			}
			p2++;
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
}
