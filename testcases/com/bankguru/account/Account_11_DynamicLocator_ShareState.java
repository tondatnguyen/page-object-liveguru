package com.bankguru.account;

import org.testng.annotations.Test;
import com.bankguru.commons.Common_01_RegisterToSystem;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import pageObjects.LoginPageObject;
import pageObjects.HomePageObject;
import commons.AbstractTest;
import commons.PageGeneratorManager;

public class Account_11_DynamicLocator_ShareState extends AbstractTest {
  WebDriver driver;
	
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) { 
	  
	  driver = openMultiBrowser(browserName);
	  loginPage = PageGeneratorManager.getLoginPage(driver);

	  log.info("Pre-Condition - STEP_01: Input to UserID/Password textbox");
	  loginPage.inputToUserIDTextbox(Common_01_RegisterToSystem.USERNAME);
	  loginPage.inputToPasswordTextbox(Common_01_RegisterToSystem.PASSWORD);
	  
	  log.info("Pre-Condition - STEP_02: Click to 'LOGIN' button");
	  homePage = loginPage.clickToLoginButton();
	  
	  log.info("Pre-Condition - STEP_03: Verify Welcome Message displayed");
	  verifyTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));;
	  
	  log.info("Pre-Condition - STEP_04: Verify UserID displayed");
	  verifyTrue(homePage.isUserIDDisplayed(Common_01_RegisterToSystem.USERNAME));
	  
	  System.out.println("USERNAME in Class Account_11_DynamicLocator_ShareState = " + Common_01_RegisterToSystem.USERNAME);
	  System.out.println("PASSWORD in Class Account_11_DynamicLocator_ShareState = " + Common_01_RegisterToSystem.PASSWORD);
  }

  @Test
  public void TC_01_CreateNewCustomer() {
	 	  
  }
  
  @Test
  public void TC_02_EditCustomer() {
	  
  }
  
  @Test
  public void TC_03_CreateNewAccount() {
	  
  }
  
  @Test
  public void TC_04_DepositToOtherUser() {
	  
  }
  
  @AfterClass (alwaysRun = true)
  public void afterClass() { 
	  closeBrowserAndDriver(driver);
  }
 
  LoginPageObject loginPage;
  HomePageObject homePage; 
}
