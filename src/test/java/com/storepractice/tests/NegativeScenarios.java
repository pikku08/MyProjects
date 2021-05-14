package com.storepractice.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NegativeScenarios {
	
	public WebDriver driver;
	
	//To execute setup and teardown methood- use @Before and @After Suite or Test or class or method
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\MyWorkspace\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		
	}
	
	@Test
	public void checkDuplicateEmail() throws InterruptedException {
		System.out.println("I am in NS Duplicate" +Thread.currentThread().getId());
		driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).click();;
		driver.findElement(By.id("email_create")).sendKeys("admin@gmail.com");
		driver.findElement(By.name("SubmitCreate")).click();

		String expectedMsg= "An account using this email address has already been registered. Please enter a valid password or request a new one.";
		String actualMsg= driver.findElement(By.xpath("//div[contains(@id, 'create_account_error')]/ol/li")).getText();
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	@Test
	public void checkInvalidEmail() throws InterruptedException {
		System.out.println("I am in NS Invalid" +Thread.currentThread().getId());
		driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).click();;
		driver.findElement(By.id("email_create")).sendKeys("asdfg");
		driver.findElement(By.name("SubmitCreate")).click();

		String expectedMsg= "Invalid email address.";
		String actualMsg= driver.findElement(By.xpath("//div[contains(@id, 'create_account_error')]/ol/li")).getText();
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	@Test
	public void checkBlankEmail() throws InterruptedException {
		System.out.println("I am in NS Blank" +Thread.currentThread().getId());
		driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).click();;
		driver.findElement(By.id("email_create")).sendKeys("");
		driver.findElement(By.name("SubmitCreate")).click();

		String expectedMsg= "Invalid email address.";
		String actualMsg= driver.findElement(By.xpath("//div[contains(@id, 'create_account_error')]/ol/li")).getText();
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
