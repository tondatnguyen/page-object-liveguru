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

public class Account_08_RegisterAndLogin_DynamicLocator_RestParameter extends AbstractTest {
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
	  
	  System.out.println("LOGIN PAGE - STEP_01: Click to 'HERE' link");
	  loginPageUrl = loginPage.getLoginPageUrl();
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
	
	  System.out.println("");
  }
  
  @Test
  public void TC_03_CheckHomePage() {
	  System.out.println("HOME PAGE - STEP_04: Verify Welcome Message displayed");
	  Assert.assertTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));;
	  
	  System.out.println("HOME PAGE - STEP_05: Verify UserID displayed");
	  Assert.assertTrue(homePage.isUserIDDisplayed(username));
  
	  System.out.println("");
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
