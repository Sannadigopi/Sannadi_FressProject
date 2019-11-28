package com.training.generics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

/**
 * 
 * @author Naveen
 * @see this class will help when you want to do custom business logic, since  in POM we dont do 
 * 			dynamic elements available, when you want to iterate the table/accordion etc 
 * @since 17-Dec-2018 
 */
public class GenericMethods {
	WebDriver driver ; 
	
	public GenericMethods(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * 
	 * @param locator 
	 * @param type
	 * @see type is id, name, xpath, text, partialtext
	 * @see locator will be the element to be found on DOM 
	 * @return  WebElement
	 * this method shall give provided it has single enty in the DOM
	 */
	public WebElement getElement(String locator, String type){
		WebElement element  = null;
		type = type.toLowerCase();
		
		if(type.equals("id")){
			element  =  driver.findElement(By.id(locator));
		} else if(type.equals("css")){
			element = driver.findElement(By.cssSelector(locator));
		}else if (type.equals("name")){
			element  = driver.findElement(By.name(locator));
		}else if(type.equals("xpath")){
			element = driver.findElement(By.xpath(locator));
		}else if(type.equals("partialLinkText")){
			element = driver.findElement(By.partialLinkText(locator));
		}
		if(checkSingleEntry(locator, type)){
			System.out.println("Element Found and Returned");
			return element;
		}	
		System.out.println("Sorry Element not found, so not returned...");
		return null;


	}
	
	
	// shall give if it has multiple entries as a list in DOM 
	
	public List<WebElement> getElementsAsList(String locator, String type){
		type = type.toLowerCase();
		if(type.equals("id")){
			return driver.findElements(By.id(locator));
		}else if(type.equals("name")){
			return driver.findElements(By.name(locator));
		}else if(type.equals("xpath")){
			return driver.findElements(By.xpath(locator));
		}else if(type.equals("class")){
			return driver.findElements(By.className(locator));
		}// other TODO 
		return null;
	}
	public void assertURL(String expectedURL) {
		String actualURL = driver.getCurrentUrl();
		System.out.println("Runtime URL is " +actualURL);
		Assert.assertTrue(actualURL.equals(expectedURL),"Assertion failled as the expected" );
	}
		
	public void MouseHover(WebElement Locator, WebDriver driver){
	
	Actions act = new Actions(driver);
	act.moveToElement(Locator).perform();
	//act.moveToElement(Locator2).perform();
	
	}
	
	public void SendValues(WebElement Locator, String value) {
		Locator.sendKeys(value);
	}
	public void assertText(String expectedText, String locator, String type, String msg) {
		type = type.toLowerCase();
		
		if(type.equals("id")){
			String actualText = driver.findElement(By.id(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}else if(type.equals("class")){
			String actualText = driver.findElement(By.className(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}else if(type.equals("name")){
			String actualText = driver.findElement(By.name(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}else if(type.equals("xpath")){
			String actualText = driver.findElement(By.xpath(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}else if(type.equals("css")){
			String actualText = driver.findElement(By.cssSelector(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}else if(type.equals("tagname")){
			String actualText = driver.findElement(By.tagName(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}else if(type.equals("linktext")){
			String actualText = driver.findElement(By.linkText(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}else if(type.equals("partiallinktext")){
			String actualText = driver.findElement(By.partialLinkText(locator)).getText();
			Assert.assertTrue(actualText.equals(expectedText),msg );
		}
		
	} 
	// return true if element exists 
	// this method works for us when we have more than 1 element 
	// to be found for 
	public boolean isElementFound(String locator, String type){
		return getElementsAsList(locator, type).size()>0;
	}
	
	// this method gives true only where there is an single entry 
	// in the DOM 
	public boolean checkSingleEntry(String locator, String type){
		return getElementsAsList(locator, type).size() ==1;
	}
}