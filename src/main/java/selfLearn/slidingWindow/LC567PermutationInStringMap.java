package selfLearn.slidingWindow;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class LC567PermutationInStringMap {
	@Test
	public void test01() {
		String s1 = "baooo", s2 = "eidbaooo";
		permutationInString(s1, s2);
	}

	private boolean permutationInString(String s1, String s2) {
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		int left = 0, right = 0;

		while (right < s1.length()) {
			map1.put(s1.charAt(right), map1.getOrDefault(s1.charAt(right), 0) + 1);
			map2.put(s2.charAt(right), map2.getOrDefault(s2.charAt(right), 0) + 1);
			right++;
		}
		map1.equals(map2);
		System.out.println(map2.entrySet());
		Assert.assertEquals(map1, map2);

		while (right < s2.length()) {

			map2.put(s2.charAt(left), map2.getOrDefault(s2.charAt(left), 0) - 1);
			left++;
			map2.put(s2.charAt(right), map2.getOrDefault(s2.charAt(right), 0) + 1);
			System.out.println(map2.entrySet());
			right++;
		}

		return false;
	}
}
