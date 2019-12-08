package com.liveguru.frontend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.testdata.DataUser;

import commonsLiveGuru.AbstractTest;
import commonsLiveGuru.PageGeneratorManager;
import pageObjectsLiveGuru.AccountInfoPageObject;
import pageObjectsLiveGuru.AdvancedSearchPageObject;
import pageObjectsLiveGuru.AdvancedSearchResultPageObject;
import pageObjectsLiveGuru.CheckOutPageObject;
import pageObjectsLiveGuru.DetailPageObject;
import pageObjectsLiveGuru.HomePageObject;
import pageObjectsLiveGuru.LoginPageObject;
import pageObjectsLiveGuru.MyDashboardPageObject;
import pageObjectsLiveGuru.MyWishListPageObject;
import pageObjectsLiveGuru.PopUpPageObject;
import pageObjectsLiveGuru.ProductPageObject;
import pageObjectsLiveGuru.RegisterPageObject;
import pageObjectsLiveGuru.ReviewPageObject;
import pageObjectsLiveGuru.ShoppingCartPageObject;
import pageObjectsLiveGuru.SuccessOrderPageObject;
import pageObjectsLiveGuru.WishListSharingPageObject;
import pageUIsLiveGuru.AbstractPageUI;
import pageUIsLiveGuru.AccountInfoPageUI;
import pageUIsLiveGuru.AdvancedSearchPageUI;
import pageUIsLiveGuru.AdvancedSearchResultPageUI;
import pageUIsLiveGuru.CheckOutPageUI;
import pageUIsLiveGuru.DetailPageUI;
import pageUIsLiveGuru.HomePageUI;
import pageUIsLiveGuru.MyDashboardPageUI;
import pageUIsLiveGuru.MyWishListPageUI;
import pageUIsLiveGuru.PopUpWindowPageUI;
import pageUIsLiveGuru.ProductPageUI;
import pageUIsLiveGuru.RegisterPageUI;
import pageUIsLiveGuru.ReviewPageUI;
import pageUIsLiveGuru.ShoppingCartPageUI;
import pageUIsLiveGuru.SuccessOrderPageUI;
import pageUIsLiveGuru.WishListSharingPageUI;

public class FrontEndFunction extends AbstractTest {
	
