package selfLearn.slidingWindow;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;

public class LC567PermutationInString {
	@Test
	public void test01() {
		String s1 = "bao", s2 = "eidbaooo";
		permutationInString(s1, s2);
		assertEquals(permutationInString(s1, s2), true);
	}

	private boolean permutationInString(String s1, String s2) {
		int[] w1 = new int[26];
		int[] w2 = new int[26];

		int left = 0, right = 0;
		while (right < s1.length()) {
			w1[s1.charAt(right) - 'a']++;
			w1[s2.charAt(right) - 'a']++;
			right++;
		}
		if (Arrays.equals(w1, w2))
			return true;

		while (right < s2.length()) {
			w2[s2.charAt(left) - 'a']--;
			left++;
			System.out.println(Arrays.toString(w2));
			if (Arrays.equals(w1, w2))
				return true;
			w2[s2.charAt(right) - 'a']++;
			right++;
		}
		return false;
	}
}

//Time complexity - O(n)
//Space complexity - O(n)