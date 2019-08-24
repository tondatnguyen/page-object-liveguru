package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewCustomerUI;

public class MiniStatementPageObject extends AbstractPage {
	WebDriver driver;
	
	public MiniStatementPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
