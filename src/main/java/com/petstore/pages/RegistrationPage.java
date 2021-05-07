package com.petstore.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.petstore.util.TestUtil;
import com.petstore.util.TestBase;

public class RegistrationPage extends TestBase{
	TestUtil data;
	
	//page object
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="repeatedPassword")
	WebElement repeatedPassword;
	
	@FindBy(name="account.firstName")
	WebElement firstName;
	
	@FindBy(name="account.lastName")
	WebElement lastName;
	
	@FindBy(name="account.email")
	WebElement email;
	
	@FindBy(name="account.phone")
	WebElement phoneNumber;
	
	@FindBy(name="account.address1")
	WebElement address1;
	
	@FindBy(name="account.address2")
	WebElement address2;
	
	@FindBy(name="account.city")
	WebElement city;
	
	@FindBy(name="account.state")
	WebElement state;
	
	@FindBy(name="account.zip")
	WebElement zipCode;
	
	@FindBy(name="account.country")
	WebElement country;
	
	@FindBy(name="account.languagePreference")
	WebElement languagePreference;
	
	@FindBy(name="account.favouriteCategoryId")
	WebElement favouriteCategoryId;
	
	@FindBy(name="account.listOption")
	WebElement listOptionCheckBox;
	
	@FindBy(name="account.bannerOption")
	WebElement bannerOptionCheckBox;
	
	@FindBy(name="newAccount")
	WebElement saveAccountInformationBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	WebElement signInBtn;
	
	public RegistrationPage() throws IOException {
		PageFactory.initElements(driver, this);
		data = new TestUtil();
	}
	
	public HomePage createNewUser() throws IOException {
		username.sendKeys(data.userName);
		password.sendKeys(data.password);
		repeatedPassword.sendKeys(data.password);
		firstName.sendKeys(data.firstName);
		lastName.sendKeys(data.lastName);
		email.sendKeys(data.email);
		phoneNumber.sendKeys(""+data.phoneNumber);
		address1.sendKeys(data.address1);
		address2.sendKeys(data.address2);
		city.sendKeys(data.city);
		state.sendKeys(data.state);
		zipCode.sendKeys(""+data.zipCode);
		country.sendKeys(data.country);
		selectDropDown(languagePreference, data.languagePreferred);
		selectDropDown(favouriteCategoryId, data.favouriteCategory);
		listOptionCheckBox.click();
		bannerOptionCheckBox.click();
		TestUtil.takeScreenshotAtEndOfTest();
		signInBtn.click();
		//saveAccountInformationBtn.click();
		
		return new HomePage();
	}
}
