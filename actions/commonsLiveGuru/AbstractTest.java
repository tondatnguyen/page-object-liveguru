package commonsLiveGuru;

import java.io.File;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	private WebDriver driver; 
	protected final Log log;
	private final String workingDir = System.getProperty("user.dir");
	//	String rootFolder = System.getProperty("user.dir");
	
	// Constructor
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver getDriver() {
		return driver;
	}

	public synchronized WebDriver openMultiBrowser(String browserName) {
	
		if (browserName.equalsIgnoreCase("firefox")) {
			// Disable log 
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, workingDir + "\\FirefoxUILog.txt");
			driver = new FirefoxDriver();
		} 
		else if (browserName.equalsIgnoreCase("chrome")) {
			//	System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("chromeheadless")) {
			WebDriverManager.chromedriver().setup();
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
			String dayValue = "0" + day;
			return dayValue;
		}
		return day + "";
	}
	
	protected String getCurrentMonth() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
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
				for(int i=0; i < listOfFiles.length; i++) {
					if(listOfFiles[i].isFile()) {
						System.out.println(listOfFiles[i].getName());
						new File(listOfFiles[i].toString()).delete();
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
}
