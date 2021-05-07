package tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import com.petstore.pages.AddressConfirmationPage;
import com.petstore.pages.CartPage;
import com.petstore.pages.FinalPage;
import com.petstore.pages.FishMenuPage;
import com.petstore.pages.HomePage;
import com.petstore.pages.LoginPage;
import com.petstore.pages.PaymentDetailsPage;
import com.petstore.pages.RegistrationPage;
import com.petstore.pages.fishpages.AngelFish;
import com.petstore.pages.fishpages.LargeAngelFish;
import com.petstore.util.TestBase;

public class Test extends TestBase{
	CartPage cartPage;
	FishMenuPage fishMenuPage;
	HomePage homePage;
	LoginPage loginPage;
	RegistrationPage registrationPage;
	AngelFish angelFish;
	LargeAngelFish largeAngelFish;
	PaymentDetailsPage paymentDetailsPage;
	AddressConfirmationPage addressConfirmationPage;
	FinalPage finalPage;
	
	public Test() {
		super();
	}
	
	@Before
	public void setUp() throws IOException {
		initialization();
		homePage = new HomePage();	
		loginPage = new LoginPage();
	}
	
	@org.junit.Test
	public void demo() throws IOException {
		
		//sign page
		homePage.signIn();
		// navigate to register now from signin page
		registrationPage = loginPage.navigateToRegistrationPage();
		
		//registration page
		registrationPage.createNewUser();
		//signin page after registering
		homePage = loginPage.login();
		
		//homepage after signin
		homePage.verifyLoggedInUserName();
		fishMenuPage = homePage.navigateToFishMenuPage();
		
		//fish menu
		fishMenuPage.verifyPageTitle();
		angelFish = fishMenuPage.navigateToAngelFishMenu();
		
		//angel fish menu
		angelFish.verifyPageTitle();
		largeAngelFish = angelFish.viewLargeAngelFish();
		
		//large angel fish menu
		largeAngelFish.verifyPageTitle();
		cartPage = largeAngelFish.addToCart();
		
		//add menu
		cartPage.verifyPageTitle();
		paymentDetailsPage=cartPage.proceedToCheckOut();
		
		//payment details page
		paymentDetailsPage.enterPaymentDetails();
		paymentDetailsPage.verifyBillingAddress();
		addressConfirmationPage = paymentDetailsPage.proceedToConfirmationPage();
		
		//address confirmation page
		finalPage = addressConfirmationPage.confirmAddress();
		
		//final page
		finalPage.verifyOrderConfirmationMessage();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
