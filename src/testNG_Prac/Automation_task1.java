package testNG_Prac;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class Automation_task1 {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;

	@Test(dataProvider = "loginData")
	public void VerifyLogin(String UserName, String Password) {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//		action = new Actions(driver);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		driver.findElement(By.name("user-name")).sendKeys(UserName);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("login-button")).click();
		driver.quit();
	}

	@DataProvider
	public Object[][] loginData() {
		Object[][] data = new Object[7][2];
		// 1st set of data
		data[0][0] = "standard_user";
		data[0][1] = "secret_sauce";
		// 2nd set of data
		data[1][0] = "locked_out_user";
		data[1][1] = "secret_sauce";
		// 3rd set of data

		data[2][0] = "problem_user";
		data[2][1] = "secret_sauce";
		// 4th set of data

		data[3][0] = "performance_glitch_user";
		data[3][1] = "secret_sauce";
		// 5th set of data

		data[4][0] = "error_user";
		data[4][1] = "secret_sauce";
		// 6th set of data

		data[5][0] = "visual_user";
		data[5][1] = "secret_sauce";
		// 7th set of data

		data[6][0] = "  ";
		data[6][1] = "secret_sauce";

		return data;

	}
//	@Test(priority = 2)
//	public void afterTest() {
//		 driver.quit();
//	}

}
