package selfLearn.strings;

import org.junit.Test;

public class LC66PlusOne {

	@Test
	public void test_01() {
		int[] digits = { 1, 2, 3 };
		plusOne(digits);
	}

	private int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				int[] newArray = new int[digits.length + 1];
				digits[i-1] = 1;
				return digits;
			}
		}
		return digits;
	}
}
 