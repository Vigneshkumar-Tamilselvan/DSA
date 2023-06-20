package mandatoryHomeWork.week3.Day_5;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

//https://leetcode.com/problems/contains-duplicate-ii/

public class Contains_Duplicate_219 {

	@Test
	public void example1() {
		int[] nums = { 1, 2, 3, 1 };
		int k = 3;
		System.out.println(findContainsDuplicate(nums, k));
	}

	@Test
	public void example2() {
		int[] nums = { 1, 0, 1, 1 };
		int k = 3;
		System.out.println(findContainsDuplicate(nums, k));
	}

	@Test
	public void example3() {
		int[] nums = { 1, 2, 3, 1, 2, 3 };
		int k = 2;
		System.out.println(findContainsDuplicate(nums, k));
	}

	private boolean findContainsDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			} else {
				int pastIndex = map.get(nums[i]);
				if (Math.abs(pastIndex - i) <= k) {
					return true;
				} else {
					map.put(nums[i], i);
				}
			}
		}
		return false;
	}
}