	@Parameters("browser")
	@BeforeClass 
	public void initData(String browserName) {
		
		driver = openMultiBrowserFrontEnd(browserName);
		driver.manage().window().maximize();
		parentWindowID = driver.getWindowHandle();
		amountOfProducts = Integer.parseInt(DataUser.WishList.AMOUNT_PRODUCTS);
		email = DataUser.Register.EMAIL + randomData() + "@test.com";
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	@Test
	public void FrontEndFunction_01_Register() {
		log.info("FrontEndFunction_01 - Step 01. Open LiveGuru99 site");
		homePage.openLiveGuru99(driver); 
		verifyEquals(homePage.getTextElement(driver, HomePageUI.HOMEPAGE_TITLE, DataUser.HomePage.HOMEPAGE_TITLE_LOCATOR), DataUser.HomePage.HOMEPAGE_TITLE);
		verifyTrue(homePage.isContainedAttributeValue(driver, AbstractPageUI.DYNAMIC_IMAGE, "src", DataUser.HomePage.HOMEPAGE_IMG, DataUser.HomePage.HOMEPAGE_IMG_LOCATOR));
		
		log.info("FrontEndFunction_01 - Step 02. Click on 'ACCOUNT' menu");
		homePage.clickOnAccountMenu(driver);
		
		log.info("FrontEndFunction_01 - Step 03. Choose 'Register' link");
		registerPage = (RegisterPageObject) homePage.openDynamicAccountMenuPage(driver, "Register");
		verifyEquals(registerPage.getTextElement(driver, RegisterPageUI.REGISTER_PAGE_TITLE, DataUser.Register.REGISTER_PAGE_TITLE_LOCATOR), DataUser.Register.REGISTER_PAGE_TITLE);
		
		log.info("FrontEndFunction_01 - Step 04. Input all valid data to form");
		log.info("FrontEndFunction_01 - Step 04a. Input Firstname");
		registerPage.inputToDynamicTextbox(driver, "firstname", DataUser.Register.FIRSTNAME);
		
		log.info("FrontEndFunction_01 - Step 04b. Input Lastname");
		registerPage.inputToDynamicTextbox(driver, "lastname", DataUser.Register.LASTNAME);
		
		log.info("FrontEndFunction_01 - Step 04c. Input Email");
		registerPage.inputToDynamicTextbox(driver, "email_address", email);
		
		log.info("FrontEndFunction_01 - Step 04d. Input Password");
		registerPage.inputToDynamicTextbox(driver, "password", DataUser.Register.PASSWORD);
		
		log.info("FrontEndFunction_01 - Step 04e. Input Re-Password");
		registerPage.inputToDynamicTextbox(driver, "confirmation", DataUser.Register.CONFIRM_PASSWORD);
		
		log.info("FrontEndFunction_01 - Step 05. Click 'REGISTER' button");
		registerPage.clickOnDynamicLinkOrButton(driver, "Register");
		
		log.info("FrontEndFunction_01 - Step 06. Verify 'Thank you for registering with Main Website Store' message is displayed!!");
		verifyEquals(registerPage.getTextElement(driver, AbstractPageUI.SUCCESS_MESSAGE), DataUser.Register.REGISTERED_SUCCESS_MESSAGE);
	}
	
	@Test
	public void FrontEndFunction_02_VerifyInfo() {
		log.info("FrontEndFunction_02 - Step 01. Open LiveGuru99 site");
		homePage = (HomePageObject) registerPage.openLiveGuru99(driver); 
		verifyEquals(homePage.getTextElement(driver, HomePageUI.HOMEPAGE_TITLE, DataUser.HomePage.HOMEPAGE_TITLE_LOCATOR), DataUser.HomePage.HOMEPAGE_TITLE);
		verifyTrue(homePage.isContainedAttributeValue(driver, AbstractPageUI.DYNAMIC_IMAGE, "src", DataUser.HomePage.HOMEPAGE_IMG, DataUser.HomePage.HOMEPAGE_IMG_LOCATOR));	
		
		log.info("FrontEndFunction_02 - Step 02a. Click on 'ACCOUNT' menu");
		homePage.clickOnAccountMenu(driver);
		
		log.info("FrontEndFunction_02 - Step 02b. Open 'MY ACCOUNT'/'DASHBOARD' page");
		myDashboardPage = (MyDashboardPageObject) homePage.openDynamicAccountMenuPage(driver, "My Account");
		verifyEquals(myDashboardPage.getTextElement(driver, MyDashboardPageUI.MY_DASHBOARD_PAGE_TITLE, DataUser.Register.ACCOUNT_DASHBOARD_PAGE_TITLE_LOCATOR), DataUser.Register.ACCOUNT_DASHBOARD_PAGE_TITLE);
		
		log.info("FrontEndFunction_02 - Step 03. Open 'ACCOUNT INFORMATION' page");
		accountInfoPage = (AccountInfoPageObject) myDashboardPage.openAccountInfoPage(driver, "Account Information");
		verifyEquals(accountInfoPage.getTextElement(driver, AccountInfoPageUI.ACCOUNT_INFO_PAGE_TITLE, DataUser.Register.ACCOUNT_INFO_PAGE_TITLE_LOCATOR), DataUser.Register.ACCOUNT_INFO_PAGE_TITLE);
		verifyEquals(accountInfoPage.getAttributeValue(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "value", "firstname"), DataUser.Register.FIRSTNAME);
		verifyEquals(accountInfoPage.getAttributeValue(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "value", "lastname"), DataUser.Register.LASTNAME);
		verifyEquals(accountInfoPage.getAttributeValue(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "value", "email"), email);
	}
	
	@Test
	public void FrontEndFunction_03_VerifyCost() {
		log.info("FrontEndFunction_03 - Step 01. Open LiveGuru99 site");
		homePage = (HomePageObject) accountInfoPage.openLiveGuru99(driver); 
		verifyEquals(homePage.getTextElement(driver, HomePageUI.HOMEPAGE_TITLE, DataUser.HomePage.HOMEPAGE_TITLE_LOCATOR), DataUser.HomePage.HOMEPAGE_TITLE);
		verifyTrue(homePage.isContainedAttributeValue(driver, AbstractPageUI.DYNAMIC_IMAGE, "src", DataUser.HomePage.HOMEPAGE_IMG, DataUser.HomePage.HOMEPAGE_IMG_LOCATOR));	
		
		log.info("FrontEndFunction_03 - Step 02. Click on 'MOBILE' menu");
		productPage = (ProductPageObject) homePage.openDynamicProductPage(driver, "Mobile");
		verifyEquals(productPage.getTextElement(driver, ProductPageUI.PRODUCT_PAGE_TITLE, DataUser.Product.Mobile.MOBILE_PAGE_TITLE_LOCATOR), DataUser.Product.Mobile.MOBILE_PAGE_TITLE);
		
		log.info("FrontEndFunction_03 - Step 03. Get cost of SONY XPERIA from MOBILE");
		priceXperiaProductPage = productPage.getRegularPriceOfDynamicProduct(driver, "Sony Xperia");
		
		log.info("FrontEndFunction_03 - Step 04. Click on SONY XPERIA detail");
		detailPage = (DetailPageObject) productPage.openDetailProductPage(driver, "Sony Xperia");
		verifyEquals(productPage.getTextElement(driver, DetailPageUI.DETAIL_PRODUCT_PAGE_TITLE), DataUser.Product.Mobile.XPERIA_NAME);
		
		log.info("FrontEndFunction_03 - Step 05. Get cost of SONY XPERIA from DETAIL");
		priceXperiaDetailPage = detailPage.getRegularPriceOfDynamicDetail(driver, "Sony Xperia");
		
		log.info("FrontEndFunction_03 - Step 06. Verify cost of SONY XPERIA from MOBILE_page & DETAIL_page");
		verifyTrue(detailPage.isEqualPrice(driver, priceXperiaProductPage, priceXperiaDetailPage));
	}
	
	@Test
	public void FrontEndFunction_04_DiscountCoupon() {
		log.info("FrontEndFunction_04 - Step 01. Open LiveGuru99 site");
		homePage = (HomePageObject) detailPage.openLiveGuru99(driver); 
		verifyEquals(homePage.getTextElement(driver, HomePageUI.HOMEPAGE_TITLE, DataUser.HomePage.HOMEPAGE_TITLE_LOCATOR), DataUser.HomePage.HOMEPAGE_TITLE);
		verifyTrue(homePage.isContainedAttributeValue(driver, AbstractPageUI.DYNAMIC_IMAGE, "src", DataUser.HomePage.HOMEPAGE_IMG, DataUser.HomePage.HOMEPAGE_IMG_LOCATOR));
		
		log.info("FrontEndFunction_04 - Step 02a. Click on 'MOBILE' menu");
		productPage = (ProductPageObject) homePage.openDynamicProductPage(driver, "Mobile");
		verifyEquals(productPage.getTextElement(driver, ProductPageUI.PRODUCT_PAGE_TITLE, DataUser.Product.Mobile.MOBILE_PAGE_TITLE_LOCATOR), DataUser.Product.Mobile.MOBILE_PAGE_TITLE);
		
		log.info("FrontEndFunction_04 - Step 02b. Add IPHONE to cart");		
		shoppingCartPage = (ShoppingCartPageObject) productPage.openShoppingCartPage(driver, "IPhone");
		verifyEquals(shoppingCartPage.getTextElement(driver, ShoppingCartPageUI.SHOPPING_CART_PAGE_TITLE, DataUser.ShipCheckOut.SHOPPING_CART_PAGE_TITLE_LOCATOR), DataUser.ShipCheckOut.SHOPPING_CART_PAGE_TITLE);
		
		log.info("FrontEndFunction_04 - Step 03. Enter COUPON CODE");
		shoppingCartPage.inputToDynamicTextbox(driver, "coupon_code", "GURU50");
		shoppingCartPage.clickOnDynamicLinkOrButton(driver, "Apply");
		verifyEquals(shoppingCartPage.getTextElement(driver, AbstractPageUI.SUCCESS_MESSAGE), DataUser.ShipCheckOut.COUPON_CODE_MESSAGE);
		
		log.info("FrontEndFunction_04 - Step 04. Verify the DISCOUNT generated");
		verifyEquals(shoppingCartPage.getTextElement(driver, ShoppingCartPageUI.DISCOUNT_GURU50_TEXT, DataUser.ShipCheckOut.DISCOUNT_TEXT).trim(), DataUser.ShipCheckOut.DISCOUNT_TEXT);
		verifyEquals(shoppingCartPage.getTextElement(driver, ShoppingCartPageUI.DISCOUNT_GURU50_PRICE), DataUser.ShipCheckOut.DISCOUNT_IPHONE_PRICE);
		verifyEquals(shoppingCartPage.getTextElement(driver, ShoppingCartPageUI.GRAND_TOTAL_TEXT, DataUser.ShipCheckOut.GRAND_TOTAL_TEXT_LOCATOR), DataUser.ShipCheckOut.GRAND_TOTAL_TEXT);
		verifyEquals(shoppingCartPage.getTextElement(driver, ShoppingCartPageUI.GRAND_TOTAL_PRICE, DataUser.ShipCheckOut.GRAND_TOTAL_TEXT_LOCATOR), DataUser.ShipCheckOut.GRAND_TOTAL_IPHONE_PRICE);
	}
	
	@Test
	public void FrontEndFunction_05_NotOver500Items() {
		log.info("FrontEndFunction_05 - Step 01. Open LiveGuru99 site");
		homePage = (HomePageObject) shoppingCartPage.openLiveGuru99(driver); 
		verifyEquals(homePage.getTextElement(driver, HomePageUI.HOMEPAGE_TITLE, DataUser.HomePage.HOMEPAGE_TITLE_LOCATOR), DataUser.HomePage.HOMEPAGE_TITLE);
		verifyTrue(homePage.isContainedAttributeValue(driver, AbstractPageUI.DYNAMIC_IMAGE, "src", DataUser.HomePage.HOMEPAGE_IMG, DataUser.HomePage.HOMEPAGE_IMG_LOCATOR));
		
		log.info("FrontEndFunction_05 - Step 02. Click on 'MOBILE' menu");
		productPage = (ProductPageObject) homePage.openDynamicProductPage(driver, "Mobile");
		verifyEquals(productPage.getTextElement(driver, ProductPageUI.PRODUCT_PAGE_TITLE, DataUser.Product.Mobile.MOBILE_PAGE_TITLE_LOCATOR), DataUser.Product.Mobile.MOBILE_PAGE_TITLE);
		
		log.info("FrontEndFunction_05 - Step 03. Add SONY XPERIA to cart");		
		shoppingCartPage = (ShoppingCartPageObject) productPage.openShoppingCartPage(driver, "Sony Xperia");
		verifyEquals(shoppingCartPage.getTextElement(driver, ShoppingCartPageUI.SHOPPING_CART_PAGE_TITLE, DataUser.ShipCheckOut.SHOPPING_CART_PAGE_TITLE_LOCATOR), DataUser.ShipCheckOut.SHOPPING_CART_PAGE_TITLE);
		
		log.info("FrontEndFunction_05 - Step 04a. Change QTY_value to 501");
		shoppingCartPage.inputToDynamicQTYTextbox(driver, "Sony Xperia", "501");
		
		log.info("FrontEndFunction_05 - Step 04b. Click UPDATE button");
		shoppingCartPage.clickOnUpdateButton(driver, "Sony Xperia");
		
		log.info("FrontEndFunction_05 - Step 05. Verify '* The maximum quantity allowed for purchase is 500.' message is displayed!!");
		verifyEquals(shoppingCartPage.getTextElement(driver, ShoppingCartPageUI.ERROR_MAX_500_QUANTITY_MESSAGE, DataUser.ShipCheckOut.ERROR_MAX_500_QUANTITY_MESSAGE_LOCATOR).trim(),  DataUser.ShipCheckOut.ERROR_MAX_500_QUANTITY_MESSAGE);
		
		log.info("FrontEndFunction_05 - Step 06a. Close IFrame");
		shoppingCartPage.closeIFrame(driver);
		log.info("FrontEndFunction_05 - Step 06b. Click on EMPTY_CART link");
		shoppingCartPage.clickOnDynamicLinkOrButton(driver, "Empty Cart");
		
		log.info("FrontEndFunction_05 - Step 07a. Verify 'SHOPPING CART IS EMPTY' title is displayed!!");
		verifyEquals(shoppingCartPage.getTextElement(driver, ShoppingCartPageUI.EMPTY_CART_MESSAGE, DataUser.ShipCheckOut.EMPTY_CART_MESSAGE_LOCATOR), DataUser.ShipCheckOut.EMPTY_CART_MESSAGE);
		
		log.info("FrontEndFunction_05 - Step 07b. Verify 'You have no items in your shopping cart.' title is displayed!!");
		verifyEquals(shoppingCartPage.getTextElement(driver, ShoppingCartPageUI.NO_ITEM_MESSAGE, DataUser.ShipCheckOut.NO_ITEMS_MESSAGE_LOCATOR), DataUser.ShipCheckOut.NO_ITEMS_MESSAGE);		
	}
	
	@Test
	public void FrontEndFunction_06_Comparison() {
		log.info("FrontEndFunction_06 - Step 01. Open LiveGuru99 site");
		homePage = (HomePageObject) shoppingCartPage.openLiveGuru99(driver); 
		verifyEquals(homePage.getTextElement(driver, HomePageUI.HOMEPAGE_TITLE, DataUser.HomePage.HOMEPAGE_TITLE_LOCATOR), DataUser.HomePage.HOMEPAGE_TITLE);
		verifyTrue(homePage.isContainedAttributeValue(driver, AbstractPageUI.DYNAMIC_IMAGE, "src", DataUser.HomePage.HOMEPAGE_IMG, DataUser.HomePage.HOMEPAGE_IMG_LOCATOR));
		
		log.info("FrontEndFunction_06 - Step 02. Click on 'MOBILE' menu");
		productPage = (ProductPageObject) homePage.openDynamicProductPage(driver, "Mobile");
		verifyEquals(productPage.getTextElement(driver, ProductPageUI.PRODUCT_PAGE_TITLE, DataUser.Product.Mobile.MOBILE_PAGE_TITLE_LOCATOR), DataUser.Product.Mobile.MOBILE_PAGE_TITLE);
		
		log.info("FrontEndFunction_06 - Step 03a. Click 'Add to Compare' for IPHONE");
		productPage.clickOnCompareButton(driver, "IPhone");
		verifyEquals(productPage.getTextElement(driver, AbstractPageUI.SUCCESS_MESSAGE), DataUser.Product.Mobile.IPHONE_COMPARED_MESSAGE);
		
		log.info("FrontEndFunction_06 - Step 03b. Click 'Add to Compare' for SONY XPERIA");
		productPage.clickOnCompareButton(driver, "Sony Xperia");
		verifyEquals(productPage.getTextElement(driver, AbstractPageUI.SUCCESS_MESSAGE), DataUser.Product.Mobile.XPERIA_COMPARED_MESSAGE);
		
		log.info("FrontEndFunction_06 - Step 04. Click on 'COMPARE' button to open POPUP window");
		popUpPage = (PopUpPageObject) productPage.openPopUpPage(driver);
		
		log.info("FrontEndFunction_06 - Step 05. Verify POPUP window");
		log.info("FrontEndFunction_06 - Step 05a. Verify POPUP_BROWSER_PAGE_TITLE");
		verifyEquals(popUpPage.getPageTitle(driver), DataUser.PopUp.POPUP_BROWSER_PAGE_TITLE);
		log.info("FrontEndFunction_06 - Step 05b. Verify POPUP_HEADER_PAGE_TITLE");
		verifyEquals(popUpPage.getTextElement(driver, PopUpWindowPageUI.POPUP_PAGE_TITLE, DataUser.PopUp.POPUP_HEADER_PAGE_TITLE_LOCATOR), DataUser.PopUp.POPUP_HEADER_PAGE_TITLE);
		log.info("FrontEndFunction_06 - Step 05c. Verify POPUP's product_NAME");
		verifyEquals(popUpPage.getTextElement(driver, PopUpWindowPageUI.DYNAMIC_PRODUCT_NAME, DataUser.PopUp.XPERIA_NAME_LOCATOR), DataUser.PopUp.XPERIA_NAME);
		verifyEquals(popUpPage.getTextElement(driver, PopUpWindowPageUI.DYNAMIC_PRODUCT_NAME, DataUser.PopUp.IPHONE_NAME_LOCATOR), DataUser.PopUp.IPHONE_NAME);
		log.info("FrontEndFunction_06 - Step 05d. Verify POPUP's product_PRICE");
		verifyEquals(popUpPage.getTextElement(driver, PopUpWindowPageUI.DYNAMIC_PRODUCT_REGULAR_PRICE, DataUser.PopUp.XPERIA_NAME_LOCATOR), DataUser.PopUp.XPERIA_PRICE);
		verifyEquals(popUpPage.getTextElement(driver, PopUpWindowPageUI.DYNAMIC_PRODUCT_REGULAR_PRICE, DataUser.PopUp.IPHONE_NAME_LOCATOR), DataUser.PopUp.IPHONE_PRICE);
		log.info("FrontEndFunction_06 - Step 05d. Verify POPUP's product_IMAGE");
		verifyTrue(popUpPage.isContainedAttributeValue(driver, AbstractPageUI.DYNAMIC_IMAGE, "src", DataUser.PopUp.XPERIA_IMAGE, DataUser.PopUp.XPERIA_IMAGE_LOCATOR));
		verifyTrue(popUpPage.isContainedAttributeValue(driver, AbstractPageUI.DYNAMIC_IMAGE, "src", DataUser.PopUp.IPHONE_IMAGE, DataUser.PopUp.IPHONE_IMAGE_LOCATOR));
		log.info("FrontEndFunction_06 - Step 05d. Verify POPUP's product_SKU");
		verifyEquals(popUpPage.getTextElement(driver, PopUpWindowPageUI.SKU_CODE, DataUser.PopUp.XPERIA_SKU_LOCATOR), DataUser.PopUp.XPERIA_SKU);
		verifyEquals(popUpPage.getTextElement(driver, PopUpWindowPageUI.SKU_CODE, DataUser.PopUp.IPHONE_SKU_LOCATOR), DataUser.PopUp.IPHONE_SKU);
		
		log.info("FrontEndFunction_06 - Step 06. Close POPUP window");
		productPage = (ProductPageObject) popUpPage.closeAllWindowsWithoutParentByTitle(driver, parentWindowID, "Mobile");	
	}
	
	@Test
	public void FrontEndFunction_07_ShareWishList() {
		log.info("FrontEndFunction_07 - Step 01. Open LiveGuru99 site");
		homePage = (HomePageObject) productPage.openLiveGuru99(driver);
		verifyEquals(homePage.getTextElement(driver, HomePageUI.HOMEPAGE_TITLE, DataUser.HomePage.HOMEPAGE_TITLE_LOCATOR), DataUser.HomePage.HOMEPAGE_TITLE);
		verifyTrue(homePage.isContainedAttributeValue(driver, AbstractPageUI.DYNAMIC_IMAGE, "src", DataUser.HomePage.HOMEPAGE_IMG, DataUser.HomePage.HOMEPAGE_IMG_LOCATOR));
		
		log.info("FrontEndFunction_07 - Step 02. Click on 'TV' menu");
		productPage = (ProductPageObject) homePage.openDynamicProductPage(driver, "TV");
		verifyEquals(productPage.getTextElement(driver, ProductPageUI.PRODUCT_PAGE_TITLE, DataUser.Product.TV.TV_PAGE_TITLE_LOCATOR), DataUser.Product.TV.TV_PAGE_TITLE);
		
		log.info("FrontEndFunction_07 - Step 03. Add 'LG-LCD' to Wishlist");
		myWishListPage = (MyWishListPageObject) productPage.openDynamicWishListPage(driver, "LG LCD");
		verifyEquals(myWishListPage.getTextElement(driver, MyWishListPageUI.MY_WISHLIST_PAGE_TITLE, DataUser.WishList.MY_WISHLIST_PAGE_TITLE_LOCATOR), DataUser.WishList.MY_WISHLIST_PAGE_TITLE);
		
		log.info("FrontEndFunction_07 - Step 04. Click on 'SHARE WISHLIST' button");
		wishListSharingPage = (WishListSharingPageObject) myWishListPage.openWishListSharingPage(driver);
		verifyEquals(wishListSharingPage.getTextElement(driver, WishListSharingPageUI.WISHLIST_SHARING_PAGE_TITLE, DataUser.WishList.WISHLIST_SHARING_PAGE_TITLE_LOCATOR), DataUser.WishList.WISHLIST_SHARING_PAGE_TITLE);
		
		log.info("FrontEndFunction_07 - Step 05a. Enter Email address");
		wishListSharingPage.inputToDynamicTextArea(driver, "email_address", email);
		log.info("FrontEndFunction_07 - Step 05b. Enter Message");
		wishListSharingPage.inputToDynamicTextArea(driver, "message", DataUser.WishList.MESSAGE);
		log.info("FrontEndFunction_07 - Step 05c. Click on 'SHARE WISHLIST' button");
		myWishListPage = (MyWishListPageObject) wishListSharingPage.openWishListPageFromSharing(driver);
		
		log.info("FrontEndFunction_07 - Step 06. Verify 'MY WISHLIST' page have 1 item");
		verifyEquals(myWishListPage.GetAmountOfProductWishList(driver), amountOfProducts);
		log.info("'MY WISHLIST' page have " + myWishListPage.GetAmountOfProductWishList(driver) + " item");
		myWishListPage.GetTextOfProductWishList(driver);
		
	}
	
	@Test
	public void FrontEndFunction_08_AddReview() {
		log.info("FrontEndFunction_08 - Step 01. Open LiveGuru99 site");
		homePage = (HomePageObject) myWishListPage.openLiveGuru99(driver);
		verifyEquals(homePage.getTextElement(driver, HomePageUI.HOMEPAGE_TITLE, DataUser.HomePage.HOMEPAGE_TITLE_LOCATOR), DataUser.HomePage.HOMEPAGE_TITLE);
		verifyTrue(homePage.isContainedAttributeValue(driver, AbstractPageUI.DYNAMIC_IMAGE, "src", DataUser.HomePage.HOMEPAGE_IMG, DataUser.HomePage.HOMEPAGE_IMG_LOCATOR));
		
		log.info("FrontEndFunction_08 - Step 02. Click on 'TV' menu");
		productPage = (ProductPageObject) homePage.openDynamicProductPage(driver, "TV");
		verifyEquals(productPage.getTextElement(driver, ProductPageUI.PRODUCT_PAGE_TITLE, DataUser.Product.TV.TV_PAGE_TITLE_LOCATOR), DataUser.Product.TV.TV_PAGE_TITLE);
			
		log.info("FrontEndFunction_08 - Step 03. Click on SAMSUNG LCD detail");
		detailPage = (DetailPageObject) productPage.openDetailProductPage(driver, "Samsung LCD");
		verifyEquals(detailPage.getTextElement(driver, DetailPageUI.DETAIL_PRODUCT_PAGE_TITLE), DataUser.Product.TV.SAMSUNG_NAME);
		
		log.info("FrontEndFunction_08 - Step 04. Click on 'ADD YOUR REVIEW' link");
		reviewPage = (ReviewPageObject) detailPage.openReviewPage(driver);
		verifyEquals(reviewPage.getTextElement(driver, ReviewPageUI.REVIEW_PAGE_BREADCRUMB), DataUser.Review.REVIEW_PAGE_TITLE);
		
		log.info("FrontEndFunction_08 - Step 05. Input empty_data to 3 fields");
		reviewPage.inputToDynamicTextArea(driver, "review_field", DataUser.Review.EMPTY_MESSAGE);
		reviewPage.inputToDynamicTextbox(driver, "summary_field", DataUser.Review.EMPTY_MESSAGE);
		reviewPage.inputToDynamicTextbox(driver, "nickname_field", DataUser.Review.EMPTY_MESSAGE);
		
		log.info("FrontEndFunction_08 - Step 06a. Click 'SUBMIT REVIEW' button");
		reviewPage.clickOnDynamicLinkOrButton(driver, "Submit Review");
		
		log.info("FrontEndFunction_08 - Step 06b. Verify ERROR message is displayed!!");
		verifyEquals(reviewPage.getTextElement(driver, AbstractPageUI.DYNAMIC_TEXTAREA_ERROR_MESSAGE, "review_field"), DataUser.Review.ERROR_MESSAGE);
		verifyEquals(reviewPage.getTextElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_ERROR_MESSAGE, "summary_field"), DataUser.Review.ERROR_MESSAGE);
		verifyEquals(reviewPage.getTextElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_ERROR_MESSAGE, "nickname_field"), DataUser.Review.ERROR_MESSAGE);
		
