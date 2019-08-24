package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewCustomerUI;

public class CustomisedStatementPageObject extends AbstractPage {
	WebDriver driver;
	
	public CustomisedStatementPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
}
