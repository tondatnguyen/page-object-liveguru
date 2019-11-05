package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

import commonsLiveGuru.AbstractPage;

public class PopUpPageObject extends AbstractPage{
	WebDriver driver;
	
	public PopUpPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}	
}
