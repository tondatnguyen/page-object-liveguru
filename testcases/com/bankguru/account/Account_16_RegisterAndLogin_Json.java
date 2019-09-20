package com.bankguru.account;

import org.testng.annotations.Test;

import com.bankguru.customer.GetCustomerDataJson;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import commons.AbstractTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;
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

public class Account_16_RegisterAndLogin_Json<DataJson> extends AbstractTest{
	WebDriver driver;
	GetCustomerDataJson dataCustomer;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	String username, password, loginPageUrl;
	String fullEmailValue;
//	String customerNameValue, genderMaleValue, dateOFBirthValue, addressValue, cityValue;
//	String stateValue, pinValue, phoneValue, passwordValue;
 
  @Parameters({"browser","customer"})
  @BeforeClass
  public void beforeClass(String browserName, String customerData) throws JsonParseException, JsonMappingException, IOException { 
	  driver = openMultiBrowser(browserName);
	  dataCustomer = GetCustomerDataJson.getCustomerData(".\\testdata\\com\\bankguru\\customer\\Customer.json");
	  registerPage = new RegisterPageObject(driver);
	  loginPage = new LoginPageObject(driver);
	  homePage = new HomePageObject(driver);
	  newCustomerPage = new NewCustomerPageObject(driver);
//	  customerNameValue = "Brian";
//	  genderMaleValue = "male";
//	  dateOFBirthValue = "1990-01-01";
//	  addressValue = "691 Loan Drive";
//	  cityValue = "Soan";
//	  stateValue = "Missisipi";
//	  pinValue = "323232";
//	  phoneValue = "1234512345";
	  fullEmailValue = dataCustomer.getEmailValue() + randomData() + "@test.com"; 
//	  passwordValue = "111222333";
	  
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
	  registerPage.inputToEmailTextbox(fullEmailValue);
	  
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
	  verifyTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));;
	  
	  System.out.println("HOME PAGE - STEP_05: Verify UserID displayed");
	  verifyTrue(homePage.isUserIDDisplayed(username));
	
	  System.out.println("");
  }
  
  @Test
  public void TC_03_CreateNewCustomer() {
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 1. Open New_Customer page");
	  homePage.clickToNewCustomerPage();
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 2. Verify New_Customer page displayed");
	  verifyTrue(newCustomerPage.isNewCustomerPageDisplayed());
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 3. Input to Customer_Name textbox");
	  newCustomerPage.inputToNewCustomerName(dataCustomer.getCustomerNameValue());
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 4. Click to Gender radio_button with 'male' value");
	  newCustomerPage.clickToGenderMale();
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 5. Input to Date_of_Birth textbox");
	  newCustomerPage.inputToDateOFBirthTextbox(dataCustomer.getDateOFBirthValue());
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 6. Input to Address textarea");
	  newCustomerPage.inputToAddressTextArea(dataCustomer.getAddressValue());
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 7. Input to City textbox");
	  newCustomerPage.inputToCityTextbox(dataCustomer.getCityValue());
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 8. Input to State textbox");
	  newCustomerPage.inputToStateTextbox(dataCustomer.getStateValue());
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 9. Input to PIN textbox");
	  newCustomerPage.inputToPINTextbox(dataCustomer.getPinValue());
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 10. Input to Mobile_Number textbox");
	  newCustomerPage.inputToPhoneTextbox(dataCustomer.getPhoneValue());
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 11. Input to Email textbox");
	  newCustomerPage.inputToEmailTextbox(fullEmailValue);
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 12. Input to Password textbox");
	  newCustomerPage.inputToPasswordTextbox(dataCustomer.getPasswordValue());
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 13. Click to Submit button");
	  newCustomerPage.clickToSubmitButton();
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 14. Verify 'Customer Registered Successfully!!!' message displayed");
	  verifyTrue(newCustomerPage.isCustomerRegisteredSuccessMessageDisplayed());
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 15. Verify all information show correct");
	  verifyEquals(newCustomerPage.getCustomerNameValueInTable(), dataCustomer.getCustomerNameValue());
	  verifyEquals(newCustomerPage.getGenderValueInTable(), dataCustomer.getGenderMaleValue());
	  verifyEquals(newCustomerPage.getBirthdayValueInTable(), dataCustomer.getDateOFBirthValue());
	  verifyEquals(newCustomerPage.getAddressValueInTable(), dataCustomer.getAddressValue());
	  verifyEquals(newCustomerPage.getCityValueInTable(), dataCustomer.getCityValue());
	  verifyEquals(newCustomerPage.getStateValueInTable(), dataCustomer.getStateValue());
	  verifyEquals(newCustomerPage.getPinValueInTable(), dataCustomer.getPinValue());
	  verifyEquals(newCustomerPage.getPhoneValueInTable(), dataCustomer.getPhoneValue());
	  verifyEquals(newCustomerPage.getEmailValueInTable(), fullEmailValue);
	  
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
