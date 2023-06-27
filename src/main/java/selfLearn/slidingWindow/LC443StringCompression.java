package selfLearn.slidingWindow;

import org.junit.Test;

public class LC443StringCompression {
	@Test
	public void test1() {
		char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		System.out.println(compress(chars));

	}

	public int compress(char[] chars) {
		int count = 1;
		int index = 0;
		for (int i = 1; i <= chars.length; i++) {
			if (i < chars.length && chars[i] == chars[i - 1]) {
				count++;
			} else {
				chars[index++] = chars[i - 1];
				if (count > 1) {
					String countstr = String.valueOf(count);
					for (char c : countstr.toCharArray()) {
						chars[index++] = c;
					}
				}
				count = 1;
			}
		}

		return index;
	}
}
