package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewCustomerUI;

public class EditAccountPageObject extends AbstractPage {
	WebDriver driver;
	
	public EditAccountPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
}
