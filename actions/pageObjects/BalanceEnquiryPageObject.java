package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewCustomerUI;

public class BalanceEnquiryPageObject extends AbstractPage {
	WebDriver driver;
	
	public BalanceEnquiryPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}


}
