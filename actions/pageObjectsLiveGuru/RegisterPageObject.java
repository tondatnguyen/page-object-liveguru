package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

import commonsLiveGuru.AbstractPage;

public class RegisterPageObject extends AbstractPage  {
	WebDriver driver;
	
	public RegisterPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	

}
