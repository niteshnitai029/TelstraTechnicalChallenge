package pageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilityPackage.WaitForElementUtility;

public class AmazonSignOutPage {
	WebDriver driver;
	WaitForElementUtility waitForElementUtility = new WaitForElementUtility();
	public AmazonSignOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
			//Accounts and list button object
			@FindBy(how = How.XPATH, using = "//span[contains(@class,'nav-line-2')][contains(text(),'Account & Lists')]")
			private WebElement AccountsAndList_Button;
			
			//Sign out link
			@FindBy(how = How.XPATH, using = "//span[contains(text(),'Sign Out')]")
			private WebElement SignOut_Link;
			
			//User name/Email text box object in the sign in page
			@FindBy(how = How.XPATH, using = "//input[@id='ap_email']")
			private WebElement Email_Textbox;
			
			//Continue button in the sign in page
			@FindBy(how = How.XPATH, using = "//input[@id='continue']")
			private WebElement Continue_Button;
			
			public void signOutAmazonSite() {
				//Hover to Accounts and List
				Actions actions = new Actions(driver);
				actions.moveToElement(AccountsAndList_Button);
				
				//Click Signout link
				actions.moveToElement(SignOut_Link);
				actions.click().build().perform();
				
				//Wait for login page
				waitForElementUtility.waitForElement(Email_Textbox, driver);
				waitForElementUtility.waitForElement(Continue_Button, driver);
			}
			
			public void closeBrowser() {
				driver.close();
			}
}
