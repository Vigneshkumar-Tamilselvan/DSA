package selfLearn.hashing;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;
import net.bytebuddy.asm.Advice.Return;

public class firstRepeatinNumber {
	@Test
	public void test_01() {
		int[] arr = { 1, 5, 3, 4, 3, 5, 6 };
		firstRepeatingNumber(arr);
	}

	private int firstRepeatingNumber(int[] arr) {
		int i = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (i < arr.length) {
			if (map.containsKey(arr[i])) {
				System.out.println(arr[i]);
				return arr[i];
			} else
				map.put(arr[i], 1);
			i++;
		}
		return 0;
	}
}
//Time - O(n)
//space - O(n)
