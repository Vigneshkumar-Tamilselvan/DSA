package selfLearn.twoPointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

//Approach - Two pointers

//TODO Edge case failing - Duplicate values getting printed.

public class LC18SumOfFour {
	@Test
	public void test_01() {
		int[] nums = { 2, 2, 2, 2, 2 };
		int target = 8;
		sumOfFour(nums, target);
	}

	private Set<int[]> sumOfFour(int[] nums, int target) {

		Set<int[]> quadruple = new HashSet<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = 1; j < nums.length - 2; j++) {
				int left = j + 1, right = nums.length - 1, sum = 0;
				while (left < right) {
					sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == target) {
						//System.out.println(nums[i]+" "+nums[j]+" "+nums[left]+" "+nums[right]);
						quadruple.add(new int[] { nums[i], nums[j], nums[left], nums[right] });
						left++;
						right--;
					} else if (sum < target)
						left++;
					else if (sum > target)
						right--;
				}
			}
		}
		return quadruple;
	}
}

//Time Complexity  - O(n*logn)
//Space Complexity - O(n)