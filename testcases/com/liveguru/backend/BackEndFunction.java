package com.liveguru.backend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.testdata.DataAdmin;
import com.liveguru.testdata.DataAdmin.OrdersPage;
import com.liveguru.testdata.DataUser;

import commonsLiveGuru.AbstractPage;
import commonsLiveGuru.AbstractTest;
import commonsLiveGuru.PageGeneratorManager;
import pageObjectsLiveGuru.BackEndHomePageObject;
import pageObjectsLiveGuru.BackEndLoginPageObject;
import pageObjectsLiveGuru.BackEndOrdersPageObject;
import pageObjectsLiveGuru.DetailPageObject;
import pageObjectsLiveGuru.EditReviewPageObject;
import pageObjectsLiveGuru.HomePageObject;
import pageObjectsLiveGuru.InvoicesPageObject;
import pageObjectsLiveGuru.PendingReviewsPageObject;
import pageObjectsLiveGuru.ProductPageObject;
import pageObjectsLiveGuru.ReviewPageObject;
import pageUIsLiveGuru.AbstractPageUI;
import pageUIsLiveGuru.BackEndOrdersPageUI;
import pageUIsLiveGuru.HomePageUI;
import pageUIsLiveGuru.ProductPageUI;
import pageUIsLiveGuru.ReviewPageUI;

public class BackEndFunction extends AbstractTest {

	@Parameters("browser")
	@BeforeClass
	public void initData(String browserName) {
		driver = openMultiBrowserBackEnd(browserName, DataAdmin.TYPEOF_FILE);
		driver.manage().window().maximize();
		backEndLoginPage = PageGeneratorManager.getBackEndLoginPage(driver);
	}

	@Test
	public void BackEndFunction_01_VerifyPrintedInvoice() throws Exception {
		log.info("BackEndFunction_01 - STEP_01: Go to BackEnd_URL");
		backEndLoginPage.openLiveGuru99BackEnd(driver);
		verifyEquals(backEndLoginPage.getBackEndLoginPageTitle(driver), DataAdmin.BackEndLoginPage.PAGE_TITLE);

		log.info("BackEndFunction_01 - STEP_02: Login BackEnd");
		backEndHomePage = backEndLoginPage.openBackEndHomePageByLogin(driver);
		backEndHomePage.closePopUp(driver);
		verifyEquals(backEndHomePage.getBackEndPageTitle(driver), DataAdmin.BackEndHomePage.PAGE_TITLE);

		log.info("BackEndFunction_01 - STEP_03: Open Orders page");
		ordersPage = (BackEndOrdersPageObject) backEndHomePage.openDynamicPageOnSalesMenu(driver, "Orders");

		log.info("BackEndFunction_01 - STEP_04a: In the Status field, select 'Cancel'");
		ordersPage.clickToDynamicDropdown(driver, DataAdmin.OrdersPage.CANCEL_OPTION, "sales_order_grid_filter_status");

		log.info("BackEndFunction_01 - STEP_04b: Click Search");
		ordersPage.clickToElementByJS(driver, AbstractPageUI.DYNAMIC_LINK_OR_BUTTON, "Search");
		ordersPage.sleepInSecond(driver, 5);

		log.info("BackEndFunction_01 - STEP_05: Select the checkbox that's next to first order");
		ordersPage.checkFirstOrderCheckbox(driver);

		log.info("BackEndFunction_01 - STEP_06a: In the Action field, select 'Print Invoices'");
		ordersPage.clickToDynamicDropdown(driver, DataAdmin.OrdersPage.PRINT_INVOICES_OPTION,
				"sales_order_grid_massaction-select");

		log.info("BackEndFunction_01 - STEP_06b: Click Submit");
		ordersPage.clickOnDynamicLinkOrButton(driver, "Submit");

		log.info("BackEndFunction_01 - STEP_07: Verify the Error message");
		verifyEquals(ordersPage.getTextElement(driver, BackEndOrdersPageUI.ERROR_MESSAGE),
				DataAdmin.OrdersPage.ERROR_MESSAGE);

		log.info("BackEndFunction_01 - STEP_08a: In the Status field, select 'Complete'");
		ordersPage.selectItemInDropdown(driver, AbstractPageUI.DYNAMIC_DROPDOWN, OrdersPage.COMPLETE_OPTION,
				"sales_order_grid_filter_status");

		log.info("BackEndFunction_01 - STEP_08b: Click Search");
		ordersPage.clickToElementByJS(driver, AbstractPageUI.DYNAMIC_LINK_OR_BUTTON, "Search");
		ordersPage.sleepInSecond(driver, 5);

		log.info("BackEndFunction_01 - STEP_09: Select the checkbox that's next to first order");
		ordersPage.checkFirstOrderCheckbox(driver);

		log.info("BackEndFunction_01 - STEP_10a: In the Action field, select 'Print Invoices'");
		ordersPage.clickToDynamicDropdown(driver, DataAdmin.OrdersPage.PRINT_INVOICES_OPTION,
				"sales_order_grid_massaction-select");

		log.info("BackEndFunction_01 - STEP_10b: Click Submit");
		ordersPage.clickToElementByJS(driver, AbstractPageUI.DYNAMIC_LINK_OR_BUTTON, "Submit");

		log.info("BackEndFunction_01 - STEP_11: Verify Invoice is downloaded");
		AbstractPage.DownloadAndDeleteFileContainName(driver, DataAdmin.TYPEOF_FILE);
	}

