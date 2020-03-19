package commonsLiveGuru;

import java.io.File;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	private WebDriver driver;
	protected final Log log;
	private final String workingDir = System.getProperty("user.dir");
	private final String downloadFilesPath = workingDir + "\\downloadFiles";
	// String rootFolder = System.getProperty("user.dir");

	// Constructor
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver getDriver() {
		return driver;
	}

	public synchronized WebDriver openMultiBrowserBackEnd(String browserName, String fileType) {

		if (browserName.equalsIgnoreCase("firefox")) {
			// Disable log
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, workingDir + "\\FirefoxUILog.txt");
			
			// Create a new FireFox Profile instance
			FirefoxProfile profile = new FirefoxProfile();

			// Set file save to directory
			profile.setPreference("browser.download.dir", downloadFilesPath);
			profile.setPreference("browser.download.folderList", 2);
			
			switch(fileType) {
			case ".pdf":
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf;");
				break;
			case ".txt":
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain;");
				break;
			case ".csv":
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");
				break;
			case ".xlsx":
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;");
				break;
			case ".docx":
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
				break;
			}
			
			// Set file mime type which do not show save to popup dialog
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			profile.setPreference("pdfjs.disabled", true);

			// Create Firefox browser based on the profile just created.
			driver = new FirefoxDriver(profile);
			
		} else if (browserName.equalsIgnoreCase("chrome")) {
			
			// Way_01: System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
			// Way_02
			WebDriverManager.chromedriver().version("76.0.3809.87").setup();
			
			/* Set file save to directory. */
			Map<String, Object> chromePreferences = new Hashtable<String, Object>();		
			chromePreferences.put("download.default_directory", downloadFilesPath);

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", chromePreferences);

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			  
			//Initiate ChromeDriver
			driver = new ChromeDriver(cap);
			
		} else if (browserName.equalsIgnoreCase("chromeheadless")) {
			
			WebDriverManager.chromedriver().version("76.0.3809.87").setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=" + Constants.HEADLESS_RESOLUTION);
			driver = new ChromeDriver(options);
			
		} else if (browserName.equalsIgnoreCase("internetexplorer")) {
			
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
			
		} else {
			log.info("Please to choose your browser_name in TestNG file!!");
		}

		return driver;
	}

	public synchronized WebDriver openMultiBrowserFrontEnd(String browserName) {

		if (browserName.equalsIgnoreCase("firefox")) {
			// Disable log
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, workingDir + "\\FirefoxUILog.txt");

			// Create Firefox browser based on the profile just created.
			driver = new FirefoxDriver();
			
		} else if (browserName.equalsIgnoreCase("chrome")) {
			
			// Way_01: System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
			// Way_02
			WebDriverManager.chromedriver().version("76.0.3809.87").setup();
			  
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("chromeheadless")) {
			
			WebDriverManager.chromedriver().version("76.0.3809.87").setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=" + Constants.HEADLESS_RESOLUTION);
			driver = new ChromeDriver(options);
			
		} else if (browserName.equalsIgnoreCase("internetexplorer")) {
			
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
			
		} else {
			log.info("Please to choose your browser_name in TestNG file!!");
		}

		return driver;
	}
	
	private boolean checkPassed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("==================PASSED==================");
			else
				log.info("==================FAILED==================");
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkPassed(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false)
				log.info("==================PASSED==================");
			else
				log.info("==================FAILED==================");
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		boolean status;
		try {
			if (actual instanceof String && expected instanceof String) {
				actual = actual.toString().trim();
				expected = expected.toString().trim();
				status = (actual.equals(expected));
			} else {
				status = (actual == expected);
			}

			if (status) {
				log.info("==================PASSED==================");
			} else {
				log.info("==================FAILED==================");
			}
			Assert.assertEquals(actual, expected, "Value is not matching!");
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	protected int randomData() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String cmd = "";
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}

			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}

			if (driver.toString().toLowerCase().contains("gecko")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}

			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
					Process process = Runtime.getRuntime().exec(cmd);
					process.waitFor();
				}
			}
			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	protected String getCurrentDay() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayLessThanTen = "0" + day;
			return dayLessThanTen + "";
		}
		return day + "";
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthLessThanTen = "0" + month;
			return monthLessThanTen + "";
		}
		return month + "";
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		return now.getYear() + "";
	}

	protected String getToday() {
		return getCurrentYear() + "-" + getCurrentMonth() + "-" + getCurrentDay();
	}

	@BeforeSuite
	public void deleteAllFilesInReportNGScreenshot() {
		System.out.println("----------START: Delete file in folder----------");
		deleteAllFilesInFolder();
		System.out.println("----------END: Delete file in folder----------");
	}

	public void deleteAllFilesInFolder() {
		try {
			String pathFolderDownload = workingDir + "\\reportNGScreenshots";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
