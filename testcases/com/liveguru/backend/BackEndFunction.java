package com.liveguru.backend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveguru.testdata.DataUser;
import com.liveguru.testdata.DataAdmin;
import commonsLiveGuru.AbstractTest;
import commonsLiveGuru.PageGeneratorManager;

public class BackEndFunction extends AbstractTest {
	
	@Parameters("browser")
	@BeforeClass 
	public void beforeClass(String browserName) {
		
		driver = openMultiBrowser(browserName);
		driver.manage().window().maximize();
		
	}

	@Test
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
	
	WebDriver driver;
	
}
