package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.BalanceEnquiryPageObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.CustomisedStatementPageObject;
import pageObjects.DeleteAccountPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MiniStatementPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.WithdrawalPageObject;

public class PageGeneratorManager {
	
	static RegisterPageObject registerPage;
	static LoginPageObject loginPage;
	static HomePageObject homePage;
	static DepositPageObject depositPage;
	static WithdrawalPageObject withdrawalPage;
	static FundTransferPageObject fundTransferPage;
	static ChangePasswordPageObject changePasswordPage;
	static MiniStatementPageObject miniStatementPage;
	static NewAccountPageObject newAccountPage;
	static NewCustomerPageObject newCustomerPage;
	static EditAccountPageObject editAccountPage;
	static EditCustomerPageObject editCustomerPage;
	static DeleteAccountPageObject deleteAccountPage;
	static DeleteCustomerPageObject deleteCustomerPage;
	static BalanceEnquiryPageObject balanceEnquiryPage;
	  
	public static RegisterPageObject getRegisterPage(WebDriver driver) {	
		if(registerPage == null) {
			registerPage = new RegisterPageObject(driver);
		}
		return registerPage;
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if(loginPage == null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		if(homePage == null) {
			homePage = new HomePageObject(driver);
		}
		return homePage; 
	}
	
	public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
		if(newCustomerPage == null) {
			newCustomerPage = new NewCustomerPageObject(driver);
		}
		return newCustomerPage;
	}
	
	public static EditCustomerPageObject getEditCustomerPage(WebDriver driver) {
		if(editCustomerPage == null) {
			editCustomerPage = new EditCustomerPageObject(driver);
		}
		return editCustomerPage;
	}
	
	public static DeleteCustomerPageObject getDeleteCustomerPage(WebDriver driver) {
		if(deleteCustomerPage == null) {
			deleteCustomerPage = new DeleteCustomerPageObject(driver);
		}
		return deleteCustomerPage;
	}
	
	public static NewAccountPageObject getNewAccountPage(WebDriver driver) {
		if(newAccountPage == null) {
			newAccountPage = new NewAccountPageObject(driver);
		}
		return newAccountPage;
	}

	public static EditAccountPageObject getEditAccountPage(WebDriver driver) {
		if(editAccountPage == null) {
			editAccountPage = new EditAccountPageObject(driver);
		}
		return editAccountPage;
	}
	
	public static DeleteAccountPageObject getDeleteAccountPage(WebDriver driver) {
		if(deleteAccountPage == null) {
			deleteAccountPage = new DeleteAccountPageObject(driver);
		}
		return deleteAccountPage;
	}
	
	public static DepositPageObject getDepositPage(WebDriver driver) {
		if(depositPage == null) {
			depositPage = new DepositPageObject(driver);
		}
		return depositPage;
	}

	public static WithdrawalPageObject getWithdrawalPage(WebDriver driver) {
		if(withdrawalPage == null) {
			withdrawalPage = new WithdrawalPageObject(driver);
		}
		return withdrawalPage;
	}

	public static FundTransferPageObject getFundTransferPage(WebDriver driver) {
		if(fundTransferPage == null) {
			fundTransferPage = new FundTransferPageObject(driver);
		}
		return fundTransferPage;
	}

	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		if(changePasswordPage == null) {
			changePasswordPage = new ChangePasswordPageObject(driver);
		}
		return changePasswordPage;
	}

	public static BalanceEnquiryPageObject getBalanceEnquiryPage(WebDriver driver) {
		if(balanceEnquiryPage == null) {
			balanceEnquiryPage = new BalanceEnquiryPageObject(driver);
		}
		return balanceEnquiryPage;
	}

	public static MiniStatementPageObject getMiniStatementPage(WebDriver driver) {
		if(miniStatementPage == null) {
			miniStatementPage = new MiniStatementPageObject(driver);
		}
		return miniStatementPage;
	}

	public static CustomisedStatementPageObject getCustomisedStatementPage(WebDriver driver) {
		return new CustomisedStatementPageObject(driver); 
	}

}
