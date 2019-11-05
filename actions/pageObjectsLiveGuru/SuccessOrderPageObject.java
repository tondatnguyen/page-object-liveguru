package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

import commonsLiveGuru.AbstractPage;
import pageUIsLiveGuru.SuccessOrderPageUI;

public class SuccessOrderPageObject extends AbstractPage{
	WebDriver driver;
	
	public SuccessOrderPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public boolean isOrderNoDisplay(WebDriver driver) {
		waitForElementVisible(driver, SuccessOrderPageUI.ORDER_SERIAL_NUMBER);
		return isControlDisplayed(driver, SuccessOrderPageUI.ORDER_SERIAL_NUMBER);
		
	}
}
