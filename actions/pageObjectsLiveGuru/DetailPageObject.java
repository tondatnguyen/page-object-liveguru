package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

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
}