	@Test
	public void BackEndFunction_02_VerifyProductReviewMechanism() {
		log.info("BackEndFunction_02 - STEP_01: Go to FrontEnd_URL");
		homePage = (HomePageObject) ordersPage.openLiveGuru99(driver);
		verifyEquals(
				homePage.getTextElement(driver, HomePageUI.HOMEPAGE_TITLE, DataUser.HomePage.HOMEPAGE_TITLE_LOCATOR),
				DataUser.HomePage.HOMEPAGE_TITLE);
		verifyTrue(homePage.isContainedAttributeValue(driver, AbstractPageUI.DYNAMIC_IMAGE, "src",
				DataUser.HomePage.HOMEPAGE_IMG, DataUser.HomePage.HOMEPAGE_IMG_LOCATOR));

		log.info("BackEndFunction_02 - STEP_02: Open XPeria review link");
		reviewPage = (ReviewPageObject) homePage.openXperiaReviewPage(driver);
		verifyEquals(reviewPage.getTextElement(driver, ReviewPageUI.REVIEW_PAGE_BREADCRUMB),
				DataUser.Review.REVIEW_PAGE_TITLE);

		log.info("BackEndFunction_02 - STEP_03a: Fill the required review");
		reviewPage.inputToDynamicTextArea(driver, "review_field", DataUser.Review.THOUGHTS_XPERIA);
		reviewPage.inputToDynamicTextbox(driver, "summary_field", DataUser.Review.SUMMARY_XPERIA);
		reviewPage.inputToDynamicTextbox(driver, "nickname_field", DataUser.Review.NICKCNAME);

		log.info("BackEndFunction_02 - STEP_03b: Submit");
		reviewPage.clickOnDynamicLinkOrButton(driver, "Submit Review");
		verifyEquals(reviewPage.getTextElement(driver, AbstractPageUI.SUCCESS_MESSAGE),
				DataUser.Review.SUCCESS_REVIEW_MESSAGE);

		log.info("BackEndFunction_02 - STEP_04: Go to BackEnd_URL by Logout");
		backEndLoginPage = (BackEndLoginPageObject) reviewPage.openLiveGuru99BackEndByLogout(driver);
		verifyEquals(backEndLoginPage.getBackEndLoginPageTitle(driver), DataAdmin.BackEndLoginPage.PAGE_TITLE);

		log.info("BackEndFunction_02 - STEP_05: Login BackEnd");
		backEndHomePage = backEndLoginPage.openBackEndHomePageByLogin(driver);
		backEndHomePage.closePopUp(driver);
		verifyEquals(backEndHomePage.getBackEndPageTitle(driver), DataAdmin.BackEndHomePage.PAGE_TITLE); 

		log.info("BackEndFunction_02 - STEP_06: Open Pending Reviews page");
		pendingReviewsPage = (PendingReviewsPageObject) backEndHomePage.openPendingReviewsPage(driver);
		verifyEquals(pendingReviewsPage.getBackEndPageTitle(driver), DataAdmin.PendingReviewwsPage.PAGE_TITLE);

		log.info("BackEndFunction_02 - STEP_07: Click on 'Edit' link");
		editReviewPage = pendingReviewsPage.openEditReviewPage(driver);
		verifyEquals(editReviewPage.getBackEndPageTitle(driver), DataAdmin.EditReviewPage.PAGE_TITLE);

		log.info("BackEndFunction_02 - STEP_08a: Change status to 'Approve'");
		editReviewPage.clickToDynamicDropdown(driver, DataAdmin.EditReviewPage.APPROVED_OPTION, "status_id");

		log.info("BackEndFunction_02 - STEP_08b: Click 'Save Review'");
		pendingReviewsPage = editReviewPage.openPendingReviewsPageBySaveReviewButton(driver);
		verifyEquals(pendingReviewsPage.getSuccessMessage(driver), DataAdmin.PendingReviewwsPage.SUCCESS_MESSAGE);

		log.info("BackEndFunction_02 - STEP_09a: Go to FrontEnd_URL");
		homePage = (HomePageObject) pendingReviewsPage.openLiveGuru99(driver);

		log.info("BackEndFunction_02 - STEP_09b: Click 'MOBILE' menu");
		productPage = (ProductPageObject) homePage.openDynamicProductPage(driver, "Mobile");
		verifyEquals(productPage.getTextElement(driver, ProductPageUI.PRODUCT_PAGE_TITLE,
				DataUser.Product.Mobile.MOBILE_PAGE_TITLE_LOCATOR), DataUser.Product.Mobile.MOBILE_PAGE_TITLE);

		log.info("BackEndFunction_02 - STEP_10: Click on Sony Xperia image");
		detailPage = productPage.openDetailProductPageByImage(driver, "Sony Xperia");

		log.info("BackEndFunction_02 - STEP_11: Click on 'REVIEW' tab at bottom of page");
		detailPage.clickOnReviewsTab(driver);

		log.info("BackEndFunction_02 - STEP_12: Verify the review comment is shown");
		verifyTrue(detailPage.isReviewDisplay());
	}

