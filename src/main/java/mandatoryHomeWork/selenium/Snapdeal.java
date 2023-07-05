package mandatoryHomeWork.selenium;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Snapdeal {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Launch the web browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		WebDriver driver = new ChromeDriver(options);

		// 1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.readyState").toString().equals("complete");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// 2. Go to Mens Fashion
		driver.findElement(By.xpath("//span[text()= \"Men's Fashion\"]")).click();

		// 3. Go to Sports Shoes
		WebElement sportsShoes = driver.findElement(By.linkText("Sports Shoes"));
		Actions action = new Actions(driver);
		action.moveToElement(sportsShoes).click().perform();

		// 4. Get the count of the sports shoes
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class= 'category-name'])[2]/../span")));
		String countOfSportsShoes = driver.findElement(By.xpath("(//*[@class= 'category-name'])[2]/../span")).getText();
		System.out.println("Get the count of the sports shoes - " + countOfSportsShoes);

		// 5. Click Training shoes
		driver.findElement(By.xpath("//div[text() = \"Training Shoes\"]")).click();

		// 6. Sort by Low to High
		driver.findElement(By.xpath("//div[@class ='sort-selected']")).click();
		driver.findElement(By.xpath("(//ul[@class='sort-value']/li[2])")).click();

		// 7. Check if the items displayed are sorted correctly
		String sortconfrimation = driver.findElement(By.xpath("//div[@class='sort-selected']")).getText();
		assertTrue(sortconfrimation.contains("Price Low To High"));
		System.out.println("Items displayed are sorted correctly");

		// 8.Select the price range (900-1200)
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("(//div[@class='price-text-box']/input)[1]")).clear();
		driver.findElement(By.xpath("(//div[@class='price-text-box']/input)[1]")).sendKeys("900");
		driver.findElement(By.xpath("(//div[@class='price-text-box']/input)[2]")).clear();
		driver.findElement(By.xpath("(//div[@class='price-text-box']/input)[2]")).sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='filter-inner']/div[5]")).click();
		System.out.println("Price range selected");

		// 9.Filter with color Navy
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(3000);
		String disabled = driver.findElement(By.xpath("//input[@type=\"checkbox\" and @value =\"Navy\"]"))
				.getAttribute("disabled");
		if (disabled.equals(false)) {
			String navyColour = driver.findElement(By.xpath("//a[@class =\"filter-name\" and text() =\" Navy\"]"))
					.getText();
			assertTrue(navyColour.contains("Navy"));
			driver.findElement(By.xpath("//input[@type=\"checkbox\" and @value =\"Navy\"]")).click();
		}

		// 10. verify the all applied filters
		if (disabled.equals(false)) {
			String colour = driver.findElement(By.xpath("(//div[@class=\"filters\"])[1]/div[1]")).getText();
			assertTrue(colour.contains("Color"));
		}
		String price = driver.findElement(By.xpath("(//div[@class=\"filters\"])[1]")).getText();
		assertTrue(price.contains("Price"));

		// 11. Mouse Hover on first resulting Training shoes
		WebElement picture = driver.findElement(By.tagName("picture"));
		action.moveToElement(picture).perform();

		// 12. click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),\"Quick View\")]")).click();

		// 13. Print the cost and the discount percentage
		Thread.sleep(3000);
		String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String offer = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Cost - " + cost.replaceAll("[^0-9]+", "") + " Offer - " + offer);

		// 14. Take the snapshot of the shoes.
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("C://screenshot/sample.png");
		FileUtils.copyFile(SrcFile, DestFile);

		// 15. Close the current window
		driver.findElement(By.xpath("//div[@id ='sidebar_modal_right']/div/div[2]/i")).click();

		// 16. Close the main window
		driver.quit();
	}
}