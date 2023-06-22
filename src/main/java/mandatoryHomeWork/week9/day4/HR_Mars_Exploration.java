package mandatoryHomeWork.week9.day4;

import org.junit.Assert;
import org.junit.Test;

public class HR_Mars_Exploration {

	@Test
	public void test_data() {
		String s = "SOSSPSSQSSOR";
		mars_Exploration(s);
		Assert.assertEquals(mars_Exploration(s), 0);
	}

	private int mars_Exploration(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i = +3) {
			if (!((s.charAt(i) == 'S') || (s.charAt(i + 1) == 'O') || (s.charAt(i + 2) == 'S')))
				count++;
		}
		System.out.println(count);
		return count;
	}

}
