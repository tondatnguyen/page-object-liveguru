package commons;

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
import pageUIs.AbstractPageUI;
import commons.PageGeneratorManager;
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
import pageObjects.WithdrawalPageObject;
public class AbstractPage {

	/* Web Browser */
	public void openUrl(WebDriver driver, String urlValue) {
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
		;
	}

	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
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
		highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		if(driver.toString().contains("internetexplorer")) {
			clickToElementByjavascriptExecutor(driver, locator);
			sleepInSecond(driver, 5);
		} else {
			element.click();
		}
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		if(driver.toString().contains("internetexplorer")) {
			clickToElementByjavascriptExecutor(driver, locator);
			sleepInSecond(driver, 5);
		} else {
			element.click();
		}
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String sendkeyValue, String... values) {
		locator = String.format(locator, (Object[]) values);
		highlightElement(driver, locator);
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(sendkeyValue);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String itemText) {
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

	public String getTextElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		highlightElement(driver, locator);
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
		
		if(elements.size()==0) {
			// Set 30s
			overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
			return true;
		} else if(elements.size()>0 && !elements.get(0).isDisplayed()) {
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
		
		if(elements.size()==0) {
			// Set 30s
			overrideGlobalTimeout(driver, Constants.LONG_TIMEOUT);
			return true;
		} else if(elements.size()>0 && !elements.get(0).isDisplayed()) {
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

	public void waitForAlertPresent(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void sleepInSecond(WebDriver driver, long timeInSecond) {
		try {
			Thread.sleep(timeInSecond*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void highlightElement(WebDriver driver, String locator) {
		javascriptExecutor  = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		String originalStyle = element.getAttribute("style");
		System.out.println("Original style of element = " + originalStyle);
		
		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 3px solid red; border-style: dashed;");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public HomePageObject openHomePage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.HOME_PAGE_LINK);
		clickToElement(driver, AbstractPageUI.HOME_PAGE_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		return PageGeneratorManager.getNewCustomerPage(driver);
	}

	public EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.EDIT_CUSTOMER_LINK);
		return PageGeneratorManager.getEditCustomerPage(driver);
	}

	public DeleteCustomerPageObject openDeleteCustomerPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.DELETE_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.DELETE_CUSTOMER_LINK);
		return PageGeneratorManager.getDeleteCustomerPage(driver);
	}

	public NewAccountPageObject openNewAccountPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, AbstractPageUI.NEW_ACCOUNT_LINK);
		return PageGeneratorManager.getNewAccountPage(driver);
	}

	public EditAccountPageObject openEditAccountPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.EDIT_ACCOUNT_LINK);
		clickToElement(driver, AbstractPageUI.EDIT_ACCOUNT_LINK);
		return PageGeneratorManager.getEditAccountPage(driver);
	}

	public DeleteAccountPageObject openDeleteAccountPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.DELETE_ACCOUNT_LINK);
		clickToElement(driver, AbstractPageUI.DELETE_ACCOUNT_LINK);
		return PageGeneratorManager.getDeleteAccountPage(driver);
	}

	public DepositPageObject openDepositPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.DEPOSIT_LINK);
		clickToElement(driver, AbstractPageUI.DEPOSIT_LINK);
		return PageGeneratorManager.getDepositPage(driver);
	}

	public WithdrawalPageObject openWithdrawalPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.WITHDRAWAL_LINK);
		clickToElement(driver, AbstractPageUI.WITHDRAWAL_LINK);
		return PageGeneratorManager.getWithdrawalPage(driver);
	}

	public FundTransferPageObject openFundTransferPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.FUND_TRANSFER_LINK);
		clickToElement(driver, AbstractPageUI.FUND_TRANSFER_LINK);
		return PageGeneratorManager.getFundTransferPage(driver);
	}

	public ChangePasswordPageObject opengetChangePasswordPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, AbstractPageUI.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getChangePasswordPage(driver);
	}

	public BalanceEnquiryPageObject openBalanceEnquiryPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.BALANCE_ENQUIRY_LINK);
		clickToElement(driver, AbstractPageUI.BALANCE_ENQUIRY_LINK);
		return PageGeneratorManager.getBalanceEnquiryPage(driver);
	}

	public MiniStatementPageObject openMiniStatementPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.MINI_STATEMENT_LINK);
		clickToElement(driver, AbstractPageUI.MINI_STATEMENT_LINK);
		return PageGeneratorManager.getMiniStatementPage(driver);
	}

	public CustomisedStatementPageObject openCustomisedStatementPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.CUSTOMISED_STATEMENT_LINK);
		clickToElement(driver, AbstractPageUI.CUSTOMISED_STATEMENT_LINK);
		return PageGeneratorManager.getCustomisedStatementPage(driver);
	}

	public LoginPageObject openLogoutLink(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.LOG_OUT_LINK);
		clickToElement(driver, AbstractPageUI.LOG_OUT_LINK);
		acceptAlert(driver);
		sleepInSecond(driver, 3);
		return PageGeneratorManager.getLoginPage(driver);
	}
	
	// Số lượng pages ít: <=20 pages
	public AbstractPage openMultiplePage(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MENU_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_LINK, pageName);
		
		switch (pageName) {
		case "New Customer":
				return PageGeneratorManager.getNewCustomerPage(driver);
		case "Change Password":
				return PageGeneratorManager.getChangePasswordPage(driver);
		case "Mini Statement":
				return PageGeneratorManager.getMiniStatementPage(driver);
		case "Balance Enquiry":
				return PageGeneratorManager.getBalanceEnquiryPage(driver);
		default:
				return PageGeneratorManager.getHomePage(driver);
		}
	}
	
	// Số lượng pages 100 -1000
	public void openMultiplePages(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MENU_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_LINK, pageName);
	}
	
	public void inputToDynamicTextbox(WebDriver driver, String nameID, String value) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, nameID);
		sendkeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, value, nameID);	
	}

	public void inputToDynamicTextArea(WebDriver driver, String nameID, String value) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTAREA, nameID);
		sendkeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTAREA, value, nameID);	
	}
	
	public void clickToDynamicRadioButton(WebDriver driver, String attributeValue) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, attributeValue);
		clickToElement(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, attributeValue);	
	}

	public void clickToDynamicButton(WebDriver driver, String attributeValue) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_BUTTON, attributeValue);
		clickToElement(driver, AbstractPageUI.DYNAMIC_BUTTON, attributeValue);	
	}

	public void clickToDynamicMenuLink(WebDriver driver, String textValue) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_MENU_LINK, textValue);
		clickToElement(driver, AbstractPageUI.DYNAMIC_MENU_LINK, textValue);	
	}
	
	public String getErrorMessageOfDynamicField(WebDriver driver, String labelName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_ERROR_MESSAGE, labelName);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_ERROR_MESSAGE, labelName);
	}
	
	public void pressTabToDynamicTextbox(WebDriver driver, String nameID) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, nameID);
		sendKeyboardToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, Keys.TAB, nameID);	
	}
	
	// Sort Ascending STRING
	public boolean isStringDataSortedAscending(WebDriver driver, String locator) {
		// Declare an ArrayList
		ArrayList<String> arrayList = new ArrayList<>();
		
		// Find all elements that match with condition (Name/Price/...)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		
		// Get text from elementList to add to arrayList
		for(WebElement element : elementList) {
			arrayList.add(element.getText());
		}
		
		System.out.println("---------------------Dữ liệu trên UI:---------------------");
		for(String name : arrayList) {
			System.out.println(name);
		}
		
		// Copy to an new array-list to SORT in code
		ArrayList<String> sortedList = new ArrayList<>();
		for(String child : arrayList) {
			sortedList.add(child);
		}
		
		// Execute SORT ASC
		Collections.sort(sortedList);
		
		System.out.println("------------Dữ liệu đã SORT ASC trong code:---------------");
		for(String child : sortedList)
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
		for(WebElement element : elementList) {
			arrayList.add(element.getText());
		}
		
		System.out.println("---------------------Dữ liệu trên UI:---------------------");
		for(String name : arrayList) {
			System.out.println(name);
		}
		
		// Copy to an new array-list to SORT in code
		ArrayList<String> sortedList = new ArrayList<>();
		for(String child : arrayList) {
			sortedList.add(child);
		}
		
		// Execute SORT DESC
		Collections.sort(sortedList); // Sort ASC
		Collections.reverse(sortedList); // Or using: Collections.sort(sortedList, Collections.reverseOrder());
		
		System.out.println("------------Dữ liệu đã SORT DESC trong code:---------------");
		for(String child : sortedList)
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
			for(WebElement element : elementList) {
				arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
			}
			
			System.out.println("---------------------Dữ liệu trên UI:---------------------");
			for(Float number : arrayList) {
				System.out.println(number);
			}
			
			// Copy to an new array-list to SORT in code
			ArrayList<Float> sortedList = new ArrayList<Float>();
			for(Float child : arrayList) {
				sortedList.add(child);
			}
			
			// Execute SORT ASC
			Collections.sort(sortedList);
			
			System.out.println("------------Dữ liệu đã SORT ASC trong code:---------------");
			for(Float child : sortedList)
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
		for(WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		
		System.out.println("---------------------Dữ liệu trên UI:---------------------");
		for(Float number : arrayList) {
			System.out.println(number);
		}
		
		// Copy to an new array-list to SORT in code
		ArrayList<Float> sortedList = new ArrayList<Float>();
		for(Float child : arrayList) {
			sortedList.add(child);
		}
		
		// Execute SORT DESC
		Collections.sort(sortedList); // Sort ASC
		Collections.reverse(sortedList); // Or using: Collections.sort(sortedList, Collections.reverseOrder());
		
		System.out.println("------------Dữ liệu đã SORT DESC trong code:---------------");
		for(Float child : sortedList)
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
