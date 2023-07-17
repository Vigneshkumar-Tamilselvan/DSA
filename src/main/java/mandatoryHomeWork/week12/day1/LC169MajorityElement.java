package mandatoryHomeWork.week12.day1;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class LC169MajorityElement {
	@Test
	public void test_01() {
		int[] nums = { 2, 2, 2, 3, 3 };
		majorityElement(nums);
		assertEquals(majorityElement(nums), 2);
	}

	private int majorityElement(int[] nums) {
		int pointer = 0;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

		while (pointer < nums.length) {
			map.put(nums[pointer], map.getOrDefault(nums[pointer], 0) + 1);
			pointer++;
		}

		for (int i : map.keySet()) {
			if (map.get(i) > (nums.length) / 2) {
				return i;
			}
		}

		return -1;
	}
}

//Time - O(n)
//Space - O(n)