package mandatoryHomeWork.week3.day2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LC2379MinimumRecolorsToGetKConsecutiveBlackBlocks {
	@Test
	public void data_01() {
		String blocks = "WBBWWBBWBW";
		int k = 7;
		minimum_colors(blocks, k);
		assertEquals(minimum_colors(blocks, k), 3);
	}

	@Test
	public void data_02() {
		String blocks = "WBWBBBW";
		int k = 2;
		minimum_colors(blocks, k);
		assertEquals(minimum_colors(blocks, k), 0);
	}

	private int minimum_colors(String blocks, int k) {
		int left = 0, right = 0, whiteBlocks = 0, min = Integer.MAX_VALUE;
		while (right < k) {
			if (blocks.charAt(right++) == 'W')
				whiteBlocks++;
		}
		min = Math.min(min, whiteBlocks);

		while (right < blocks.length()) {
			if (blocks.charAt(left++) == 'W')
				whiteBlocks--;
			if (blocks.charAt(right) == 'W')
				whiteBlocks++;
			min = Math.min(min, whiteBlocks);
			right++;
		}
		return min;
	}
}