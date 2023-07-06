package mandatoryHomeWork.week3.day3;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class LC2418SortThePeople {
	@Test
	public void data_01() {
		String[] names = { "Mary", "John", "Emma" };
		int[] heights = { 180, 165, 170 };
		sort_people(names, heights);

	}

	private String[] sort_people(String[] names, int[] heights) {

		Map<Integer, String> map = new TreeMap<>();
		String[] result = new String[names.length];
		int index = names.length - 1;

		if (names.length == heights.length)
			for (int i = 0; i < names.length; i++)
				map.put(heights[i], names[i]);

		for (String value : map.values())
			result[index--] = value;

		return result;
	}
}

//Time complexity - O(n)
//Space complexity - O(n)