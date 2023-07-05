package selfLearn.slidingWindow;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LC1876SubstringsOfSizeThreeWithDistinctCharactersMap {
	@Test
	public void test_01() {
		String s = "xyzzaz";
		substringsOfSizeThree(s);
		assertEquals(substringsOfSizeThree(s), 1);
	}

	private int substringsOfSizeThree(String s) {
		int count = 0;
		for (int i = 0; i < s.length() - 2; i++)
			if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2) && s.charAt(i + 1) != s.charAt(i + 2))
				count++;
		return count;
	}
}
