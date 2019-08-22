package com.bankguru.account;

import org.testng.annotations.Test;

import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.RegisterPageFactory;

import org.testng.annotations.BeforeClass;


import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import pageObjects.RegisterPageObject;
import pageUIs.NewCustomerUI;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.HomePageObject;

public class Account_04_RegisterAndLogin_Selenium_PageFactory {
	WebDriver driver;
	RegisterPageFactory registerPage;
	LoginPageFactory loginPage;
	HomePageFactory homePage;
	NewCustomerPageObject newCustomerPage;
	String username, password, loginPageUrl;
	String customerNameValue, genderMaleValue, dateOFBirthValue, addressValue, cityValue;
	String stateValue, pinValue, phoneValue, emailValue, passwordValue;
	
  @BeforeClass
  public void beforeClass() { 
	  driver = new FirefoxDriver();
	  registerPage = new RegisterPageFactory(driver);
	  loginPage = new LoginPageFactory(driver);
	  homePage = new HomePageFactory(driver);
	  newCustomerPage = new NewCustomerPageObject(driver);
	  customerNameValue = "Brian";
	  genderMaleValue = "male";
	  dateOFBirthValue = "1990-01-01";
	  addressValue = "691 Loan Drive";
	  cityValue = "Soan";
	  stateValue = "Missisipi";
	  pinValue = "323232";
	  phoneValue = "1234512345";
	  emailValue = "auto" + randomData() + "@test.com"; 
	  passwordValue = "111222333";
	  
	  System.out.println("PRE-CONDITION - STEP_01: Open BANK GURU APPLICATION");
	  driver.get("http://demo.guru99.com/v4/index.php");
	  
	  System.out.println("PRE-CONDITION - STEP_02: Get Login_Page url");
	  loginPageUrl = loginPage.getLoginPageUrl();
  }

  @Test
  public void TC_01_RegisterToSystem() {
	  
	  System.out.println("LOGIN PAGE - STEP_01: Click to 'HERE' link");
	  loginPage.clickToHereLink();
	  
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
	  loginPage.clickToLoginButton();

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
	  return random.nextInt(9999);
  }
  
}
