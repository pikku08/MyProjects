package com.zoopla.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFlipLearn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\MyWorkspace\\Drivers\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:\\MyWorkspace\\Drivers\\chromedriver.exe");
		driver.get("https://app.fliplearn.com/home/wrv1_home/");
		
	}

}
