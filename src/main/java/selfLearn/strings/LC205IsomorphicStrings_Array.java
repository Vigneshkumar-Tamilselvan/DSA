package selfLearn.strings;

import org.junit.Test;

import junit.framework.Assert;

public class LC205IsomorphicStrings_Array {
	@Test
	public void data_01() {
		String s = "eggss", t = "addss";
		isomorphicStrings(s, t);
		Assert.assertEquals(isomorphicStrings(s, t), true);
	}

	// @Test
	public void data_02() {
		String s = "foo", t = "bar";
		isomorphicStrings(s, t);
		Assert.assertEquals(isomorphicStrings(s, t), false);
	}

	// @Test
	public void data_03() {
		String s = "paper", t = "title";
		isomorphicStrings(s, t);
		Assert.assertEquals(isomorphicStrings(s, t), true);
	}

	private boolean isomorphicStrings(String s, String t) {
		int[] word = new int[26];

		int p1 = 0, p2 = 0;
		if (s.length() != t.length())
			return false;
		while (p1 < s.length() && p2 < t.length()) {
			if (word[s.charAt(p1) - 'a'] == t.charAt(p2))
				return true;
			else {
				word[s.charAt(p1) - 'a'] = t.charAt(p2);
			}
			p1++;
			p2++;
		}
		return false;
	}
}
