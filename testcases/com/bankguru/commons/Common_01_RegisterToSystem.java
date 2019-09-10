package com.bankguru.commons;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import pageObjects.RegisterPageObject;
import pageObjects.LoginPageObject;
import commons.AbstractTest;
import commons.PageGeneratorManager;

public class Common_01_RegisterToSystem extends AbstractTest {
  WebDriver driver;
	
  @Parameters("browser")
  @BeforeTest
  public void beforeTest(String browserName) { 
	  
	  driver = openMultiBrowser(browserName);
	  emailValue = "auto" + randomData() + "@test.com"; 
	  loginPage = PageGeneratorManager.getLoginPage(driver);

	  log.info("REGISTER - STEP_01: Verify Login_Page is display.");
	  verifyTrue(loginPage.isLoginPageDisplayed());
	  
	  log.info("REGISTER - STEP_02: Click to 'HERE' link");
	  registerPage = loginPage.clickToHereLink();
	  
	  log.info("REGISTER - STEP_03: Input to Email_ID_textbox");
	  registerPage.inputToEmailTextbox(emailValue);
	  
	  log.info("REGISTER - STEP_04: Click to 'SUBMIT' button");
	  registerPage.clickToSubmitButton();
	  
	  log.info("REGISTER - STEP_05: Get username/password info");
	  USERNAME = registerPage.getUsernameInfo();
	  PASSWORD = registerPage.getPasswordInfo();
	  
	  System.out.println("USERNAME in Class Common_01_RegisterToSystem = " + USERNAME);
	  System.out.println("PASSWORD in Class Common_01_RegisterToSystem = " + PASSWORD);
	  
	  driver.quit();	
  }
  
  public static String USERNAME, PASSWORD;
  String emailValue;
  LoginPageObject loginPage;
  RegisterPageObject registerPage;
  
}
