package commonsLiveGuru;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.liveguru.testdata.DataUser;

import pageUIsLiveGuru.AbstractPageUI;
import pageUIsLiveGuru.AdvancedSearchPageUI;
import pageUIsLiveGuru.DetailPageUI;
import pageUIsLiveGuru.ProductPageUI;
import pageUIsLiveGuru.ShoppingCartPageUI;


public class AbstractPage {

	/* Web Browser */
	public void openUrl(WebDriver driver, String urlValue) {
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(Constants.LONG_TIMEOUT, TimeUnit.SECONDS);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void waitForAlertPresent(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
		sleepInSecond(driver, 2);
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	/* Web Element */
	public void clickToElement(WebDriver driver, String locator) {
	//	highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		if (driver.toString().contains("internetexplorer")) {
			clickToElementByjavascriptExecutor(driver, locator);
			sleepInSecond(driver, 5);
		} else {
			element.click();
		}
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
	//	highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		if (driver.toString().contains("internetexplorer")) {
			clickToElementByjavascriptExecutor(driver, locator);
			sleepInSecond(driver, 5);
		} else {
			element.click();
		}
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
	//	highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String sendkeyValue, String... values) {
		locator = String.format(locator, (Object[]) values);
	//	highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(sendkeyValue);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemText) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(itemText);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemText, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(itemText);
	}
	
