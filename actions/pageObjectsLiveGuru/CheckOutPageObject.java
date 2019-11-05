package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

import commonsLiveGuru.AbstractPage;

public class CheckOutPageObject extends AbstractPage{
	WebDriver driver;
	
	public CheckOutPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void ClickToContinueButton(WebDriver driver, String locator, String... divID) {
		locator = String.format(locator, (Object[]) divID);
		waitForElementVisible(driver, locator);
		clickToElement(driver, locator);
	}
}
