package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
	private WebDriver driver;

	public WebDriver openMultiBrowser(String browserName) {
		
		  String rootFolder = System.getProperty("user.dir");
		  
		  if(browserName.equalsIgnoreCase("firefox")) {
			  driver = new FirefoxDriver();
		  } else if(browserName.equalsIgnoreCase("chrome")) {
			  System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
			  driver = new ChromeDriver();
		  } else if(browserName.equalsIgnoreCase("chromeheadless")) {
			  System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
			  ChromeOptions options = new ChromeOptions();
			  options.addArguments("headless");
			  options.addArguments("window-size=1600x900");
			  driver = new ChromeDriver(options);
		  } else {
			  System.out.println("Please to choose your browser_name in TestNG file!!");
		  }
		  
		  System.out.println("PRE-CONDITION - STEP_01: Open BANK GURU APPLICATION");
		  driver.get("http://demo.guru99.com/v4/index.php");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		  return driver;
	}
	
}
