package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewCustomerUI;

public class NewAccountPageObject extends AbstractPage {
	WebDriver driver;
	
	public NewAccountPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
}
