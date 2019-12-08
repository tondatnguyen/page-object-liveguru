package pageObjectsLiveGuru;

import org.openqa.selenium.WebDriver;

import com.liveguru.testdata.DataAdmin;

import commonsLiveGuru.AbstractPage;
import commonsLiveGuru.PageGeneratorManager;
import pageUIsLiveGuru.BackEndLoginPageUI;


public class BackEndLoginPageObject extends AbstractPage {
	WebDriver driver;
	BackEndLoginPageObject backEndLoginPage;
	
	public BackEndLoginPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public String getBackEndLoginPageTitle(WebDriver driver) {
		waitForElementVisible(driver, BackEndLoginPageUI.PAGE_TITLE);
		return getTextElement(driver, BackEndLoginPageUI.PAGE_TITLE);
	}

	public BackEndHomePageObject openBackEndHomePageByLogin(WebDriver driver) {
		inputToDynamicTextbox(driver, "username", DataAdmin.USERNAME);
		inputToDynamicTextbox(driver, "login", DataAdmin.PASSWORD);
		clickToElement(driver, BackEndLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getBackEndHomePage(driver); 
	}
		
}
