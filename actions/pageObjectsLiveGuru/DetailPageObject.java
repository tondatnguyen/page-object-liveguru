package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;
import com.liveguru.testdata.DataUser;

import commonsLiveGuru.AbstractPage;
import pageUIsLiveGuru.DetailPageUI;

public class DetailPageObject extends AbstractPage{
	WebDriver driver;
	
	public DetailPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public String getRegularPriceOfDynamicDetail(WebDriver driver, String productName) {
		waitForElementVisible(driver, DetailPageUI.DYNAMIC_DETAIL_PRODUCT_REGULAR_PRICE, productName);
		return getTextElement(driver, DetailPageUI.DYNAMIC_DETAIL_PRODUCT_REGULAR_PRICE, productName);
	}
	
	public String getSpecialPriceOfDynamicDetail(WebDriver driver, String productName) {
		waitForElementVisible(driver, DetailPageUI.DYNAMIC_DETAIL_PRODUCT_SPECIAL_PRICE, productName);
		return getTextElement(driver, DetailPageUI.DYNAMIC_DETAIL_PRODUCT_SPECIAL_PRICE, productName);
	}
	
	public void clickOnReviewsTab(WebDriver driver) {
		waitForElementVisible(driver, DetailPageUI.REVIEWS_TAB);
		clickToElement(driver, DetailPageUI.REVIEWS_TAB);
	}
	
	public boolean isReviewDisplay() {
		waitForElementVisible(driver, DetailPageUI.REVIEW_MESSAGE);
		if(getTextElement(driver, DetailPageUI.REVIEW_MESSAGE).contains(DataUser.Review.THOUGHTS_XPERIA)) {
			return true;
		}
			return false;
	}	
}
