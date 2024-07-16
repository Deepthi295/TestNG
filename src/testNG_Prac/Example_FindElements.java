package testNG_Prac;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Example_FindElements {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;
	SoftAssert sAssert;

	@Test(priority = 1, enabled = true)
	public void VerifyTotalLinksONPage() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int TotalLinks = links.size();
		System.out.println("Total no of LInks page:" + TotalLinks);
	
		assertTrue(TotalLinks > 320,"failed to validate the total no of links in the main page  ");
		System.out.println("Successfully validate the total no of links in the main page  ");
	}

	@Test(priority = 2, enabled = true)
	public void VerifyFotterLinks() {
		WebElement footerSection = driver.findElement(By.id("glbfooter"));
		List<WebElement> footerlinks = footerSection.findElements(By.tagName("a"));
		int footerlinkscount = footerlinks.size();
		System.out.println("Total links under  of FooterSection" + footerlinkscount);
	}

	@Test(priority = 3, enabled = true)
	public void Verifyfootercolumnlinks() {
		WebElement footercolumn = driver.findElement(By.xpath("//div[@id='gf-BIG']/table//td[2]"));
		List<WebElement> columnlinks = footercolumn.findElements(By.tagName("a"));
		int columnlinkscount = columnlinks.size();
		System.out.println("Total column links count " + columnlinkscount);
		System.out.println("**********************************");
		for (int i = 0; i < columnlinks.size(); i++) {
			String linkText = columnlinks.get(i).getText();
			System.out.println(linkText);
		}
		for (WebElement ele : columnlinks) {
			String text = ele.getText();
			if (text.contains("Developers")) {
				ele.click();
				break;
			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='logo']")));
		String text = driver.findElement(By.xpath("//img[@class='logo']")).getAttribute("alt");
//		if (text.contains("Developers Program")) {
//			System.out.println("Log is verified successfully ");
//		} else {
//			System.out.println("failed to verified Developers Program ");
//		}
    assertTrue(text.contains("Developers Program"),"failed to verified Developers Program " );// hard assert 
		sAssert.assertTrue(text.contains("Developers Program"),"failed to verified Developers Program ");// soft assert
		
		System.out.println("logo is verified successfully ");
		
		
		
		String url = driver.getCurrentUrl();
		System.out.println(url + "          " + "url of the page ");
//		if (url.equalsIgnoreCase("https://developer.ebay.com/")) {
//			System.out.println("Successfully verified the developers page URL");
//		} else {
//			System.out.println("failed to verify the current URL developer page");
//		}
		assertEquals(true,url.equals("https://developer.ebay.com/"),"failed to validate developer page"  );
		System.out.println("Successfully verified the developers page ");
		
		
		
		String title = driver.getTitle();
		System.out.println("page title " + "     " + title);
//		if (title.contains("Developers Program")) {
//			System.out.println("Successfully page title is verified");
//
//		} else {
//			System.out.println("failed to verify page title ");
//		}
       assertEquals(true,title.contains("Developers Program"),"Failed to verify page title");
       System.out.println("Successfully validate  the pag etitle ");
		
	}

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.get("https://ebay.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		System.out.println("setup");
		 sAssert = new SoftAssert();// soft assert non static obj 
		

	}

	@AfterTest
	public void afterTest() {
		System.out.println("Aftermethod");
		 driver.quit();
	}

}
