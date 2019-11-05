package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;
import commonsLiveGuru.AbstractPage;


public class AdvancedSearchPageObject extends AbstractPage{
	WebDriver driver;
	
	public AdvancedSearchPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
}
