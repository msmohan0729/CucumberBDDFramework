package com.petstore.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.petstore.util.TestBase;

public class FinalPage extends TestBase{
	
	@FindBy(xpath="//ul[@class='messages']")
	WebElement confirmationMsg;
	
	public FinalPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyOrderConfirmationMessage() {
		String msg = confirmationMsg.getText();
		Assert.assertEquals("Thank you, your order has been submitted.", msg);
	}
}
