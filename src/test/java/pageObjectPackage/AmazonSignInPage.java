package pageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfigFileReader;
import utilityPackage.TakeScreenshots;
import utilityPackage.WaitForElementUtility;

public class AmazonSignInPage {
	
	WebDriver driver;
	ConfigFileReader configFileReader;
	TakeScreenshots takeScreenshots;
	WaitForElementUtility waitForElementUtility = new WaitForElementUtility();
	public AmazonSignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		//Sign in button object
		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Hello. Sign in')]")
		private WebElement Signin_Button;
		
		//User name/Email text box object in the sign in page
		@FindBy(how = How.XPATH, using = "//input[@id='ap_email']")
		private WebElement Email_Textbox;
		
		//Continue button in the sign in page
		@FindBy(how = How.XPATH, using = "//input[@id='continue']")
		private WebElement Continue_Button;
		
		//Password field in the sign in page
		@FindBy(how = How.XPATH, using = "//input[@id='ap_password']")
		private WebElement Password_Textbox;
			
		//Login button object in the sign in page
		@FindBy(how = How.XPATH, using = "//input[@id='signInSubmit']")
		private WebElement SignInSubmit_Button;
		
		
		//Sign in to Amazon Website
		public void Click_Signin_Link() throws Exception {
			//Taking screenshot
			takeScreenshots = new TakeScreenshots();
			takeScreenshots.screenShot(driver);
			//Click Sign in button
			Signin_Button.click();
			
			//Wait for elements to load
			waitForElementUtility.waitForElement(Email_Textbox, driver);
			waitForElementUtility.waitForElement(Continue_Button, driver);
		}
		//Enter username and click continue button
		public void EnterUsername_ClickContinue() throws Exception {
			Email_Textbox.sendKeys(new ConfigFileReader().getEmailID());
			//Taking screenshot
			takeScreenshots.screenShot(driver);
			Continue_Button.click();
			
			//Wait for elements to load
			waitForElementUtility.waitForElement(Password_Textbox, driver);
			waitForElementUtility.waitForElement(SignInSubmit_Button, driver);
		}
		
		//Enter password and click sign button
		public void EnterPassword_ClickSignIn() throws Exception {
			
			Password_Textbox.sendKeys(new ConfigFileReader().getPassword());
			//Taking screenshot
			takeScreenshots.screenShot(driver);
			SignInSubmit_Button.click();
		}
		
		
}
