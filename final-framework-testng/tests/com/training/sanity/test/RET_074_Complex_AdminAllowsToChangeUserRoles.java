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

public class RET_074_Complex_AdminAllowsToChangeUserRoles {
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
		loginPOM.clickLinkTextLogin();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Login successful and Validated");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(10000L);
		driver.quit();
	}
	@Test
	public void ValidLoginAndAdminAllowsToChangeUserRoles() throws InterruptedException {
		loginPOM.ClickUsersLink();
		Thread.sleep(5000L);
		genericmeth.assertText("All Users","//a[@class='wp-first-item current']","xpath", "All Users LinK text is Not Present");
		System.out.println("Assertion pass and displayed All Users LinK Under User Link");			
		genericmeth.assertText("Add New","//li[@id='menu-users']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]","xpath", "Add New Link text is Not Present");
		System.out.println("Assertion pass and displayed Add New Link Under User Link");			
		genericmeth.assertText("Your Profile","//a[contains(text(),'Your Profile')]","xpath", "Your Profile Link text is Not Present");
		System.out.println("Assertion pass and displayed Your Profile Link Under User Link");
		screenShot.captureScreenShot("validated Links are Displayed");
		Thread.sleep(5000L);
		loginPOM.ClickChangeRoleDropdownBox();
		genericmeth.assertText("Change role to…","/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/div[1]/div[2]/select[1]/option[1]","xpath", "Change role to… dropdown Option is Not Present");
		System.out.println("Assertion pass and displayed All Users LinK Under User Link");			
		genericmeth.assertText("Shop manager","/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/div[1]/div[2]/select[1]/option[2]","xpath", "Shop manager dropdown Option is Not Present");
		System.out.println("Assertion pass and displayed Shop Manager Option role in the role change dropdown");			
		genericmeth.assertText("Customer","/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/div[1]/div[2]/select[1]/option[3]","xpath", "Customer dropdown Option is Not Present");
		System.out.println("Assertion pass and displayed Customer Option role in the role change dropdown");
		genericmeth.assertText("Agent","/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/div[1]/div[2]/select[1]/option[4]","xpath", "Agent dropdown Option is Not Present");
		System.out.println("Assertion pass and displayed Agent Option role in the role change dropdown");
		screenShot.captureScreenShot("validated Entered Values are Displayed");
		Thread.sleep(5000L);
		loginPOM.SendUserSerarchTextBox("manzoor mehadi");
		loginPOM.ClickSearchBtn();
		loginPOM.ClickUserCheckBox1();
		loginPOM.ClickChangeRoleDropdownBox();
		loginPOM.SelectChangeRoleDropdownOPtion("Agent");
		loginPOM.ClickChangeBtn();
		Thread.sleep(10000L);
		genericmeth.assertText("Changed roles.","//*[@id='message']/p","xpath", "Changed roles. message is Not Present");
		System.out.println("Assertion pass and displayed Displayed Message as Changed roles");
		screenShot.captureScreenShot("Displayed message as Changed roles");
		Thread.sleep(5000L);
		loginPOM.SendUserSerarchTextBox("alex hales");
		loginPOM.ClickSearchBtn();
		loginPOM.ClickUserCheckBox2();
		loginPOM.ClickChangeRoleDropdownBox();
		loginPOM.SelectChangeRoleDropdownOPtion("Customer");
		loginPOM.ClickChangeBtn();
		Thread.sleep(10000L);
		genericmeth.assertText("Changed roles.","//*[@id='message']/p","xpath", "Changed roles. message is Not Present");
		System.out.println("Assertion pass and displayed Displayed Message as Changed roles");
		screenShot.captureScreenShot("Displayed message as Changed roles");
		Thread.sleep(5000L);
		loginPOM.SendUserSerarchTextBox("mariya");
		loginPOM.ClickSearchBtn();
		loginPOM.ClickUserCheckBox3();
		loginPOM.ClickChangeRoleDropdownBox();
		loginPOM.SelectChangeRoleDropdownOPtion("Shop manager");
		loginPOM.ClickChangeBtn();
		Thread.sleep(10000L);
		genericmeth.assertText("Changed roles.","//*[@id='message']/p","xpath", "Changed roles. message is Not Present");
		System.out.println("Assertion pass and displayed Displayed Message as Changed roles");
		screenShot.captureScreenShot("Displayed message as Changed roles");
		
	}

}
