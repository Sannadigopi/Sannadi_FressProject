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

public class RETC_043_RealEstateMediumAdminToViewAddedPropertyDetailsInHomeScreen {
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
	public void validLoginTestAndAdminToViewAddedPropertyDetailsInHomeScreen() throws InterruptedException {
		loginPOM.clickLinkTextLogin();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("validLoginTest");
		loginPOM.clickPropertiesLink();
		Thread.sleep(5000L);
		loginPOM.NumOfLinksText(2);
		screenShot.captureScreenShot("validated Links");
		genericmeth.assertText("All Properties","//a[@class='wp-first-item current']","xpath", "All Properties text Link Not Displayed");
		System.out.println("Assertion is Passed and All Properties Text Link is Displayed to met as Expected");
		genericmeth.assertText("Add New","//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]","xpath", "Add New text Link Not Displayed");
		System.out.println("Assertion is Passed and Add New Text Link is Displayed to met as Expected");
		screenShot.captureScreenShot("Validated Links after successful login");
		loginPOM.clickAddNewLink();
		loginPOM.SendTitleTextBox("new launch");
		loginPOM.SendTextArea("new launch");
		Thread.sleep(5000L);
		screenShot.captureScreenShot("Validated Entered Values are Displayed");
		loginPOM.clickPublishBtn();
		Thread.sleep(5000L);
		genericmeth.assertText("View post","//a[contains(text(),'View post')]", "xpath", "View post Link is Not Present");
		System.out.println("Assertion is passed and View Post link Published successfully");
		screenShot.captureScreenShot("Validated View Post Link");
		loginPOM.clickLinkTextViewPost();
		Thread.sleep(5000L);
		genericmeth.assertText("new launch","//p[contains(text(),'new launch')]","xpath","new launch post is Not present on home screen");
		System.out.println("Assertion is passed and new post is launched on home screen successfully");
		screenShot.captureScreenShot("Validated Post launch on home screen");
	}
	
}
