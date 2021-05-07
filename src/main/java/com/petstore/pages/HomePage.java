package com.petstore.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.petstore.util.TestUtil;
import com.petstore.util.TestBase;
import org.junit.Assert;

public class HomePage extends TestBase{
	TestUtil data;
	
	//Page Object
	@FindBy(id="WelcomeContent")
	WebElement welcomeContent;
	
	@FindBy(xpath="//img[@src='../images/fish_icon.gif']")
	WebElement fishMenuBtn;
	
	@FindBy(xpath="//img[@src='../images/dogs_icon.gif']")
	WebElement dogsMenuBtn;
	
	@FindBy(xpath="//img[@src='../images/cats_icon.gif']")
	WebElement catsMenuBtn;
	
	@FindBy(xpath="//img[@src='../images/reptiles_icon.gif']")
	WebElement reptilesMenuBtn;
	
	@FindBy(xpath="//img[@src='../images/birds_icon.gif']")
	WebElement birdsMenuBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Out')]")
	WebElement signOutBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	WebElement signInBtn;
	
	@FindBy(name="img_cart")
	WebElement cart;
	
	@FindBy(xpath="//a[contains(text(),'My Account')]")
	WebElement myAccountBtn;
	
	@FindBy(xpath="//img[@src='../images/logo-topbar.gif']")
	WebElement petStoreLogo;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
		data = new TestUtil();
	}
	
	public boolean verifyPetStoreLogo() {
		if(petStoreLogo.isDisplayed()) return true;
		else return false;
	}
	
	public void verifyLoggedInUserName() {
		String title = welcomeContent.getText();
		title = title.trim();
		Assert.assertEquals("Welcome "+prop.getProperty("username")+"!", title);
	}
	
	public FishMenuPage navigateToFishMenuPage() {
		//fishMenuBtn.click();
		TestUtil.clickButton(fishMenuBtn);
		return new FishMenuPage();
	}
	
	public LoginPage signIn() throws IOException {
		//signInBtn.click();
		TestUtil.clickButton(signInBtn);
		return new LoginPage();
	}
	
	public void signOut() {
		//signOutBtn.click();
		TestUtil.clickButton(signOutBtn);
	}
}
