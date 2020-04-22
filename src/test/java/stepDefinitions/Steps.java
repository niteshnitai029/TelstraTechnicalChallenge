package stepDefinitions;

import org.openqa.selenium.WebDriver;
import dataProvider.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectPackage.AmazonHomePage;
import pageObjectPackage.AmazonSignInPage;
import pageObjectPackage.AmazonSignOutPage;
import utilityPackage.LoggerForTestCases;

public class Steps {
	
	WebDriver driver;
	ConfigFileReader configFileReader;
	LoggerForTestCases Log;
	AmazonSignInPage amazonSignInPage;
	AmazonHomePage amazonHomePage;
	AmazonSignOutPage amazonSignOutPage;
	
	@Before
	public void setup() {
		configFileReader=new ConfigFileReader();
		Log = new LoggerForTestCases();
		driver = configFileReader.getBrowser();
		LoggerForTestCases.info("Web driver inititated");
		LoggerForTestCases.info("Web driver wait has inititated and set to 20 seconds");
	}
	
	@Given("user is on Amazon home page")
	public void user_is_on_Amazon_home_page() throws Exception {
		driver.get(configFileReader.getApplicationUrl());
		LoggerForTestCases.info("Amazon URL loaded successfully");
	}

	@When("user click on signIn link")
	public void user_click_on_signIn_link() throws Exception {
		amazonSignInPage = new AmazonSignInPage(driver);
		amazonSignInPage.Click_Signin_Link();
		LoggerForTestCases.info("User clicked on sign in link");
	}

	@When("enter username and click continue button")
	public void enter_username_and_click_continue_button() throws Exception {
		amazonSignInPage.EnterUsername_ClickContinue();
		LoggerForTestCases.info("User enter email id and clicked continue button");
	}

	@Then("enter password and click signin button")
	public void enter_password_and_click_signin_button() throws Exception {
	    amazonSignInPage.EnterPassword_ClickSignIn();
	    LoggerForTestCases.info("User enetered password and sign in successful");
	}

	@When("user enter item name in search textbox and click search button")
	public void user_enter_item_name_in_search_textbox_and_click_search_button() throws Exception{
		amazonHomePage = new AmazonHomePage(driver);
		amazonHomePage.searchItemSonyTV();
		LoggerForTestCases.info("Searching SONY TV 55 inches in searchbox");
	}

	@Then("user view search results and selects item")
	public void user_view_search_results_and_selects_item() throws Exception {
	    amazonHomePage.selectItem();
	    LoggerForTestCases.info("User selected random item from the search list");
	}

	@When("user views selected item and add to cart")
	public void user_views_selected_item_and_add_to_cart() throws Exception{
		amazonHomePage.AddToCart();
		LoggerForTestCases.info("User added to the cart");
	}

	@Then("user can view item in the cart list")
	public void user_can_view_item_in_the_cart_list() throws Exception {
		amazonHomePage.AddedToCartConfirmation();
		LoggerForTestCases.info("User verified item which is added to cart");
	}

	@After
	public void closeBrowser() throws Exception {
		driver.close();
		LoggerForTestCases.info("Test case has completed and webdriver session closed the browser");
	}

}
