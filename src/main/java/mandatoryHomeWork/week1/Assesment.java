package mandatoryHomeWork.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Assesment {
	@Test
	public void data() {

		int[] a = { 1, 2, 5 };
		int[] b = { 2, 3, 5 };
		merge_array(a, b);
	}

	private void merge_array(int[] a, int[] b) {
		int size = (a.length + b.length);
		List<Integer> ls = new ArrayList<Integer>(size);

		for (int a1 : a) {
			ls.add(a1);
		}
		for (int b1 : a) {
			ls.add(b1);
		}

		System.out.println(ls);

		Collections.sort(ls);

		System.out.println(ls);

	}

}
