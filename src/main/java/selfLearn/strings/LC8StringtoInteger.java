package selfLearn.strings;

import org.junit.Test;

public class LC8StringtoInteger {

	@Test
	public void test_data_01() {
		String s = "-4193 with  00 words";
		bruteforce(s);
		stringToInteger(s);
		System.out.println(bruteforce(s));
	}

	private int bruteforce(String string) {
		String integerString = string.replaceAll("[^(-?\\d)]", "");
		int integerValue = Integer.parseInt(integerString);
		return integerValue;
	}

	private int stringToInteger(String string) {
		return 0;
	}

}
