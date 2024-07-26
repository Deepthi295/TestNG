package testNG_Prac;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Example_Handlingframes {
	WebDriver driver;
	Actions action;

	@Test(priority = 1, enabled = true)
	public void VerifiyDraggable() {
		driver.findElement(By.xpath("//a[text()='Draggable']")).click();
		driver.switchTo().frame(0);
		String test = driver.findElement(By.xpath("//div[@id='draggable']")).getText();
		//System.out.println("test1" + test);
		action.clickAndHold(driver.findElement(By.id("draggable"))).build().perform();
		action.moveByOffset(90, 90);
		action.release().build().perform();
		driver.switchTo().parentFrame();
	}

	@Test(priority = 2, enabled = true)
	public void Verifydroppable() {
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		driver.switchTo().frame(0);
	    String test = driver.findElement(By.xpath("//div[@id='draggable']/p[text()='Drag me to my target']")).getText();
	    System.out.println("test2:"+test);
		action.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build()
				.perform();
		driver.switchTo().defaultContent();
	}

	@Test(priority = 3, enabled = true)
	public void Verifyresizable() {
		driver.findElement(By.xpath("//a[text()='Resizable']")).click();
		driver.switchTo().frame(0);
		String test = driver.findElement(By.xpath("//h3[text()='Resizable']")).getText();
		System.out.println("test3:"+test);
		WebElement resize =driver.findElement(By.xpath("//div[@id='resizable']/h3/following-sibling::div[3]"));
		action.clickAndHold(resize).moveByOffset(120, 80).release().perform();
        driver.switchTo().defaultContent();

	}

	@Test(priority = 4, enabled = true)
	public void VerifySelectable() {
		driver.findElement(By.xpath("//a[text()='Selectable']")).click();
		driver.switchTo().frame(0);
		action.click(driver.findElement(By.xpath("//li[text()='Item 3']"))).build().perform();
		driver.switchTo().defaultContent();

	}

	@Test(priority = 5, enabled = false)
	public void VerifySortable() {
		driver.findElement(By.id("//a[text()='//a[text()='Sortable']")).click();
		driver.switchTo().frame(0);
		
		//action.clickAndHold()
		
	}

	@BeforeMethod
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action = new Actions(driver);

	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

}
