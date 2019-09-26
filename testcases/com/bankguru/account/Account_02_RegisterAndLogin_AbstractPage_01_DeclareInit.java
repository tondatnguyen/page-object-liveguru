package com.bankguru.account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import commons.AbstractPage;

public class Account_02_RegisterAndLogin_AbstractPage_01_DeclareInit {
	WebDriver driver;
	String email, username, password, loginPageUrl, welcomeMessage;
	AbstractPage abstractPage;
	
  @BeforeClass
  public void beforeClass() {
	  abstractPage = new AbstractPage(); 
	  driver = new FirefoxDriver();
	  email = "auto" + randomData() + "@test.com";
	  
	  //driver.get("http://demo.guru99.com/v4/index.php");
	  abstractPage.openUrl(driver, "http://demo.guru99.com/v4/index.php");	  
	  System.out.println("PRE-CONDITION - STEP_01: Get Login_Page url");
	  
	  //loginPageUrl = driver.getCurrentUrl();
	  loginPageUrl = abstractPage.getCurrentPageUrl(driver);
  }

  @Test
  public void TC_01_RegisterToSystem() {
	  
	  System.out.println("REGISTER - STEP_01: Click to 'HERE' link");
	  //driver.findElement(By.xpath("//a[text()='here']")).click();
	  abstractPage.clickToElement(driver, "//a[text()='here']");
	  
	  System.out.println("REGISTER - STEP_02: Input to Email_ID_textbox");
	  //driver.findElement(By.name("emailid")).sendKeys(email);  
	  abstractPage.sendkeyToElement(driver, "//input[@name='emailid']", email);
	  
	  System.out.println("REGISTER - STEP_03: Click to 'SUBMIT' button");
	  //driver.findElement(By.name("btnLogin")).click();
	  abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
	  
	  System.out.println("REGISTER - STEP_04: Get username/password info");
	  //username = driver.findElement(By.xpath("//td[contains(text(),'User ID')]/following-sibling::td")).getText();
	  //password = driver.findElement(By.xpath("//td[contains(text(),'Password')]/following-sibling::td")).getText();
	  username = abstractPage.getTextElement(driver, "//td[contains(text(),'User ID')]/following-sibling::td");
	  password = abstractPage.getTextElement(driver, "//td[contains(text(),'Password')]/following-sibling::td");
	  System.out.println("");
  }

  @Test
  public void TC_02_LoginToSystem() {
	  
	  System.out.println("LOGIN - STEP_01: Open Login_Page");
	  //driver.get(loginPageUrl);
	  abstractPage.openUrl(driver, loginPageUrl);
	  
	  System.out.println("LOGIN - STEP_02: Input to UserID/Password textbox");
	  //driver.findElement(By.name("uid")).sendKeys(username);
	  //driver.findElement(By.name("password")).sendKeys(password);
	  abstractPage.sendkeyToElement(driver, "//input[@name='uid']", username);
	  abstractPage.sendkeyToElement(driver, "//input[@name='password']", password);
	  
	  System.out.println("LOGIN - STEP_03: Click to 'LOGIN' button");
	  //driver.findElement(By.name("btnLogin")).click();
	  abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
	  
	  System.out.println("LOGIN - STEP_04: Verify Welcome Message displayed");
	  //String welcomeMessage = driver.findElement(By.xpath("//marquee[contains(text(),'Welcome To Manager')]")).getText();
	  welcomeMessage = abstractPage.getTextElement(driver, "//marquee[contains(text(),'Welcome To Manager')]");
	  Assert.assertEquals("Welcome To Manager's Page of Guru99 Bank", welcomeMessage);
	  
	  
	  System.out.println("LOGIN - STEP_05: Verify UserID displayed");
	  //Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : " + username + "']")).isDisplayed());
	  Assert.assertTrue(abstractPage.isControlDisplayed(driver, "//td[text()='Manger Id : " + username + "']"));
	  
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
