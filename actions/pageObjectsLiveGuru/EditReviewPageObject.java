package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

import commonsLiveGuru.AbstractPage;
import commonsLiveGuru.PageGeneratorManager;


public class EditReviewPageObject extends AbstractPage {
	WebDriver driver;
	
	public EditReviewPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public PendingReviewsPageObject openPendingReviewsPageBySaveReviewButton(WebDriver driver) {
		clickOnDynamicLinkOrButton(driver, "Save Review");
		return PageGeneratorManager.getPendingReviewsPage(driver);	
	}
		
}