	public String getSelectedItemInDropdown(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void selectAnItemInCustomDropdown(WebDriver driver, String parentLocator, String ItemsOfDropdownLocator,
			String expectedText) throws Exception {
		javascriptExecutor = (JavascriptExecutor) driver;
		explicitWait = new WebDriverWait(driver, 30);

		element = driver.findElement(By.xpath(parentLocator));
		javascriptExecutor.executeScript("arguments[0].click()", element);
		Thread.sleep(1000);

		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ItemsOfDropdownLocator)));

		elements = driver.findElements(By.xpath(ItemsOfDropdownLocator));
		for (WebElement anItem : elements) {
			if (anItem.getText().contains(expectedText)) {
				if (anItem.isDisplayed()) {
					anItem.click();
				} else {
					javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", anItem);
					Thread.sleep(1000);
					javascriptExecutor.executeScript("arguments[0].click()", anItem);
				}
				Thread.sleep(1000);
				break;
			}
		}
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}
	
	public String getTextElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	
	public String getTextElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkToCheckbox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlUndisplayed(WebDriver driver, String locator) {
		// Set 5s
		overrideGlobalTimeout(driver, Constants.SHORT_TIMEOUT);
		List<WebElement> elements = driver.findElements(By.xpath(locator));

		if (elements.size() == 0) {
			// Set 30s
			overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			// Set 30s
			overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
			return true;
		} else {
			// Set 30s
			highlightElement(driver, locator);
			overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
			return false;
		}
	}

	public void overrideGlobalTimeout(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlUndisplayed(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);

		// Set 5s
		overrideGlobalTimeout(driver, Constants.SHORT_TIMEOUT);
		List<WebElement> elements = driver.findElements(By.xpath(locator));

		if (elements.size() == 0) {
			// Set 30s
			overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			// Set 30s
			overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
			return true;
		} else {
			// Set 30s
			highlightElement(driver, locator);
			overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
			return false;
		}
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWindowsWithoutParent(WebDriver driver, String parentWindow) {
		allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}
	
	public AbstractPage closeAllWindowsWithoutParentByTitle(WebDriver driver, String parentWindowID, String parentWindowTitle) {
		allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			if(!driver.getTitle().equals(parentWindowTitle)) {
				driver.close();	
			}
		}
		driver.switchTo().window(parentWindowID);
		return PageGeneratorManager.getProductPage(driver);
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void rightClick(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, String locatorSource, String locatorTarget) {
		elementSource = driver.findElement(By.xpath(locatorSource));
		elementTarget = driver.findElement(By.xpath(locatorTarget));
		action = new Actions(driver);
		action.dragAndDrop(elementSource, elementTarget).perform();
	}

	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaSript) {
		javascriptExecutor = (JavascriptExecutor) driver;
		return javascriptExecutor.executeScript(javaSript);
	}

	public void clickToElementByjavascriptExecutor(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollToElement(WebDriver driver, String locator, String... nameTitle) {
		locator = String.format(locator, (Object[]) nameTitle);
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void sendkeyToElementByjavascriptExecutor(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public void scrollToBottomPage(WebDriver driver) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		String originalStyle = element.getAttribute("style");
		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 5px solid red; border-style: dashed;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
		javascriptExecutor = (JavascriptExecutor) driver;
		String textActual = (String) javascriptExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public boolean checkAnyImageLoaded(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) javascriptExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				element);
		if (status) {
			return true;
		} else
			return false;
	}

	public void waitForElementPresence(WebDriver driver, String Locator) {
		By byLocator = By.xpath(Locator);
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}

	public void waitForElementVisible(WebDriver driver, String Locator) {
		By byLocator = By.xpath(Locator);
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}

	public void waitForElementVisible(WebDriver driver, String Locator, String... values) {
		Locator = String.format(Locator, (Object[]) values);
		By byLocator = By.xpath(Locator);
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}

	public void waitForElementInvisible(WebDriver driver, String Locator) {
		By byLocator = By.xpath(Locator);
		explicitWait = new WebDriverWait(driver, shortTimeout);

		overrideGlobalTimeout(driver, Constants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
		overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
	}

	public void waitForElementClickable(WebDriver driver, String Locator) {
		By byLocator = By.xpath(Locator);
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byLocator));
	}

	public void sleepInSecond(WebDriver driver, long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void highlightElement(WebDriver driver, String locator) {
		javascriptExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		String originalStyle = element.getAttribute("style");

		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 3px solid red; border-style: dashed;");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}
	
	public AbstractPage openLiveGuru99(WebDriver driver) {
		openUrl(driver, Constants.TEST_URL);	
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public AbstractPage openDynamicAccountMenuPage(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_ACCOUNT_MENU_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_ACCOUNT_MENU_LINK, pageName);
		switch(pageName) {
		case "Register":
			return PageGeneratorManager.getRegisterPage(driver);
		case "My Account":
			return PageGeneratorManager.getMyDashboardPage(driver);
		case "My Wishlist":
			return PageGeneratorManager.getMyWishListPage(driver);
		default: 
			return PageGeneratorManager.getHomePage(driver);
		}
	}

	public AbstractPage openAccountInfoPage(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MY_ACCOUNT_MENU_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_MY_ACCOUNT_MENU_LINK, pageName);
		return PageGeneratorManager.getAccountInfoPage(driver);
	}
	
	public AbstractPage openDynamicProductPage(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_PRODUCT_MENU_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_PRODUCT_MENU_LINK, pageName);
		return PageGeneratorManager.getProductPage(driver);
	}
	
	public AbstractPage openDetailProductPage(WebDriver driver, String productName) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_PRODUCT_NAME, productName);
		clickToElement(driver, ProductPageUI.DYNAMIC_PRODUCT_NAME, productName);
		return PageGeneratorManager.getDetailPage(driver);
	}
	
	public AbstractPage openReviewPage(WebDriver driver) {
		waitForElementVisible(driver, DetailPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, DetailPageUI.ADD_YOUR_REVIEW_LINK);
		return PageGeneratorManager.getReviewPage(driver);
	}
	
	public AbstractPage openShoppingCartPage(WebDriver driver, String productName) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_PRODUCT_ADD_TO_CART_BUTTON, productName);
		clickToElement(driver, ProductPageUI.DYNAMIC_PRODUCT_ADD_TO_CART_BUTTON, productName);
		return PageGeneratorManager.getShoppingCartPage(driver);
	}

	public AbstractPage openCheckOutPage(WebDriver driver) {
		waitForElementVisible(driver, ShoppingCartPageUI.PROCEED_TO_CHECKOUT_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.PROCEED_TO_CHECKOUT_BUTTON);
		return PageGeneratorManager.getCheckOutPage(driver);
	}

	public AbstractPage openSuccessOrderPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_LINK_OR_BUTTON, "Place Order");
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK_OR_BUTTON, "Place Order");
		return PageGeneratorManager.getSuccessOrderPage(driver);
	}
	
	public AbstractPage openPopUpPage(WebDriver driver) {
		clickOnDynamicLinkOrButton(driver, "Compare");
		switchToWindowByTitle(driver, DataUser.PopUp.POPUP_BROWSER_PAGE_TITLE);
		return PageGeneratorManager.getPopUpWindowsPage(driver);
	}
	
	public AbstractPage openDynamicWishListPage(WebDriver driver, String productName) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_PRODUCT_ADD_TO_WISHLIST_LINK, productName);
		clickToElement(driver, ProductPageUI.DYNAMIC_PRODUCT_ADD_TO_WISHLIST_LINK, productName);
		return PageGeneratorManager.getMyWishListPage(driver);
	}
	
	public AbstractPage openWishListPageFromSharing(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_LINK_OR_BUTTON, "Share Wishlist");
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK_OR_BUTTON, "Share Wishlist");
		return PageGeneratorManager.getMyWishListPage(driver);	
	}
	
	public AbstractPage openMenuWishListPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_ACCOUNT_MENU_LINK, "My Wishlist");
		clickToElement(driver, AbstractPageUI.DYNAMIC_ACCOUNT_MENU_LINK, "My Wishlist");
		return PageGeneratorManager.getMyWishListPage(driver);
	}
	
	public AbstractPage openWishListSharingPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_LINK_OR_BUTTON, "Share Wishlist");
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK_OR_BUTTON, "Share Wishlist");
		return PageGeneratorManager.getWishListSharingPage(driver);	
	}
	
	public AbstractPage openAdvancedSearchPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.ADVANCED_SEARCH_LINK);
		clickToElement(driver, AbstractPageUI.ADVANCED_SEARCH_LINK);
		return PageGeneratorManager.getAdvanceSearchPage(driver);
	}
	
	public AbstractPage openAdvancedSearchResultPage(WebDriver driver) {
		waitForElementVisible(driver, AdvancedSearchPageUI.ADVANCED_SEARCH_BUTTON);
		clickToElement(driver, AdvancedSearchPageUI.ADVANCED_SEARCH_BUTTON);
		return PageGeneratorManager.getAdvanceSearchResultPage(driver);
	}
	
	// Amount of pages: 100 -1000 pages
	public void openPagesWithLocatorsWithoutReturn(WebDriver driver, String typeOfLocator, String pageName) {
		waitForElementVisible(driver, typeOfLocator, pageName);
		clickToElement(driver, typeOfLocator, pageName);
	}
	
	public void clickOnAccountMenu(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.ACCOUNT_MENU);
		clickToElement(driver, AbstractPageUI.ACCOUNT_MENU);
	}
	
	public void clickOnDynamicLinkOrButton(WebDriver driver, String titleName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_LINK_OR_BUTTON, titleName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK_OR_BUTTON, titleName);
	}
	
	public void clickToDynamicRadioButton(WebDriver driver, String attributeValue) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, attributeValue);
		clickToElement(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, attributeValue);
	}

	public void inputToDynamicTextbox(WebDriver driver, String nameID, String value) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, nameID);
		sendkeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, value, nameID);
	}

	public void inputToDynamicTextArea(WebDriver driver, String nameID, String value) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTAREA, nameID);
		sendkeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTAREA, value, nameID);
	}

	public String getErrorMessageOfDynamicTextbox(WebDriver driver, String nameID) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX_ERROR_MESSAGE, nameID);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX_ERROR_MESSAGE, nameID);
	}

	public String getErrorMessageOfDynamicTextArea(WebDriver driver, String nameID) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTAREA_ERROR_MESSAGE, nameID);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_TEXTAREA_ERROR_MESSAGE, nameID);
	}

	public String getRegularPriceOfDynamicProduct(WebDriver driver, String productName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_PRODUCT_REGULAR_PRICE, productName);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_PRODUCT_REGULAR_PRICE, productName);
	}
	
	public String getSpecialPriceOfDynamicProduct(WebDriver driver, String productName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_PRODUCT_SPECIAL_PRICE, productName);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_PRODUCT_SPECIAL_PRICE, productName);
	}
	
