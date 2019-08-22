package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePageFactory {
	@FindBy (how = How.XPATH, using = "//marquee[contains(text(),'Welcome To Manager')]")
	private WebElement welcomeMessage;
	
	@FindBy (how = How.XPATH, using = "//td[contains(text(),'Manger Id :')]")
	private WebElement userIDText;
	
	@FindBy (how = How.XPATH, using = "//a[text()='New Customer']")
	private WebElement newCustomerLink;
	
	WebDriver driver;
	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isWelcomeMessageDisplayed(String expectedText) {
		String actualText = welcomeMessage.getText();
		return actualText.equals(expectedText);
	}

	public boolean isUserIDDisplayed(String userID) {
		String actualText = userIDText.getText();
		return actualText.contains(userID);
	}

	public void clickToNewCustomerPage() {
		newCustomerLink.click();	
	}
	
}
