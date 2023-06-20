package mandatoryHomeWork.week1;

import org.junit.Test;

public class Sandglass_pattern {

	public void test_data() {
		int n = 5;
		two_sum(n);
	}

	private void two_sum(int n) {

		for (int i = n; i >= 0; i--) { // row
			for (int j = n - i; j > 1; j--) { // inner line space
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) { // column
				System.out.print("* ");
			}
			System.out.println();
		}
		for (int i = 0; i < n; i++) { // row
			for (int j = n - i; j > 1; j--) { // inner line space
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) { // column
				System.out.print("* ");
			}
			System.out.println();
		}

	}

}
