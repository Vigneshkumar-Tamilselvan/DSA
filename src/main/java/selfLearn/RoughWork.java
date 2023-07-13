package selfLearn;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class RoughWork {
@Test
	public void test_01() {
	String pattern = "abcdf",s = "qw er ty ui op";
		moveLeft(pattern, s);
	}

	private boolean moveLeft(String pattern, String s) {
		int pointer = 0;
		String[] word = s.split(" ");
		Map<Character, String> map = new HashMap<Character, String>();

		if (pattern.length() == word.length) {
			while (pointer < pattern.length()) {
				map.put(pattern.charAt(pointer), map.getOrDefault(pattern.charAt(pointer),0) + 1);
			}
			pointer++;
			
		}
		

		return false;
	}
}
//Time - O(n)
//space - O(n)
