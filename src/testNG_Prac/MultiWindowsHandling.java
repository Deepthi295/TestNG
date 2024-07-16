package testNG_Prac;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class MultiWindowsHandling {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;
	
	
	
	
  @Test
  public void VerifyMultiWindows() {
	  
	  
  }
  @BeforeTest
  public void SetUpDriver() {
	  driver = new ChromeDriver();
	  driver.get("https://phptravels.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  action = new Actions(driver);
	  wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
