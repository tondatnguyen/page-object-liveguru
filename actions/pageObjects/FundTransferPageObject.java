package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewCustomerUI;

public class FundTransferPageObject extends AbstractPage {
	WebDriver driver;
	
	public FundTransferPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
}
