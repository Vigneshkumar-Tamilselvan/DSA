package mandatoryHomeWork.selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Jira_Edge_And_Firefox {

	public static void main(String[] arg) throws InterruptedException {

		EdgeOptions options = new EdgeOptions();
		options.addArguments("--inPrivate");
		WebDriver driver = new EdgeDriver();
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
		Thread.sleep(2000);

		// Move to Board
		driver.findElement(By.xpath("//input[@name =\"search\"]")).sendKeys("Test");
		driver.findElement(By.xpath("//span[text() = \"Test\"]")).isDisplayed();
		driver.findElement(By.xpath("//span[text() = \"Test\"]")).click();

		// WebElement on which drag and drop operation needs to be performed

		WebElement fromElement = driver.findElement(By.xpath("//div[@data-rbd-draggable-id = 'ISSUE::10001']"));

		// WebElement to which the above object is dropped WebElement toElement =
		WebElement toElement = driver.findElement(By.xpath("(//button[@class=\"css-18tbdf3\"])[2]"));

		Actions builder = new Actions(driver);
		Thread.sleep(6000);
		System.out.println("Building a drag and drop action");

		
		builder.dragAndDrop(fromElement, toElement).perform();
		// Actions dragAndDrop
		Action dragAndDrop = builder.clickAndHold(fromElement).pause(Duration.ofSeconds(1000)).moveToElement(toElement)
				.build();

		dragAndDrop.perform();

		Thread.sleep(6000);
		// Click on any Task
		driver.findElement(By.xpath("//div[@data-rbd-draggable-id = 'ISSUE::10002']")).click();
		Thread.sleep(5000);

		// Click on Add a child issue
		driver.findElement(By.xpath("//button[@aria-label = \"Add a child issue\"]")).click();
		driver.findElement(By.id("childIssuesPanel")).sendKeys("Child issue - 1");
		driver.findElement(By.xpath("(//button/span[text() = \"Create\"])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("childIssuesPanel")).sendKeys(Keys.ESCAPE);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//span[text() = \"Child issue - 1\"])")).click();

		// Go to that sub task and do below actions
		String comment = "Test";
		driver.findElement(By.xpath("//input[@placeholder=\"Add a comment…\"]")).click();
		driver.findElement(By.xpath("//div[@aria-label=\"Main content area, start typing to enter text.\"]"))
				.sendKeys(comment);
		driver.findElement(By.xpath("//button/span[text() = \"Save\"]")).click();
		Thread.sleep(5000);
		System.out.println("Comment added");
		WebElement value = driver.findElement(By.xpath("(//p[text() = " + comment + "]/parent::div)[2]"));
		System.out.println(value.isDisplayed());
		System.out.println("Comment displayed");
		Thread.sleep(7000);
		driver.quit();
	}
}
