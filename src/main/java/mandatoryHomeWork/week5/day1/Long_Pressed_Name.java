package mandatoryHomeWork.week5.day1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Long_Pressed_Name {

	@Test
	public void data_01() {
		String name = "saeed";
		String typed = "saaedd";
		pressed_name(name, typed);
		assertEquals(pressed_name(name, typed), false);
	}

	@Test
	public void data_02() {
		String name = "saeed";
		String typed = "saaeedd";
		pressed_name(name, typed);
		assertEquals(pressed_name(name, typed), true);
	}

	private boolean pressed_name(String name, String typed) {

		int p1 = 0, p2 = 0;

		/*
		 * if (name.length() == typed.length()) return true;
		 */
		if (name.length() > typed.length())
			return false;

		while (p2 < typed.length()) {
			if (p1 < name.length() && name.charAt(p1) == typed.charAt(p2))
				p1++;
			else if (p2 == 0 || typed.charAt(p2) != typed.charAt(p2-1))
				return false;
			p2++;
		}
		System.out.println(p1);
		System.out.println(name.length());
		return p1 == name.length();

	}
}