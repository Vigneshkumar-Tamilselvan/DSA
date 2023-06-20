package mandatoryHomeWork.week5.Day_4;

import org.junit.Assert;
import org.junit.Test;

public class Defanging_An_IP_Address_1108 {

	@Test
	public void test_01() {
		String address = "1.1.1.1";
		ip_address(address);
		Assert.assertEquals(ip_address(address), "1[.]1[.]1[.]1");
	}
	
	@Test
	public void test_02() {
		String address = "255.100.50.0";
		ip_address(address);
		Assert.assertEquals(ip_address(address), "255[.]100[.]50[.]0");
	}

	private String ip_address(String address) {
		return address.replace(".", "[.]");
	}
}
