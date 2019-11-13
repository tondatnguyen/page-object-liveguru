package com.liveguru.commons;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commonsLiveGuru.AbstractTest;

public class Common_01_Login extends AbstractTest {
  WebDriver driver;
	
  @Parameters("browser")
  @BeforeTest
  public void beforeTest(String browserName) { 
	  
	  driver = openMultiBrowser(browserName);
	  

	
  }

 
  
}
