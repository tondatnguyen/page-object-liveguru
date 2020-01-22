package pageObjectsLiveGuru;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.model.Test;

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
	
	public boolean isDateBackEndDataSortedAscending(WebDriver driver, String locator) {
		ArrayList<String> originalDateList = new ArrayList<>();
		ArrayList<String> sortedDateList = new ArrayList<>();
		List<WebElement> elementDateList = driver.findElements(By.xpath(locator));
		
		for (WebElement elementDate : elementDateList) {
			originalDateList.add(elementDate.getText().trim());
		}
		

		System.out.println("---------------------Data displayed on UI:---------------------");
		for (String originalDate : originalDateList) {
			System.out.println(originalDate);
		}

		for (String originalDate : originalDateList) {
			sortedDateList.add(originalDate);
		}
		sortDates(sortedDateList);

		System.out.println("------------Data had been SORT ASC:---------------");
		for (String sortedDate : sortedDateList)
			System.out.println(sortedDate);

		return sortedDateList.equals(originalDateList);
	}
	
	private static void sortDates(List<String> dateList) {

		Collections.sort(dateList, new Comparator<String>() {
			DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a");
			@Override
			public int compare(String DATE_1, String DATE_2) {
				try {
					return dateFormat.parse(DATE_1).compareTo(dateFormat.parse(DATE_2));
				} catch (ParseException e) {
					e.printStackTrace();
				}	
				return (Integer) null;
			}
		});
	}
	
	public boolean isDateBackEndDataSortedDescending(WebDriver driver, String locator) {
		ArrayList<String> originalDateList = new ArrayList<>();
		ArrayList<String> sortedDateList = new ArrayList<>();
		List<WebElement> elementDateList = driver.findElements(By.xpath(locator));
		
		for (WebElement elementDate : elementDateList) {
			originalDateList.add(elementDate.getText().trim());
		}
		

		System.out.println("---------------------Data displayed on UI:---------------------");
		for (String originalDate : originalDateList) {
			System.out.println(originalDate);
		}

		for (String originalDate : originalDateList) {
			sortedDateList.add(originalDate);
		}
		sortDates(sortedDateList);
		Collections.reverse(sortedDateList);

		System.out.println("------------Data had been SORT DESC:---------------");
		for (String sortDate : sortedDateList)
			System.out.println(sortDate);

		return sortedDateList.equals(originalDateList);
	}
	
}
