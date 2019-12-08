package commonsLiveGuru;

import org.openqa.selenium.WebDriver;
import pageObjectsLiveGuru.AccountInfoPageObject;
import pageObjectsLiveGuru.AdvancedSearchPageObject;
import pageObjectsLiveGuru.AdvancedSearchResultPageObject;
import pageObjectsLiveGuru.CheckOutPageObject;
import pageObjectsLiveGuru.DetailPageObject;
import pageObjectsLiveGuru.EditReviewPageObject;
import pageObjectsLiveGuru.BackEndHomePageObject;
import pageObjectsLiveGuru.BackEndLoginPageObject;
import pageObjectsLiveGuru.HomePageObject;
import pageObjectsLiveGuru.InvoicesPageObject;
import pageObjectsLiveGuru.LoginPageObject;
import pageObjectsLiveGuru.ProductPageObject;
import pageObjectsLiveGuru.MyDashboardPageObject;
import pageObjectsLiveGuru.PopUpPageObject;
import pageObjectsLiveGuru.RegisterPageObject;
import pageObjectsLiveGuru.ReviewPageObject;
import pageObjectsLiveGuru.ShoppingCartPageObject;
import pageObjectsLiveGuru.SuccessOrderPageObject;
import pageObjectsLiveGuru.MyWishListPageObject;
import pageObjectsLiveGuru.BackEndOrdersPageObject;
import pageObjectsLiveGuru.PendingReviewsPageObject;
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
	static BackEndLoginPageObject backEndLoginPage;
	static BackEndHomePageObject backEndHomePage;
	static BackEndOrdersPageObject ordersPage;
	static PendingReviewsPageObject pendingReviewsPage;
	static EditReviewPageObject editReviewPage;
	static InvoicesPageObject invoicesPage;
	
	public static BackEndLoginPageObject getBackEndLoginPage(WebDriver driver) {	
		if(backEndLoginPage == null) {
			backEndLoginPage = new BackEndLoginPageObject(driver);
		}
		return backEndLoginPage;
	}
	
	public static BackEndHomePageObject getBackEndHomePage(WebDriver driver) {	
		if(backEndHomePage == null) {
			backEndHomePage = new BackEndHomePageObject(driver);
		}
		return backEndHomePage;
	}

	public static BackEndOrdersPageObject getOrdersPage(WebDriver driver) {	
		if(ordersPage == null) {
			ordersPage = new BackEndOrdersPageObject(driver);
		}
		return ordersPage;
	}
	
	public static PendingReviewsPageObject getPendingReviewsPage(WebDriver driver) {	
		if(pendingReviewsPage == null) {
			pendingReviewsPage = new PendingReviewsPageObject(driver);
		}
		return pendingReviewsPage;
	}
	
	public static EditReviewPageObject getEditReviewPage(WebDriver driver) {	
		if(editReviewPage == null) {
			editReviewPage = new EditReviewPageObject(driver);
		}
		return editReviewPage;
	}
	
	public static InvoicesPageObject getInvoicesPage(WebDriver driver) {	
		if(invoicesPage == null) {
			invoicesPage = new InvoicesPageObject(driver);
		}
		return invoicesPage;
	}
	
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
