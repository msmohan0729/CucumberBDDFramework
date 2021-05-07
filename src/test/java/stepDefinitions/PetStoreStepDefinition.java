package stepDefinitions;

import java.io.IOException;
import org.junit.Assert;

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
import com.petstore.util.TestUtil;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PetStoreStepDefinition extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	RegistrationPage registrationPage;
	FishMenuPage fishMenuPage;
	AngelFish angelFish;
	LargeAngelFish largeAngelFish;
	CartPage cartPage;
	PaymentDetailsPage paymentDetailsPage;
	AddressConfirmationPage addressConfirmationPage;
	FinalPage finalPage;
	
	@Before
	public void setUp() throws IOException {
		TestBase.initialization();
		homePage = new HomePage();
	}
	
	@Given("^the user is already in the petstore homepage$")
	public void the_user_is_already_in_the_petstore_homepage() throws IOException {
		boolean flag = homePage.verifyPetStoreLogo();
		Assert.assertTrue(flag);
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@Then("^the user is in the registration menu$")
	public void the_user_is_in_the_registration_menu() throws IOException {
		loginPage = homePage.signIn();
		registrationPage = loginPage.navigateToRegistrationPage();
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@Then("^the user enters the required details for account creation$")
	public void the_user_enters_the_required_details_for_account_creation() throws IOException {
		registrationPage.createNewUser();
	}

	@Then("^the user enters his username and password for signin$")
	public void the_user_enters_his_username_and_password_for_signin() throws IOException {
		homePage = loginPage.login();
	}

	@Then("^click on the sign in button$")
	public void click_on_the_sign_in_button() throws IOException {
		homePage.verifyLoggedInUserName();
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@Then("^the user selects fish for ordering$")
	public void the_user_selects_fish_for_ordering() throws IOException {
		fishMenuPage = homePage.navigateToFishMenuPage();
		fishMenuPage.verifyPageTitle();
		TestUtil.takeScreenshotAtEndOfTest();
		angelFish = fishMenuPage.navigateToAngelFishMenu();
		angelFish.verifyPageTitle();
		TestUtil.takeScreenshotAtEndOfTest();
		largeAngelFish = angelFish.viewLargeAngelFish();
		largeAngelFish.verifyPageTitle();
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@Then("^the user adds the selected fish to the cart$")
	public void the_user_adds_the_selected_fish_to_the_cart() throws IOException {
		cartPage = largeAngelFish.addToCart();
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@Then("^the user checkout the fish by entering the payment details$")
	public void the_user_checkout_the_fish_by_entering_the_payment_details() throws IOException {
		cartPage.verifyPageTitle();
		paymentDetailsPage=cartPage.proceedToCheckOut();
		TestUtil.takeScreenshotAtEndOfTest();
		paymentDetailsPage.enterPaymentDetails();
		paymentDetailsPage.verifyBillingAddress();
		TestUtil.takeScreenshotAtEndOfTest();
		addressConfirmationPage = paymentDetailsPage.proceedToConfirmationPage();
		TestUtil.takeScreenshotAtEndOfTest();
	}

	@Then("^the user successfully places the order$")
	public void the_user_successfully_places_the_order() throws IOException {
		finalPage = addressConfirmationPage.confirmAddress();
		finalPage.verifyOrderConfirmationMessage();
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@After
	public void tearDown() throws IOException {
		TestUtil.takeScreenshotAtEndOfTest();
		driver.quit();
	}

}
