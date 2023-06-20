package mandatoryHomeWork.week1.day2;

import org.junit.Test;

public class Maximum_69_Number {
	@Test
	public void testdata01() {
		int number = 9669;
		maximum_number(number);
	}

	public void testdata02() {
		int number = 9996;
		maximum_number(number);
	}

	public void testdata03() {
		int number = 9999;
		maximum_number(number);
	}

	private void maximum_number(int number) {
		int size = 0;
		if (number > 10 & number < 100)
			size = 1;
		if (number >= 100 & number < 1000)
			size = 2;
		if (number >= 1000 & number < 10000)
			size = 3;
		if (number >= 10000 & number < 100000)
			size = 4;
		int[] n = new int[size + 1];
		int i = 0;
		do {
			n[i] = number % 10;
			number = number / 10;
			// System.out.println(n[i]);
			i++;
		} while (number > 0);
		for (int j = 0; j <= n.length - 1; j++) {
			if (n[j] == 6) {
				n[j] = 9;
				break;
			}

		}
		for (int a : n) {
			System.out.print(a);

		}
	}
}
