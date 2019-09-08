package com.bankguru.account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.junit.Assert.assertTrue;

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

public class Account_10_Assert_Verify_Log_ReportHTML extends AbstractTest {
  private WebDriver driver;
	
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) { 
	  
	  driver = openMultiBrowser(browserName);
	  emailValue = "auto" + randomData() + "@test.com"; 
	  loginPage = PageGeneratorManager.getLoginPage(driver);

  }

  @Test
  public void TC_01_RegisterToSystem() {
	  
	  log.info("REGISTER - STEP_01: Verify Login_Page is display.");
	  verifyTrue(loginPage.isLoginPageDisplayed());
	  
	  log.info("REGISTER - STEP_02: Verify Delete_Customer_Form is not displayed.");
	  verifyTrue(loginPage.isDeleteCustomerFormLinkUndisplayed());
	  
	  log.info("REGISTER - STEP_03: Click to Selenium Dropdown Toggle");
	  loginPage.clickToSeleniumDropdownToggle();
	  
	  log.info("REGISTER - STEP_04: Verify Delete_Customer_Form is displayed.");
	  verifyTrue(loginPage.isDeleteCustomerFormLinkDisplayed());
	  
	  log.info("REGISTER - STEP_05: Verify Home_Page is not displayed");
	  verifyTrue(loginPage.isHomePageUndisplayed());
	  
	  log.info("REGISTER - STEP_06: Verify Register_Page is not displayed");
	  verifyTrue(loginPage.isRegisterPageUndisplayed());
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
