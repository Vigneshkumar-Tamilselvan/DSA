package mandatoryHomeWork.selenium;

import static org.junit.Assert.assertTrue;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Jira_01_Create_a_new_project_and_a_new_sprint {

	public static void main(String[] args) throws InterruptedException {

		// 1. Log in to JIRA
		WebDriver driver = new ChromeDriver();
		driver.get("https://vigneshkumartamilselvan.atlassian.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("return document.readyState").toString().equals("complete");

		// Log in to continue
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("vigneshkumartamilselvan@gmail.com");
		driver.findElement(By.id("login-submit")).submit();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf@23");
		driver.findElement(By.id("login-submit")).submit();

		// 2. Click on the menu icon on the left top corner and Verify the JIRA Software
		// is present in the menu and click it.
		driver.findElement(By.xpath("//div[@id = \"ak-jira-navigation\"]//descendant::button")).click();
		driver.findElement(By.xpath("//span[text() = \"Jira Software\"]")).click();

		// 3. Verify the icon present in the page and text as "You don't have any
		// software projects" and click on Create Project, before clicking verify the
		// button is enabled.

		boolean img_present = driver
				.findElement(By.xpath("//h4[text() =\"You currently have no projects\"]/preceding-sibling::img"))
				.isDisplayed();
		Assert.assertEquals(img_present, true);
		boolean text_present = driver.findElement(By.xpath("//h4[text() =\"You currently have no projects\"]"))
				.isDisplayed();
		Assert.assertEquals(text_present, true);
		if (driver.findElement(By.xpath("//span[text() =\"Create project\"]")).isEnabled())
			driver.findElement(By.xpath("//span[text() =\"Create project\"]")).click();
		else
			System.err.println("Create project button is disabled");

		// 4. Click on the SCRUM option and select use template in next page
		driver.findElement(By.xpath("//h4[text()=\"Scrum\"]/following-sibling::button")).click();
		driver.findElement(By.xpath("//span[text()=\"Use template\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Select a company-managed project\"]")).click();

		// 5. Give the project details and create a new project, Now verify Project Key
		// and 3 Types of JIRA status pane present(To Do, Inprogress, Done).
		driver.findElement(By.id("project-create.create-form.name-field.input")).sendKeys("Test project -3");
		Thread.sleep(3000);
		String project_key_value = driver
				.findElement(By.id("project-create.create-form.advanced-dropdown.key-field.input"))
				.getAttribute("value");

		Assert.assertFalse(project_key_value.isEmpty());
		driver.findElement(By.xpath("(//span[text() =\"Create project\"])[2]")).click();

		List<String> status_List = new ArrayList<>();
		status_List.add("To Do");
		status_List.add("In Progress");
		status_List.add("Done");
		for (String status : status_List) {
			boolean status_result = driver.findElement(By.xpath("//h2[text() = '" + status + "']")).isDisplayed();
			assertTrue(status_result);
		}

		// 6. Now Star the project using the top right corner icon and verify it is
		// starred.
		driver.findElement(By.xpath("//div[@id=\"ghx-header-dynamic-append-zone\"]/button/span")).click();
		boolean star_status = driver.findElement(By.xpath("//div[@id=\"ghx-header-dynamic-append-zone\"]/button/span"))
				.isSelected();
		assertTrue(star_status);

		// 7. Verify there is No Sprit have started(Next to star) and click on Backlog.
		// String tooltipText = ageTextBox.getAttribute("title");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href=\"/jira/software/c/projects/TP3/boards/25/backlog\"]")).click();
		Actions actions = new Actions(driver);
		WebElement start_Sprint = driver.findElement(By.xpath("(//div[@class='header-right'])[1]"));
		actions.moveToElement(start_Sprint).perform();
		String sprint_msg = driver
				.findElement(By.xpath("//div[text() = \"Sprint cannot be started because it contains no issues\"]"))
				.getText();
		Assert.assertEquals(sprint_msg, "Sprint cannot be started because it contains no issues");
		System.out.println(sprint_msg);

		// 8. Now click on Add date in the sprint 1(Default sprint pane) and click add
		// dates, Verify add dates text before clicking.
		driver.findElement(By.xpath("//button[text() = \"Create sprint\"]")).click();
		driver.findElement(By.xpath("//*[text()=\"Add dates\"]")).click();
		driver.findElement(By.xpath("//input[@class =\"text\"]")).sendKeys("Test update project - 1");
		// Display the Date & Time using toString()
		//Date date = Calendar.getInstance().getTime();
		//String formatter = new SimpleDateFormat("dd-M-yyyy").format(date);

	}

}
