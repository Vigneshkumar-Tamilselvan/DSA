package mandatoryHomeWork.week3.day1; //75% Done

import org.junit.Test;
import org.testng.Assert;

public class LC1876SubstringsOfSizeThreeWithDistinctCharacters {
	@Test
	public void testdata_01() {
		String s = "xxzzazmn";
		int target = 3;
		distinct_Character(s, target);
		Assert.assertEquals(distinct_Character(s, target), 2);

	}

	private int distinct_Character(String s, int target) {
		int count = 0;
		for (int i = 0; i < s.length() - 2; i++) {
			if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i + 1) != s.charAt(i + 2) && s.charAt(i) != s.charAt(i + 2))
				count++;
		}
		return count;
	}
}

//Time Complexity - O(n)
//Space Complexity - O(1)