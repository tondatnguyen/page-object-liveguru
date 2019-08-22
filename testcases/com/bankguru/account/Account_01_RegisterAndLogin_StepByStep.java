package com.bankguru.account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Account_01_RegisterAndLogin_StepByStep {
	WebDriver driver;
	String email, username, password, loginPageUrl;
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("http://demo.guru99.com/v4/index.php");
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
	  System.out.println("PRE-CONDITION - STEP_01: Get Login_Page url");
	  loginPageUrl = driver.getCurrentUrl();
	  email = "auto" + randomData() + "@test.com";
  }

  @Test
  public void TC_01_RegisterToSystem() {
	  
	  System.out.println("REGISTER - STEP_01: Click to 'HERE' link");
	  driver.findElement(By.xpath("//a[text()='here']")).click();
	  
	  System.out.println("REGISTER - STEP_02: Input to Email_ID_textbox");
	  driver.findElement(By.name("emailid")).sendKeys(email);  
	  
	  System.out.println("REGISTER - STEP_03: Click to 'SUBMIT' button");
	  driver.findElement(By.name("btnLogin")).click();
	  
	  username = driver.findElement(By.xpath("//td[contains(text(),'User ID')]/following-sibling::td")).getText();
	  password = driver.findElement(By.xpath("//td[contains(text(),'Password')]/following-sibling::td")).getText();
	  
	  System.out.println("");
  }

  @Test
  public void TC_02_LoginToSystem() {
	  
	  System.out.println("LOGIN - STEP_01: Open Login_Page");
	  driver.get(loginPageUrl);
	  
	  System.out.println("LOGIN - STEP_02: Input to UserID/Password textbox");
	  driver.findElement(By.name("uid")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  
	  System.out.println("LOGIN - STEP_03: Click to 'LOGIN' button");
	  driver.findElement(By.name("btnLogin")).click();
	  
	  System.out.println("LOGIN - STEP_04: Verify Welcome Message displayed");
	  String welcomeMessage = driver.findElement(By.xpath("//marquee[contains(text(),'Welcome To Manager')]")).getText();
	  Assert.assertEquals("Welcome To Manager's Page of Guru99 Bank", welcomeMessage);
	  
	  System.out.println("LOGIN - STEP_05: Verify UserID displayed");
	  Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : " + username + "']")).isDisplayed());
	  
	  System.out.println("");
  }
  
  @AfterClass
  public void afterClass() { 
	  driver.quit();
  }

  public int randomData() {
	  Random random = new Random();
	  return random.nextInt(9999);
  }
  
}
