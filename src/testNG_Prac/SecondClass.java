package testNG_Prac;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondClass {

	@Test
	public void test3() {
		System.out.println("test3");
	}

	@BeforeTest
	public void beforetest() {
		System.out.println("before test");
	}

	@AfterTest
	public void aftertest() {
		System.out.println("After test");

	}

	@BeforeSuite
	public void beforeSuit() {
		System.out.println("before suit");

	}

	@AfterSuite
	public void aftersuit() {
		System.out.println("Afetr suit");

	}
	@BeforeMethod
	public void beforemethod() {
		System.out.println(" Before method");

	}
	@AfterMethod
	public void Aftermethod() {
		System.out.println(" After method");

	}
}
