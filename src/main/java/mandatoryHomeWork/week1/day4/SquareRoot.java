package mandatoryHomeWork.week1.day4;

import java.util.Arrays;

import org.junit.Test;

public class SquareRoot {
	@Test
	public void test_data_one() {
		int[] num = { 0, 3, -9, 7, -7 };
		square_root(num);
		//Assert.assertTrue(false);
	}

	private int[] square_root(int[] num) {
		for (int i = 0; i < num.length; i++) {
			num[i] = num[i] * num[i];
			
		}
		Arrays.sort(num);
		//Arrays.toString(num);
		System.out.println(	Arrays.toString(num));
		return num;
	}
}
