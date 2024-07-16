package testNG_Prac;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Example_HnadlingMultiple_Windows {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;

	@Test(priority = 1, enabled = true)
	public void VerifyMultipletabs() throws Exception {
		String mwindId = driver.getWindowHandle();
		System.out.println("mwindID" + mwindId);
		driver.findElement(By.xpath("//a/strong[text()='Signup']")).click();
		Set<String> windIDs = driver.getWindowHandles();
		System.out.println("windID" + windIDs);
		String childwind1 = null;
		for (String wind : windIDs) {
			if (!wind.equals(mwindId)) {
				childwind1 = wind;
			}
		}
		driver.switchTo().window(childwind1);
		driver.findElement(By.id("first_name")).sendKeys("Deepthi");
		driver.findElement(By.id("last_name")).sendKeys("bond");
		driver.switchTo().window(mwindId);
		driver.findElement(By.xpath("//a[text()='Demo']")).click();
		driver.findElement(By.name("first_name")).sendKeys("Deepthi");
		driver.findElement(By.name("last_name")).sendKeys("bond");
		driver.findElement(By.xpath("//a/Strong[text()='Login']")).click();
		windIDs = driver.getWindowHandles();
		String childwind2 = null;
		for (String windId : windIDs) {
			if (!windId.equals(mwindId) || !windId.equals(childwind1)) {
				childwind2 = windId;
			}
		}
		driver.switchTo().window(childwind2);
		driver.findElement(By.id("email")).sendKeys("Deepthi1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("jamesbond");
		driver.switchTo().window(childwind1);
		driver.findElement(By.id("inputEmail")).sendKeys("jamesbond@gmail.com");
		driver.findElement(By.id("inputPhone")).sendKeys("9848022338");
		driver.findElement(By.id("inputEmail")).click();
		driver.findElement(By.id("inputEmail")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.id("inputEmail")).sendKeys(Keys.chord(Keys.CONTROL, "c"));
		driver.findElement(By.id("inputCompanyName")).click();
		driver.findElement(By.id("inputEmail")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
		driver.findElement(By.id("inputAddress")).sendKeys("Ameerpet");
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(mwindId);
		driver.findElement(By.name("BusinessName")).sendKeys("QualityThought");
		Thread.sleep(2000);
		driver.quit();

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.get("https://phptravels.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		System.out.println("setup");

	}

	@AfterTest
	public void afterTest() {
	}

}
