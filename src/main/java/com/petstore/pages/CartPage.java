package com.petstore.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.petstore.util.TestBase;
import com.petstore.util.TestUtil;

public class CartPage extends TestBase{
	//Page Object
	@FindBy(xpath="//h2")
	WebElement pageTitle;
	
	
	@FindBy(name="updateCartQuantities")
	WebElement updateCartBtn;
	
	@FindBy(xpath="//a[contains(text(),'Proceed to Checkout')]")
	WebElement checkoutBtn;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public PaymentDetailsPage proceedToCheckOut() throws IOException {
		//checkoutBtn.click();
		TestUtil.clickButton(checkoutBtn);
		return new PaymentDetailsPage();
	}
	
	public void verifyPageTitle() {
		String title = pageTitle.getText();
		Assert.assertEquals("Shopping Cart", title);
	}
	
	
}
