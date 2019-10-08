package com.bankguru.account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import pageObjects.RegisterPageObject;
import pageObjects.WithdrawalPageObject;
import pageObjects.LoginPageObject;
import pageObjects.MiniStatementPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.BalanceEnquiryPageObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.DeleteAccountPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.NewCustomerPageObject;
import commons.AbstractTest;
import commons.PageGeneratorManager;

public class Account_13_Payment_Flow extends AbstractTest {
	String customerID, savingAccountType, currentAccountType, firstAccountID, secondAccountID;
	String customerName, gender, dateOfBirth, address, city, state, pin, phone, email, password;
	String editAddress, editCity, editState, editPin, editPhone, editEmail;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = openMultiBrowser(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		customerName = "John Wick";
		gender = "male";
		dateOfBirth = "2001-09-09";
		address = "340 PO Box";
		city = "LosAngeles";
		state = "New York";
		pin = "556677";
		phone = "1234567890";
		email = "auto" + randomData() + "@test.com";
		password = "johnwick";

		editAddress = "39 Denis Trail";
		editCity = "Corpus Christy";
		editState = "Texas";
		editPin = "889900";
		editPhone = "0987654321";
		editEmail = "editAuto" + randomData() + "@test.com";
		
		savingAccountType = "Savings";
		currentAccountType = "Current";
		
		log.info("Pre-Condition - STEP_01: Input to UserID/Password textbox");
		loginPage.inputToUserIDTextbox("mngr227401");
		loginPage.inputToPasswordTextbox("jAmYses");

		log.info("Pre-Condition - STEP_02: Click to 'LOGIN' button");
		homePage = loginPage.clickToLoginButton();

		log.info("Pre-Condition - STEP_03: Verify Welcome Message displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));
	}

	@Test
	public void Payment_01_CreateNewCustomerAccount() {
		log.info("Payment_01 - Step 01. Open New Customer Page");
		newCustomerPage = (NewCustomerPageObject) homePage.openMultiplePage(driver, "New Customer");
		verifyTrue(newCustomerPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Add New Customer"));

		log.info("Payment_01 - Step 02. Input valid data to all require fields");
		newCustomerPage.inputToDynamicTextbox(driver, "name", customerName);
		newCustomerPage.clickToDynamicRadioButton(driver, "m");
		newCustomerPage.inputToDynamicTextbox(driver, "dob", dateOfBirth);
		newCustomerPage.inputToDynamicTextArea(driver, "addr", address);
		newCustomerPage.inputToDynamicTextbox(driver, "city", city);
		newCustomerPage.inputToDynamicTextbox(driver, "state", state);
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", pin);
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", phone);
		newCustomerPage.inputToDynamicTextbox(driver, "emailid", email);
		newCustomerPage.inputToDynamicTextbox(driver, "password", password);

		log.info("Payment_01 - Step 03. Click to SUBMIT button");
		newCustomerPage.clickToDynamicButton(driver, "Submit");

		log.info("Payment_01 - Step 04. Verify 'Customer Registered Successfully!!!' message displayed");
		verifyTrue(newCustomerPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Customer Registered Successfully!!!"));

		log.info("Payment_01 - Step 05. Verify all info in table displayed");
		verifyEquals(newCustomerPage.getDynamicDataDisplayInTable(driver, "Customer Name"), customerName);
		verifyEquals(newCustomerPage.getDynamicDataDisplayInTable(driver, "Gender"), gender);
		verifyEquals(newCustomerPage.getDynamicDataDisplayInTable(driver, "Birthdate"), dateOfBirth);
		verifyEquals(newCustomerPage.getDynamicDataDisplayInTable(driver, "Address"), address);
		verifyEquals(newCustomerPage.getDynamicDataDisplayInTable(driver, "City"), city);
		verifyEquals(newCustomerPage.getDynamicDataDisplayInTable(driver, "State"), state);
		verifyEquals(newCustomerPage.getDynamicDataDisplayInTable(driver, "Pin"), pin);
		verifyEquals(newCustomerPage.getDynamicDataDisplayInTable(driver, "Mobile No."), phone);
		verifyEquals(newCustomerPage.getDynamicDataDisplayInTable(driver, "Email"), email);
		customerID = newCustomerPage.getDynamicDataDisplayInTable(driver, "Customer ID");
	}

	@Test
	public void Payment_02_EditCustomerAccountAndCheckEditSuccessful() {
		log.info("Payment_02 - Step 01. Open Edit Customer Page");
		editCustomerPage = (EditCustomerPageObject) newCustomerPage.openMultiplePage(driver, "Edit Customer");
		verifyTrue(editCustomerPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Edit Customer Form"));

		log.info("Payment_02 - Step 02. Input to CustomerID textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "cusid", customerID);

		log.info("Payment_02 - Step 03. Click to Submit button");
		editCustomerPage.clickToDynamicButton(driver, "Submit");
		verifyTrue(editCustomerPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Edit Customer"));

		log.info("Payment_02 - Step 04. Update data to editable fields");
		editCustomerPage.inputToDynamicTextArea(driver, "addr", editAddress);
		editCustomerPage.inputToDynamicTextbox(driver, "city", editCity);
		editCustomerPage.inputToDynamicTextbox(driver, "state", editState);
		editCustomerPage.inputToDynamicTextbox(driver, "pinno", editPin);
		editCustomerPage.inputToDynamicTextbox(driver, "telephoneno", editPhone);
		editCustomerPage.inputToDynamicTextbox(driver, "emailid", editEmail);
		
		log.info("Payment_02 - Step 05. Click to Submit button");
		editCustomerPage.clickToDynamicButton(driver, "Submit");
		
		log.info("Payment_02 - Step 06. Verify 'Customer details updated Successfully!!!' message displayed");
		verifyTrue(newCustomerPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Customer details updated Successfully!!!"));
		
		log.info("Payment_02 - Step 07. Verify all required fields updated successfully");
		verifyEquals(editCustomerPage.getDynamicDataDisplayInTable(driver, "Customer Name"), customerName);
		verifyEquals(editCustomerPage.getDynamicDataDisplayInTable(driver, "Gender"), gender);
		verifyEquals(editCustomerPage.getDynamicDataDisplayInTable(driver, "Birthdate"), dateOfBirth);
		verifyEquals(editCustomerPage.getDynamicDataDisplayInTable(driver, "Address"), editAddress);
		verifyEquals(editCustomerPage.getDynamicDataDisplayInTable(driver, "City"), editCity);
		verifyEquals(editCustomerPage.getDynamicDataDisplayInTable(driver, "State"), editState);
		verifyEquals(editCustomerPage.getDynamicDataDisplayInTable(driver, "Pin"), editPin);
		verifyEquals(editCustomerPage.getDynamicDataDisplayInTable(driver, "Mobile No."), editPhone);
		verifyEquals(editCustomerPage.getDynamicDataDisplayInTable(driver, "Email"), editEmail);
	}

	@Test
	public void Payment_03_AddNewAccount() {
		log.info("================ CREATE FIRST ACCOUNT ================");
		log.info("Payment_03 - Step 01. Open New Account Page");
		newAccountPage = (NewAccountPageObject) editCustomerPage.openMultiplePage(driver, "New Account");
		verifyTrue(newAccountPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Add new account form"));
		
		log.info("Payment_03 - Step 02. Input to CustomerID textbox");
		newAccountPage.inputToDynamicTextbox(driver, "cusid", customerID);
		
		log.info("Payment_03 - Step 03. Select Savings value in Account Type dropdown");
		newAccountPage.selectValueInDynamicDropdown(driver, "selaccount", savingAccountType);
		
		log.info("Payment_03 - Step 04. Input to Initial deposit textbox");
		newAccountPage.inputToDynamicTextbox(driver, "inideposit", "50000");
		
		log.info("Payment_03 - Step 05. Click to Submit button");
		newAccountPage.clickToDynamicButton(driver, "submit");
		
		log.info("Payment_03 - Step 06. Verify 'Account Generated Successfully!!!' message displayed");
		verifyTrue(newAccountPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Account Generated Successfully!!!"));
		
		log.info("Payment_03 - Step 07. Verify account created successfully");
		verifyEquals(newAccountPage.getDynamicDataDisplayInTable(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getDynamicDataDisplayInTable(driver, "Customer Name"), customerName);
		verifyEquals(newAccountPage.getDynamicDataDisplayInTable(driver, "Email"), editEmail);
		verifyEquals(newAccountPage.getDynamicDataDisplayInTable(driver, "Account Type"), savingAccountType);
		verifyEquals(newAccountPage.getDynamicDataDisplayInTable(driver, "Date of Opening"), getToday());
		verifyEquals(newAccountPage.getDynamicDataDisplayInTable(driver, "Current Amount"), "50000");
		
		firstAccountID = newAccountPage.getDynamicDataDisplayInTable(driver, "Account ID");
		
		log.info("================ CREATE SECOND ACCOUNT ================");
		log.info("Payment_03 - Step 08. Open New Account Page");
		newAccountPage = (NewAccountPageObject) newAccountPage.openMultiplePage(driver, "New Account");
		verifyTrue(newAccountPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Add new account form"));
		
		log.info("Payment_03 - Step 09. Input to CustomerID textbox");
		newAccountPage.inputToDynamicTextbox(driver, "cusid", customerID);
		
		log.info("Payment_03 - Step 10. Select Current value in Account Type dropdown");
		newAccountPage.selectValueInDynamicDropdown(driver, "selaccount", currentAccountType);
		
		log.info("Payment_03 - Step 11 Input to Initial deposit textbox");
		newAccountPage.inputToDynamicTextbox(driver, "inideposit", "10000");
		
		log.info("Payment_03 - Step 12. Click to Submit button");
		newAccountPage.clickToDynamicButton(driver, "submit");
		
		log.info("Payment_03 - Step 13. Verify 'Account Generated Successfully!!!' message displayed");
		verifyTrue(newAccountPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Account Generated Successfully!!!"));
		//Account Generated Successfully!!!
		log.info("Payment_03 - Step 14. Verify account created successfully");
		verifyEquals(newAccountPage.getDynamicDataDisplayInTable(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getDynamicDataDisplayInTable(driver, "Customer Name"), customerName);
		verifyEquals(newAccountPage.getDynamicDataDisplayInTable(driver, "Email"), editEmail);
		verifyEquals(newAccountPage.getDynamicDataDisplayInTable(driver, "Account Type"), currentAccountType);
		verifyEquals(newAccountPage.getDynamicDataDisplayInTable(driver, "Date of Opening"), getToday());
		verifyEquals(newAccountPage.getDynamicDataDisplayInTable(driver, "Current Amount"), "10000");
		
		secondAccountID = newAccountPage.getDynamicDataDisplayInTable(driver, "Account ID");		
	}

	@Test
	public void Payment_04_EditAccount() {
		log.info("Payment_04 - Step 01. Open Edit Account Page");
		editAccountPage = (EditAccountPageObject) newAccountPage.openMultiplePage(driver, "Edit Account");
		verifyTrue(editAccountPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Edit Account Form"));
		
		log.info("Payment_04 - Step 02. Input to Account No textbox");
		editAccountPage.inputToDynamicTextbox(driver, "accountno", firstAccountID);

		log.info("Payment_04 - Step 03. Click to Submit button");
		editAccountPage.clickToDynamicButton(driver, "Submit");
		verifyTrue(editAccountPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Edit Account Entry Form"));

		log.info("Payment_04 - Step 04. Change Type of Account to Current Value");
		editAccountPage.selectValueInDynamicDropdown(driver, "a_type", currentAccountType);
		
		log.info("Payment_04 - Step 05. Click to Submit button");
		editAccountPage.clickToDynamicButton(driver, "Submit");
		
		log.info("Payment_04 - Step 06. Verify 'Account details updated Successfully!!!' message displayed");
		verifyTrue(editAccountPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Account details updated Successfully!!!"));
		
		log.info("Payment_04 - Step 07. Verify First Account updated successfully");
		verifyEquals(editAccountPage.getDynamicDataDisplayInTable(driver, "Account ID"), firstAccountID);
		verifyEquals(editAccountPage.getDynamicDataDisplayInTable(driver, "Customer ID"), customerID);
		verifyEquals(editAccountPage.getDynamicDataDisplayInTable(driver, "Customer Name"), customerName);
		verifyEquals(editAccountPage.getDynamicDataDisplayInTable(driver, "Email"), editEmail);
		verifyEquals(editAccountPage.getDynamicDataDisplayInTable(driver, "Account Type"), currentAccountType);
		verifyEquals(editAccountPage.getDynamicDataDisplayInTable(driver, "Date of Opening"), getToday());
		verifyEquals(editAccountPage.getDynamicDataDisplayInTable(driver, "Current Amount"), "50000");
	}

	@Test
	public void Payment_05_TransferMoneyIntoCurrentAccount() {
		log.info("Payment_05 - Step 01. Open Deposit page");
		depositPage = (DepositPageObject) editAccountPage.openMultiplePage(driver, "Deposit");
		verifyTrue(depositPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Amount Deposit Form"));
		
		log.info("Payment_05 - Step 02. Input to Account No textbox");
		depositPage.inputToDynamicTextbox(driver, "accountno", firstAccountID);
		
		log.info("Payment_05 - Step 03. Input to Amount textbox");
		depositPage.inputToDynamicTextbox(driver, "ammount", "5000");
		
		log.info("Payment_05 - Step 04. Input to Description textbox");
		depositPage.inputToDynamicTextbox(driver, "desc", "NOP TIEN");
		
		log.info("Payment_05 - Step 05. Click to Submit button");
		depositPage.clickToDynamicButton(driver, "Submit");
		
		log.info("Payment_05 - Step 06. Verify 'Transaction	details of Deposit for Account' message displayed");
		verifyTrue(depositPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Transaction details of Deposit for Account " + firstAccountID));
		
		log.info("Payment_05 - Step 07. Verify Deposited successfully");
		verifyEquals(depositPage.getDynamicDataDisplayInTable(driver, "Account No"), firstAccountID);
		verifyEquals(depositPage.getDynamicDataDisplayInTable(driver, "Amount Credited"), "5000");
		verifyEquals(depositPage.getDynamicDataDisplayInTable(driver, "Type of Transaction"), "Deposit");
		verifyEquals(depositPage.getDynamicDataDisplayInTable(driver, "Description"), "NOP TIEN");
		verifyEquals(depositPage.getDynamicDataDisplayInTable(driver, "Current Balance"), "55000");
	}

	@Test
	public void Payment_06_WithdrawMoneyFromCurrentAccount() {
		log.info("Payment_06 - Step 01. Open Withdrawal page");
		withdrawalPage = (WithdrawalPageObject) editAccountPage.openMultiplePage(driver, "Withdrawal");
		verifyTrue(withdrawalPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Amount Withdrawal Form"));
		
		log.info("Payment_06 - Step 02. Input to Account No textbox");
		withdrawalPage.inputToDynamicTextbox(driver, "accountno", firstAccountID);
		
		log.info("Payment_06 - Step 03. Input to Amount textbox");
		withdrawalPage.inputToDynamicTextbox(driver, "ammount", "15000");
		
		log.info("Payment_06 - Step 04. Input to Description textbox");
		withdrawalPage.inputToDynamicTextbox(driver, "desc", "RUT TIEN");
		
		log.info("Payment_06 - Step 05. Click to Submit button");
		withdrawalPage.clickToDynamicButton(driver, "Submit");
		
		log.info("Payment_06 - Step 06. Verify 'Transaction	details of Withdrawal for Account' message displayed");
		verifyTrue(withdrawalPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Transaction details of Withdrawal for Account " + firstAccountID));
		
		log.info("Payment_06 - Step 07. Verify Withdrawal successfully");
		verifyEquals(withdrawalPage.getDynamicDataDisplayInTable(driver, "Account No"), firstAccountID);
		verifyEquals(withdrawalPage.getDynamicDataDisplayInTable(driver, "Amount Debited"), "15000");
		verifyEquals(withdrawalPage.getDynamicDataDisplayInTable(driver, "Type of Transaction"), "Withdrawal");
		verifyEquals(withdrawalPage.getDynamicDataDisplayInTable(driver, "Description"), "RUT TIEN");
		verifyEquals(withdrawalPage.getDynamicDataDisplayInTable(driver, "Current Balance"), "40000");
	}

	@Test
	public void Payment_07_TransferMoneyIntoOtherAccount() {
		log.info("Payment_07 - Step 01. Open Fund Transfer page");
		fundTransferPage = (FundTransferPageObject) withdrawalPage.openMultiplePage(driver, "Fund Transfer");
		verifyTrue(fundTransferPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Fund transfer"));
		
		log.info("Payment_07 - Step 02. Input to Payers account no textbox");
		fundTransferPage.inputToDynamicTextbox(driver, "payersaccount", firstAccountID);
		
		log.info("Payment_07 - Step 03. Input to Payees account no textbox");
		fundTransferPage.inputToDynamicTextbox(driver, "payeeaccount", secondAccountID);
		
		log.info("Payment_07 - Step 04. Input to Amount textbox");
		fundTransferPage.inputToDynamicTextbox(driver, "ammount", "10000");
		
		log.info("Payment_07 - Step 05. Input to Description textbox");
		fundTransferPage.inputToDynamicTextbox(driver, "desc", "CHUYEN TIEN");
		
		log.info("Payment_07 - Step 06. Click to Submit button");
		fundTransferPage.clickToDynamicButton(driver, "Submit");
		
		log.info("Payment_07 - Step 07. Verify 'Fund Transfer Details' message displayed");
		verifyTrue(fundTransferPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Fund Transfer Details"));
		
		log.info("Payment_07 - Step 08. Verify Deposited successfully");
		verifyEquals(fundTransferPage.getDynamicDataDisplayInTable(driver, "From Account Number"), firstAccountID);
		verifyEquals(fundTransferPage.getDynamicDataDisplayInTable(driver, "To Account Number"), secondAccountID);
		verifyEquals(fundTransferPage.getDynamicDataDisplayInTable(driver, "Amount"), "10000");
		verifyEquals(fundTransferPage.getDynamicDataDisplayInTable(driver, "Description"), "CHUYEN TIEN");
	}

	@Test
	public void Payment_08_CheckCurrentAccountBalance() {
		log.info("Payment_08 - Step 01. Open Balance Enquiry page");
		balanceEnquiryPage = (BalanceEnquiryPageObject) fundTransferPage.openMultiplePage(driver, "Balance Enquiry");
		verifyTrue(balanceEnquiryPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Balance Enquiry Form"));
		
		log.info("Payment_08 - Step 02. Input to First Account No textbox");
		balanceEnquiryPage.inputToDynamicTextbox(driver, "accountno", firstAccountID);
		
		log.info("Payment_08 - Step 03. Click to Submit button");
		balanceEnquiryPage.clickToDynamicButton(driver, "Submit");
		
		log.info("Payment_08 - Step 04. Verify 'Balance Details for Account " + firstAccountID + "' message displayed");
		verifyTrue(balanceEnquiryPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Balance Details for Account " + firstAccountID));
		
		log.info("Payment_08 - Step 05. Verify Current Balance of First Account is correct");
		verifyEquals(balanceEnquiryPage.getDynamicDataDisplayInTable(driver, "Account No"), firstAccountID);
		verifyEquals(balanceEnquiryPage.getDynamicDataDisplayInTable(driver, "Type of Account"), currentAccountType);
		verifyEquals(balanceEnquiryPage.getDynamicDataDisplayInTable(driver, "Balance"), "30000");
		
		log.info("Payment_08 - Step 06. Open Balance Enquiry page again");
		balanceEnquiryPage = (BalanceEnquiryPageObject) balanceEnquiryPage.openMultiplePage(driver, "Balance Enquiry");
		verifyTrue(balanceEnquiryPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Balance Enquiry Form"));
		
		log.info("Payment_08 - Step 07. Input to Second Account No textbox");
		balanceEnquiryPage.inputToDynamicTextbox(driver, "accountno", secondAccountID);
		
		log.info("Payment_08 - Step 08. Click to Submit button");
		balanceEnquiryPage.clickToDynamicButton(driver, "Submit");
		
		log.info("Payment_08 - Step 09. Verify 'Balance Details for Account " + secondAccountID + "' message displayed");
		verifyTrue(balanceEnquiryPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Balance Details for Account " + secondAccountID));
		
		log.info("Payment_08 - Step 10. Verify Current Balance of Second Account is correct");
		verifyEquals(balanceEnquiryPage.getDynamicDataDisplayInTable(driver, "Account No"), secondAccountID);
		verifyEquals(balanceEnquiryPage.getDynamicDataDisplayInTable(driver, "Type of Account"), currentAccountType);
		verifyEquals(balanceEnquiryPage.getDynamicDataDisplayInTable(driver, "Balance"), "20000");
	}

	@Test
	public void Payment_09_DeleteAllAccountAndCheckDeleleSuccess() {
		log.info("Payment_09 - Step 01. Open Delete Account page");
		deleteAccountPage = (DeleteAccountPageObject) balanceEnquiryPage.openMultiplePage(driver, "Delete Account");
		verifyTrue(deleteAccountPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Delete Account Form"));
		
		log.info("Payment_09 - Step 02. Input to First Account No textbox");
		deleteAccountPage.inputToDynamicTextbox(driver, "accountno", firstAccountID);
		
		log.info("Payment_09 - Step 03. Click to Submit button");
		deleteAccountPage.clickToDynamicButton(driver, "Submit");
		
		log.info("Payment_09 - Step 04. Verify alert message 'Do you really want to delete this Account?' displayed");
		verifyTrue(deleteAccountPage.isDynamicAlertMessageDisplayedAndAcceptAlert(driver, "Do you really want to delete this Account?"));
		
		log.info("Payment_09 - Step 05. Verify alert message 'Account Deleted Sucessfully' displayed");
		verifyTrue(deleteAccountPage.isDynamicAlertMessageDisplayedAndAcceptAlert(driver, "Account Deleted Sucessfully"));
		
		log.info("Payment_09 - Step 06. Open Delete Account page again");
		deleteAccountPage = (DeleteAccountPageObject) balanceEnquiryPage.openMultiplePage(driver, "Delete Account");
		verifyTrue(deleteAccountPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Delete Account Form"));
		
		log.info("Payment_09 - Step 07. Input to Second Account No textbox");
		deleteAccountPage.inputToDynamicTextbox(driver, "accountno", secondAccountID);
		
		log.info("Payment_09 - Step 08. Click to Submit button");
		deleteAccountPage.clickToDynamicButton(driver, "Submit");
		
		log.info("Payment_09 - Step 09. Verify alert message 'Do you really want to delete this Account?' displayed");
		verifyTrue(deleteAccountPage.isDynamicAlertMessageDisplayedAndAcceptAlert(driver, "Do you really want to delete this Account?"));
		
		log.info("Payment_09 - Step 10. Verify alert message 'Account Deleted Sucessfully' displayed");
		verifyTrue(deleteAccountPage.isDynamicAlertMessageDisplayedAndAcceptAlert(driver, "Account Deleted Sucessfully"));
	}

	@Test
	public void Payment_10_DeleteCustomerAndCheckDeleleSuccess() {
		log.info("Payment_10 - Step 01. Open Delete Customer page");
		deleteCustomerPage = (DeleteCustomerPageObject) deleteAccountPage.openMultiplePage(driver, "Delete Customer");
		verifyTrue(deleteCustomerPage.isDynamicPageNameOrTableHeaderMessageDisplayed(driver, "Delete Customer Form"));
		
		log.info("Payment_10 - Step 02. Input to CustomerID textbox");
		deleteCustomerPage.inputToDynamicTextbox(driver, "cusid", customerID);
		
		log.info("Payment_10 - Step 03. Click to Submit button");
		deleteCustomerPage.clickToDynamicButton(driver, "Submit");
		
		log.info("Payment_10 - Step 04. Verify alert message 'Do you really want to delete this Customer?' displayed");
		verifyTrue(deleteCustomerPage.isDynamicAlertMessageDisplayedAndAcceptAlert(driver, "Do you really want to delete this Customer?"));
		
		log.info("Payment_10 - Step 05. Verify alert message 'Customer deleted Successfully' displayed");
		verifyTrue(deleteCustomerPage.isDynamicAlertMessageDisplayedAndAcceptAlert(driver, "Customer deleted Successfully"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
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
	DeleteAccountPageObject deleteAccountPage;
	BalanceEnquiryPageObject balanceEnquiryPage;
	EditCustomerPageObject editCustomerPage;
	FundTransferPageObject fundTransferPage;
}
