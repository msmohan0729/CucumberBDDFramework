package com.petstore.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.petstore.util.TestBase;
import com.petstore.util.TestUtil;

public class AddressConfirmationPage extends TestBase{
	
	@FindBy(xpath="//div[@id='Catalog']")
	WebElement pageTitle;
	
	@FindBy(xpath="//a[contains(text(),'Confirm')]")
	WebElement confirmBtn;
	
	public AddressConfirmationPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public FinalPage confirmAddress() {
		TestUtil.clickButton(confirmBtn);
		//confirmBtn.click();
		return new FinalPage();
	}
	
	
}
