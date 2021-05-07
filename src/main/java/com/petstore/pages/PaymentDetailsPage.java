package com.petstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.petstore.util.TestBase;
import com.petstore.util.TestUtil;

import java.io.IOException;
import org.junit.Assert;

public class PaymentDetailsPage extends TestBase{
	@FindBy(xpath="(//th[@colspan='2'])[1]")
	WebElement pageTitle;   
	
	@FindBy(name="order.cardType")
	WebElement cardType;
	
	@FindBy(name="order.creditCard")
	WebElement cardNumber;
	
	@FindBy(name="order.expiryDate")
	WebElement expiryDate;
	
	@FindBy(name="newOrder")
	WebElement continueBtn;
	
	@FindBy(xpath="(//th[@colspan='2'])[2]")
	WebElement title;

	public PaymentDetailsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void enterPaymentDetails() {
		selectDropDown(cardType, prop.getProperty("cardtype"));
		cardNumber.clear();
		cardNumber.sendKeys(prop.getProperty("cardnumber"));
		expiryDate.clear();
		expiryDate.sendKeys(prop.getProperty("expirydate"));
	}
	
	public void verifyBillingAddress() {
		String fn=title.getText();
		Assert.assertEquals("Billing Address", fn);	
	}
	
	public AddressConfirmationPage proceedToConfirmationPage() throws IOException {
		//continueBtn.click();
		TestUtil.clickButton(continueBtn);
		return new AddressConfirmationPage();
	}

}
