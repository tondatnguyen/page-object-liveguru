package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;
import commons.PageGeneratorManager;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;

	// Hàm khởi tạo
	public LoginPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public String getLoginPageUrl() {
		return getCurrentPageUrl(driver);
	}

	public RegisterPageObject clickToHereLink() {
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public void inputToUserIDTextbox(String username) {
		waitForElementVisible(driver, LoginPageUI.USERID_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERID_TEXTBOX, username);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public boolean isLoginPageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.USERID_TEXTBOX);
		return isControlDisplayed(driver, LoginPageUI.USERID_TEXTBOX);
	}

	public boolean isDeleteCustomerFormLinkDisplayed() {
		waitForElementVisible(driver, LoginPageUI.DELETE_CUSTOMER_FORM_AT_LOGIN_PAGE);
		return isControlDisplayed(driver, LoginPageUI.DELETE_CUSTOMER_FORM_AT_LOGIN_PAGE);
	}

	public boolean isDeleteCustomerFormLinkUndisplayed() {
		waitForElementInvisible(driver, LoginPageUI.DELETE_CUSTOMER_FORM_AT_LOGIN_PAGE);
		return isControlUndisplayed(driver, LoginPageUI.DELETE_CUSTOMER_FORM_AT_LOGIN_PAGE);
	}

	public void clickToSeleniumDropdownToggle() {
		waitForElementVisible(driver, LoginPageUI.SELENIUM_DROPDOWN_TOOGLE_AT_LOGIN_PAGE);
		clickToElement(driver, LoginPageUI.SELENIUM_DROPDOWN_TOOGLE_AT_LOGIN_PAGE);
	}

	public boolean isHomePageUndisplayed() {
		waitForElementInvisible(driver, LoginPageUI.WELCOME_MESSAGE_AT_HOME_PAGE);
		return isControlUndisplayed(driver, LoginPageUI.WELCOME_MESSAGE_AT_HOME_PAGE);
	}

	public boolean isRegisterPageUndisplayed() {
		waitForElementInvisible(driver, LoginPageUI.EMAIL_TEXTBOX_AT_REGISTER_PAGE);
		return isControlUndisplayed(driver, LoginPageUI.EMAIL_TEXTBOX_AT_REGISTER_PAGE);
	}

}
