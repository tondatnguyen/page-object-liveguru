package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewCustomerUI;

public class ChangePasswordPageObject extends AbstractPage {
	WebDriver driver;
	
	public ChangePasswordPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
