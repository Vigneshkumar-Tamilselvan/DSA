package mandatoryHomeWork.week3.day3;

import java.util.Arrays;

import org.junit.Test;

public class LC1984MinimumDifferenceBetweenHighestAndLowestOfKScores {
	@Test
	public void data_01() {
		int[] score = { 12, 45, 2, 0, 4, 56, 23, 89, 27 };
		int k = 3;
		minimum_score(score, k);
		System.out.println(minimum_score(score, k));
	}

	private int minimum_score(int[] score, int k) {
		Arrays.sort(score);

		int left = 0, right = 0, dif = 0, min = Integer.MAX_VALUE;
		while (right < k) {
			right++;
		}
		min = Math.min(score[right-1] - score[left], min);

		while (right < score.length) {
			left++;
			dif = score[right] - score[left];
			min = Math.min(dif, min);
			right++;
		}
		return min;
	}
}

//Time complexity - O(n logn)
//Space complexity - O(1)
