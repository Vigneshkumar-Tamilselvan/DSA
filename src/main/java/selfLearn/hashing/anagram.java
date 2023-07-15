package selfLearn.hashing;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class anagram {
	@Test
	public void test_01() {
		String s = "anagram", t = "eagaram";
		anagram(s, t);
		Assert.assertEquals(true, true);
	}

	private boolean anagram(String s, String t) {
		Map<Character, Integer> mapS = new HashMap<Character, Integer>();
		Map<Character, Integer> mapT = new HashMap<Character, Integer>();
		int p = 0;

		while (p < s.length() && s.equals(t)) {
			mapS.put(s.charAt(p), mapS.getOrDefault(mapS.get(s.charAt(p)), 0) + 1);
			mapT.put(t.charAt(p), mapT.getOrDefault(mapT.get(t.charAt(p)), 0) + 1);
		}
		p++;

		for (char ch : mapS.keySet()) {
			if (mapS.get(ch) != mapT.get(ch))
				return false;
		}
		return true;
	}
}
//Time - O(n)
//space - O(n)
