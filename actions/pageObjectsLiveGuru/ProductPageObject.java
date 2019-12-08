package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

import commonsLiveGuru.AbstractPage;
import commonsLiveGuru.PageGeneratorManager;
import pageUIsLiveGuru.ProductPageUI;

public class ProductPageObject extends AbstractPage{
	WebDriver driver;
	
	public ProductPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void clickOnCompareButton(WebDriver driver, String productName) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_PRODUCT_ADD_TO_COMPARE_LINK, productName);
		clickToElement(driver, ProductPageUI.DYNAMIC_PRODUCT_ADD_TO_COMPARE_LINK, productName);
	}
	
	public DetailPageObject openDetailProductPageByImage(WebDriver driver, String productName) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_PRODUCT_IMAGE, productName);
		clickToElement(driver, ProductPageUI.DYNAMIC_PRODUCT_IMAGE, productName);
		return PageGeneratorManager.getDetailPage(driver);
	}
}
