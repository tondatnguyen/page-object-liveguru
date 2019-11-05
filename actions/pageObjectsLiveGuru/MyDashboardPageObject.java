package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

import commonsLiveGuru.AbstractPage;

public class MyDashboardPageObject extends AbstractPage{
	WebDriver driver;
	
	public MyDashboardPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
}
