package mandatoryHomeWork.week3.day4;

import org.junit.Test;

public class LC2269FindTheKBeautyOfANumber {
	@Test
	public void data_01() {
		String num = "430043";
		int k = 2;
		number_Sub_Array(num, k);
	}

	private int number_Sub_Array(String num, int k) {
		int left = 0, right = 0, count = 0;
		String s = "";

		while (right < k) {
			s += num.charAt(right++);
		}
		if (Integer.parseInt(num) % Integer.parseInt(s) == 0)
			count++;

		while (right < num.length()) {
			left = left + 1;
			right = right + 1;
			num.subSequence(left, right);
		}

		return count;

	}
}
