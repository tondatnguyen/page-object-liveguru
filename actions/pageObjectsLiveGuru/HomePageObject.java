package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

import commonsLiveGuru.AbstractPage;


public class HomePageObject extends AbstractPage {
	WebDriver driver;
	
	public HomePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	
		
}
