package selfLearn.slidingWindow;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LC1876SubstringsOfSizeThreeWithDistinctCharacters {
	@Test
	public void test_01() {
		String s = "xyzzaz";
		substringsOfSizeThree(s);
	}

	private int substringsOfSizeThree(String s) {
		int left = 0, right = 0, count = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (right < 3) {
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
			right++;
		}
		if (s.charAt(left) != s.charAt(left + 1) && s.charAt(left + 1) != s.charAt(right - 1))
			count++;
		System.out.println(map);
		while (right < s.length()) {
			map.remove(s.charAt(left));
			if (s.charAt(left) != s.charAt(right - 1) && s.charAt(right - 1) != s.charAt(right))
				count++;
			map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

			left++;
			right++;
		}
		System.out.println(count);
		return count;
	}

}
