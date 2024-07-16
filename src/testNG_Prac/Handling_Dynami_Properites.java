package testNG_Prac;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Handling_Dynami_Properites {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;
	FluentWait<WebDriver> fwait;

	@Test(priority = 1, enabled = true)
	public void Verifydyanamic() {
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//span[text()='Dynamic Properties']")).click();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		fwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("visibleAfter")));
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("visibleAfter")));// explicite wait
		driver.findElement(By.id("visibleAfter")).click();

	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/dynamic-properties");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));//implicet
		// wait
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class);// fluent wait syntax

	}

	@AfterTest
	public void afterTest() {
	}

}
