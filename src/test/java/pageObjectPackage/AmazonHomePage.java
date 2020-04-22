package pageObjectPackage;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfigFileReader;
import utilityPackage.TakeScreenshots;
import utilityPackage.WaitForElementUtility;

public class AmazonHomePage {
	WebDriver driver;
	ConfigFileReader configFileReader;
	TakeScreenshots takeScreenshots;
	WaitForElementUtility waitForElementUtility = new WaitForElementUtility();
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		//Title Verification object
		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Hello, Telstra')]")
		private WebElement Title_Text;
		
		//Search text box object
		@FindBy(how = How.XPATH, using = "//input[@id='twotabsearchtextbox']")
		private WebElement Search_Textbox;
		
		//Search button object
		@FindBy(how = How.XPATH, using = "//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")
		private WebElement Search_Button;
		
		//Add To Cart button object
		@FindBy(how = How.XPATH, using = "//input[@id='add-to-cart-button']")
		private WebElement AddToCart_Button;
			
		//Added to cart confirmation 
		@FindBy(how = How.XPATH, using = "//h1[@class='a-size-medium a-text-bold']")
		private WebElement AddedToCart_Text;
		
		//Search sony 55 inch tv in Amazon.com
		public void searchItemSonyTV() throws IOException {
			takeScreenshots = new TakeScreenshots();
			waitForElementUtility.waitForElement(Title_Text, driver);
			//Taking screenshot
			takeScreenshots.screenShot(driver);
			
			//Enter "Sony 55 inch TV" in the search criteria
			Search_Textbox.sendKeys(new ConfigFileReader().getSearchItem());
			//Taking screenshot
			takeScreenshots.screenShot(driver);
			Search_Button.click();
		}
		
		//Select item from search results
		public void selectItem() throws IOException {
			
			//Random generation of integer
			Random ran = new Random();
			int x = ran.nextInt(10)+1;
			
			//select random item
			WebElement selectItem = driver.findElement(By.xpath("//div[@data-index='"+ x +"']//a[@class='a-link-normal a-text-normal']"));
			//WebElement selectItem = driver.findElement(By.xpath(new ConfigFileReader().getSelectItemXpath()));
			//Taking screenshot
			takeScreenshots.screenShot(driver);
			selectItem.click();
		}
		
		//Add to cart
		public void AddToCart() throws IOException {
			//Taking screenshot
			takeScreenshots.screenShot(driver);
			waitForElementUtility.waitForElement(AddToCart_Button, driver);
			AddToCart_Button.click();
		}
		
		//Added to cart confirmation
		public void AddedToCartConfirmation() throws Exception {
			
			waitForElementUtility.waitForElement(AddedToCart_Text, driver);
			//Taking screenshot
			takeScreenshots.screenShot(driver);
			String AddedToCartText = AddedToCart_Text.getText();
			String expectedOutput= "Added to Cart";
			
			if(AddedToCartText.equalsIgnoreCase(expectedOutput)) {
				System.out.println("Assertion is successful -  Added item to the cart");
			} else {
				System.out.println("Something is wrong with the test case");
			}
			
			Thread.sleep(3000);
		}
		
		
}
