package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//*[@id='responsive']/li[7]/a/i")
	private WebElement LinkTextLogin;
	
	@FindBy(xpath ="//*[@id=\"post-133\"]/div/div/div/ul/li[2]/a")
	private WebElement TagNameRegisterBtn;
	
	@FindBy(xpath = "//*[@id=\"post-133\"]/div/div/div/ul/li[1]/a")
	private WebElement clickTagNameLoginBtn;
	 
	public void clickTagNameLoginBtn() {
		this.clickTagNameLoginBtn.click();
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	@FindBy(xpath = " //li[@id='wp-admin-bar-my-account']")
	private WebElement HyperLinkAdmin;
	
	@FindBy(xpath = "//*[@id=\"wp-admin-bar-my-account\"]/a")
	private WebElement MouseOverClick;
	
	public void MouseHoverClick(String howdy) {
		Actions act = new Actions(driver);
		act.moveToElement(MouseOverClick).perform();
	}
	
	@FindBy(id="last_name")
	private WebElement LastName;
	
	@FindBy(id="phone")
	private WebElement Phone;
	
	@FindBy(id="submit")
	private WebElement SubmitBtn;	

	@FindBy(xpath="//*[@id=\"password\"]/td/button")
	private WebElement ChangePasswordBtn; 
	
	@FindBy(id="pass1-text")
	private WebElement newpassword; 
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="first-name")
	private WebElement firstname;
	
	@FindBy(xpath = "//*[@id=\"signupform\"]/p[5]/input")
	private WebElement RegisterBtn;
	
	@FindBy(xpath = "//*[@id=\"wp-admin-bar-logout\"]/a")
	private WebElement LogOutBtn;
	
	
	public void clickLinkTextLogin() {
		this.LinkTextLogin.click();
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}	
	public void clickHyperLinkAdmin() {
		this.HyperLinkAdmin.click();
	}
	
	public void sendLastName(String lastName) {
		this.LastName.clear();
		this.LastName.sendKeys(lastName);
	}
	public void sendPhone(String phone) {
		this.Phone.clear();
		this.Phone.sendKeys(phone);
	}
	public void clickSubmitBtn() {
		this.SubmitBtn.click();
		
	}
	public void clickChangePasswordBtn() {
		this.ChangePasswordBtn.click();
	}
	public void clickTagNameRegisterBtn() {
		this.TagNameRegisterBtn.click();
	}
	public void sendNewPassword(String newpassword) {
		this.newpassword.clear(); 
		this.newpassword.sendKeys(newpassword); 
	}
	public void sendEmail(String email) {
		this.email.clear(); 
		this.email.sendKeys(email); 
	}
	public void sendFirstName(String firstname) {
		this.firstname.clear(); 
		this.firstname.sendKeys(firstname); 
	}
	public void clickRegisterBtn() {
		this.RegisterBtn.click();
	}
	public void clickLogOutBtn() {
		this.LogOutBtn.click();
	}
	@FindBy(xpath ="//div[contains(text(),'Properties')]")
	private WebElement PropertiesTab;
	
	public void clickPropertiesLink() {
		this.PropertiesTab.click();
	}
	@FindBy(xpath ="//a[@class='wp-first-item'][contains(text(),'All Properties')]")
	private WebElement AllPropertiesLink;
	
	public void clickAllPropertiesLink() {
		this.AllPropertiesLink.click();
	}
	@FindBy(xpath ="//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement AddNewLink;
	
	public void clickAddNewLink() {
		this.AddNewLink.click();
	}
	@FindBy(xpath ="//input[@id='title']")
	private WebElement TitleTextBox;
	
	public void SendTitleTextBox(String value) {
		this.TitleTextBox.clear();
		this.TitleTextBox.sendKeys(value);	
	}
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement TextArea;
	
	public void SendTextArea(String value) {
		this.TextArea.clear();
		this.TextArea.sendKeys(value);
	}
	@FindBy(xpath = "//input[@id='publish']")
	private WebElement publishBtn;	
	
	public void clickPublishBtn() {
		this.publishBtn.click();
	}
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/input[2]")
	 private WebElement PublishRunBtn;
	
	 public void scrollElementPublish() {
		WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/input[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	 public void clickPublishRunBtn() {
		this.PublishRunBtn.click();
	}
	 
	/*@FindBy(xpath= "//div[contains(@id,'publishing-action')]//input[2][contains(@type,'submit')]")
	private WebElement Publish;
	
	public void ClickPublish() {
		this.Publish.click();
	}*/
	
	@FindBy(xpath = "//a[contains(text(),'View post')]")
	private WebElement linkTextViewPost;
	
	public void clickLinkTextViewPost() {
		this.linkTextViewPost.click();
	}
	
	@FindBy(xpath = "//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']")
	private WebElement AreaOfAddress;
	
	public void NumOfLinksText(int i) {
	List<WebElement> NumLinks = AreaOfAddress.findElements(By.tagName("a"));
	for(i =0; i<NumLinks.size()-3;i++ ) {
		String text = NumLinks.get(i).getText();
		System.out.println("Link Text is----->" +text );
	}
	}
	@FindBy(xpath = "//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']")
	private WebElement AreaOfAllLinks;
	
	public void AllLinksText(int i) {
	List<WebElement> AllLinks = AreaOfAllLinks.findElements(By.tagName("a"));
	for(i =0; i<AllLinks.size();i++ ) {
		String Ltext = AllLinks.get(i).getText();
		System.out.println("Link Text is----->" +Ltext );
	}
	}
	@FindBy(xpath = "//a[contains(text(),'Features')]")
	private WebElement FeaturesLink;
	
	public void clickFeaturesLink() {
		this.FeaturesLink.click();
	}
	@FindBy(xpath = "//input[@id='tag-name']")
	private WebElement NameTextBox;
	
	public void SendNameTextBox(String Name) {
		this.NameTextBox.clear();
		this.NameTextBox.sendKeys(Name);
	}
	@FindBy(xpath ="//input[@id='tag-slug']")
	private WebElement SlugTextArea;
	
	public void SendSlugTextArea(String Slug) {
		this.SlugTextArea.clear();
		this.SlugTextArea.sendKeys(Slug);
	}
	@FindBy(xpath = "//textarea[@id='tag-description']")
	private WebElement TextAreaDescription;
	
	public void SendDescriptionTextArea(String Description) {
		this.TextAreaDescription.clear();
		this.TextAreaDescription.sendKeys(Description);
	}
	@FindBy(xpath = "//input[@id='submit']")
	private WebElement AddNewFeatureBtn;
	
	public void clickAddNewFeatureBtn() {
	this.AddNewFeatureBtn.click();
	}
	@FindBy(xpath = "//input[@id='submit']")
	private WebElement AddNewRegionBtn;
	
	public void clickAddNewRegionBtn() {
	this.AddNewRegionBtn.click();
	}
	@FindBy(xpath = "//a[@class='page-title-action']")
	private WebElement AddNewBtn;
	
	public void clickAddNewBtn() {
		this.AddNewBtn.click();
	}
	@FindBy(xpath = "//li[contains(@id,'property_feature-')]//label[@class='selectit'][contains(text(),'launch')]")
	private WebElement CheckBoxLaunch;
	
	public void ClickCheckBoxlaunch() {
		this.CheckBoxLaunch.click();
	}
	@FindBy(xpath ="//a[contains(text(),'Regions')]")
	private WebElement RegionsLink;
	
	public void clickRegionsLink() {
		this.RegionsLink.click();
	}
	@FindBy(xpath ="//select[@id='parent']")
	private WebElement parentDropdownBox;
	
	public void ClickParentDropdownBoxOptions() {
		this.parentDropdownBox.click();
		
	}
	@FindBy(xpath ="//select[@id='parent']")
	private WebElement SelectDropdownOption;
	
	public void SelectParentDropDwonOption(String Option) {
		Select ParentOption = new Select(SelectDropdownOption);
		ParentOption.selectByVisibleText(Option);
	}
	@FindBy(xpath = "//li[contains(@id,'region-')]//label[@class='selectit'][contains(text(),'Electronic city')]")
	private WebElement CheckBoxRegion;
	
	public void ClickCheckBoxRegion() {
		this.CheckBoxRegion.click();
	}
}