//	public void pressTabToDynamicTextbox(WebDriver driver, String nameID) {
//		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, nameID);
//		sendKeyboardToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, Keys.TAB, nameID);
//	}
//
	public boolean isHeaderMessageDisplayed(WebDriver driver, String locator, String message) {
		waitForElementVisible(driver, locator, message);
		return isControlDisplayed(driver, locator, message);
	}

	public boolean isContainedAttributeValue(WebDriver driver, String locator, String attributeName, String expectedValue, String...values) {
		locator = String.format(locator, (Object[]) values);
		waitForElementVisible(driver, locator);
		String actualValue = getAttributeValue(driver, locator, attributeName);
		return actualValue.contains(expectedValue);			
	}
	
	public boolean isEqualPrice(WebDriver driver, String price01, String price02) {
		return price01.equals(price02);
	}
	
	public boolean isDynamicAlertMessageDisplayedAndAcceptAlert(WebDriver driver, String expectedAlertMessage) {
		waitForAlertPresent(driver);
		String actualAlertMessage = getTextAlert(driver);
		acceptAlert(driver);
		return actualAlertMessage.equals(expectedAlertMessage);
	}
	
	// Sort Ascending STRING
	public boolean isStringDataSortedAscending(WebDriver driver, String locator) {
		
		ArrayList<String> arrayList = new ArrayList<>();

		// Find all elements that match with condition (Name/Price/...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// Get text from elementList to add to arrayList
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		System.out.println("---------------------Data displayed on UI:---------------------");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// Copy to an new array-list to SORT in code
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}

		// Execute SORT ASC
		Collections.sort(sortedList);

		System.out.println("------------Data had been SORT ASC:---------------");
		for (String child : sortedList)
			System.out.println(child);

		// Verify 2 arrays to be equal. If not be equal => return FALSE
		return sortedList.equals(arrayList);
	}

	// Sort Descending STRING
	public boolean isStringDataSortedDescending(WebDriver driver, String locator) {
		// Declare an ArrayList
		ArrayList<String> arrayList = new ArrayList<>();

		// Find all elements that match with condition (Name/Price/...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// Get text from elementList to add to arrayList
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		System.out.println("---------------------Data displayed on UI:---------------------");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// Copy to an new array-list to SORT in code
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}

		// Execute SORT DESC
		Collections.sort(sortedList); // Sort ASC
		Collections.reverse(sortedList); // Or using: Collections.sort(sortedList, Collections.reverseOrder());

		System.out.println("------------Data had been SORT DESC:---------------");
		for (String child : sortedList)
			System.out.println(child);

		// Verify 2 arrays to be equal. If not be equal => return FALSE
		return sortedList.equals(arrayList);
	}

	// Sort Ascending FLOAT
	public boolean isFloatDataSortedAscending(WebDriver driver, String locator) {
		// Declare an ArrayList
		ArrayList<Float> arrayList = new ArrayList<Float>();

		// Find all elements that match with condition (Name/Price/...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// Get text from elementList to add to arrayList
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}

		System.out.println("---------------------Data displayed on UI:---------------------");
		for (Float number : arrayList) {
			System.out.println(number);
		}

		// Copy to an new array-list to SORT in code
		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : arrayList) {
			sortedList.add(child);
		}

		// Execute SORT ASC
		Collections.sort(sortedList);

		System.out.println("------------Data had been SORT ASC:---------------");
		for (Float child : sortedList)
			System.out.println(child);

		// Verify 2 arrays to be equal. If not be equal => return FALSE
		return sortedList.equals(arrayList);
	}

	// Sort Descending FLOAT
	public boolean isFloatDataSortedDescending(WebDriver driver, String locator) {
		// Declare an ArrayList
		ArrayList<Float> arrayList = new ArrayList<Float>();

		// Find all elements that match with condition (Name/Price/...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// Get text from elementList to add to arrayList
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}

		System.out.println("---------------------Data displayed on UI:---------------------");
		for (Float number : arrayList) {
			System.out.println(number);
		}

		// Copy to an new array-list to SORT in code
		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : arrayList) {
			sortedList.add(child);
		}

		// Execute SORT DESC
		Collections.sort(sortedList); // Sort ASC
		Collections.reverse(sortedList); // Or using: Collections.sort(sortedList, Collections.reverseOrder());

		System.out.println("------------Data had been SORT DESC:---------------");
		for (Float child : sortedList)
			System.out.println(child);

		// Verify 2 arrays to be equal. If not be equal => return FALSE
		return sortedList.equals(arrayList);
	}

	private WebElement element, elementSource, elementTarget;
	private List<WebElement> elements;
	private Select select;
	private JavascriptExecutor javascriptExecutor;
	private WebDriverWait explicitWait;
	long shortTimeout = 5;
	long longTimeout = Constants.LONG_TIMEOUT;
	private Set<String> allWindows;
	private Actions action;
}
