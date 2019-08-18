package com.bankguru.account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import pageObjects.RegisterPageObject;
import pageObjects.LoginPageObject;
import pageObjects.HomePageObject;

public class Account_02_RegisterAndLogin_AbstractPage_03_PageObjectPattern {
	WebDriver driver;
	String email, username, password, loginPageUrl, welcomeMessage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	HomePageObject homePage;
	
  @BeforeClass
  public void beforeClass() { 
	  driver = new FirefoxDriver();
	  email = "auto" + randomData() + "@test.com";
	  registerPage = new RegisterPageObject(driver);
	  loginPage = new LoginPageObject(driver);
	  homePage = new HomePageObject(driver);
	    
	  System.out.println("PRE-CONDITION - STEP_01: Open BANK GURU APPLICATION");
	  driver.get("http://demo.guru99.com/v4/index.php");
	  
	  System.out.println("PRE-CONDITION - STEP_02: Get Login_Page url");
	  loginPageUrl = loginPage.getLoginPageUrl();
  }

  @Test
  public void TC_01_registerToSystem() {
	  
	  System.out.println("LOGIN PAGE - STEP_01: Click to 'HERE' link");
	  loginPage.clickToHereLink();
	  
	  System.out.println("REGISTER PAGE - STEP_02: Input to Email_ID_textbox");
	  registerPage.inputToEmailTextbox(email);
	  
	  System.out.println("REGISTER PAGE - STEP_03: Click to 'SUBMIT' button");
	  registerPage.clickToSubmitButton();
	  System.out.println("REGISTER PAGE - STEP_04: Get username/password info");
	  username = registerPage.getUsernameInfo();
	  password = registerPage.getPasswordInfo();
	  
	  System.out.println("");
  }

  @Test
  public void TC_02_loginToSystem() {
	  
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
