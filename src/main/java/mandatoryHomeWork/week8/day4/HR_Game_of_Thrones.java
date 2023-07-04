package mandatoryHomeWork.week8.day4;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class HR_Game_of_Thrones {
	@Test
	public void test_data() {
		String s = "aaabbbb";
		game_Of_Thrones(s);
		Assert.assertEquals(game_Of_Thrones(s), true);
	}

	private boolean game_Of_Thrones(String s) {
		int pointer = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		while (pointer < s.length()) {
			if (map.containsKey(s.charAt(pointer)))
				map.remove(s.charAt(pointer), map.get(s.charAt(pointer)));
			else
				map.put(s.charAt(pointer), 1);
			pointer++;
		}
		return (map.size() <= 1) ? true : false;
	}
}
