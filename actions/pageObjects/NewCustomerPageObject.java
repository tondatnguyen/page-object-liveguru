package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewCustomerUI;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;
	
	public NewCustomerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public boolean isNewCustomerPageDisplayed() {
		waitForElementVisible(driver, NewCustomerUI.NEW_CUSTOMER_PAGE_HEADING);
		return isControlDisplayed(driver, NewCustomerUI.NEW_CUSTOMER_PAGE_HEADING);
	}

	public void inputToNewCustomerName(String customerName) {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_NAME_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.CUSTOMER_NAME_TEXTBOX , customerName);
	}

	public void clickToGenderMale() {
		waitForElementVisible(driver, NewCustomerUI.GENDER_MALE_RADIO);
		clickToElement(driver, NewCustomerUI.GENDER_MALE_RADIO);	
	}

	public void inputToDateOFBirthTextbox(String dateOfBirth) {
		waitForElementVisible(driver, NewCustomerUI.DATE_OF_BIRTH_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);	
	}

	public void inputToAddressTextArea(String address) {
		waitForElementVisible(driver, NewCustomerUI.ADDRESS_TEXTAREA);
		sendkeyToElement(driver, NewCustomerUI.ADDRESS_TEXTAREA, address);	
	}

	public void inputToCityTextbox(String city) {
		waitForElementVisible(driver, NewCustomerUI.CITY_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.CITY_TEXTBOX, city);	
	}

	public void inputToStateTextbox(String state) {
		waitForElementVisible(driver, NewCustomerUI.STATE_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.STATE_TEXTBOX, state);	
	}

	public void inputToPINTextbox(String pinNumber) {
		waitForElementVisible(driver, NewCustomerUI.PIN_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.PIN_TEXTBOX, pinNumber);		
	}

	public void inputToPhoneTextbox(String phoneNumber) {
		waitForElementVisible(driver, NewCustomerUI.PHONE_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.PHONE_TEXTBOX, phoneNumber);		
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, NewCustomerUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.EMAIL_TEXTBOX, email);	
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, NewCustomerUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, NewCustomerUI.PASSWORD_TEXTBOX, password);			
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, NewCustomerUI.SUBMIT_BUTTON);
		clickToElement(driver, NewCustomerUI.SUBMIT_BUTTON);		
	}

	public boolean isCustomerRegisteredSuccessMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerUI.NEW_CUSTOMER_REGISTERED_HEADING);
		return isControlDisplayed(driver, NewCustomerUI.NEW_CUSTOMER_REGISTERED_HEADING);
	}

	public String getCustomerNameValueInTable() {
		waitForElementVisible(driver, NewCustomerUI.CUSTOMER_NAME_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerUI.CUSTOMER_NAME_VALUE_IN_TABLE);
	}

	public String getGenderValueInTable() {
		waitForElementVisible(driver, NewCustomerUI.GENDER_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerUI.GENDER_VALUE_IN_TABLE);
	}

	public String getBirthdayValueInTable() {
		waitForElementVisible(driver, NewCustomerUI.DATE_OF_BIRTH_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerUI.DATE_OF_BIRTH_VALUE_IN_TABLE);
	}

	public String getAddressValueInTable() {
		waitForElementVisible(driver, NewCustomerUI.ADDRESS_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerUI.ADDRESS_VALUE_IN_TABLE);
	}

	public String getCityValueInTable() {
		waitForElementVisible(driver, NewCustomerUI.CITY_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerUI.CITY_VALUE_IN_TABLE);
	}

	public String getStateValueInTable() {
		waitForElementVisible(driver, NewCustomerUI.STATE_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerUI.STATE_VALUE_IN_TABLE);
	}

	public String getPinValueInTable() {
		waitForElementVisible(driver, NewCustomerUI.PIN_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerUI.PIN_VALUE_IN_TABLE);
	}

	public String getPhoneValueInTable() {
		waitForElementVisible(driver, NewCustomerUI.PHONE_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerUI.PHONE_VALUE_IN_TABLE);
	}

	public String getEmailValueInTable() {
		waitForElementVisible(driver, NewCustomerUI.EMAIL_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerUI.EMAIL_VALUE_IN_TABLE);
	}



}
