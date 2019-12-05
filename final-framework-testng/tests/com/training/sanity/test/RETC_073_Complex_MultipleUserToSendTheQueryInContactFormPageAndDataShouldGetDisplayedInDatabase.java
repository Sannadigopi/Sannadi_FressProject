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

public class RETC_073_Complex_MultipleUserToSendTheQueryInContactFormPageAndDataShouldGetDisplayedInDatabase {
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
	public void validLoginTestAndUserToSendTheQueryInContactFormPageAndDataShouldGetDisplayedInDatabase() throws InterruptedException {
		loginPOM.MouseOverNewLaunch("New Launch");
		Thread.sleep(5000L);
		loginPOM.ClickLineLink();
		loginPOM.SendYourName("manzoor");
		loginPOM.SendYourEmail("manzoor@gmail.com");
		loginPOM.SendYourSubject("asdfas");
		loginPOM.SendTextAreaMessage("sdfsdfsd");
		screenShot.captureScreenShot("validated Entered Values are Displayed");
		Thread.sleep(5000L);
		loginPOM.ClickSendBtn();
		loginPOM.clickLinkLogin();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("validLoginTest");
		loginPOM.ClickUsersLink();
		loginPOM.SendUserSerarchTextBox("manzoor");
		loginPOM.ClickSearchBtn();
		Thread.sleep(5000L);
		screenShot.captureScreenShot("validated User Details in Database");
		genericmeth.assertText("manzoor", "//tbody[@id='the-list']", "xpath", "manzoor User Details are Not present in the User Database");
		
		
	}
}	
