package com.training.sanity.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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

public class RETC_044_RealEstateMediumAdminToCreatePropetyDetailsBasedOnTheFeatureCreated {
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
	public void validLoginTestAndAdminToCreatePropetyDetailsBasedOnTheFeatureCreated() throws InterruptedException {
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
		loginPOM.clickFeaturesLink();
		loginPOM.SendNameTextBox("New Launches");
		loginPOM.SendSlugTextArea("launch");
		loginPOM.SendDescriptionTextArea("New Launches of villas, apartments, flats");
		Thread.sleep(5000L);
		screenShot.captureScreenShot("validated Add New Features Madule info");
		loginPOM.clickAddNewFeatureBtn();		
		loginPOM.clickAllPropertiesLink();
		Thread.sleep(5000L);
		screenShot.captureScreenShot("validated Added New Link");
		loginPOM.clickAddNewBtn();
		loginPOM.SendTitleTextBox("prestige");
		loginPOM.SendTextArea("home town");
		Thread.sleep(5000L);
		screenShot.captureScreenShot("validated Entered Values are Displayed");
		Thread.sleep(5000L);
		loginPOM.ClickCheckBoxlaunch();
		screenShot.captureScreenShot("validated to Select CheckBox");
		Thread.sleep(10000L);
		loginPOM.scrollElementPublish();
		Thread.sleep(5000L);
		genericmeth.assertText("View post","//a[contains(text(),'View post')]","xpath", "Post published. View post Message Link Not Displayed");
		System.out.println("Assertion is Passed and Post published. View post Message Link is Displayed to met as Expected");
		screenShot.captureScreenShot("validated Published Post Message");
		
			
		}
}
