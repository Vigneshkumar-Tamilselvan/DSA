package mandatoryHomeWork.selenium;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Jira_Create_a_new_project_and_a_new_sprint {

	public static void main(String[] args) throws InterruptedException {
		// 1. Log in to JIRA
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
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
		System.out.println("Step 7 pass");

		// 7. Verify there is No Sprit have started(Next to star) and click on Backlog.
		// String tooltipText = ageTextBox.getAttribute("title");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()=\"Backlog\"]/ancestor::a")).click();
		boolean start_Sprint = driver.findElement(By.xpath("//button[text()='Start sprint']")).isEnabled();
		assertFalse(start_Sprint);

		// 8. Now click on Add date in the sprint 1(Default sprint pane) and click add
		// dates, Verify add dates text before clicking.
		String addDates = driver.findElement(By.xpath("//span[text()=\"Add dates\"]")).getText();
		Assert.assertEquals(addDates, "Add dates");
		driver.findElement(By.xpath("//span[text()=\"Add dates\"]")).click();

		// 9. In the Displaying pop up, Update the sprint name as Project_Name -
		// Sprint_1_2W and Select Duration as 2 Weeks, Start date as Current time + 45
		// Mins and Click on Update button.
		driver.findElement(By.xpath("//input[@class =\"text\"]")).sendKeys("Project_Name - Sprint_1_2W");
		Select select = new Select(driver.findElement(By.id("ghx-sprint-duration")));
		select.selectByValue("2 weeks ");
		// Display the Date & Time using toString()
		System.out.println(Calendar.getInstance().getTime());
		// String formatter = new SimpleDateFormat("dd-M-yyyy").format(date);
		
		// 10. Verify Create sprint button is disabled.
		
		
		//11. Click on Add issue and Add 2 Story and 2 Bugs, After adding verify the project name with bug id, JIRA status as Todo and Assignee as Unassigned.

	}

}
