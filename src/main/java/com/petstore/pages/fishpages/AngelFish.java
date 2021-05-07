package com.petstore.pages.fishpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.petstore.pages.CartPage;
import com.petstore.pages.FishMenuPage;
import com.petstore.util.TestBase;
import org.junit.Assert;

public class AngelFish extends TestBase{
	//Page Object
	@FindBy(xpath="//h2")
	WebElement pageTitle;
	
	@FindBy(xpath="//a[contains(text(),'EST-1')]")
	WebElement viewLargeAngelFish;
	
	@FindBy(xpath="//a[contains(text(),'EST-2')]")
	WebElement viewSmallAngelFish;
	
	@FindBy(xpath="//a[@href='/actions/Cart.action?addItemToCart=&workingItemId=EST-1']")
	WebElement addLargeAngelFishToCart;
	
	@FindBy(xpath="//a[@href='/actions/Cart.action?addItemToCart=&workingItemId=EST-2']")
	WebElement addSmallAngelFishToCart;
	
	@FindBy(xpath="//a[contains(text(),'Return to FISH')]")
	WebElement returnToFishMenu;

	public AngelFish() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyPageTitle() {
		String title = pageTitle.getText();
		Assert.assertEquals("Angelfish", title);
	}
	
	public CartPage addLargeAngelFishToCart() {
		addLargeAngelFishToCart.click();
		return new CartPage();
	}
	
	public CartPage addSmallAngelFishToCart() {
		addSmallAngelFishToCart.click();
		return new CartPage();
	}
	
	public FishMenuPage returnToFishMenuPage() {
		returnToFishMenu.click();
		return new FishMenuPage();
	}
	
	public LargeAngelFish viewLargeAngelFish() {
		viewLargeAngelFish.click();
		return new LargeAngelFish();
	}
}
