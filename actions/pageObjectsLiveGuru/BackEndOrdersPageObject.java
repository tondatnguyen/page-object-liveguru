package pageObjectsLiveGuru;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import commonsLiveGuru.AbstractPage;
import pageUIsLiveGuru.AbstractPageUI;
import pageUIsLiveGuru.BackEndOrdersPageUI;


public class BackEndOrdersPageObject extends AbstractPage {
	WebDriver driver;
	public BackEndOrdersPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void checkFirstOrderCheckbox(WebDriver driver) {
		reFindElement(driver, BackEndOrdersPageUI.FIRST_ORDER_CHECKBOX);
		checkToCheckbox(driver, BackEndOrdersPageUI.FIRST_ORDER_CHECKBOX);
	}
		
	public void clickToViewDropdownListOfOrdersPage (WebDriver driver, String optionValue) {
		waitForElementVisible(driver, BackEndOrdersPageUI.VIEW_DROPDOWN_LIST);
		selectItemInDropdown(driver, BackEndOrdersPageUI.VIEW_DROPDOWN_LIST, optionValue);
		waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
	}
	
	public int getPaginationSize(WebDriver driver) {
		List<WebElement> elementList = driver.findElements(By.xpath(BackEndOrdersPageUI.PAGINATION));
		System.out.println("SIZE IS: " + elementList.size());
		return elementList.size();
	}
	
	public void clickToSelectVisible(WebDriver driver) {
		waitForElementVisible(driver, BackEndOrdersPageUI.SELECT_LINK);
		clickToElement(driver, BackEndOrdersPageUI.SELECT_LINK);
		waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
	}
	
	public void clickToUnSelectVisible(WebDriver driver) {
		waitForElementVisible(driver, BackEndOrdersPageUI.UNSELECT_LINK);
		clickToElement(driver, BackEndOrdersPageUI.UNSELECT_LINK);
		waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
	}
	
	public boolean isAllCheckboxSelected(WebDriver driver) {
		waitForElementVisible(driver, BackEndOrdersPageUI.ALL_CHECKBOX);
 		List<WebElement> elements = driver.findElements(By.xpath(BackEndOrdersPageUI.ALL_CHECKBOX));
 		int countIsSelected = 0;
 		
 		for(WebElement element: elements) {
 			if(element.isSelected()) {
 				countIsSelected ++;
 			}
 		}
 		
 		if(countIsSelected == elements.size()) {
 			System.out.println("Amount of selected checkbox is: " + countIsSelected);
 			return true;
 		} else
 			return false;
	}
	
	public boolean isAllCheckboxUnSelected(WebDriver driver) {
		waitForElementVisible(driver, BackEndOrdersPageUI.ALL_CHECKBOX);
 		List<WebElement> elements = driver.findElements(By.xpath(BackEndOrdersPageUI.ALL_CHECKBOX));
 		int countIsUnSelected = 0;
 		
 		for(WebElement element: elements) {
 			if(!element.isSelected()) {
 				countIsUnSelected ++;
 			}
 		}
 		
 		if(countIsUnSelected == elements.size()) {
 			System.out.println("Amount of un-selected checkbox is: " + countIsUnSelected);
 			return true;
 		} else
 			return false;
	}
}
