package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewCustomerUI;

public class WithdrawalPageObject extends AbstractPage {
	WebDriver driver;
	
	public WithdrawalPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
