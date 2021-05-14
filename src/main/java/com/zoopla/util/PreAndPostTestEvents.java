package com.zoopla.util;

import java.io.File;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.zoopla.base.TestBase;

public class PreAndPostTestEvents extends TestBase {
	protected WebDriver driver;
	
	@BeforeClass
	public void setup(){
		System.out.println("Before Class");
		initialization();
		}
		
		 @BeforeMethod
		    public void Initialization(Method method) {
		        System.out.println("Before Method");
		
		 }
		 
		 @AfterMethod
		    public void captureScreenShotIfFailure(ITestResult result) {
			 System.out.println("After Method");
			 System.out.println("Test Name: " + result.getName());
		        if (!result.isSuccess()) {
		        	 System.out.println("Test Result: FAIL");
		                 
		        } else {
		        	 System.out.println("Test Result: PASS");
		        }
		        System.out.println("******************************************************");
		        System.out.println( "__________________________________________________________________________");
		    }

	@AfterClass
	public void tearDown(){
	 System.out.println("After Class");
		driver.close();

		
		}

}
