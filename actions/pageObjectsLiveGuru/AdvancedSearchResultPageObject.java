package pageObjectsLiveGuru;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonsLiveGuru.AbstractPage;
import pageUIsLiveGuru.AdvancedSearchResultPageUI;

public class AdvancedSearchResultPageObject extends AbstractPage{
	WebDriver driver;
	
	public AdvancedSearchResultPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void printProductNameAndPrice(WebDriver driver) {
		List<WebElement> listName = driver.findElements(By.xpath(AdvancedSearchResultPageUI.LIST_PRODUCT_NAME));
		
		for(WebElement productName : listName) {
			System.out.print("Product name is '" + productName.getText() + "' ");
			
			String productHTMLTextValue = productName.getAttribute("innerHTML");
			if(productHTMLTextValue.equals("Samsung Galaxy") || productHTMLTextValue.equals("LG LCD")) {
				System.out.println("with price to be " + getSpecialPriceOfDynamicProduct(driver, productHTMLTextValue));
			} else {
				System.out.println("with price to be " + getRegularPriceOfDynamicProduct(driver, productHTMLTextValue));
			}
		}
		
	}
	
}
