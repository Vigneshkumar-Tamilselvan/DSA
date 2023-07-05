package selfLearn.strings;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class LC205IsomorphicStrings_Map {
	@Test
	public void data_01() {
		String s = "eggss", t = "addst";
		isomorphicStrings(s, t);
		Assert.assertEquals(isomorphicStrings(s, t), true);
	}

	@Test
	public void data_02() {
		String s = "foo", t = "bar";
		isomorphicStrings(s, t);
		Assert.assertEquals(isomorphicStrings(s, t), false);
	}

	@Test
	public void data_03() {
		String s = "paper", t = "title";
		isomorphicStrings(s, t);
		Assert.assertEquals(isomorphicStrings(s, t), true);
	}


	private boolean isomorphicStrings(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		int p1 = 0, p2 = 0;

		while (p1 < s.length() && p2 < t.length()) {
			if (map.containsKey(s.charAt(p1)) && map.get(s.charAt(p1)) == t.charAt(p2))
				return true;
			else
				map.put(s.charAt(p1), t.charAt(p2));
			p1++;
			p2++;
		}
		return false;
	}

}