	@Test
	public void BackEndFunction_03_VerifySortIsWorkingCorrectly() throws Exception {
		log.info("BackEndFunction_03 - STEP_01: Go to BackEnd_URL");
		backEndLoginPage = (BackEndLoginPageObject) detailPage.openLiveGuru99BackEndByLogout(driver);
		verifyEquals(backEndLoginPage.getBackEndLoginPageTitle(driver), DataAdmin.BackEndLoginPage.PAGE_TITLE);

		log.info("BackEndFunction_03 - STEP_02: Login BackEnd");
		backEndHomePage = backEndLoginPage.openBackEndHomePageByLogin(driver);
		backEndHomePage.closePopUp(driver);
		verifyEquals(backEndHomePage.getBackEndPageTitle(driver), DataAdmin.BackEndHomePage.PAGE_TITLE);

		log.info("BackEndFunction_03 - STEP_03: Open Invoices page");
		invoicesPage = (InvoicesPageObject) backEndHomePage.openDynamicPageOnSalesMenu(driver, "Invoices");
		verifyEquals(invoicesPage.getBackEndPageTitle(driver), DataAdmin.InvoicesPage.PAGE_TITLE);

		log.info("BackEndFunction_03 - STEP_04: Sort 'Invoice #' in ASC");
		invoicesPage.clickToColumnTitle(driver, "Invoice #");
		verifyTrue(invoicesPage.isInvoiceIDSortASC());

		log.info("BackEndFunction_03 - STEP_05: Sort 'Invoice #' in DESC");
		invoicesPage.clickToColumnTitle(driver, "Invoice #");
		verifyTrue(invoicesPage.isInvoiceIDSortDESC());

		log.info("BackEndFunction_03 - STEP_06: Sort 'Invoice Date' in ASC");
		invoicesPage.clickToColumnTitle(driver, "Invoice Date");
		verifyTrue(invoicesPage.isInvoiceDateSortASC());

		log.info("BackEndFunction_03 - STEP_07: Sort 'Invoice Date' in DESC");
		invoicesPage.clickToColumnTitle(driver, "Invoice Date");
		verifyTrue(invoicesPage.isInvoiceDateSortDESC());

		log.info("BackEndFunction_03 - STEP_08: Sort 'Order #' in ASC");
		invoicesPage.clickToColumnTitle(driver, "Order #");
		verifyTrue(invoicesPage.isOrderIDSortASC());

		log.info("BackEndFunction_03 - STEP_09: Sort 'Order #' in DESC");
		invoicesPage.clickToColumnTitle(driver, "Order #");
		verifyTrue(invoicesPage.isOrderIDSortDESC());

		log.info("BackEndFunction_03 - STEP_10: Sort 'Order Date' in ASC");
		invoicesPage.clickToColumnTitle(driver, "Order Date");
		verifyTrue(invoicesPage.isOrderDateSortASC());

		log.info("BackEndFunction_03 - STEP_11: Sort 'Order Date' in DESC");
		invoicesPage.clickToColumnTitle(driver, "Order Date");
		verifyTrue(invoicesPage.isOrderDateSortDESC());

		log.info("BackEndFunction_03 - STEP_12: Sort 'Bill to Name' in ASC");
		invoicesPage.clickToColumnTitle(driver, "Bill to Name");
		verifyTrue(invoicesPage.isBillNameSortASC());

		log.info("BackEndFunction_03 - STEP_13: Sort 'Bill to Name' in DESC");
		invoicesPage.clickToColumnTitle(driver, "Bill to Name");
		verifyTrue(invoicesPage.isBillNameSortDESC());

		log.info("BackEndFunction_03 - STEP_14: Sort 'Amount' in ASC");
		invoicesPage.clickToColumnTitle(driver, "Amount");
		verifyTrue(invoicesPage.isAmountSortASC());

		log.info("BackEndFunction_03 - STEP_15: Sort 'Amount' in DESC");
		invoicesPage.clickToColumnTitle(driver, "Amount");
		verifyTrue(invoicesPage.isAmountSortDESC());
	}

