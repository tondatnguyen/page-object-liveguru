package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;


public class CustomisedStatementPageObject extends AbstractPage {
	WebDriver driver;
	
	public CustomisedStatementPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
}
