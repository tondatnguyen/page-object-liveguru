package com.bankguru.account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import pageObjects.RegisterPageObject;
import pageObjects.WithdrawalPageObject;
import pageUIs.AbstractPageUI;
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

public class Account_08_DynamicLocator_RestParameter extends AbstractTest {
  private WebDriver driver;
	
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) { 
	  
	  driver = openMultiBrowser(browserName);
	  emailValue = "auto" + randomData() + "@test.com"; 
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	  System.out.println("PRE-CONDITION - STEP_02: Get Login_Page url");
	  loginPageUrl = loginPage.getLoginPageUrl();
  }

  @Test
  public void TC_01_RegisterToSystem() {
	  
	  System.out.println("LOGIN PAGE - STEP_01: Click to 'HERE' link");
	  registerPage = loginPage.clickToHereLink();
	  
	  System.out.println("REGISTER PAGE - STEP_02: Input to Email_ID_textbox");
	  registerPage.inputToEmailTextbox(emailValue);
	  
	  System.out.println("REGISTER PAGE - STEP_03: Click to 'SUBMIT' button");
	  registerPage.clickToSubmitButton();
	  
	  System.out.println("REGISTER PAGE - STEP_04: Get username/password info");
	  username = registerPage.getUsernameInfo();
	  password = registerPage.getPasswordInfo();
	  
	  System.out.println("");
  }

  @Test
  public void TC_02_LoginToSystem() {
	  
	  System.out.println("REGISTER PAGE - STEP_01: Open Login_Page");
	  registerPage.openLoginPageUrl(loginPageUrl);
	  
	  System.out.println("LOGIN PAGE - STEP_02: Input to UserID/Password textbox");
	  loginPage.inputToUserIDTextbox(username);
	  loginPage.inputToPasswordTextbox(password);
	  
	  System.out.println("LOGIN PAGE - STEP_03: Click to 'LOGIN' button");
	  homePage = loginPage.clickToLoginButton();

	  System.out.println("HOME PAGE - STEP_04: Verify Welcome Message displayed");
	  Assert.assertTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));;
	  
	  System.out.println("HOME PAGE - STEP_05: Verify UserID displayed");
	  Assert.assertTrue(homePage.isUserIDDisplayed(username));
	
	  System.out.println("");
  }
  
  @Test
  public void TC_03_OpenMultiplePages() {
	 System.out.println("Action Chain - STEP_01: HOME PAGE navigate to DEPOSIT PAGE");
	 //depositPage = homePage.openDepositPage(driver);
	 homePage.openMultiplePages(driver, AbstractPageUI.DEPOSIT_TEXT);
	 depositPage = PageGeneratorManager.getDepositPage(driver);
	 
	 System.out.println("Action Chain - STEP_02: DEPOSIT PAGE navigate to WITHDRAWAL PAGE");
	 //withdrawalPage = depositPage.openWithdrawalPage(driver);
	 depositPage.openMultiplePages(driver, AbstractPageUI.WITHDRAWAL_TEXT);
	 withdrawalPage = PageGeneratorManager.getWithdrawalPage(driver);
	 
	 System.out.println("Action Chain - STEP_03: WITHDRAWAL PAGE navigate to CHANGE PASSWORD PAGE");
	 changePasswordPage = (ChangePasswordPageObject) withdrawalPage.openMultiplePage(driver, AbstractPageUI.CHANGE_PASSWORD_TEXT);
	 
	 System.out.println("Action Chain - STEP_04: CHANGE PASSWORD PAGE navigate to MINI STATEMENT PAGE");
	 miniStatementPage = (MiniStatementPageObject) changePasswordPage.openMultiplePage(driver, AbstractPageUI.MINI_STATEMENT_TEXT);
	 
	 System.out.println("Action Chain - STEP_05: Logout then Login and navigate to NEW ACCOUNT PAGE");
	 loginPage = miniStatementPage.openLogoutLink(driver);
	 loginPage.inputToUserIDTextbox(username);
	 loginPage.inputToPasswordTextbox(password);
	 homePage = loginPage.clickToLoginButton();
	 homePage.openMultiplePages(driver, AbstractPageUI.NEW_ACCOUNT_TEXT);
	 newAccountPage = PageGeneratorManager.getNewAccountPage(driver);
	 
	 System.out.println("Action Chain - STEP_07: NEW ACCOUNT PAGE navigate to NEW CUSTOMER PAGE");
	 newAccountPage.openMultiplePages(driver, AbstractPageUI.NEW_CUSTOMER_TEXT);
	 newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
	 
	 System.out.println("Action Chain - STEP_08: NEW CUSTOMER PAGE navigate to DELETE CUSTOMER PAGE");
	 newCustomerPage.openMultiplePages(driver, AbstractPageUI.DELETE_CUSTOMER_TEXT);
	 deleteCustomerPage = PageGeneratorManager.getDeleteCustomerPage(driver);
	 
	 System.out.println("Action Chain - STEP_09: DELETE CUSTOMER PAGE navigate to EDIT ACCOUNT PAGE");
	 deleteCustomerPage.openMultiplePages(driver, AbstractPageUI.EDIT_ACCOUNT_TEXT);
	 editAccountPage = PageGeneratorManager.getEditAccountPage(driver);	 
	 
	 System.out.println("Action Chain - STEP_10: EDIT ACCOUNT PAGE navigate to BALANCE ENQUIRY PAGE");
	 balanceEnquiryPage = (BalanceEnquiryPageObject) editAccountPage.openMultiplePage(driver, AbstractPageUI.BALANCE_ENQUIRY_TEXT);
	 
	 System.out.println("Action Chain - STEP_11: BALANCE ENQUIRY PAGE navigate to HOME PAGE");
	 balanceEnquiryPage.openMultiplePages(driver, AbstractPageUI.HOME_PAGE_TEXT);
	 homePage = PageGeneratorManager.getHomePage(driver);
	 
	 System.out.println("Action Chain - STEP_12: Logout then Login and navigate to EDIT CUSTOMER PAGE");
	 loginPage = homePage.openLogoutLink(driver);
	 loginPage.inputToUserIDTextbox(username);
	 loginPage.inputToPasswordTextbox(password);
	 homePage = loginPage.clickToLoginButton();
	 homePage.openMultiplePages(driver, AbstractPageUI.EDIT_CUSTOMER_TEXT);
	 editCustomerPage = PageGeneratorManager.getEditCustomerPage(driver);
}
  
  @AfterClass (alwaysRun = true)
  public void afterClass() { 
	  driver.quit();
  }

  public int randomData() {
	  Random random = new Random();
	  return random.nextInt(99999);
  }
  
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
