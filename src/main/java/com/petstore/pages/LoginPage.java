package com.petstore.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.petstore.util.TestUtil;
import com.petstore.util.TestBase;


public class LoginPage extends TestBase {
	TestUtil data;
	
	//Page Factory
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="signon")
	WebElement loginInBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Register Now!')]")
	WebElement registerNowBtn;
	
	//to initialize page objects
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		data = new TestUtil();
	}
	
	public HomePage login() throws IOException {
		username.sendKeys(prop.getProperty("usernameID"));
		password.clear();
		password.sendKeys(prop.getProperty("password"));
		//loginInBtn.click();
		TestUtil.takeScreenshotAtEndOfTest();
		TestUtil.clickButton(loginInBtn);
		return new HomePage();
	}
	
	public RegistrationPage navigateToRegistrationPage() throws IOException {
		//registerNowBtn.click();
		TestUtil.clickButton(registerNowBtn);
		return new RegistrationPage();
	}
}
