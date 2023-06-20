package mandatoryHomeWork.selenium;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

//		1. Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//		2. Mouseover on Brands and Search L'Oreal Paris
		WebElement brandsMenu = driver.findElement(By.id("brand_arrowUp"));

		Actions action = new Actions(driver);
		action.moveToElement(brandsMenu);

//		3. Click L'Oreal Paris
		WebElement subMenu = driver.findElement(By.xpath("//div[@id='brandCont_Popular']//following::a[5]"));
		action.moveToElement(subMenu);
		action.click().perform();

//		4. Check the title contains L'Oreal Paris
		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains("L'Oreal Paris")) {
			System.out.println("Page contains the expected title");
		} else {
			System.out.println("Invalid Title");
		}

//		5. Click sort By and select customer top rated
		driver.findElement(By.id("filter-sort")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

		// Scroll Down
		JavascriptExecutor Scrool = (JavascriptExecutor) driver;
		Scrool.executeScript("window.scrollBy(0,300)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//		6. Click Category and click Hair->Click haircare-Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Scrool.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(5000);

//		7. Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[class='title' and text()='Concern']")).click();
		driver.findElement(By.xpath("//span[class='title' and text()='Color Protection']")).click();

//		8.check whether the Filter is applied with Shampoo
		boolean isFilterdisplayed = driver.findElement(By.xpath("//span[@class='filter-value' and text()='Shampoo']"))
				.isDisplayed();
		if (isFilterdisplayed == true) {
			System.out.println("Shampoo filter applied");
		} else {
			System.out.println("Shampoo filter not applied");
		}

//		9. Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[@id='title-listing']//following::a")).click();

//		10. GO to the new window and select size as	175ml
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		driver.findElement(By.xpath("//span[text()='180ml']")).click();

//		11. Print the MRP of the product
		String mrpPrice = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println("The price of the product is :" + mrpPrice);

//		12. Click on ADD to BAG
		driver.findElement(By.xpath("//span[@class='Add to Bag']")).click();

//		13. Go to Shopping Bag
		driver.findElement(By.xpath("//button[@class='css-aesrxy' and @type='button']")).click();

//		14. Print the Grand Total amount
		String grandTotal = driver.findElement(By.xpath("//div[@id='payment_details']//following::span[5]")).getText();
		System.out.println("The Grand Total is :" + grandTotal);

//		15. Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();

//		16. Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();

//		17. Check if this grand total is the same in step 14
		driver.findElement(By.xpath("//p[text()='New Address']//preceding::img[1]")).click();
		String priceInBookingPage = driver.findElement(By.xpath("//p[text()='Price Details']//following::p")).getText();
		if (priceInBookingPage.equals(grandTotal)) {
			System.out.println("Both price details are verified");
		} else {
			System.out.println("Both price details are different");
		}

//		18. Close all windows
		driver.quit();
	}

}
