package utilityPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityFunctions {
	
	WebDriver driver;
	
	public void waitForAMoment() {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	}
}