	@Test
	public void BackEndFunction_04_VerifyPaginationFunctionality() {
		log.info("BackEndFunction_04 - STEP_01: Go to BackEnd_URL");
		backEndLoginPage.openLiveGuru99BackEndByLogout(driver);
		verifyEquals(backEndLoginPage.getBackEndLoginPageTitle(driver), DataAdmin.BackEndLoginPage.PAGE_TITLE);

		log.info("BackEndFunction_04 - STEP_02: Login BackEnd");
		backEndHomePage = backEndLoginPage.openBackEndHomePageByLogin(driver);
		backEndHomePage.closePopUp(driver);
		verifyEquals(backEndHomePage.getBackEndPageTitle(driver), DataAdmin.BackEndHomePage.PAGE_TITLE);

		log.info("BackEndFunction_04 - STEP_03: Open Orders page");
		ordersPage = (BackEndOrdersPageObject) backEndHomePage.openDynamicPageOnSalesMenu(driver, "Orders");
		verifyEquals(ordersPage.getBackEndPageTitle(driver), DataAdmin.OrdersPage.PAGE_TITLE);

		log.info("BackEndFunction_04 - STEP_04: Select View per page option with 20");
		ordersPage.clickToViewDropdownListOfOrdersPage(driver, "20");
		verifyEquals(ordersPage.getPaginationSize(driver), 20);

		log.info("BackEndFunction_04 - STEP_04: Select View per page option with 30");
		ordersPage.clickToViewDropdownListOfOrdersPage(driver, "30");
		verifyEquals(ordersPage.getPaginationSize(driver), 30);
		
		log.info("BackEndFunction_04 - STEP_04: Select View per page option with 50");
		ordersPage.clickToViewDropdownListOfOrdersPage(driver, "50");
		verifyEquals(ordersPage.getPaginationSize(driver), 50);
		
		log.info("BackEndFunction_04 - STEP_04: Select View per page option with 100");
		ordersPage.clickToViewDropdownListOfOrdersPage(driver, "100");
		verifyEquals(ordersPage.getPaginationSize(driver), 100);
	
		log.info("BackEndFunction_04 - STEP_04: Select View per page option with 200");
		ordersPage.clickToViewDropdownListOfOrdersPage(driver, "200");
		verifyEquals(ordersPage.getPaginationSize(driver), 200);
	}

