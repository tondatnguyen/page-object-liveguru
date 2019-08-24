package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewCustomerUI;

public class DepositPageObject extends AbstractPage {
	WebDriver driver;
	
	public DepositPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
