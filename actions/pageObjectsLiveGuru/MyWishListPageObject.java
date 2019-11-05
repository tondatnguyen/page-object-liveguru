package pageObjectsLiveGuru;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonsLiveGuru.AbstractPage;
import pageUIsLiveGuru.MyWishListPageUI;

public class MyWishListPageObject extends AbstractPage{
	WebDriver driver;
	
	public MyWishListPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public int GetAmountOfProductWishList(WebDriver driver) {
		List<WebElement> listProduct = driver.findElements(By.xpath(MyWishListPageUI.LIST_PRODUCT_WISHLIST));
		return listProduct.size();
	}
	
	public void GetTextOfProductWishList(WebDriver driver) {
		List<WebElement> listProduct = driver.findElements(By.xpath(MyWishListPageUI.LIST_PRODUCT_WISHLIST));
		for(WebElement productName : listProduct) {
			System.out.println("Product name is: " + productName.getText());
		}
	}
}
