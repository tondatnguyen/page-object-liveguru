package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;
import commons.PageGeneratorManager;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	
	//	Hàm khởi tạo
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



}
