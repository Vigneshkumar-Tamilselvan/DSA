package mandatoryHomeWork.week9.day5;

import org.junit.Test;

public class HR_Caesars_Cipher {
	@Test
	public void test_data_01() {
		String s = "middle-Outz";
		caesars_Cipher(s);
	}

	private String caesars_Cipher(String s) {
		int pointer = 0, charValue = 0;
		while (pointer < s.length()) {
			charValue = Math.abs(s.charAt(pointer));
			System.out.println(charValue % 26);
			if ((charValue >= 65 && charValue <= 90) || (charValue >= 97 && charValue <= 122)) {
				// char c = (char) charValue;
			}

		}

		return s;
	}
}
