package endToEndScenario;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EndToEndScenario {

	@Test
	public void telstraTask() {
		
					//Launching browser and navigate to amazon website
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
					WebDriver driver = new ChromeDriver();
					driver.manage().window().maximize();
					driver.get("https://www.amazon.com.au/");
					WebDriverWait waitForElementToLoad = new WebDriverWait(driver, 20);
					
					//Click Sign in button
					WebElement signInButton = driver.findElement(By.xpath("//span[contains(text(),'Hello. Sign in')]"));
					signInButton.click();
					
					//Initialize web elements
					WebElement emailTextBox =  driver.findElement(By.xpath("//input[@id='ap_email']"));
					WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
					
					//Wait until all elements are loaded
					waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_email']")));
					waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='continue']")));
					
					//Enter email id to proceed
					emailTextBox.sendKeys("tesltratask@gmail.com");
					continueButton.click();
					
					//Initialize web elements
					WebElement passwordField = driver.findElement(By.xpath("//input[@id='ap_password']"));
					WebElement signInSubmitButton = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
					
					waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_password']")));
					waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='signInSubmit']")));
					
					//Login to Amazon.com
					passwordField.sendKeys("testuser1");
					signInSubmitButton.click();
					
					//Verify login is successful
					String actualTitle = driver.findElement(By.xpath("//span[contains(text(),'Hello, Telstra')]")).getText();
					String expectedTitle = "Hello, Telstra";
					
					assertTrue(actualTitle.contains(expectedTitle));
					
					System.out.println("Assertion done!!");
					System.out.println("Login successful!!");
					
					//Enter text in search box
					WebElement searchItems = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
					WebElement searchButton = driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']"));
					
					searchItems.sendKeys("Sony 55 inch TV");
					searchButton.click();
					
					//Random generation of integer
					Random ran = new Random();
					int x = ran.nextInt(10)+1;
					
					//select random item
					WebElement selectItem = driver.findElement(By.xpath("//div[@data-index='"+ x +"']//a[@class='a-link-normal a-text-normal']"));
					selectItem.click();
					
					//Add to cart
					WebElement addToCart =  driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
					waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));
					addToCart.click();
					
					
					//Verify login is successful
					waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='a-size-medium a-text-bold']")));
					
					String AddedToCardText = driver.findElement(By.xpath("//h1[@class='a-size-medium a-text-bold']")).getText();
					String expectedOutput= "Added to Cart";
					assertTrue(AddedToCardText.contains(expectedOutput));
					System.out.println("Added to cart successfully");
					
					Actions actions = new Actions(driver);
					WebElement mainMenu = driver.findElement(By.xpath("//span[contains(@class,'nav-line-2')][contains(text(),'Account & Lists')]"));
					actions.moveToElement(mainMenu);
					
					//Sign out the amazon
					WebElement signOutButton = driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]"));
					//signOutButton.click();
					actions.moveToElement(signOutButton);
					actions.click().build().perform();
					
					System.out.println("Signout is successful");
					
					//Wait for login page
					waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_email']")));
					waitForElementToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='continue']")));
					
					//Close browser
					driver.close();
					
	}			

}
