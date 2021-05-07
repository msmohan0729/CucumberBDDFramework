package com.petstore.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.petstore.pages.fishpages.AngelFish;
import com.petstore.pages.fishpages.GoldFish;
import com.petstore.pages.fishpages.Koi;
import com.petstore.pages.fishpages.TigerShark;
import com.petstore.util.TestBase;
import com.petstore.util.TestUtil;

import org.junit.Assert;

public class FishMenuPage extends TestBase{
	//Page Objects
	@FindBy(xpath="//h2")
	WebElement pageHeader;
	
	@FindBy(xpath="//a[contains(text(),'FI-SW-01')]")
	WebElement angelFish;
	
	@FindBy(xpath="//a[contains(text(),'FI-SW-02')]")
	WebElement tigerShark;
	
	@FindBy(xpath="//a[contains(text(),'FI-SW-03')]")
	WebElement koi;
	
	@FindBy(xpath="//a[contains(text(),'FI-SW-04')]")
	WebElement goldFish;
	
	@FindBy(xpath="//a[contains(text(),'Return to Main Menu')]")
	WebElement returnToMainMenu;

	public FishMenuPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyPageTitle() {
		String title = pageHeader.getText();
		Assert.assertEquals("Fish", title);
	}
	
	public AngelFish navigateToAngelFishMenu() {
		//angelFish.click();
		TestUtil.clickButton(angelFish);
		return new AngelFish();
	}
	
	public TigerShark navigateToTigerSharkMenu() {
		//tigerShark.click();
		TestUtil.clickButton(tigerShark);
		return new TigerShark();
	}
	
	public Koi navigateToKoiFishMenu() {
		//koi.click();
		TestUtil.clickButton(koi);
		return new Koi();
	}
	
	public GoldFish navigateToGoldFishMenu() {
		//goldFish.click();
		TestUtil.clickButton(goldFish);
		return new GoldFish();
	}
	
	public HomePage navigateBackToMainMenu() throws IOException {
		//returnToMainMenu.click();
		TestUtil.clickButton(returnToMainMenu);
		return new HomePage();
	}

}
