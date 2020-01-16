package pageObjectsLiveGuru;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.liveguru.testdata.DataAdmin;

import commonsLiveGuru.AbstractPage;
import pageUIsLiveGuru.AbstractPageUI;
import pageUIsLiveGuru.BackEndHomePageUI;

public class BackEndHomePageObject extends AbstractPage {
	WebDriver driver;

	public BackEndHomePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void closePopUp(WebDriver driver) {
		waitForElementVisible(driver, BackEndHomePageUI.CLOSE_POPUP_BUTTON);
		clickToElement(driver, BackEndHomePageUI.CLOSE_POPUP_BUTTON);
	}

	public int getPages(WebDriver driver) {
		String pages = getAttributeValue(driver, AbstractPageUI.KEYPRESS, "onkeypress");
		pages = pages.trim().replace("customerGridJsObject.inputPage(event, '", "").replace("')", "");
		return Integer.valueOf(pages);
	}

	public int getTotalRecords(WebDriver driver, String locator) {
		String record = driver.findElement(By.xpath(locator)).getAttribute("innerHTML").trim();
		return Integer.valueOf(record);
	}
	
	public void clickToNextArrow(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.NEXT_PAGE_ARROW_LINK);
		clickToElement(driver, AbstractPageUI.NEXT_PAGE_ARROW_LINK);
		waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
		sleepInSecond(driver, 5);
	}
	
	public boolean isCountRecordsPassed(int countRecords, int totalRecords) {
		if (countRecords == totalRecords && totalRecords == 0) {
			System.out.println("Total records is: " + totalRecords + ". No records found");
			return true;
		} else if (countRecords != totalRecords) {
			System.out.println("Count records is: " + countRecords);
			System.out.println("Total records is: " + totalRecords);
			System.out.println("Searching not work correctly!!!");
			return false;
		} else
			System.out.println("Total records is: " + totalRecords);
		return true;
	}
	
	public boolean isIDListResult(WebDriver driver) {
		int countRecords = 0;
		String ID = DataAdmin.BackEndHomePage.ID;

		inputFromToIDTextbox(driver, ID);

		int pages = getPages(driver);
		int totalRecords = getTotalRecords(driver, BackEndHomePageUI.RECORD);
		for (int page = 1; page <= pages; page++) {
			List<WebElement> elements = driver.findElements(By.xpath(BackEndHomePageUI.ID_LIST));
			for (WebElement element : elements) {
				String elementStr = element.getText().trim();
				if (elementStr.contains(ID) || elementStr.equalsIgnoreCase(ID)) {
					countRecords += 1;
				}
			}
			if (page > 1 && page < pages) {
				clickToNextArrow(driver);
			}
		}

		clearElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "customerGrid_filter_entity_id_from");
		clearElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "customerGrid_filter_entity_id_to");
		
		return isCountRecordsPassed(countRecords, totalRecords);
	}

	public void inputFromToIDTextbox(WebDriver driver, String ID) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "customerGrid_filter_entity_id_from");
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "customerGrid_filter_entity_id_to");
		inputToDynamicTextbox(driver, "customerGrid_filter_entity_id_from", ID);
		inputToDynamicTextbox(driver, "customerGrid_filter_entity_id_to", ID);
		clickOnDynamicLinkOrButton(driver, "Search");
		waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
	}

	public boolean isNameListResult(WebDriver driver) {
		int countRecords = 0;
		String name = DataAdmin.BackEndHomePage.NAME;

		inputNameTextbox(driver, name);

		int pages = getPages(driver);
		int totalRecords = getTotalRecords(driver, BackEndHomePageUI.RECORD);
		for (int page = 1; page <= pages; page++) {
			List<WebElement> elements = driver.findElements(By.xpath(BackEndHomePageUI.NAME_LIST));
			for (WebElement element : elements) {
				String elementStr = element.getText().trim();
				if (elementStr.contains(name) || elementStr.equalsIgnoreCase(name))
					countRecords += 1;
			}
			if (page > 1 && page < pages) {
				clickToNextArrow(driver);
			}
		}

		clearElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "customerGrid_filter_name");
		
		return isCountRecordsPassed(countRecords, totalRecords);
	}

	public void inputNameTextbox(WebDriver driver, String name) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "customerGrid_filter_name");
		inputToDynamicTextbox(driver, "customerGrid_filter_name", name);
		clickOnDynamicLinkOrButton(driver, "Search");
		waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
	}

	public boolean isEmailListResult(WebDriver driver) {
		int countRecords = 0;
		String email = DataAdmin.BackEndHomePage.EMAIL;

		inputEmailTextbox(driver, email);

		int pages = getPages(driver);
		int totalRecords = getTotalRecords(driver, BackEndHomePageUI.RECORD);
		for (int page = 1; page <= pages; page++) {
			List<WebElement> elements = driver.findElements(By.xpath(BackEndHomePageUI.EMAIL_LIST));
			for (WebElement element : elements) {
				String elementStr = element.getText().trim();
				if (elementStr.contains(email) || elementStr.equalsIgnoreCase(email))
					countRecords += 1;
			}
			if (page > 1 && page < pages) {
				clickToNextArrow(driver);
			}
		}

		clearElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "customerGrid_filter_email");
		
		return isCountRecordsPassed(countRecords, totalRecords);
	}
	
	public void inputEmailTextbox(WebDriver driver, String email) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "customerGrid_filter_email");
		inputToDynamicTextbox(driver, "customerGrid_filter_email", email);
		clickOnDynamicLinkOrButton(driver, "Search");
		waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
	}

	public boolean isTelephoneListResult(WebDriver driver) {
		int countRecords = 0;
		String tel = DataAdmin.BackEndHomePage.TELEPHONE;

		inputTelephoneTextbox(driver, tel);

		int pages = getPages(driver);
		int totalRecords = getTotalRecords(driver, BackEndHomePageUI.RECORD);
		for (int page = 1; page <= pages; page++) {
			List<WebElement> elements = driver.findElements(By.xpath(BackEndHomePageUI.TELEPHONE_LIST));
			for (WebElement element : elements) {
				String elementStr = element.getText().trim();
				if (elementStr.contains(tel) || elementStr.equalsIgnoreCase(tel))
					countRecords += 1;
			}
			if (page > 1 && page < pages) {
				clickToNextArrow(driver);
			}
		}

		clearElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "customerGrid_filter_Telephone");
		
		return isCountRecordsPassed(countRecords, totalRecords);
	}
	
	public void inputTelephoneTextbox(WebDriver driver, String tel) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "customerGrid_filter_Telephone");
		inputToDynamicTextbox(driver, "customerGrid_filter_Telephone", tel);
		clickOnDynamicLinkOrButton(driver, "Search");
		waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
	}

	public boolean isZipListResult(WebDriver driver) {
		int countRecords = 0;
		String zip = DataAdmin.BackEndHomePage.ZIP;

		inputZipTextbox(driver, zip);

		int pages = getPages(driver);
		int totalRecords = getTotalRecords(driver, BackEndHomePageUI.RECORD);
		for (int page = 1; page <= pages; page++) {
			List<WebElement> elements = driver.findElements(By.xpath(BackEndHomePageUI.ZIP_LIST));
			for (WebElement element : elements) {
				String elementStr = element.getText().trim();
				if (elementStr.contains(zip) || elementStr.equalsIgnoreCase(zip))
					countRecords += 1;
			}
			if (page > 1 && page < pages) {
				clickToNextArrow(driver);
			}
		}

		clearElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "customerGrid_filter_billing_postcode");
		
		return isCountRecordsPassed(countRecords, totalRecords);
	}
	
	public void inputZipTextbox(WebDriver driver, String zip) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "customerGrid_filter_billing_postcode");
		inputToDynamicTextbox(driver, "customerGrid_filter_billing_postcode", zip);
		clickOnDynamicLinkOrButton(driver, "Search");
		waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
	}
	
	public boolean isCountryListResult(WebDriver driver) {
		int countRecords = 0;
		String country = DataAdmin.BackEndHomePage.COUNTRY;		
		
		selectCountryDropdownList(driver, DataAdmin.BackEndHomePage.COUNTRY);
		
		int pages = getPages(driver);
		int totalRecords = getTotalRecords(driver, BackEndHomePageUI.RECORD);
		for (int page = 1; page <= pages; page++) {
			List<WebElement> elements = driver.findElements(By.xpath(BackEndHomePageUI.COUNTRY_LIST));
			System.out.println("Element size of page " + page + " is: " + elements.size());
			for (WebElement element : elements) {
				String elementStr = element.getText().trim();
				if (elementStr.contains(country) || elementStr.equalsIgnoreCase(country))
					countRecords += 1;
			}
			if (page < pages) {
				clickToNextArrow(driver);
			}
		}

		selectAllCountryOptionInDropdownList(driver);
		
		return isCountRecordsPassed(countRecords, totalRecords);
	}
	
	public void selectCountryDropdownList(WebDriver driver, String countryName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWN, "customerGrid_filter_billing_country_id");
		selectItemInDropdown(driver, AbstractPageUI.DYNAMIC_DROPDOWN, countryName, "customerGrid_filter_billing_country_id");

		if(driver.toString().contains("firefox")) {
			scrollToDisplaySearchButton(driver);
		}
		
		clickOnDynamicLinkOrButton(driver, "Search");
		waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
	}
	
	public void scrollToDisplaySearchButton(WebDriver driver) {			
		// Way_01
		//String scrollToHeadPage = Keys.chord(Keys.CONTROL, Keys.HOME);
		//driver.findElement(By.xpath("//span[contains(text(),'Country')]")).sendKeys(scrollToHeadPage);;
		
		// Way_02
		scrollToElement(driver, "//img[@class='logo']");
		
		waitForElementVisible(driver, "//button[@title='Search']");
	}
	
	public void selectAllCountryOptionInDropdownList(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWN, "customerGrid_filter_billing_country_id");
		selectItemInDropdown(driver, AbstractPageUI.DYNAMIC_DROPDOWN, "All Countries", "customerGrid_filter_billing_country_id");
	}
	
	public boolean isStateProvinceListResult(WebDriver driver) {
		int countRecords = 0;
		String stateProvince = DataAdmin.BackEndHomePage.STATE_PROVINCE;
		
		inputStateProvinceTextbox(driver, stateProvince);

		int pages = getPages(driver);
		int totalRecords = getTotalRecords(driver, BackEndHomePageUI.RECORD);
		for (int page = 1; page <= pages; page++) {
			List<WebElement> elements = driver.findElements(By.xpath(BackEndHomePageUI.STATE_LIST));
			for (WebElement element : elements) {
				String elementStr = element.getText().trim();
				if (elementStr.contains(stateProvince) || elementStr.equalsIgnoreCase(stateProvince))
					countRecords += 1;
			}
			if (page > 1 && page < pages) {
				clickToNextArrow(driver);
			}
		}

		return isCountRecordsPassed(countRecords, totalRecords);
	}
	
	public void inputStateProvinceTextbox(WebDriver driver, String stateProvince) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, "customerGrid_filter_billing_region");
		inputToDynamicTextbox(driver, "customerGrid_filter_billing_region", stateProvince);
		clickOnDynamicLinkOrButton(driver, "Search");
		waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
	}
	
}
