package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

import commonsLiveGuru.AbstractPage;

public class AccountInfoPageObject extends AbstractPage{
	WebDriver driver;
	
	public AccountInfoPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
}
