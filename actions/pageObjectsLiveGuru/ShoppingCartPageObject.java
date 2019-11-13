package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

import commonsLiveGuru.AbstractPage;
import pageUIsLiveGuru.ShoppingCartPageUI;

public class ShoppingCartPageObject extends AbstractPage{
	WebDriver driver;
	
	public ShoppingCartPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void inputToDynamicQTYTextbox(WebDriver driver, String productName, String value) {
		waitForElementVisible(driver, ShoppingCartPageUI.QTY_TEXTBOX, productName);
		sendkeyToElement(driver, ShoppingCartPageUI.QTY_TEXTBOX, value, productName);
	}
	
	public void clickOnUpdateButton(WebDriver driver, String productName) {
		waitForElementVisible(driver, ShoppingCartPageUI.QTY_UPDATE_BUTTON, productName);
		clickToElement(driver, ShoppingCartPageUI.QTY_UPDATE_BUTTON, productName);
	}
	
	public void clickToEmptyCartByJS(WebDriver driver) {
		clickToElementByjavascriptExecutor(driver, "//button[@title='Empty Cart']");
	}
	
	public void closeIFrame(WebDriver driver) {
		waitForElementVisible(driver, ShoppingCartPageUI.IFRAME, "primis");
		switchToFrame(driver, ShoppingCartPageUI.IFRAME, "primis");
		switchToFrame(driver, ShoppingCartPageUI.IFRAME, "Video-iFrame");
		clickToElement(driver, ShoppingCartPageUI.IFRAME_CLOSE_BUTTON);
		switchToMainWindow(driver);
	}
	
}
