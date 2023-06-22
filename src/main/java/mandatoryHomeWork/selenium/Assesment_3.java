package mandatoryHomeWork.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assesment_3 {

	public static void main(String[] args) {
		// 1
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("return document.readyState").toString().equals("complete");

		// pop up close
		driver.findElement(By.xpath("//div[@data-id= 'auth-flow-section']/span")).click();
		// 2
		driver.findElement(By.xpath("//a[text()=\"Holidays\"]")).click();

		// 3
		Set<String> win = driver.getWindowHandles();
		List<String> al = new ArrayList<String>();
		al.addAll(win);
		driver.switchTo().window(al.get(1));
		driver.findElement(By.xpath("//input[@id = \"fromCity\"]")).sendKeys("chennai");
		driver.findElement(By.xpath("//input[@id = \"toCity\"]")).sendKeys("Goa");

		// 4
		driver.findElement(By.xpath("//div[@id = 'departureDate']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class='DayPicker-Month']")));
		driver.findElement(By.xpath("(//div[@class ='DayPicker-Month']//div[@class='DayPicker-Week'][5])/div")).click();
		
		//5
		driver.findElement(By.xpath("//p[text()=\"Select Rooms\"]")).click();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class=\"room-component-container\"]")));
		driver.findElement(By.xpath("//button[text()=\"APPLY\"]")).click();
		
		//6
		driver.findElement(By.xpath("//div[text() = \"Select Filters (Optional)\"]")).click();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[text() = \"Flights\"]")));
		driver.findElement(By.xpath("//label[text() = \"With Flights\"]/parent::li/span")).click();
		driver.findElement(By.xpath("//button[text() = \"APPLY\"]")).click();
		
		//7
		driver.findElement(By.xpath("//button[@id= 'search_button']")).click();
		
		//8
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@id=\"filter\"]")));
		Actions action = new Actions(driver); 
		WebElement Start_element = driver.findElement(By.xpath("//div[@class=\"rc-slider\"]"));

		//action.moveToElement(Start_element).dragAndDrop(element, element).perform();
		
		//9
		List<String> list = new ArrayList<String>();
		driver.findElement(By.xpath("//span[text() = \"4N/5D\"]")).getText();
	}

}