	@Test
	public void BackEndFunction_05_VerifySearchFunctionality() {
		log.info("BackEndFunction_05 - STEP_01: Go to BackEnd_URL");
		backEndLoginPage.openLiveGuru99BackEndByLogout(driver);
		backEndLoginPage.openLiveGuru99BackEnd(driver);
		verifyEquals(backEndLoginPage.getBackEndLoginPageTitle(driver), DataAdmin.BackEndLoginPage.PAGE_TITLE);

		log.info("BackEndFunction_05 - STEP_02: Login BackEnd");
		backEndHomePage = backEndLoginPage.openBackEndHomePageByLogin(driver);
		backEndHomePage.closePopUp(driver);
		verifyEquals(backEndHomePage.getBackEndPageTitle(driver), DataAdmin.BackEndHomePage.PAGE_TITLE);

		log.info("BackEndFunction_05 - STEP_03: Open Manage Customers page");
		backEndHomePage = (BackEndHomePageObject) backEndHomePage.openBackEndHomePageByMenu(driver);
		verifyEquals(backEndHomePage.getBackEndPageTitle(driver), DataAdmin.BackEndHomePage.PAGE_TITLE);
		
		log.info("BackEndFunction_05 - STEP_04a: Search data with ID");
		verifyTrue(backEndHomePage.isIDListResult(driver)); 
		
		log.info("BackEndFunction_05 - STEP_04b: Search data with Name");
		verifyTrue(backEndHomePage.isNameListResult(driver));
		
		log.info("BackEndFunction_05 - STEP_04c: Search data with Email");
		verifyTrue(backEndHomePage.isEmailListResult(driver));
		
		log.info("BackEndFunction_05 - STEP_04d: Search data with Telephone");
		verifyTrue(backEndHomePage.isTelephoneListResult(driver));
		
		log.info("BackEndFunction_05 - STEP_04e: Search data with Zip");
		verifyTrue(backEndHomePage.isZipListResult(driver));
		
		log.info("BackEndFunction_05 - STEP_04f: Search data with Country");
		verifyTrue(backEndHomePage.isCountryListResult(driver));
		
		log.info("BackEndFunction_05 - STEP_04g: Search data with State/Province");
		verifyTrue(backEndHomePage.isStateProvinceListResult(driver));
	}
	
	@Test
	public void BackEndFunction_06_VerifySelectCheckboxFunctionality() {
		log.info("BackEndFunction_06 - STEP_01: Go to BackEnd_URL");
		backEndLoginPage.openLiveGuru99BackEndByLogout(driver);
		verifyEquals(backEndLoginPage.getBackEndLoginPageTitle(driver), DataAdmin.BackEndLoginPage.PAGE_TITLE);

		log.info("BackEndFunction_06 - STEP_02: Login BackEnd");
		backEndHomePage = backEndLoginPage.openBackEndHomePageByLogin(driver);
		backEndHomePage.closePopUp(driver);
		verifyEquals(backEndHomePage.getBackEndPageTitle(driver), DataAdmin.BackEndHomePage.PAGE_TITLE);

		log.info("BackEndFunction_06 - STEP_03a: Open Orders page");
		ordersPage = (BackEndOrdersPageObject) backEndHomePage.openDynamicPageOnSalesMenu(driver, "Orders");
		verifyEquals(ordersPage.getBackEndPageTitle(driver), DataAdmin.OrdersPage.PAGE_TITLE);
		
		log.info("BackEndFunction_06 - STEP_03b: Select View per page option with 30");
		ordersPage.clickToViewDropdownListOfOrdersPage(driver, "30");
		verifyEquals(ordersPage.getPaginationSize(driver), 30);
		
		log.info("BackEndFunction_06 - STEP_04: Click 'Select Visible' link");
		ordersPage.clickToSelectVisible(driver);
		verifyTrue(ordersPage.isAllCheckboxSelected(driver));
		
		log.info("BackEndFunction_06 - STEP_045 Click 'Unselect Visible' link");
		ordersPage.clickToUnSelectVisible(driver);
		verifyTrue(ordersPage.isAllCheckboxUnSelected(driver));
	}

	@AfterClass (alwaysRun = true)
	public void cleanData() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	HomePageObject homePage;
	ReviewPageObject reviewPage;
	BackEndHomePageObject backEndHomePage;
	BackEndLoginPageObject backEndLoginPage;
	BackEndOrdersPageObject ordersPage;
	PendingReviewsPageObject pendingReviewsPage;
	EditReviewPageObject editReviewPage;
	InvoicesPageObject invoicesPage;
	ProductPageObject productPage;
	DetailPageObject detailPage;
}
