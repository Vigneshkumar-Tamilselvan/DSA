package mandatoryHomeWork.week1;

import org.junit.Test;

public class Count_of_Matches_in_Tournament {
	@Test
	public void test01() {
		int n = 14;
		Count_of_Matches(n);
	}

	public void test02() {
		int n = 7;
		Count_of_Matches(n);
	}

	private int Count_of_Matches(int n) {
		System.out.println("Total number of matches: " + (n - 1));
		return n - 1;
	}

}
