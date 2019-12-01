package com.training.sanity.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import bsh.Console;

public class RETC_045_RealEstateMediumAdminAllowToCreatePropertyDetailsBasedOnTheRegionCreated {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericmeth;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		genericmeth = new GenericMethods(driver);
		// open the browser 
		driver.get(baseUrl);
		genericmeth.assertURL("http://realestatem1.upskills.in/");
		System.out.println("Assertion is passed and match the base URL with runtime URL");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(10000L);
		driver.quit();
	}
	@Test
	public void validLoginTestAndAdminToCreatePropetyDetailsBasedOnTheRegionCreated() throws InterruptedException {
		loginPOM.clickLinkTextLogin();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("validLoginTest");
		loginPOM.clickPropertiesLink();
		Thread.sleep(5000L);
		loginPOM.AllLinksText(5);
		screenShot.captureScreenShot("validated All Links");
		genericmeth.assertText("All Properties","//a[@class='wp-first-item current']","xpath", "All Properties text Link Not Displayed");
		System.out.println("Assertion is Passed and All Properties Text Link is Displayed to met as Expected");
		genericmeth.assertText("Add New","//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]","xpath", "Add New text Link Not Displayed");
		System.out.println("Assertion is Passed and Add New Text Link is Displayed to met as Expected");
		genericmeth.assertText("Features","//a[contains(text(),'Features')]","xpath", "Features text Link Not Displayed");
		System.out.println("Assertion is Passed and Features Text Link is Displayed to met as Expected");
		genericmeth.assertText("Regions","//a[contains(text(),'Regions')]","xpath", "Regions text Link Not Displayed");
		System.out.println("Assertion is Passed and Regions Text Link is Displayed to met as Expected");
		genericmeth.assertText("Properties Settings","//a[contains(text(),'Properties Settings')]","xpath", "Properties Settings text Link Not Displayed");
		System.out.println("Assertion is Passed and Properties Settings Text Link is Displayed to met as Expected");
		loginPOM.clickRegionsLink();
		loginPOM.SendNameTextBox("Electronic city");
		loginPOM.SendSlugTextArea("Electronic city");
		Thread.sleep(5000L);
		screenShot.captureScreenShot("Validated Entered Values Displayed");
		loginPOM.ClickParentDropdownBoxOptions();
		
		try {
			genericmeth.assertText("None", "//option[contains(text(),'None')]", "xpath", "Option None is Not present in the dropdown");
			genericmeth.assertText("Commercial", "//option[contains(text(),'Commercial')]", "xpath", "Option Commercial is Not present in the dropdown");
			genericmeth.assertText("Apartments", "//option[contains(text(),'Apartments')]", "xpath", "Option Apartments is Not present in the dropdown");	
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Apartments Option is Not Located in the Parent Dropdown Box");
		}
		
		Thread.sleep(5000L);
		screenShot.captureScreenShot("Validated dropdownOptions");
		loginPOM.SelectParentDropDwonOption("None");
		loginPOM.SendDescriptionTextArea("New Launches of villas, apartments, flats");
		screenShot.captureScreenShot("validate Entered values Displayed");
		loginPOM.clickAddNewRegionBtn();
		loginPOM.clickAllPropertiesLink();
		loginPOM.clickAddNewLink();
		loginPOM.SendTitleTextBox("prestige");
		loginPOM.SendTextArea("home town");
		Thread.sleep(5000L);
		screenShot.captureScreenShot("validate Entered values Displayed");
		loginPOM.ClickCheckBoxRegion();
		Thread.sleep(5000L);
		loginPOM.clickPublishRunBtn();
		Thread.sleep(5000L);
		genericmeth.assertText("View post","//a[contains(text(),'View post')]", "xpath", "View post Link is Not Present");
		System.out.println("Assertion is passed and View Post link Published successfully");
		screenShot.captureScreenShot("Validated View Post Link");

	}
}
