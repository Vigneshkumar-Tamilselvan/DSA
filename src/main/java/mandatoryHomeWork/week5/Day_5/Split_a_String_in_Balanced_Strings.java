package mandatoryHomeWork.week5.Day_5;

import org.junit.Test;

public class Split_a_String_in_Balanced_Strings {
	@Test
	public void test_01() {
		String word = "RLRRRLLRLL";
		split_string(word);
	}

	private int split_string(String word) {

		int L = 0, R = 0, i = 0, count = 0;

		while (i < word.length()) {
			if (word.charAt(i) == 'R')
				R++;
			else
				L++;

			if (R != 0 && R == L) {
				count++;
				R = 0;
				L = 0;
			}
			i++;
		}
		return count;
	}
}
