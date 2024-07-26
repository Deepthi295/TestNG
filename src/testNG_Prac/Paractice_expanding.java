package testNG_Prac;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Paractice_expanding {
	WebDriver driver;
	Actions action;

	
  @Test
  public void Lgin() {
	  driver.findElement(By.name("username")).sendKeys("practice");
	  driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

  }
  @BeforeTest
  public void Setup() {
	  driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		action = new Actions(driver);

	  
  }

  @AfterTest
  public void close () {
	  driver.quit();
  }

}
