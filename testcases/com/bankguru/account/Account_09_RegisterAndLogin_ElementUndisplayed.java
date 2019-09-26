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

public class Account_09_RegisterAndLogin_ElementUndisplayed extends AbstractTest {
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
	  
	  System.out.println("REGISTER - STEP_1.1: Verify Login_Page is display.");
	  Assert.assertTrue(loginPage.isLoginPageDisplayed());
	  
	  System.out.println("REGISTER - STEP_1.2.1: Verify Delete_Customer_Form is not displayed.");
	  Assert.assertTrue(loginPage.isDeleteCustomerFormLinkUndisplayed());
	  
	  System.out.println("REGISTER - STEP_1.2.2: Click to Selenium Dropdown Toggle");
	  loginPage.clickToSeleniumDropdownToggle();
	  
	  System.out.println("REGISTER - STEP_1.2.3: Verify Delete_Customer_Form is displayed.");
	  Assert.assertTrue(loginPage.isDeleteCustomerFormLinkDisplayed());
	  
	  System.out.println("REGISTER - STEP_1.3: Verify Home_Page is not displayed");
	  Assert.assertTrue(loginPage.isHomePageUndisplayed());
	  
	  System.out.println("REGISTER - STEP_1.4: Verify Register_Page is not displayed");
	  Assert.assertTrue(loginPage.isRegisterPageUndisplayed());
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
