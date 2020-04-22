package utilityPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElementUtility {
	
	public void waitForElement(WebElement value, WebDriver driver)
    {
        // wait for field
        WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOf(value));
            System.out.print(".");      
    }
}
