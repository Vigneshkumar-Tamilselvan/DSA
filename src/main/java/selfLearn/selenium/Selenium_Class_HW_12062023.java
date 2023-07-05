package selfLearn.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Class_HW_12062023 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/table.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.readyState").toString().equals("complete");

		int header_Country = 0, name_Header = 0;
		int row_Count = driver.findElements(By.xpath("//tbody[@id= \"form:j_idt89_data\"]/tr")).size();
		int page_Count = driver.findElements(By.xpath("//span[@class = 'ui-paginator-pages']/a")).size();
		int headers_Count = driver.findElements(By.xpath("//thead[@id = 'form:j_idt89_head']/tr/th")).size();
		Map<String, ArrayList<String>> map = new HashMap<>();

		String country_Header = driver.findElement(By.xpath("//th[@id = 'form:j_idt89:j_idt94']/span")).getText();
		String name_Headers = driver.findElement(By.xpath("(//th[@id = 'form:j_idt89:j_idt92']/span)[1]")).getText();

		// List<WebElement> headers = driver.findElements(By.xpath("//div[@class =
		// 'ui-datatable-scrollable-header-box']/table/thead/tr/th"));

		System.out.println("No of pages = " + page_Count + " and Rows = " + page_Count * row_Count);

		for (int i = 1; i <= headers_Count; i++) {
			if ((driver.findElement(By.xpath("//thead[@id = 'form:j_idt89_head']/tr/th[" + i + "]")).getText())
					.equals(country_Header))
				header_Country = i;
			if ((driver.findElement(By.xpath("//thead[@id = 'form:j_idt89_head']/tr/th[" + i + "]")).getText())
					.equals(name_Headers))
				name_Header = i;
		}

		for (int i = 1; i <= 1; i++) {
			for (int j = 1; j <= row_Count; j++) {
				String country = driver
						.findElement(By
								.xpath("//tbody[@id= \"form:j_idt89_data\"]/tr[" + j + "]/td[" + header_Country + "]"))
						.getText();
				String name = driver
						.findElement(
								By.xpath("//tbody[@id= \"form:j_idt89_data\"]/tr[" + j + "]/td[" + name_Header + "]"))
						.getText();

				if (map.containsKey(country)) {
					ArrayList<String> new_list = map.get(country);
					new_list.add(name);
					map.put(country, new_list);
				} else {
					ArrayList<String> ls = new ArrayList<>();
					ls.add(name);
					map.put(country, ls);
				}

			}
			
			WebElement pageLink = driver.findElement(
					By.xpath("(//a[contains(@class,'ui-paginator-page ui-state-default')])[" + i + "]"));
			pageLink.click();
			
			Thread.sleep(5000);
		}
		System.out.println(map.entrySet());
	}
}
