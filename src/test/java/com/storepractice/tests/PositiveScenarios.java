package com.storepractice.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveScenarios {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\MyWorkspace\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.navigate().to("http://automationpractice.com/index.php");
		Reporter.log("Chrome browser is launched", true);
	}
	
	@Test
	public void SignIn() {
		System.out.println("I am in PS " +Thread.currentThread().getId());
		
		driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).click();;
		driver.findElement(By.id("email_create")).sendKeys("admin123@gmail.com");
		driver.findElement(By.name("SubmitCreate")).click();
		SoftAssert assert1= new SoftAssert();
		//div[@class='account_creation']/h3[contains(text(), 'Your personal information')]
		String expectedMsg= "YOUR PERSONAL INFORMATION";
		String actualMsg= driver.findElement(By.xpath("//div[@class='account_creation']/h3")).getText();
		//Assert.assertEquals(actualMsg, expectedMsg);
		//driver.findElement(By.id("customer_firstname")).sendKeys("PRIYANKA");
		//driver.findElement(By.id("customer_lastname")).sendKeys("SENGAR");
		//using Soft assert
		
		assert1.assertEquals(actualMsg, expectedMsg);
		Reporter.log("Fill data on Sign in page",true);
		driver.findElement(By.id("customer_firstname")).sendKeys("PRIYANKA");
		driver.findElement(By.id("customer_lastname")).sendKeys("SENGAR");
		assert1.assertAll();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	
}
