package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

import commonsLiveGuru.AbstractPage;

public class ReviewPageObject extends AbstractPage{
	WebDriver driver;
	
	public ReviewPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
}
