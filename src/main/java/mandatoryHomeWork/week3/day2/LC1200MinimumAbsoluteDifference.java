package mandatoryHomeWork.week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LC1200MinimumAbsoluteDifference {

	@Test
	public void data_01() {
		int[] arr = { 3, 8, -10, 23, 19, -4, -14, 27 };
		sort_number(arr);
		Assert.assertEquals(sort_number(arr), 4);
	}

	private List<List<Integer>> sort_number(int[] arr) {
		List<List<Integer>> list = new ArrayList<>();
		int min = 0, dif = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));

		for (int i = 1; i < arr.length; i++) {
			dif = arr[i - 1] - arr[i];
			System.out.println(dif);
			min = Math.min(min, dif);
			// List<Integers> subList = new ArrayList<>();
			System.out.println("[" + arr[i - 1] + "," + arr[i] + "]");
		}

		return list;
	}
}

//Time complexity - O(log n)
//Space complexity - O(n)
