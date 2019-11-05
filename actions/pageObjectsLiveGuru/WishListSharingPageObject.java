package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

import commonsLiveGuru.AbstractPage;

public class WishListSharingPageObject extends AbstractPage{
	WebDriver driver;
	
	public WishListSharingPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
}
