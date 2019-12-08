package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

import commonsLiveGuru.AbstractPage;
import commonsLiveGuru.PageGeneratorManager;
import pageUIsLiveGuru.PendingReviewsPageUI;


public class PendingReviewsPageObject extends AbstractPage {
	WebDriver driver;
	
	public PendingReviewsPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public EditReviewPageObject openEditReviewPage(WebDriver driver) {
		clickToElement(driver, PendingReviewsPageUI.EDIT);
		return PageGeneratorManager.getEditReviewPage(driver);	
	}
		
}
