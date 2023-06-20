package mandatoryHomeWork.week5.day4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Rings_and_Rods_2103 {

	@Test
	public void test_01() {
		String rings = "B1G1R1R6B6";
		rbg(rings);
	}

	private int rbg(String rings) {

		int count = 0;
		Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();

		for (int i = 0; i < rings.length(); i += 2) {

			char key = rings.charAt(i + 1);
			char value = rings.charAt(i);

			if (map.containsKey(key)) {
				Set<Character> set = new HashSet<Character>();
				set.add(value);
				map.put(key, set);
			} else {
				HashSet<Character> set = new HashSet<Character>();
				set.add(value);
				map.put(key, set);
			}
		}

		System.out.println(map.entrySet());
		return count;

	}

}
