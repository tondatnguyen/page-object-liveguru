package commonsLiveGuru;

import org.openqa.selenium.WebDriver;
import pageObjectsLiveGuru.AccountInfoPageObject;
import pageObjectsLiveGuru.AdvancedSearchPageObject;
import pageObjectsLiveGuru.AdvancedSearchResultPageObject;
import pageObjectsLiveGuru.CheckOutPageObject;
import pageObjectsLiveGuru.DetailPageObject;
import pageObjectsLiveGuru.HomePageObject;
import pageObjectsLiveGuru.LoginPageObject;
import pageObjectsLiveGuru.ProductPageObject;
import pageObjectsLiveGuru.MyDashboardPageObject;
import pageObjectsLiveGuru.PopUpPageObject;
import pageObjectsLiveGuru.RegisterPageObject;
import pageObjectsLiveGuru.ReviewPageObject;
import pageObjectsLiveGuru.ShoppingCartPageObject;
import pageObjectsLiveGuru.SuccessOrderPageObject;
import pageObjectsLiveGuru.MyWishListPageObject;
import pageObjectsLiveGuru.WishListSharingPageObject;

public class PageGeneratorManager {
	
	static RegisterPageObject registerPage;
	static LoginPageObject loginPage;
	static HomePageObject homePage;
	static ProductPageObject productPage;
	static DetailPageObject detailProductPage;
	static ShoppingCartPageObject shoppingCartPage;
	static CheckOutPageObject checkOutPage;
	static SuccessOrderPageObject successOrderPage;
	static ReviewPageObject reviewPage;
	static AdvancedSearchPageObject advancedSearchPage;
	static AdvancedSearchResultPageObject advancedSearchResultPage;
	static MyDashboardPageObject myDashboardPage;
	static AccountInfoPageObject accountInfoPage;
	static MyWishListPageObject myWishListPage;
	static WishListSharingPageObject wishListSharingPage;
	static PopUpPageObject popUpWindowsPage;
	  
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
	
	public static ProductPageObject getProductPage(WebDriver driver) {	
		if(productPage == null) {
			productPage = new ProductPageObject(driver);
		}
		return productPage;
	}

	public static DetailPageObject getDetailPage(WebDriver driver) {	
		if(detailProductPage == null) {
			detailProductPage = new DetailPageObject(driver);
		}
		return detailProductPage;
	}
	
	public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {	
		if(shoppingCartPage == null) {
			shoppingCartPage = new ShoppingCartPageObject(driver);
		}
		return shoppingCartPage;
	}
	
	public static SuccessOrderPageObject getSuccessOrderPage(WebDriver driver) {	
		if(successOrderPage == null) {
			successOrderPage = new SuccessOrderPageObject(driver);
		}
		return successOrderPage;
	}
	
	public static ReviewPageObject getReviewPage(WebDriver driver) {	
		if(reviewPage == null) {
			reviewPage = new ReviewPageObject(driver);
		}
		return reviewPage;
	}
	
	public static AdvancedSearchPageObject getAdvanceSearchPage(WebDriver driver) {	
		if(advancedSearchPage == null) {
			advancedSearchPage = new AdvancedSearchPageObject(driver);
		}
		return advancedSearchPage;
	}

	public static AdvancedSearchResultPageObject getAdvanceSearchResultPage(WebDriver driver) {	
		if(advancedSearchResultPage == null) {
			advancedSearchResultPage = new AdvancedSearchResultPageObject(driver);
		}
		return advancedSearchResultPage;
	}
	
	public static MyDashboardPageObject getMyDashboardPage(WebDriver driver) {	
		if(myDashboardPage == null) {
			myDashboardPage = new MyDashboardPageObject(driver);
		}
		return myDashboardPage;
	}
	
	public static AccountInfoPageObject getAccountInfoPage(WebDriver driver) {	
		if(accountInfoPage == null) {
			accountInfoPage = new AccountInfoPageObject(driver);
		}
		return accountInfoPage;
	}
	
	public static MyWishListPageObject getMyWishListPage(WebDriver driver) {	
		if(myWishListPage == null) {
			myWishListPage = new MyWishListPageObject(driver);
		}
		return myWishListPage;
	}

	public static WishListSharingPageObject getWishListSharingPage(WebDriver driver) {	
		if(wishListSharingPage == null) {
			wishListSharingPage = new WishListSharingPageObject(driver);
		}
		return wishListSharingPage;
	}
	
	public static CheckOutPageObject getCheckOutPage(WebDriver driver) {	
		if(checkOutPage == null) {
			checkOutPage = new CheckOutPageObject(driver);
		}
		return checkOutPage;
	}
	
	public static PopUpPageObject getPopUpWindowsPage(WebDriver driver) {	
		if(popUpWindowsPage == null) {
			popUpWindowsPage = new PopUpPageObject(driver);
		}
		return popUpWindowsPage;
	}

}
