package com.zoopla.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.zoopla.base.TestBase;

public class AllPageObject extends TestBase{
	
	//AllPageFunction allPageFunction= new AllPageFunction();
	public AllPageObject() {
//		super();
		TestBase.initialization();
		
	}
	
	public By search_Button= By.xpath("//button[contains(text(),'Search')]");
	public By propertyValue_List= By.xpath("//div[contains(@id,'listing_')]//*//*//div[contains(@class,'e2uk8e18')]//*//*//p[contains(@class,'css-18tfumg-Text')]");
	public By property_List= By.xpath("//div[contains(@id,'listing_')]//*//*//*//*//*//img[contains(@class,'e2uk8e1')]");
	public By agentName_Textfield= By.xpath("//div[@class='ui-agent__text']//h4[@class='ui-agent__name']");
	public By agentProperty_List= By.xpath("//ul[contains(@class,'listing-results')]//li[contains(@id,'listing_')]");
	public By searchProperty_Textbox= By.cssSelector("span.search-input-location-placeholder-1");
	
	public WebElement getAgentName_Textfield() {
		return finder(agentName_Textfield);
	}

	/**
	 * @return the search_Button
	 */
	public WebElement getSearch_Button() {
		return finder(search_Button);
	}

	/**
	 * @return the propertyValue_List
	 */
	public List<WebElement> getPropertyValue_List() {
		return finders(propertyValue_List);
	}

	/**
	 * @return the property_List
	 */
	public List<WebElement> getProperty_List() {
		return finders(property_List);
	}

	/**
	 * @return the agentProperty_List
	 */
	public List<WebElement> getAgentProperty_List() {
		return finders(agentProperty_List);
	}

	/**
	 * @return the searchProperty_Textbox
	 */
	public WebElement getSearchProperty_Textbox() {
		return finder(searchProperty_Textbox);
	}
	
	///Function
	 public WebElement finder(By locator) {
	        WebElement webElement = null;
	        try {
	            webElement = driver.findElement(locator);
	            return webElement;
	        }catch(Exception e) {
	        	System.out.println("Not able to find desired element " +locator.toString());
	        	e.printStackTrace();
	        }
	        return webElement;

	    }
	    
	    public List<WebElement> finders(By locator) {
	        List<WebElement> webElement = null;
	        webElement = driver.findElements(locator);
	        return webElement;
	    }
	    
	    public void waitForElementPresent(By locator) {
	    	try {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    	}
	    	catch(Exception e) {
	        	System.out.println("some exception occured while waiting for the element" +locator.toString());
	        	e.printStackTrace();
	    	}
	    }

}
