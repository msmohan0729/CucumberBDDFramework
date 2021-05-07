package com.petstore.pages.fishpages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.petstore.pages.CartPage;
import com.petstore.util.TestBase;
import com.petstore.util.TestUtil;

public class LargeAngelFish extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Angelfish')]")
	WebElement title;
	
	@FindBy(xpath="//a[contains(text(),'Add to Cart')]")
	WebElement addToCartBtn;
	
	public LargeAngelFish() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyPageTitle() {
		String titleMsg = title.getText();
		Assert.assertEquals("Angelfish", titleMsg);
	}
	
	public CartPage addToCart() {
		//addToCartBtn.click();
		TestUtil.clickButton(addToCartBtn);
		return new CartPage();
	}
	
	
}
