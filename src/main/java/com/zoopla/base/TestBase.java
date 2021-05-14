package com.zoopla.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zoopla.util.TestUtils;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	public TestBase() {
		
		prop= new Properties();
		
	}
	
	public static void initialization() {
		
		try {
			FileInputStream fis= new FileInputStream("D:\\MyWorkspace\\Project_WorkSpace\\zoopla\\config.properties");
			prop.load(fis);
			String browserName= prop.getProperty("browser");
			String url= prop.getProperty("url");
			
			if(browserName.equalsIgnoreCase("chrome")){
				
				System.setProperty("webdriver.chrome.driver", "D:\\MyWorkspace\\Drivers\\chromedriver.exe");
				driver= new ChromeDriver();
				wait = new WebDriverWait(driver,TestUtils.explicitWait);
				
			}else if(browserName.equalsIgnoreCase("firefox")){
				
			}else if(browserName.equalsIgnoreCase("IE")){
				
			}
			driver.manage().deleteAllCookies();
//			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(TestUtils.implicitlyWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtils.pageLoadTimeout, TimeUnit.SECONDS);
			driver.get(url);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
