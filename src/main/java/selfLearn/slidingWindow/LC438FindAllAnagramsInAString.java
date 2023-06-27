package selfLearn.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class LC438FindAllAnagramsInAString {

	@Test
	public void test01() {
		String s = "cbaebabacb", p = "abc";
		findAllAnagramsInAString(s, p);
	}

	@SuppressWarnings("unlikely-arg-type")
	private List<Integer> findAllAnagramsInAString(String s, String p) {
		int left = 0, right = 0;
		List<Integer> ls = new ArrayList<>();

		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		while (right < p.length()) {
			map1.put(s.charAt(right), map1.getOrDefault(s.charAt(right), 0) + 1);
			map2.put(p.charAt(right), map2.getOrDefault(p.charAt(right), 0) + 1);
			right++;
		}
		if (map1.equals(map2))
			ls.add(left);
		ls.forEach(index -> System.out.println(index));

		while (right < s.length()) {
			if (s.charAt(left) >= 1)
				map1.put(s.charAt(left), map1.get(s.charAt(left) - 1));
			else
				map1.remove(s.charAt(left));
			left++;
			if (map1.equals(map2))
				ls.add(left);

			map1.put(s.charAt(right), map1.get(s.charAt(right) + 1));
			right++;
			
		}

		ls.forEach(index -> System.out.println(index));
		return ls;
	}

}
