package com.bankguru.account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import pageObjects.RegisterPageObject;
import pageObjects.LoginPageObject;
import pageObjects.HomePageObject;
import pageObjects.NewCustomerPageObject;
import commons.PageGeneratorManager;

public class Account_05_RegisterAndLogin_PageGenerator {
	  WebDriver driver;
	  RegisterPageObject registerPage;
	  LoginPageObject loginPage;
	  HomePageObject homePage;
	  NewCustomerPageObject newCustomerPage;
	  String username, password, loginPageUrl;
	  String customerNameValue, genderMaleValue, dateOFBirthValue, addressValue, cityValue;
	  String stateValue, pinValue, phoneValue, emailValue, passwordValue;

  @Parameters("browser")	  
  @BeforeClass
  public void beforeClass(String browserName) { 
	  
	  driver = new FirefoxDriver();

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
  public void TC_03_CreateNewCustomer() {
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 1. Open New_Customer page");
	  newCustomerPage = homePage.clickToNewCustomerPage();
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 2. Verify New_Customer page displayed");
	  Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 3. Input to Customer_Name textbox");
	  newCustomerPage.inputToNewCustomerName(customerNameValue);
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 4. Click to Gender radio_button with 'male' value");
	  newCustomerPage.clickToGenderMale();
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 5. Input to Date_of_Birth textbox");
	  newCustomerPage.inputToDateOFBirthTextbox(dateOFBirthValue);
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 6. Input to Address textarea");
	  newCustomerPage.inputToAddressTextArea(addressValue);
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 7. Input to City textbox");
	  newCustomerPage.inputToCityTextbox(cityValue);
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 8. Input to State textbox");
	  newCustomerPage.inputToStateTextbox(stateValue);
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 9. Input to PIN textbox");
	  newCustomerPage.inputToPINTextbox(pinValue);
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 10. Input to Mobile_Number textbox");
	  newCustomerPage.inputToPhoneTextbox(phoneValue);
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 11. Input to Email textbox");
	  newCustomerPage.inputToEmailTextbox(emailValue);
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 12. Input to Password textbox");
	  newCustomerPage.inputToPasswordTextbox(passwordValue);
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 13. Click to Submit button");
	  newCustomerPage.clickToSubmitButton();
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 14. Verify 'Customer Registered Successfully!!!' message displayed");
	  Assert.assertTrue(newCustomerPage.isCustomerRegisteredSuccessMessageDisplayed());
	  
	  System.out.println("NEW_CUSTOMER PAGE - STEP: 15. Verify all information show correct");
	  Assert.assertEquals(newCustomerPage.getCustomerNameValueInTable(), customerNameValue);
	  Assert.assertEquals(newCustomerPage.getGenderValueInTable(), genderMaleValue);
	  Assert.assertEquals(newCustomerPage.getBirthdayValueInTable(), dateOFBirthValue);
	  Assert.assertEquals(newCustomerPage.getAddressValueInTable(), addressValue);
	  Assert.assertEquals(newCustomerPage.getCityValueInTable(), cityValue);
	  Assert.assertEquals(newCustomerPage.getStateValueInTable(), stateValue);
	  Assert.assertEquals(newCustomerPage.getPinValueInTable(), pinValue);
	  Assert.assertEquals(newCustomerPage.getPhoneValueInTable(), phoneValue);
	  Assert.assertEquals(newCustomerPage.getEmailValueInTable(), emailValue);
	  
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
