package pageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSignInPage {
	
	WebDriver driver;
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
		
		public void waitForElement(WebElement value, WebDriver driver)
	     {
	         // wait for field
	         WebDriverWait wait = new WebDriverWait(driver, 60);
	             wait.until(ExpectedConditions.visibilityOf(value));
	             System.out.print(".");      
	     }
		
		//Sign in to Amazon Website
		public void Signin_Process_AmazonSite() throws Exception {
			//Click Sign in button
			Signin_Button.click();
			
			//Wait for elements to load
			waitForElement(Email_Textbox, driver);
			waitForElement(Continue_Button, driver);
			
			//Enter email and click continue
			Email_Textbox.sendKeys("tesltratask@gmail.com");
			Continue_Button.click();
			
			//Wait for elements to load
			waitForElement(Password_Textbox, driver);
			waitForElement(SignInSubmit_Button, driver);
			
			//Enter password and click sign in button
			Password_Textbox.sendKeys("testuser1");
			SignInSubmit_Button.click();
		}
}
