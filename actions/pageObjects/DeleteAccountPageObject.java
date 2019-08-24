package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewCustomerUI;

public class DeleteAccountPageObject extends AbstractPage {
	WebDriver driver;
	
	public DeleteAccountPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
