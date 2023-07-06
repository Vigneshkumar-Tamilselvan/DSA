package mandatoryHomeWork.week3.day1; //completed

import org.junit.Test;

public class LC643MaximumAverageSubarrayI {

	@Test
	public void testdata_01() {
		int[] arr = { 1, 12, -5, -6, 50, 3 };
		int k = 4;
		maximum_average(arr, k);
		System.out.println(maximum_average(arr, k));
		// Output: 12.75000
	}

	@Test
	public void testdata_02() {
		int[] arr = { 5 };
		int k = 1;
		maximum_average(arr, k);
		System.out.println(maximum_average(arr, k));
		// Output: 5.00000
	}

	private double maximum_average(int[] arr, int k) {
		int left = 0, right = 0;
		double max = 0, sum = 0;

		while (right < k)
			sum += arr[right++];
		max = Math.max(max, sum / k);

		while (right < arr.length) {
			sum -= arr[left++];
			sum += arr[right++];
			max = Math.max(max, sum / k);
		}
		return max;
	}
}

//Time Complexity - O(n)
//space complexity - O(1)