package pageObjectsLiveGuru;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonsLiveGuru.AbstractPage;
import pageUIsLiveGuru.AbstractPageUI;
import pageUIsLiveGuru.InvoicesPageUI;

public class InvoicesPageObject extends AbstractPage {
	WebDriver driver;

	public InvoicesPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void clickToColumnTitle(WebDriver driver, String ColumnName) {
		waitForElementVisible(driver, InvoicesPageUI.COLUMN_TITLE, ColumnName);
		clickToElement(driver, InvoicesPageUI.COLUMN_TITLE, ColumnName);
		waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
	}

	public boolean isBillNameSortASC() {
		return isStringDataSortedAscending(driver, InvoicesPageUI.BILL_TO_NAME);
	}
	
	public boolean isBillNameSortDESC() {
		return isStringDataSortedDescending(driver, InvoicesPageUI.BILL_TO_NAME);
	}
	
	public boolean isAmountSortASC() {
		return isFloatDataSortedAscending(driver, InvoicesPageUI.AMOUNT);
	}
	
	public boolean isAmountSortDESC() {
		return isFloatDataSortedDescending(driver, InvoicesPageUI.AMOUNT);
	}
	
	public boolean isInvoiceIDSortASC() {
		return isIntegerBackEndDataSortedAscending(driver, InvoicesPageUI.INVOICE_NO);
	}
	
	public boolean isInvoiceIDSortDESC() {
		return isIntegerBackEndDataSortedDescending(driver, InvoicesPageUI.INVOICE_NO);
	}
	
	public boolean isOrderIDSortASC() {
		return isIntegerBackEndDataSortedAscending(driver, InvoicesPageUI.ORDER_NO);
	}
	
	public boolean isOrderIDSortDESC() {
		return isIntegerBackEndDataSortedDescending(driver, InvoicesPageUI.ORDER_NO);
	}
	
	public boolean isInvoiceDateSortASC() {
		return isDateBackEndDataSortedAscending(driver, InvoicesPageUI.INVOICE_DATE);
	}
	
	public boolean isInvoiceDateSortDESC() {
		return isDateBackEndDataSortedDescending(driver, InvoicesPageUI.INVOICE_DATE);
	}
	
	public boolean isOrderDateSortASC() {
		return isDateBackEndDataSortedAscending(driver, InvoicesPageUI.ORDER_DATE);
	}
	
	public boolean isOrderDateSortDESC() {
		return isDateBackEndDataSortedDescending(driver, InvoicesPageUI.ORDER_DATE);
	}
	
	// Sort ASC INTEGER
	public boolean isIntegerBackEndDataSortedAscending(WebDriver driver, String locator) {

		ArrayList<Integer> arrayList = new ArrayList<>();

		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		for (WebElement element : elementList) {
			arrayList.add(Integer.parseInt(element.getText().trim().substring(0, 9)));
		}

		System.out.println("---------------------Data displayed on UI:---------------------");
		for (int number : arrayList) {
			System.out.println(number);
		}

		ArrayList<Integer> sortedList = new ArrayList<>();
		for (int child : arrayList) {
			sortedList.add(child);
		}

		Collections.sort(sortedList);

		System.out.println("------------Data had been SORT ASC:---------------");
		for (int child : sortedList)
			System.out.println(child);

		return sortedList.equals(arrayList);
	}
	
	// Sort DESC INTEGER
	public boolean isIntegerBackEndDataSortedDescending(WebDriver driver, String locator) {

		ArrayList<Integer> arrayList = new ArrayList<>();
		
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		for (WebElement element : elementList) {
			arrayList.add(Integer.parseInt(element.getText().trim().substring(0, 9)));
		}

		System.out.println("---------------------Data displayed on UI:---------------------");
		for (int number : arrayList) {
			System.out.println(number);
		}
		
		ArrayList<Integer> sortedList = new ArrayList<>();
		for (int child : arrayList) {
			sortedList.add(child);
		}

		Collections.sort(sortedList);
		Collections.reverse(sortedList);

		System.out.println("------------Data had been SORT DESC:---------------");
		for (int child : sortedList)
			System.out.println(child);

		return sortedList.equals(arrayList);
	}
	
	// Sort ASC DATE
	public boolean isDateBackEndDataSortedAscending(WebDriver driver, String locator) {

		ArrayList<LocalDateTime> originalDateList = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm:ss a");
		
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		
		for (WebElement element : elementList) {
			originalDateList.add(LocalDateTime.parse(element.getText().replace(",", "").trim(), formatter));
		}

		System.out.println("---------------------Data displayed on UI:---------------------");
		for (LocalDateTime originalDate : originalDateList) {
			System.out.println(originalDate);
		}

		ArrayList<LocalDateTime> sortedDateList = new ArrayList<>();
		for (LocalDateTime copyOriginalDate : originalDateList) {
			sortedDateList.add(copyOriginalDate);
		}

		Collections.sort(sortedDateList);

		System.out.println("------------Data had been SORT ASC:---------------");
		for (LocalDateTime sortDate : sortedDateList)
			System.out.println(sortDate);

		return sortedDateList.equals(originalDateList);
	}
	
	// Sort DESC DATE
	public boolean isDateBackEndDataSortedDescending(WebDriver driver, String locator) {
		
		ArrayList<LocalDateTime> originalDateList = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm:ss a");
	
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		for (WebElement element : elementList) {	
			originalDateList.add(LocalDateTime.parse(element.getText().replace(",", "").trim(), formatter));
		}

		System.out.println("---------------------Data displayed on UI:---------------------");
		for (LocalDateTime originalDate : originalDateList) {
			System.out.println(originalDate);
		}

		ArrayList<LocalDateTime> sortedDateList = new ArrayList<>();
		for (LocalDateTime copyOriginalDate : originalDateList) {
			sortedDateList.add(copyOriginalDate);
		}
		
		Collections.sort(sortedDateList);
		Collections.reverse(sortedDateList);

		System.out.println("------------Data had been SORT ASC:---------------");
		for (LocalDateTime sortDate : sortedDateList)
			System.out.println(sortDate);

		return sortedDateList.equals(originalDateList);
	}
	
}
