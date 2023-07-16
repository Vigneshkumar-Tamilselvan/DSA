package selfLearn.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class RepeatsTheMaximumNumberOfTimes {
	@Test
	public void test_01() {
		int[] arr = { 1, 5, 2, 2, 2, 2, 3, 4, 3, 5, 6, 3, 4, 4 };
		repeatsTheMaximumNumberOfTimes(arr);
	}

	private void repeatsTheMaximumNumberOfTimes(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxCount = 0, minVariable = Integer.MAX_VALUE;
		int i = 0;
		while (i < arr.length) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			i++;
		}
		System.out.println(map);
		for (Entry<Integer, Integer> a : map.entrySet()) {
			maxCount = Math.max(maxCount, a.getValue());
		}

		for (Entry<Integer, Integer> a : map.entrySet()) {
			if (a.getValue().equals(maxCount)) {
				minVariable = Math.min(minVariable, a.getKey());
				break;
			}

		}
		System.out.println(minVariable);
	}
}

//Time - O(3n) - O(n)
//space - O(n)
