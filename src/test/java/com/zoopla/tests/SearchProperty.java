package com.zoopla.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.zoopla.base.TestBase;
import com.zoopla.pageobjects.AllPageObject;

public class SearchProperty extends TestBase{

	public SearchProperty() {
		super();
	}

	AllPageObject allPageObject= new AllPageObject();

	@Test
	public void searchLocation() {

		try {
			Thread.sleep(5000);
			WebElement element= allPageObject.getSearchProperty_Textbox();
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.click();
			actions.sendKeys("London");
			actions.build().perform();
			allPageObject.getSearch_Button().click();


			List<WebElement> ele= allPageObject.getPropertyValue_List();
			System.out.println(ele.size());
			List<Long> value= new ArrayList<Long>();
			for(WebElement str: ele) {

				String val= str.getText();
				val= val.replace("£", "");
				val= val.replace(",", "");
				Long dal= Long.parseLong(val);
				value.add(dal);

			}

			Collections.sort(value);
			System.out.println(value);
			List<WebElement> fele= allPageObject.getProperty_List();
			WebElement fElement= fele.get(4);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", fElement);
//			Thread.sleep(10000);
			fElement.click();
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			System.out.println("clicked");

			WebElement sElement= allPageObject.getAgentName_Textfield();
			String ExpectedagentName= sElement.getText();
			System.out.println("Expected agent name is "+ExpectedagentName);
			sElement.click();

			//Last Page - verification

			List<WebElement> tList= allPageObject.getAgentProperty_List();

			for(int count=1; count<=tList.size(); count++) {
				WebElement ele1= driver.findElement(By.xpath("(//ul[contains(@class,'listing-results')]//li[contains(@id,'listing_')]//*//*//*/a[contains(@class,'photo')])["+count+"]"));
				ele1.click();
				String actualAgentName= allPageObject.getAgentName_Textfield().getText();
				if (actualAgentName.equalsIgnoreCase(ExpectedagentName)) {
					System.out.println(count+ " property belong to "+ ExpectedagentName);
				}else {
					System.out.println(count+ " property doesn't belong to "+ ExpectedagentName);
				}
				driver.navigate().back();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}catch(ElementNotVisibleException e) {
			e.printStackTrace();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}

	}
}
