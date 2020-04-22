package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
		LoggerForTestCases.info("Chrome driver inititated");
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
	}

	@When("enter username and click continue button")
	public void enter_username_and_click_continue_button() throws Exception {
		amazonSignInPage.EnterUsername_ClickContinue();
	}

	@Then("enter password and click signin button")
	public void enter_password_and_click_signin_button() throws Exception {
	    amazonSignInPage.EnterPassword_ClickSignIn();
	}

	@When("user enter item name in search textbox and click search button")
	public void user_enter_item_name_in_search_textbox_and_click_search_button() {
		amazonHomePage = new AmazonHomePage(driver);
		amazonHomePage.searchItemSonyTV();
	}

	@Then("user view search results and selects item")
	public void user_view_search_results_and_selects_item() {
	    amazonHomePage.selectItem();
	}

	@When("user views selected item and add to cart")
	public void user_views_selected_item_and_add_to_cart() {
		amazonHomePage.AddToCart();
	}

	@Then("user can view item in the cart list")
	public void user_can_view_item_in_the_cart_list() {
		amazonHomePage.AddedToCartConfirmation();
	}

	@After
	public void closeBrowser() {
		driver.close();
	}

}
