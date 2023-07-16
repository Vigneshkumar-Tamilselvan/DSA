package selfLearn.hashing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class FirstNonRepeatingCharacter {
	@Test
	public void test_01() {
		String s = "love to code. lets code";
		firstNonRepeatingCharacter(s);
	}

	private void firstNonRepeatingCharacter(String s) {
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		int minValue = 1;
		int i = 0;
		while (i < s.length()) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			i++;
		}
		for (Entry<Character, Integer> a : map.entrySet()) {
			if (a.getValue().equals(minValue)) {
				System.out.println(s.indexOf(a.getKey()));
				break;
			}
		}
	}
}

//Time - O(2n)- O(n)
//Space - O(n)
