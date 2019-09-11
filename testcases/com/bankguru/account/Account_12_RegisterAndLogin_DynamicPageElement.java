package com.bankguru.account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import pageObjects.RegisterPageObject;
import pageObjects.WithdrawalPageObject;
import pageObjects.LoginPageObject;
import pageObjects.MiniStatementPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.BalanceEnquiryPageObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.NewCustomerPageObject;
import commons.AbstractTest;
import commons.PageGeneratorManager;

public class Account_12_RegisterAndLogin_DynamicPageElement extends AbstractTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = openMultiBrowser(browserName);
		emailValue = "auto" + randomData() + "@test.com";
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("Pre-Condition - STEP_01: Input to UserID/Password textbox");
		loginPage.inputToUserIDTextbox("mngr222270");
		loginPage.inputToPasswordTextbox("urytute");

		log.info("Pre-Condition - STEP_02: Click to 'LOGIN' button");
		homePage = loginPage.clickToLoginButton();

		log.info("Pre-Condition - STEP_03: Verify Welcome Message displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));
	}

	@Test
	public void TC_01_ValidateNewCustomerForm() throws Exception {
		System.out.println("NewCustomer - Step 01. Open New Customer page");
		newCustomerPage = (NewCustomerPageObject) homePage.openMultiplePage(driver, "New Customer");
		// newCustomerPage = new NewCustomerPageObject(driver);

		// Press TAB to textbox
		newCustomerPage.pressTabToDynamicTextbox(driver, "name");
		newCustomerPage.pressTabToDynamicTextbox(driver, "dob");
		newCustomerPage.pressTabToDynamicTextbox(driver, "city");
		newCustomerPage.pressTabToDynamicTextbox(driver, "state");
		newCustomerPage.pressTabToDynamicTextbox(driver, "pinno");
		newCustomerPage.pressTabToDynamicTextbox(driver, "telephoneno");
		newCustomerPage.pressTabToDynamicTextbox(driver, "emailid");
		newCustomerPage.pressTabToDynamicTextbox(driver, "password");

		// Verify error message
		verifyEquals(newCustomerPage.getErrorMessageOfDynamicField(driver, "Customer Name"), "Customer name must not be blank");
		verifyEquals(newCustomerPage.getErrorMessageOfDynamicField(driver, "Date of Birth"), "Date Field must not be blank");
		verifyEquals(newCustomerPage.getErrorMessageOfDynamicField(driver, "City"), "City Field must not be blank");
		verifyEquals(newCustomerPage.getErrorMessageOfDynamicField(driver, "State"), "State must not be blank");
		verifyEquals(newCustomerPage.getErrorMessageOfDynamicField(driver, "PIN"), "PIN Code must not be blank");
		Thread.sleep(3000);

		// Click on Female radio_button
		newCustomerPage.clickToDynamicRadioButton(driver, "f");

		// Input to textbox
		newCustomerPage.inputToDynamicTextbox(driver, "name", "Selenium Test");
		newCustomerPage.inputToDynamicTextbox(driver, "dob", "09/09/2019");
		newCustomerPage.inputToDynamicTextbox(driver, "city", "York New");
		newCustomerPage.inputToDynamicTextbox(driver, "state", "New York");
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", "123456");
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", "098765432");
		newCustomerPage.inputToDynamicTextbox(driver, "emailid", "SeleniumTest@gmail.com");
		newCustomerPage.inputToDynamicTextbox(driver, "password", "123123");
		Thread.sleep(3000);
		
		// Click on Reset button
		newCustomerPage.clickToDynamicButton(driver, "Reset");
		Thread.sleep(3000);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	HomePageObject homePage;
	DepositPageObject depositPage;
	WithdrawalPageObject withdrawalPage;
	ChangePasswordPageObject changePasswordPage;
	MiniStatementPageObject miniStatementPage;
	NewAccountPageObject newAccountPage;
	NewCustomerPageObject newCustomerPage;
	DeleteCustomerPageObject deleteCustomerPage;
	EditAccountPageObject editAccountPage;
	BalanceEnquiryPageObject balanceEnquiryPage;
	EditCustomerPageObject editCustomerPage;
	String username, password, loginPageUrl;
	String customerNameValue, genderMaleValue, dateOFBirthValue, addressValue, cityValue;
	String stateValue, pinValue, phoneValue, emailValue, passwordValue;

}