		log.info("FrontEndFunction_08 - Step 07. Input valid_data to 3 fields");
		reviewPage.inputToDynamicTextArea(driver, "review_field", DataUser.Review.THOUGHS_SAMSUNG);
		reviewPage.inputToDynamicTextbox(driver, "summary_field", DataUser.Review.SUMMARY_SAMSUNG);
		reviewPage.inputToDynamicTextbox(driver, "nickname_field", DataUser.Review.NICKCNAME);
		
		log.info("FrontEndFunction_08 - Step 08a. Click 'SUBMIT REVIEW' button");
		reviewPage.clickOnDynamicLinkOrButton(driver, "Submit Review");
		
		log.info("FrontEndFunction_08 - Step 08b. Verify ACCEPTED message is displayed!!");
		verifyEquals(reviewPage.getTextElement(driver, AbstractPageUI.SUCCESS_MESSAGE), DataUser.Review.SUCCESS_REVIEW_MESSAGE);
	}
	
	@Test
	public void FrontEndFunction_09_PurchaseProduct() {
		log.info("FrontEndFunction_09 - Step 01. Open LiveGuru99 site");
		homePage = (HomePageObject) reviewPage.openLiveGuru99(driver);
		verifyEquals(homePage.getTextElement(driver, HomePageUI.HOMEPAGE_TITLE, DataUser.HomePage.HOMEPAGE_TITLE_LOCATOR), DataUser.HomePage.HOMEPAGE_TITLE);
		verifyTrue(homePage.isContainedAttributeValue(driver, AbstractPageUI.DYNAMIC_IMAGE, "src", DataUser.HomePage.HOMEPAGE_IMG, DataUser.HomePage.HOMEPAGE_IMG_LOCATOR));
		
		log.info("FrontEndFunction_09 - Step 02. Click on 'MY WISHLIST' link in ACCOUNT menu");
		homePage.clickOnAccountMenu(driver);
		myWishListPage = (MyWishListPageObject) homePage.openMenuWishListPage(driver);
		
		log.info("FrontEndFunction_09 - Step 03. Click on 'ADD TO CART' button");
		myWishListPage.clickOnDynamicLinkOrButton(driver, "Add to Cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("FrontEndFunction_09 - Step 04a. Choose COUNTRY to be United States");
		shoppingCartPage.selectItemInDropdown(driver, ShoppingCartPageUI.DROPDOWN_LIST, DataUser.ShipCheckOut.COUNTRY, "country");
		log.info("FrontEndFunction_09 - Step 04b. Choose PROVINCE/STATE to be New York");
		shoppingCartPage.selectItemInDropdown(driver, ShoppingCartPageUI.DROPDOWN_LIST, DataUser.ShipCheckOut.STATE, "region_id");
		log.info("FrontEndFunction_09 - Step 04c. Input ZIP_CODE");
		shoppingCartPage.inputToDynamicTextbox(driver, "postcode", DataUser.ShipCheckOut.ZIP);
		
		log.info("FrontEndFunction_09 - Step 05. Click on 'Estimate' link");
		shoppingCartPage.clickOnDynamicLinkOrButton(driver, "Estimate");
		
		log.info("FrontEndFunction_09 - Step 06. Verify Shipping_cost is generated");
		verifyEquals(shoppingCartPage.getTextElement(driver, ShoppingCartPageUI.SHIPPING_COST), DataUser.ShipCheckOut.SHIPPING_COST);
		
		log.info("FrontEndFunction_09 - Step 07a. Select Shipping_cost(Fixed - $5.00)");
		shoppingCartPage.clickToDynamicRadioButton(driver, "s_method_flatrate_flatrate");
		
		log.info("FrontEndFunction_09 - Step 07b. Click on 'UPDATE TOTAL' button");
		shoppingCartPage.clickOnDynamicLinkOrButton(driver, "Update Total");
		
		log.info("FrontEndFunction_09 - Step 08. Verify Shipping_cost is add to GRAND TOTAL");
		verifyEquals(shoppingCartPage.getTextElement(driver, ShoppingCartPageUI.SHIPPING_COST), DataUser.ShipCheckOut.SHIPPING_COST);
		
		log.info("FrontEndFunction_09 - Step 09. Click on 'PROCEED TO CHECKOUT' button");
		checkOutPage = (CheckOutPageObject) shoppingCartPage.openCheckOutPage(driver);
		
		log.info("FrontEndFunction_09 - Step 10. Enter 'BILLING INFO'");
		log.info("FrontEndFunction_09 - Step 10a. Scrolling to Address then input");
		checkOutPage.scrollToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "billing:street1");	
		checkOutPage.inputToDynamicTextbox(driver, "billing:street1", DataUser.ShipCheckOut.ADDRESS);
		log.info("FrontEndFunction_09 - Step 10b. Input City");
		checkOutPage.inputToDynamicTextbox(driver, "billing:city", DataUser.ShipCheckOut.CITY);
		log.info("FrontEndFunction_09 - Step 10c. Choose State");
		checkOutPage.selectItemInDropdown(driver, CheckOutPageUI.DROPDOWN_LIST, DataUser.ShipCheckOut.STATE, "billing:region_id");
		log.info("FrontEndFunction_09 - Step 10d. Input Zip code");
		checkOutPage.inputToDynamicTextbox(driver, "billing:postcode", DataUser.ShipCheckOut.ZIP);
		log.info("FrontEndFunction_09 - Step 10e. Choose Country");
		checkOutPage.selectItemInDropdown(driver, CheckOutPageUI.DROPDOWN_LIST, DataUser.ShipCheckOut.COUNTRY, "billing:country_id");
		log.info("FrontEndFunction_09 - Step 10f. Input Telephone");
		checkOutPage.inputToDynamicTextbox(driver, "billing:telephone", DataUser.ShipCheckOut.TELEPHONE);
		log.info("FrontEndFunction_09 - Step 10g. Click Continue");
		checkOutPage.clickOnDynamicLinkOrButton(driver, "Continue");
		
		log.info("FrontEndFunction_09 - Step 11. In 'SHIPPING METHOD', click 'Continue' button");
		checkOutPage.ClickToContinueButton(driver, CheckOutPageUI.CONTINUE_BUTTON, "shipping-method-buttons-container");
		
		log.info("FrontEndFunction_09 - Step 12a. In 'PAYMENT INFO', select 'Check / Money Order'");
		checkOutPage.clickToDynamicRadioButton(driver, "p_method_checkmo");
		log.info("FrontEndFunction_09 - Step 12b. In 'PAYMENT INFO', click 'Continue' button");
		checkOutPage.ClickToContinueButton(driver, CheckOutPageUI.CONTINUE_BUTTON, "payment-buttons-container");
		
		log.info("FrontEndFunction_09 - Step 13. Click on 'PLACE ORDER' button");
		successOrderPage = (SuccessOrderPageObject) checkOutPage.openSuccessOrderPage(driver);
		
		log.info("FrontEndFunction_09 - Step 14a. Verify SUCCESS_ORDER PAGE");
		verifyEquals(successOrderPage.getTextElement(driver, SuccessOrderPageUI.SUCCESS_ORDER_PAGE_TITLE, DataUser.ShipCheckOut.SUCCESS_ORDER_PAGE_TITLE_LOCATOR),  DataUser.ShipCheckOut.SUCCESS_ORDER_PAGE_TITLE);
		log.info("FrontEndFunction_09 - Step 14b. Verify Order is generated");
		verifyTrue(successOrderPage.isOrderNoDisplay(driver));
		log.info("FrontEndFunction_09 - Step 14c. Print the order's No.");
		successOrderPage.getTextElement(driver, SuccessOrderPageUI.ORDER_SERIAL_NUMBER);
	}
	
	@Test
	public void FrontEndFunction_10_Search() {
		log.info("FrontEndFunction_10 - Step 01. Open LiveGuru99 site");
		homePage = (HomePageObject) successOrderPage.openLiveGuru99(driver);
		verifyEquals(homePage.getTextElement(driver, HomePageUI.HOMEPAGE_TITLE, DataUser.HomePage.HOMEPAGE_TITLE_LOCATOR), DataUser.HomePage.HOMEPAGE_TITLE);
		verifyTrue(homePage.isContainedAttributeValue(driver, AbstractPageUI.DYNAMIC_IMAGE, "src", DataUser.HomePage.HOMEPAGE_IMG, DataUser.HomePage.HOMEPAGE_IMG_LOCATOR));
		
		log.info("FrontEndFunction_10 - Step 02. Click on 'Advance Search' link");
		advancedSearchPage = (AdvancedSearchPageObject) homePage.openAdvancedSearchPage(driver);
		verifyEquals(advancedSearchPage.getTextElement(driver, AdvancedSearchPageUI.SEARCH_SETTINGS_MESSAGE, DataUser.AdvanceSearch.SETTINGS_TITLE_LOCATOR), DataUser.AdvanceSearch.SETTINGS_TITLE);
		
		log.info("FrontEndFunction_10 - Step 03a. Enter range 0-150 in Price field");
		advancedSearchPage.inputToDynamicTextbox(driver, "price", DataUser.AdvanceSearch.START_PRICE_01);
		advancedSearchPage.inputToDynamicTextbox(driver, "price_to", DataUser.AdvanceSearch.END_PRICE_01);
		
		log.info("FrontEndFunction_10 - Step 03b. Scrolling then clink on SEARCH button");
		advancedSearchPage.scrollToElement(driver, AdvancedSearchPageUI.ADVANCED_SEARCH_BUTTON);
		advancedSearchResultPage = (AdvancedSearchResultPageObject) advancedSearchPage.openAdvancedSearchResultPage(driver);
		verifyEquals(advancedSearchResultPage.getTextElement(driver, AdvancedSearchResultPageUI.RESULTS_TEXT), DataUser.AdvanceSearch.RESULT_TEXT);
		
		log.info("FrontEndFunction_10 - Step 04. Print result of Product's name and price");
		advancedSearchResultPage.printProductNameAndPrice(driver);
		
		log.info("FrontEndFunction_10 - Step 05a. Scrolling then click on 'Advance Search' link");
		advancedSearchResultPage.scrollToElement(driver, AbstractPageUI.ADVANCED_SEARCH_LINK);
		advancedSearchPage = (AdvancedSearchPageObject) advancedSearchResultPage.openAdvancedSearchPage(driver);
		verifyEquals(advancedSearchPage.getTextElement(driver, AdvancedSearchPageUI.SEARCH_SETTINGS_MESSAGE, DataUser.AdvanceSearch.SETTINGS_TITLE_LOCATOR), DataUser.AdvanceSearch.SETTINGS_TITLE);
		
		log.info("FrontEndFunction_10 - Step 05b. Enter range 151-1000 in Price field");
		advancedSearchPage.inputToDynamicTextbox(driver, "price", DataUser.AdvanceSearch.START_PRICE_02);
		advancedSearchPage.inputToDynamicTextbox(driver, "price_to", DataUser.AdvanceSearch.END_PRICE_02);
		
		log.info("FrontEndFunction_10 - Step 05c. Scrolling then clink on SEARCH button");
		advancedSearchPage.scrollToElement(driver, AdvancedSearchPageUI.ADVANCED_SEARCH_BUTTON);
		advancedSearchResultPage = (AdvancedSearchResultPageObject) advancedSearchPage.openAdvancedSearchResultPage(driver);
		verifyEquals(advancedSearchResultPage.getTextElement(driver, AdvancedSearchResultPageUI.RESULTS_TEXT), DataUser.AdvanceSearch.RESULT_TEXT);
		
		log.info("FrontEndFunction_10 - Step 06. Print result of Product's name and price");
		advancedSearchResultPage.printProductNameAndPrice(driver);
	}
	
	@AfterClass(alwaysRun = true)
	public void cleanData() {
		closeBrowserAndDriver(driver);
	}
	
	WebDriver driver;
	String email;
	String priceXperiaProductPage, priceXperiaDetailPage;
	String parentWindowID;
	int amountOfProducts;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	ProductPageObject productPage;
	DetailPageObject detailPage;
	ShoppingCartPageObject shoppingCartPage;
	PopUpPageObject popUpPage;
	ReviewPageObject reviewPage;
	MyDashboardPageObject myDashboardPage;
	AccountInfoPageObject accountInfoPage;
	MyWishListPageObject myWishListPage;
	WishListSharingPageObject wishListSharingPage;
	CheckOutPageObject checkOutPage;
	SuccessOrderPageObject successOrderPage;
	AdvancedSearchPageObject advancedSearchPage;
	AdvancedSearchResultPageObject advancedSearchResultPage;
	
}
