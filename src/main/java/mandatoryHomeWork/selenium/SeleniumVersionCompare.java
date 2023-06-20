package mandatoryHomeWork.selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumVersionCompare {

	public static void main(String[] args) {

		// Latest version - 4.9
		// WebDriver driver = new ChromeDriver();

		// ChromeManager
		// WebDriverManager.chromedriver().setup();
		// ChromeDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// Launch browser URL
		driver.get("https://id.atlassian.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Log in to continue
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("vigneshkumartamilselvan@gmail.com");
		driver.findElement(By.id("login-submit")).submit();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf@23");
		driver.findElement(By.id("login-submit")).submit();

		// Main page
		driver.findElement(By.xpath("(//div[@data-testid = 'product-container'][1]/a)[2]")).click();

		// Create issue
		driver.findElement(By.xpath("//button[@id=\"createGlobalItem\"]")).click();

		// Summary*
		driver.findElement(By.xpath("//input[@name='summary']")).sendKeys("Test case - 1");

		

		// Choose Assignee
		List<String> myList = Arrays.asList("Aravind Swamy", "Bhuvanesh K A", "priyankabuvana3",
				"Vigneshkumar Tamilselvan");
		Random random_Assignee = new Random();
		int randomitem = random_Assignee.nextInt(myList.size());
		String assignee_name = myList.get(randomitem);
		
		driver.findElement(By.xpath("//div[contains(@class,'fabric-user-picker_value-container fabric-user-picker_value-container--has-value')]")).click();
		driver.findElement(By.xpath("(//div[@class = 'fabric-user-picker__value-container fabric-user-picker__value-container--has-value css-4r8r93'])[2]")).sendKeys(assignee_name);
		
		System.out.println(assignee_name);
		
		// Assignee - Assign to me
		// driver.findElement(By.xpath("//span[text() = 'Assign to me']")).click();

		// create issue
		// driver.findElement(By.xpath("(//button/span[text() =
		// 'Create'])[2]")).click();

		System.out.println("Issue created");

		// Close all browser
		// driver.quit();
		driver.executeCdpCommand(assignee_name, null);
	}
}
