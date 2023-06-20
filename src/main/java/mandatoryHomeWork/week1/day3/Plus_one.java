package mandatoryHomeWork.week1.day3;

import org.junit.Test;

public class Plus_one {	@Test
	public void test_data_1() {
	int sum = 0;
	int num = 1;
	plusOne(sum, num);
}

private void plusOne(int sum, int num) {
	do {
		int a = num % 10;
		sum = sum + a;
		num = num / 10;
		if (num < 10)
			sum = sum + num;
		if (sum > 10) {
			int b = sum % 10;
			int c = sum / 10;
			sum = b + c;
		}
	} while (num > 10);
	System.out.println(sum);
}
}