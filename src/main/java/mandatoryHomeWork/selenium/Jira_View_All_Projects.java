package mandatoryHomeWork.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;


public class Jira_View_All_Projects {

	public static void main(String[] args) throws InterruptedException {

		// Launch browser in incognito
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--incognito"); WebDriver driver = new
		 * ChromeDriver(options);
		 */
		WebDriver driver = new ChromeDriver();
		driver.get("https://id.atlassian.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Log in to continue
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("vigneshkumartamilselvan@gmail.com");
		driver.findElement(By.id("login-submit")).submit();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf@23");
		driver.findElement(By.id("login-submit")).submit();

		// Switch to
		driver.findElement(By.xpath("(//div[@data-testid = 'product-container'][1]/a)[4]")).click();
		Thread.sleep(9000);

		// Click on project
		driver.findElement(By.xpath("//span[text() = \"Projects\"]")).click();
		driver.findElement(By.xpath("//span[text() = \"View all projects\"]")).click();
		Thread.sleep(3000);

		// Invalid project name
		driver.findElement(By.xpath("//input[@name =\"search\"]")).sendKeys("SDET");
		boolean invalid_project = driver.findElement(By.tagName("h4")).isDisplayed();
		Assert.assertEquals(true, invalid_project);

		// Valid project name
		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@name =\"search\"]")).sendKeys(Keys.ESCAPE);
		driver.findElement(By.xpath("//input[@name =\"search\"]")).sendKeys("Test");
		driver.findElement(By.xpath("//span[text() = \"Test\"]")).isDisplayed();
		driver.findElement(By.xpath("//span[text() = \"Test\"]")).click();

		List<WebElement> findElements = driver.findElements(By.xpath("//*[@alt='Task']"));

		List<String> task_List = new ArrayList<String>();
		for (int i = 1; i < (findElements.size() + 1); i++) {
			WebElement iteam = driver.findElement(By.xpath("(//span[@class=\"sc-15cfu5s-1 fKpSAB\"])[" + i + "]"));
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);", iteam);

			String card_text = iteam.getText();

			task_List.add(card_text);
			System.out.println(card_text);
		}
		String currentURL = driver.getCurrentUrl();

		// Open a new tab and Create a new issues
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {

			driver.switchTo().window(handle);
		}
		driver.navigate().to(currentURL);

		// Create issue
		driver.findElement(By.xpath("//button[@id=\"createGlobalItem\"]")).click();

		// Summary*
		String created_Bug = "Test case - New tab";
		driver.findElement(By.xpath("//input[@name='summary']")).sendKeys(created_Bug);
		driver.findElement(By.xpath("//span[text() = 'Assign to me']")).click();
		driver.findElement(By.xpath("(//button/span[text() ='Create'])[2]")).click();
		System.out.println("Issue created");
		driver.close();

		// Refresh and validate does the board has newly created issue
		driver.switchTo().window(windowHandles.iterator().next());
		driver.navigate().refresh();
		Assert.assertFalse(task_List.contains(created_Bug));

		// Create a bug with blocked by newly created issue
		driver.findElement(By.xpath("//span[text()='Create']")).click();
		driver.findElement(By.xpath("//input[@name='summary']")).sendKeys("Create - New Issue");
		driver.findElement(By.xpath("//*[text()='blocks']")).click();
		driver.findElement(By.xpath("//*[text()='is blocked by']")).click();
		driver.findElement(By.xpath("//*[text()='Select Issue']")).sendKeys("AutomateJira");
		driver.findElement(By.xpath("(//span[text()='Create'])[2]")).click();
		driver.findElement(By.xpath("//*[text()='linkedIssue']")).click();
		driver.findElement(By.xpath("//*[text()='To Do']")).click();
		driver.findElement(By.xpath("//*[text()='Done']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
		if (driver.findElement(By.xpath("//span[text()='tes']/following::span[2]")).isDisplayed())
			System.out.println("Passed");

		driver.close();

	}
}
